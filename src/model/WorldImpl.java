package model;

import java.util.List;

import input.Command;
import model.animated.AbstractCharacter;
import model.animated.Animated;
import model.animated.Bullet;
import model.animated.Enemy;
import model.animated.Player;
import model.inanimated.Button;
import model.room.Room;
import utility.Collisions;
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
    private WorldEvent listener;
    private List<Command> listMovements;
    private List<Command> listShots;
    private List<Animated> listEnemy;                   //|list of enemies
    private List<Room> listRoom;
    private List<WorldEvent> listEvent;
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
     * set the next round.
     */
    @Override
    public void setNextRound() {
        // TODO Auto-generated method stub
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
     * @return the player(user) obj.
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
     * refresh shot ratio.
     */
    @Override
    public void refreshShotRatio() {
        // TODO Auto-generated method stub

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
     * @param listener
     *            the listener to set as WorldEventListener.
     */
    @Override
    public void setEventListener(final WorldEvent listener) {
        this.listener = listener;
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
     * @param life hp to inc to the player.
     * inc the player's heart by an amount.
     */
    private void incPlayerLife(final int life) {
        AbstractCharacter player = (AbstractCharacter) this.player;
        player.incLife(life);
        listEvent.add(new PlayerHeartChange(player.getLife()));
    }
    /**
     * 
     * @param life hp to dec to the player.
     * @param c Animated obj to cast.
     */
    private void decPlayerLife(final int life, final Animated c) {
        AbstractCharacter player = (AbstractCharacter) c;
        player.decLife(life);
        listEvent.add(new PlayerHeartChange(player.getLife()));
    }
    /**
     * 
     * @param life hp to dec from the enemy.
     * @param e Animeted obj to cast.
     */
    private void decEnemyLife(final int life, final Animated e) {
        AbstractCharacter enemy = (AbstractCharacter) e;
        enemy.decLife(life);
        if (enemy.getLife() <= 0) {
            listEvent.add(new PlayerKillEnemy(0)); //Da qualche parte devo prendere il punteggio
        }
        removeEnemy(enemy);
    }
    /**
     * @return if the enemy in a room are all defeated.
     */
    private boolean allEnemyDefeated() {
        return this.listEnemy.isEmpty();
    }
    private void playerGetsHitByBullet(final Animated p) {
        AbstractCharacter player = (AbstractCharacter) p;
        for (Bullet b : this.listBulletEnemies) {
        //collisione tra player e lista di bullet con eliminazione bullet e scala vita al player.
        }
    }
}
