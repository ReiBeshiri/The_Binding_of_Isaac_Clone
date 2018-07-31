package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import input.Command;
import model.ai.BasicAI;
import model.animated.AbstractCharacter;
import model.animated.Animated;
import model.animated.Bullet;
import model.animated.BulletImpl;
import model.animated.Enemy;
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
import worldevent.WorldEvent;

/**
* WorldImpl. 
*
*/
public class WorldImpl implements World {
    private Animated player;                            //|is the player
    private List<GameObject> listGameObject = new ArrayList<>();
    private Room room;                                  //|method addRoom is setRoom
    private boolean gameOver = false;   //false initially
    private boolean bossDefeated;   //false initially
    private List<Bullet> listBulletPlayer = new ArrayList<>();
    private List<Bullet> listBulletEnemies = new ArrayList<>();
    private Button button;
    private List<Command> listMovements = new ArrayList<>();
    private List<Command> listShots = new ArrayList<>();
    private List<Animated> listEnemy = new ArrayList<>();                   //|list of enemies
    private List<Room> listRoom = new ArrayList<>();
    private List<WorldEvent> listEvent = new ArrayList<>();
    private int currentRound = 1;
    private static final int DAMAGE = 1;
    private Mode mode;
    private RoundsGenerator roundsGenerator;
    private WorldEnvironment we;
    private double shotRatio = ProportionUtility.getPlayerBulletRatio();
    /**
     * @return list of game objects.
     */
    @Override
    public List<GameObject> getAllElements() {
        return this.listGameObject;
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
     *           the player that will be set.
     */
    @Override
    public void createPlayer(final Animated player) {
        this.player = player;
        ModelUtility.updatePlayerModelUtility(player);
    }

    /**
     * Create the environment.
     * Needs to be called to create the rooms.
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
     * Set the game mode.
     * The mode chosen by the player.
     * Needs to be called to set the mode.
     * @param m the game mode chosen by the player.
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
     * Set the next round by adding to the list of enemy the new monsters to generate.
     */
    @Override
    public void setNextRound() {
        listEnemy.addAll(roundsGenerator.generateMonster());
    }

    /**
     * @param bullet
     *          the bullet removed from the enemy bullet list.
     */
    @Override
    public void removeBulletEnemy(final Bullet bullet) {
        this.listBulletEnemies.remove(bullet);
    }

    /**
     * @param bullet
     *          the bullet removed from the player bullet Collection.
     */
    @Override
    public void removeBulletPlayer(final Bullet bullet) {
        this.listBulletPlayer.remove(bullet);
    }

    /**
     * @param enemy
     *          the enemy removed from the enemy list. 
     */
    @Override
    public void removeEnemy(final Animated enemy) {
        this.listEnemy.remove(enemy);
    }

    /**
     * @param bullet
     *          the bullet to add to the bulletList of the Player.
     */
    @Override
    public void addPlayerBullet(final Bullet bullet) {
        this.listBulletPlayer.add(bullet);
    }

    /**
     * @param bullet
     *          the bullet to add to the bulletList of the Enemies.
     */
    @Override
    public void addEnemyBullet(final Bullet bullet) {
        this.listBulletEnemies.add(bullet);
    }

    /**
     * @param newRoom
     *          the new Room to add.
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
     *          the button to add.
     */
    @Override
    public void addButton(final Button btn) {
        this.button = btn;
    }

    /**
     * @param effect
     *          the change status of the button.
     */
    @Override
    public void setButton(final boolean effect) {
        this.button.setPressed(effect);
    }

    /**
     * @param deltaTime
     *            A fixed amount of time that will effect the game flow.
     * @param listMovement 
     *          the list of command to be updated.
     * @param listShots 
     *          the list of command to be updated.
     */
    @Override
    public void update(final double deltaTime, final List<Command> listMovement, final List<Command> listShots) {
        this.shotRatio += deltaTime;
        resetObjects();
        ModelUtility.updateListCommandModelUtility(listMovement, listShots);
        this.listMovements = listMovement;
        this.listShots = listShots;
        createPlayerBullet(listShots);
        this.player.update(deltaTime);
        if (getActualRoom().equals(this.listRoom.get(0))) {
            mainRoomActions(deltaTime);
        } else if (getActualRoom().equals(this.listRoom.get(1))) {
            shopRoomAction();
        } else {
            bossRoomAction(deltaTime);
        }
        //update ModelUtility
        ModelUtility.updateCurrentRound(this.currentRound);
        //ModelUtility.updateListCommandModelUtility(listMovement, listShots);
        ModelUtility.updateListWorldEvent(this.listEvent);
        ModelUtility.updatePlayerModelUtility(getPlayer());
        ModelUtility.updateRoomModelUtility(this.room);
        ModelUtility.updateListGameObject(getNewListGameObj());
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
    //Private methods for update utility.
    //

    /**
     * Increment player's life.
     * @param life hp to increment to the player.
     * increment the player's heart by an amount.
     */
    private void incPlayerLife(final int life) {
        AbstractCharacter player = (AbstractCharacter) getPlayer();
        player.incLife(life);
        listEvent.add(new PlayerHeartChange(player.getLife()));
    }

    /**
     * Decrement player's life.
     * If the life is <= 0 create the PlayerDied event.
     * @param life hp to decrement to the player.
     * @param c Animated object to cast.
     */
    private void decPlayerLife(final int life, final Animated c) {
        AbstractCharacter player = (AbstractCharacter) c;
        player.decLife(life);
        listEvent.add(new PlayerHeartChange(player.getLife()));
        if (player.getLife() <= 0) {
            if (!this.mode.equals(Mode.GOD)) {
                this.listEvent.add(new PlayerDied());
            }
        }
    }

    /**
     * Decrement enemy's life.
     * @param life hp to decrement from the enemy.
     * @param e Animated object to cast.
     */
    private void decEnemyLife(final int life, final Animated e) {
        AbstractCharacter enemy = (AbstractCharacter) e;
        Enemy enemyPoints = (Enemy) enemy;
        enemy.decLife(life);
        if (enemy.getLife() <= 0) {
            listEvent.add(new PlayerKillEnemy(enemyPoints.getPoint()));
        }
        removeEnemy(enemy);
    }

    /**
     * Method to put first of the update before to check the collision with enemy/enemy bullet. 
     * @return if the enemy in a room are all defeated.
     */
    private boolean allEnemyDefeated() {
        return this.listEnemy.isEmpty();
    }

    /**
     * Check if a enemy bullet's hits the player.
     * @param p player.
     */
    private void playerGetsHitByBullet(final Animated p, final Double deltaTime) {
        final List<Bullet> dieBullets = new ArrayList<>();
        AbstractCharacter player = (AbstractCharacter) p;
        for (Bullet b : this.listBulletEnemies) {
            b.update(deltaTime);
            if (!CollisionUtil.entityCollision(b, player).isEmpty() && !b.isDead()) {
                decPlayerLife(DAMAGE, player);
                removeBulletEnemy(b);
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
        for (Bullet b : this.listBulletPlayer) {
            b.update(deltaTime);
            for (Animated enemy : this.listEnemy) {
                if (!CollisionUtil.entityCollision(b, enemy).isEmpty() && !b.isDead()) {
                    decEnemyLife(DAMAGE, enemy);
                    dieBullets.add(b);
                }
            }
            if (b.isDead()) {
                dieBullets.add(b);
            }
        }
        listBulletPlayer.removeAll(dieBullets);
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
    private List<GameObject> getNewListGameObj() {
        this.listGameObject.add(getPlayer());
        this.listGameObject.add(this.button);
        this.listGameObject.addAll(this.listBulletEnemies);
        this.listGameObject.addAll(this.listBulletPlayer);
        this.listGameObject.addAll(this.listEnemy);
        return this.listGameObject;
    }

    /**
     * @param hb1 first CirceHitbox.
     * @param hb2 second CirceHitbox.
     * @return if the two objects are colliding.
     */
    private boolean isColliding(final CircleHitBox hb1,  final CircleHitBox hb2) {
        Collection<Command> c = CollisionUtil.entityCollision(hb1, hb2);
        return !c.isEmpty();
    }

    /**
     * create player bullets.
     * @param listShot the list of the shots to create.
     */
    private void createPlayerBullet(final List<Command> listShot) {
        if (this.shotRatio < ProportionUtility.getPlayerBulletRatio()) {
            this.listShots.clear();
        } else {
            if (!this.listShots.isEmpty()) {
                MovementStrategy ms = new SimplyDirectionMovement(this.listShots.get(0));
                HitBox hb = new CircleHitBox(this.player.getHitBox().getX(), this.player.getHitBox().getY(), ProportionUtility.getRadiusBullet());
                this.listBulletPlayer.add(new BulletImpl((CircleHitBox) hb, ProportionUtility.getPlayerVel(), ms, ProportionUtility.getPlayerBulletRange(), ImageType.ENEMY_BULLET));
                this.shotRatio = 0;
            }
            this.listShots.clear();
        }
    }

    /**
     * Action in the main room.
     * @param deltaTime delta time.
     */
    private void mainRoomActions(final Double deltaTime) {
        if (getActualRoom().equals(this.listRoom.get(0))) {
            if (!this.button.isPressed() && getCurrentRound() >= 4 && CollisionUtil.doorPlayerCollision((CircleHitBox) getPlayer().getHitBox(), (RectangularHitBox) we.getRightDoorFromMainToShop().getHitBox()) && this.mode.equals(Mode.NORMAL)) {
                //se hai finito i round nella main puoi andare nello shop.
                this.room = this.listRoom.get(2);
                getPlayer().getHitBox().changePosition(SpawnUtility.getSpawnXEnterRightDoor(), SpawnUtility.getSpawnYEnterRightDoor());
            }
            //wallColliding();
            playerBulletHitsEnemy(deltaTime);
            if (!this.listEnemy.isEmpty()) {
                this.listEnemy.iterator().next().update(deltaTime);
            }
            if (!allEnemyDefeated()) {
                playerGetsHitByBullet(getPlayer(), deltaTime);
                if (allEnemyDefeated()) {
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
            if (!this.button.isPressed() && isColliding((CircleHitBox) this.button.getHitBox(), (CircleHitBox) getPlayer().getHitBox())) {
                //se il bottone non è premuto e lo preme parte il round sucessivo.
                //nella modalità normale ci sono 3 round e dopo la fine del terzo il current round sarà 4 quindi premendo il botton non succ niente.
                setNextRound();
                this.listEvent.add(new PlayerHitButton());
            }
        }
    }

    /**
     * Action in the boss room.
     * @param deltaTime dt.
     */
    private void bossRoomAction(final double deltaTime) {
        if (getActualRoom().equals(this.listRoom.get(2))) {
            if (!isBossDefeated()) {
                Animated boss = we.getBoss();
                this.listEnemy.add(boss);
                boss.update(deltaTime);
                playerGetsHitByBullet(getPlayer(), deltaTime);
                playerBulletHitsEnemy(deltaTime);
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
            for (Inanimated i : we.getItems()) {
                Heart h = (Heart) i;
                if (isColliding((CircleHitBox) getPlayer().getHitBox(), (CircleHitBox) i.getHitBox())) {
                    incPlayerLife(h.getLife());
                    we.getItems().remove(i);
                }
            }
            if (CollisionUtil.doorPlayerCollision((CircleHitBox) getPlayer().getHitBox(), (RectangularHitBox) we.getRightDoorFromShopToBoss().getHitBox())) {
                this.room = this.listRoom.get(2);
                we.getLeftDoorFromBossToShop().setOpen(false);
                this.listEvent.add(new BossFightStarted());
                getPlayer().getHitBox().changePosition(SpawnUtility.getSpawnXEnterRightDoor(), SpawnUtility.getSpawnYEnterRightDoor());
            }
        }
    }

    /**
     * @return the player in the spawn A of the map.
     */
    private Animated playerCreation() {
        HitBox hb = new CircleHitBox(SpawnUtility.getSpawnAX(), SpawnUtility.getSpawnAY(),
                ProportionUtility.getRadiusPlayer());
        Animated p = new PlayerImpl(ProportionUtility.getPlayerVel(), ProportionUtility.getPlayerLife(), hb,
                new BasicAI(new PlayerMovement(), new PlayerProjectile(ProportionUtility.getRadiusBullet())),
                ProportionUtility.getPlayerBulletRange(), ImageType.PLAYER, ProportionUtility.getPlayerBulletRatio());
        return p;
    }

    /**
     * reset lists.
     */
    private void resetObjects() {
        this.listEvent.clear();
        this.listGameObject.clear();
    }

    /**
     * Collisions with the walls.
     */
    private void wallColliding() {
            CollisionUtil.checkBoundaryCollision((CircleHitBox) this.player.getHitBox(), (RectangularHitBox) we.getRoomHB());
    }
}
