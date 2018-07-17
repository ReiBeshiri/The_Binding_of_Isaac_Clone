package model;

import java.util.List;

import input.Command;
import model.animated.AbstractCharacter;
import model.animated.Animated;
import model.animated.Bullet;
import model.animated.Enemy;
import model.animated.Player;
import model.environment.WorldEnvironment;
import model.environment.WorldEnvironmentImpl;
import model.inanimated.Button;
import model.room.Room;
import model.rounds.DynamicRounds;
import model.rounds.RoundsGenerator;
import model.rounds.StaticRounds;
import utility.CollisionUtil;
import utility.Mode;
import worldevent.PlayerHeartChange;
import worldevent.PlayerKillEnemy;
import worldevent.WorldEvent;
    /**
     *WorldImpl. 
     *
     */
public class WorldImpl implements World {
    private Animated player;                            //|is the player
    private List<GameObject> listGameObject;
    private Room room;                                  //|method addRoom is setRoom
    private boolean gameOver;   //false initially
    private boolean bossDefeated;   //false initially
    private List<Bullet> listBulletPlayer;
    private List<Bullet> listBulletEnemies;
    private Button button;
    private List<Command> listMovements;
    private List<Command> listShots;
    private List<Animated> listEnemy;                   //|list of enemies
    private List<Room> listRoom;
    private List<WorldEvent> listEvent;
    private int currentRound;
    private static final int DAMAGE = 1;
    private Mode mode;
    private RoundsGenerator roundsGenerator;
    private WorldEnvironment we;
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
    }
    /**
     * Create the environment.
     * Needs to be called to create the rooms.
     */
    public void createEnvironment() {
        we = new WorldEnvironmentImpl();
        listRoom.addAll(we.createWorld());
    }
    /**
     * Set the game mode.
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
        // TODO Auto-generated method stub
        // update ModelUtility
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
        AbstractCharacter player = (AbstractCharacter) this.player;
        player.incLife(life);
        listEvent.add(new PlayerHeartChange(player.getLife()));
    }
    /**
     * Decrement player's life.
     * @param life hp to decrement to the player.
     * @param c Animated object to cast.
     */
    private void decPlayerLife(final int life, final Animated c) {
        AbstractCharacter player = (AbstractCharacter) c;
        player.decLife(life);
        listEvent.add(new PlayerHeartChange(player.getLife()));
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
    private void playerGetsHitByBullet(final Animated p) {
        AbstractCharacter player = (AbstractCharacter) p;
        for (Bullet b : this.listBulletEnemies) {
            if (!CollisionUtil.entityCollision(b, player).isEmpty()) {
                player.decLife(DAMAGE); //where should i take the dmg from?
                removeBulletEnemy(b);
            }
        }
    }
    /**
     * Check if a player's bullet hits an enemy.
     */
    private void playerBulletHitsEnemy() {
        for (Bullet b : this.listBulletPlayer) {
            for (Animated enemy : this.listEnemy) {
                if (!CollisionUtil.entityCollision(b, enemy).isEmpty()) {
                    decEnemyLife(DAMAGE, enemy);
                    removeBulletPlayer(b);
                }
            }
         }
    }
    /**
     * Increment the current round.
     */
    private void incCurrentRound() {
        this.currentRound++;
    }
}
