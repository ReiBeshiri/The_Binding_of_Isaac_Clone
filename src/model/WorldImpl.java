package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import input.Command;
import model.ai.BasicAI;
import model.animated.AbstractCharacter;
import model.animated.Animated;
import model.animated.Bullet;
import model.animated.BulletImpl;
import model.animated.Enemy;
import model.animated.EntityStats;
import model.animated.PlayerImpl;
import model.environment.WorldEnvironment;
import model.environment.WorldEnvironmentImpl;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import model.hitbox.RectangularHitBox;
import model.inanimated.Button;
import model.inanimated.Heart;
import model.inanimated.Inanimated;
import model.room.Room;
import model.rounds.DynamicRounds;
import model.rounds.RoundsGenerator;
import model.rounds.StaticRounds;
import model.strategy.MovementStrategy;
import model.strategy.PlayerMovement;
import model.strategy.PlayerProjectile;
import model.strategy.SimplyDirectionMovement;
import proxyutility.ImageType;
import utility.CollisionUtil;
import utility.Mode;
import utility.ModelUtility;
import utility.ProportionUtility;
import utility.SpawnUtility;
import worldevent.BossFightStarted;
import worldevent.PlayerDied;
import worldevent.PlayerHeartChange;
import worldevent.PlayerHitButton;
import worldevent.PlayerKillAllEnemy;
import worldevent.PlayerKillBoss;
import worldevent.PlayerKillEnemy;
import worldevent.RoomChange;
import worldevent.WorldEvent;

/**
 * WorldImpl.
 *
 */
public class WorldImpl implements World {
    private Animated player; // |is the player
    private final List<Animated> listAnimatedObj;
    private Room room; // |method addRoom is setRoom
    private final boolean gameOver; // false initially --> NO FINAL, appena viene modificata togliere final.
    private boolean bossDefeated; // false initially
    private final List<Bullet> listBulletPlayer;
    private final List<Bullet> listBulletEnemies;
    private Button button;
    private List<Command> listMovements;
    private List<Command> listShots;
    private final List<Animated> listEnemy; // |list of enemies
    private final List<Room> listRoom;
    private final List<WorldEvent> listEvent;
    private int currentRound = 1;
    private static final int DAMAGE = 1;
    private Mode mode;
    private RoundsGenerator roundsGenerator;
    private WorldEnvironment we;

    /**
     * Constructor for this class.
     */
    public WorldImpl() {
        listAnimatedObj = new ArrayList<>();
        gameOver = false;
        listBulletPlayer = new ArrayList<>();
        listBulletEnemies = new ArrayList<>();
        listEnemy = new ArrayList<>();
        listMovements = new ArrayList<>();
        listShots = new ArrayList<>();
        listRoom = new ArrayList<>();
        listEvent = new ArrayList<>();
        ModelUtility.updateCurrentRound(0);
        ModelUtility.updateListAnimatedObject(Collections.emptyList());
        ModelUtility.updateListMovementCommand(Collections.emptyList());
        ModelUtility.updateListShotCommand(Collections.emptyList());
        ModelUtility.updateListWorldEvent(Collections.emptyList());
        ModelUtility.updatePauseDuringRound(false);
    }

    /**
     * @return the actual room.
     */
    @Override
    public Room getActualRoom() {
        return this.room;
    }

    /**
     * @return true if game is over.
     */
    @Override
    public boolean isGameOver() {
        return this.gameOver;
    }

    /**
     * @return true if boss is defeated.
     */
    @Override
    public boolean isBossDefeated() {
        return this.bossDefeated;
    }

    /**
     * @param player
     *            the player that will be set.
     */
    @Override
    public void createPlayer(final Animated player) {
        this.player = player;
        ModelUtility.updatePlayerModelUtility(player);
    }

    /**
     * Create the environment. Needs to be called to create the rooms.
     */
    public void createEnvironment() {
        we = new WorldEnvironmentImpl();
        listRoom.addAll(we.createWorld());
        this.room = this.listRoom.get(0);
        addButton(we.getButton());
        createPlayer(playerCreation());
        ModelUtility.updateRoomModelUtility(this.room);
    }

    /**
     * Set the game mode. The mode chosen by the player. Needs to be called to set
     * the mode.
     * 
     * @param m
     *            the game mode chosen by the player.
     */
    public void setMode(final Mode m) {
        this.mode = m;
        if (this.mode.equals(Mode.NORMAL)) {
            this.roundsGenerator = new StaticRounds();
        } else {
            this.roundsGenerator = new DynamicRounds();
        }
    }

    /**
     * Set the next round by adding to the list of enemy the new monsters to
     * generate.
     */
    @Override
    public void setNextRound() {
        if (this.mode.equals(Mode.NORMAL) && getCurrentRound() < 4) {
            listEnemy.addAll(roundsGenerator.generateMonster());
            this.button.setPressed(true);
        }
    }

    /**
     * @param bullet
     *            the bullet removed from the enemy bullet list.
     */
    @Override
    public void removeBulletEnemy(final Bullet bullet) {
        this.listBulletEnemies.remove(bullet);
    }

    /**
     * @param bullet
     *            the bullet removed from the player bullet Collection.
     */
    @Override
    public void removeBulletPlayer(final Bullet bullet) {
        this.listBulletPlayer.remove(bullet);
    }

    /**
     * @param enemy
     *            the enemy removed from the enemy list.
     */
    @Override
    public void removeEnemy(final Animated enemy) {
        this.listEnemy.remove(enemy);
    }

    /**
     * @param bullet
     *            the bullet to add to the bulletList of the Player.
     */
    @Override
    public void addPlayerBullet(final Bullet bullet) {
        this.listBulletPlayer.add(bullet);
    }

    /**
     * @param bullet
     *            the bullet to add to the bulletList of the Enemies.
     */
    @Override
    public void addEnemyBullet(final Bullet bullet) {
        this.listBulletEnemies.add(bullet);
    }

    /**
     * @param newRoom
     *            the new Room to add.
     */
    @Override
    public void addRoom(final Room newRoom) {
        this.listRoom.add(newRoom);
    }

    /**
     * @return the player(user) object.
     */
    @Override
    public Animated getPlayer() {
        return this.player;
    }

    /**
     * @param btn
     *            the button to add.
     */
    @Override
    public void addButton(final Button btn) {
        this.button = btn;
    }

    /**
     * @param effect
     *            the change status of the button.
     */
    @Override
    public void setButton(final boolean effect) {
        this.button.setPressed(effect);
    }

    /**
     * @param deltaTime
     *            A fixed amount of time that will effect the game flow.
     * @param listMovement
     *            the list of command to be updated.
     * @param listShots
     *            the list of command to be updated.
     */
    @Override
    public void update(final double deltaTime, final List<Command> listMovement, final List<Command> listShots) {
        resetObjects();
        incInternalDT(deltaTime);
        ModelUtility.updateListMovementCommand(listMovement);
        ModelUtility.updateListShotCommand(listShots);
        ModelUtility.updateRoomModelUtility(this.room);
        this.listMovements = listMovement;
        this.listShots = listShots;
        createPlayerBullet();
        this.player.update(deltaTime);
        if (getActualRoom().equals(this.listRoom.get(0))) {
            mainRoomActions(deltaTime);
            ModelUtility.updatePauseDuringRound(this.button.isPressed());
        } else if (getActualRoom().equals(this.listRoom.get(1))) {
            shopRoomAction();
            ModelUtility.updatePauseDuringRound(true); // you can always pause in the shop
        } else {
            bossRoomAction(deltaTime);
            ModelUtility.updatePauseDuringRound(this.button.isPressed());
        }
        ModelUtility.updateCurrentRound(this.currentRound);
        ModelUtility.updateListWorldEvent(this.listEvent);
        ModelUtility.updatePlayerModelUtility(getPlayer());
        ModelUtility.updateListAnimatedObject(getNewListGameObj());
    }

    /**
     * @return the list of command pressed by the user for moving.
     */
    @Override
    public List<Command> getMovementCommandList() {
        return this.listMovements;
    }

    /**
     * @return the list of command pressed by the user for shots.
     */
    public List<Command> getShotCommandList() {
        return this.listShots;
    }

    /**
     * @return the current round.
     */
    public int getCurrentRound() {
        return this.currentRound;
    }

    //
    // Private methods for update utility.
    //

    /**
     * Increment player's life.
     * 
     * @param life
     *            hp to increment to the player. increment the player's heart by an
     *            amount.
     */
    private void incPlayerLife(final int life) {
        final AbstractCharacter player = (AbstractCharacter) getPlayer();
        player.incLife(life);
        listEvent.add(new PlayerHeartChange(player.getLife()));
    }

    /**
     * Decrement player's life. If the life is <= 0 create the PlayerDied event.
     * 
     * @param life
     *            hp to decrement to the player.
     * @param c
     *            Animated object to cast.
     */
    private void decPlayerLife(final int life, final Animated c) {
        final AbstractCharacter player = (AbstractCharacter) c;
        player.decLife(life);
        listEvent.add(new PlayerHeartChange(player.getLife()));
        if (player.getLife() <= 0 && !this.mode.equals(Mode.GOD)) {
            this.listEvent.add(new PlayerDied());
        }
    }

    /**
     * Decrement enemy's life.
     * 
     * @param life
     *            hp to decrement from the enemy.
     * @param e
     *            Animated object to cast.
     */
    private Animated decEnemyLife(final int life, final Animated e) {
        final AbstractCharacter enemy = (AbstractCharacter) e;
        final Enemy enemyPoints = (Enemy) enemy;
        enemy.decLife(life);
        if (enemy.getLife() <= 0) {
            listEvent.add(new PlayerKillEnemy(enemyPoints.getPoint()));
            return enemy;
        }
        return null;
    }

    /**
     * Method to put first of the update before to check the collision with
     * enemy/enemy bullet.
     * 
     * @return if the enemy in a room are all defeated.
     */
    private boolean allEnemyDefeated() {
        return this.listEnemy.isEmpty();
    }

    /**
     * Check if a enemy bullet's hits the player.
     * 
     * @param p
     *            player.
     */
    private void playerGetsHitByBullet(final Animated p, final Double deltaTime) {
        final List<Bullet> dieBullets = new ArrayList<>();
        final AbstractCharacter player = (AbstractCharacter) p;
        for (final Bullet b : this.listBulletEnemies) {
            b.update(deltaTime);
            if (!CollisionUtil.entityCollision(b, player).isEmpty() && !b.isDead()) {
                decPlayerLife(DAMAGE, player);
                dieBullets.add(b);
            }
            if (b.isDead()) {
                dieBullets.add(b);
            }
        }
        this.listBulletEnemies.removeAll(dieBullets);
    }

    /**
     * Check if a player's bullet hits an enemy.
     */
    private void playerBulletHitsEnemy(final Double deltaTime) {
        final List<Bullet> dieBullets = new ArrayList<>();
        final List<Animated> dieEnemy = new ArrayList<>();
        for (final Bullet b : this.listBulletPlayer) {
            b.update(deltaTime);
            for (final Animated enemy : this.listEnemy) {
                if (!CollisionUtil.entityCollision(b, enemy).isEmpty()) {
                    if (!Objects.isNull(decEnemyLife(DAMAGE, enemy))) {
                        dieEnemy.add(enemy);
                    }
                    dieBullets.add(b);
                }
            }
            if (b.isDead()) {
                dieBullets.add(b);
            }
        }
        listBulletPlayer.removeAll(dieBullets);
        listEnemy.removeAll(dieEnemy);
    }

    /**
     * Increment the current round.
     */
    private void incCurrentRound() {
        this.currentRound++;
    }

    /**
     * @return the updated list of the game object in the game.
     */
    private List<Animated> getNewListGameObj() {
        this.listAnimatedObj.add(getPlayer());
        this.listAnimatedObj.addAll(this.listBulletEnemies);
        this.listAnimatedObj.addAll(this.listBulletPlayer);
        this.listAnimatedObj.addAll(this.listEnemy);
        return this.listAnimatedObj;
    }

    /**
     * @param hb1
     *            first CirceHitbox.
     * @param hb2
     *            second CirceHitbox.
     * @return if the two objects are colliding.
     */
    private boolean isColliding(final CircleHitBox hb1, final CircleHitBox hb2) {
        final Collection<Command> c = CollisionUtil.entityCollision(hb1, hb2);
        return !c.isEmpty();
    }

    /**
     * create player bullets.
     * 
     * @param listShot
     *            the list of the shots to create.
     */
    private void createPlayerBullet() {
        if (!this.listShots.isEmpty() && ((AbstractCharacter) getPlayer()).canShot()) {
            Command d = listShots.get(0);
            listShots.clear();
            listShots.add(d);
            ModelUtility.updateListShotCommand(listShots);
            this.listBulletPlayer.addAll(getPlayer().shot());
        }
    }

    /**
     * Action in the main room.
     * 
     * @param deltaTime
     *            delta time.
     */
    private void mainRoomActions(final Double deltaTime) {
        if (getActualRoom().equals(this.listRoom.get(0))) {
            wallColliding();
            if (allEnemyDefeated() && !this.button.isPressed()) {
                playerBulletHitsEnemy(deltaTime);
            }
            if (!this.button.isPressed() && getCurrentRound() >= 4
                    && CollisionUtil.doorPlayerCollision((CircleHitBox) getPlayer().getHitBox(),
                            (RectangularHitBox) we.getRightDoorFromMainToShop().getHitBox())
                    && !this.mode.equals(Mode.INFINITE)) {
                // se hai finito i round nella main puoi andare nello shop.
                this.room = this.listRoom.get(1);
                listEvent.add(new RoomChange(this.room));
                getPlayer().getHitBox().changePosition(SpawnUtility.getSpawnXEnterRightDoor(),
                        SpawnUtility.getSpawnYEnterRightDoor());
            }
            if (!this.listEnemy.isEmpty()) {
                listEnemy.forEach(x -> {
                    x.update(deltaTime);
                    if (((AbstractCharacter) x).canShot()) {
                        listBulletEnemies.addAll(x.shot());
                    }
                });
            }
            if (!allEnemyDefeated()) {
                playerBulletHitsEnemy(deltaTime);
                playerGetsHitByBullet(getPlayer(), deltaTime);
                if (allEnemyDefeated()) {
                    this.listBulletEnemies.clear();
                    this.listEvent.add(new PlayerKillAllEnemy());
                    incCurrentRound();
                    this.button.setPressed(false);
                    if (this.mode.equals(Mode.NORMAL)) {
                        we.getRightDoorFromMainToShop().setOpen(true);
                    }
                    if (getCurrentRound() >= 4 && this.mode.equals(Mode.NORMAL)) {
                        we.getRightDoorFromShopToBoss().setOpen(true);
                    }
                }
            }
            if (!this.button.isPressed()
                    && isColliding((CircleHitBox) this.button.getHitBox(), (CircleHitBox) getPlayer().getHitBox())
                    && getCurrentRound() < 4) {
                // se il bottone non è premuto e lo preme parte il round sucessivo.
                // nella modalità normale ci sono 3 round e dopo la fine del terzo il current
                // round sarà 4 quindi premendo il botton non succ niente.
                setNextRound();
                this.listEvent.add(new PlayerHitButton());
            }
        }
    }

    /**
     * Action in the boss room.
     * 
     * @param deltaTime
     *            dt.
     */
    private void bossRoomAction(final double deltaTime) {
        if (getActualRoom().equals(this.listRoom.get(2))) {
            final Animated boss = we.getBoss();
            playerBulletHitsEnemy(deltaTime);
            if (!isBossDefeated()) {
                this.listEnemy.add(boss);
                boss.update(deltaTime);
                playerGetsHitByBullet(getPlayer(), deltaTime);
                if (allEnemyDefeated()) {
                    this.bossDefeated = true;
                    this.listEvent.add(new PlayerKillBoss());
                }
            }
        }
    }

    /**
     * Action in the shop room.
     */
    private void shopRoomAction() {
        if (getActualRoom().equals(this.listRoom.get(1))) {
            for (final Inanimated i : we.getItems()) {
                final Heart h = (Heart) i;
                if (isColliding((CircleHitBox) getPlayer().getHitBox(), (CircleHitBox) i.getHitBox())) {
                    incPlayerLife(h.getLife());
                    we.getItems().remove(i);
                }
            }
            if (CollisionUtil.doorPlayerCollision((CircleHitBox) getPlayer().getHitBox(),
                    (RectangularHitBox) we.getRightDoorFromShopToBoss().getHitBox())) {
                this.room = this.listRoom.get(2);
                listEvent.add(new RoomChange(this.room));
                we.getLeftDoorFromBossToShop().setOpen(false);
                this.listEvent.add(new BossFightStarted());
                getPlayer().getHitBox().changePosition(SpawnUtility.getSpawnXEnterRightDoor(),
                        SpawnUtility.getSpawnYEnterRightDoor());
            }
        }
    }

    /**
     * @return the player in the spawn A of the map.
     */
    private Animated playerCreation() {
        final HitBox hb = new CircleHitBox(SpawnUtility.getSpawnAX(), SpawnUtility.getSpawnAY(),
                ProportionUtility.getRadiusPlayer());
        return new PlayerImpl(EntityStats.PLAYER.getVel(), EntityStats.PLAYER.getLife(), hb,
                new BasicAI(new PlayerMovement(), new PlayerProjectile()),
                ImageType.PLAYER, EntityStats.PLAYER.getShotRatio(), EntityStats.PLAYER.getBulletRadius(), EntityStats.PLAYER.getBulletVel(), EntityStats.PLAYER.getBulletRange(), EntityStats.PLAYER.getBulletDamage());
    }

    /**
     * reset lists.
     */
    private void resetObjects() {
        this.listEvent.clear();
        this.listAnimatedObj.clear();
    }

    /**
     * Collisions with the walls.
     */
    private void wallColliding() {
        CollisionUtil.checkBoundaryCollision((CircleHitBox) this.player.getHitBox(),
                (RectangularHitBox) we.getRoomHB());
        for (final Animated enemy : this.listEnemy) {
            if (CollisionUtil.checkBoundaryCollision((CircleHitBox) enemy.getHitBox(),
                    (RectangularHitBox) we.getRoomHB())) {
                final AbstractCharacter character = (AbstractCharacter) enemy;
                if (character.getAI().getMovementStrategy() instanceof SimplyDirectionMovement) {
                    final SimplyDirectionMovement movement = (SimplyDirectionMovement) character.getAI()
                            .getMovementStrategy();
                    movement.reverseMovementDirection();
                }
            }
        }
    }

    private void incInternalDT(final double dt) {
        ((AbstractCharacter) getPlayer()).incAttendTime(dt);
        listEnemy.forEach(x -> {
            ((AbstractCharacter) x).incAttendTime(dt);
        });
    }
}
