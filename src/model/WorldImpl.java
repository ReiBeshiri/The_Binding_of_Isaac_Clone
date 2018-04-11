package model;

import java.util.List;

import input.Command;
import model.animated.Bullet;
import model.animated.Enemy;
import model.animated.Player;
import model.inanimated.Button;
import model.room.Room;
import worldevent.WorldEvent;
    /**
     *WorldImpl. 
     *
     */
public class WorldImpl implements World {
    private Player player;
    private List<GameObject> listGameObject;
    private Room room;                                  //|method addRoom is setRoom
    private boolean gameOver;   //false initially
    private boolean bossDefeated;   //false initially
    private List<Bullet> listBulletPlayer;              //|keep track of 2 different lists
    private List<Bullet> listBulletEnemies;             //|keep track of 2 different lists
    private Button button;                              //|need setButtonState as method
    private WorldEvent listener;
    private List<Command> listCommand;
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
    public void setPlayer(final Player player) {
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
     *          the bullet removed from the bullet Collection.
     */
    @Override
    public void removeBullet(final Bullet bullet) {
        // TODO Auto-generated method stub
    }
    /**
     * @param enemy
     *          the enemy removed from the enemy list. 
     */
    @Override
    public void removeEnemy(final Enemy enemy) {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
    }
    /**
     * @return the player(user) obj.
     */
    @Override
    public Player getPlayer() {
        return this.player;
    }
    /**
     * @param btn
     *          the button to add.
     */
    @Override
    public void addButton(final Button btn) {
        // TODO Auto-generated method stub

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
        // TODO Auto-generated method stub
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
     * @param list 
     *          the list of command to be updated.
     */
    @Override
    public void update(final double deltaTime, final List<Command> list) {
        // TODO Auto-generated method stub
    }
    /**
     * @return the list of command pressed by the user.
     */
    @Override
    public List<Command> getCommandList() {
        return this.listCommand;
    }

}
