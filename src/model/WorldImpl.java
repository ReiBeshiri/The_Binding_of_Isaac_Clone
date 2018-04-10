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
    /**
     * @return list of gameobj.
     */
    @Override
    public List<GameObject> getAllElements() {
        // TODO Auto-generated method stub
        return null;
    }
    /**
     * @return the actual room.
     */
    @Override
    public Room getActualRoom() {
        // TODO Auto-generated method stub
        return null;
    }
    /**
     * @return true if game is over.
     */
    @Override
    public boolean isGameOver() {
        // TODO Auto-generated method stub
        return false;
    }
    /**
     * @return true if boss is defeated.
     */
    @Override
    public boolean isBossDefeated() {
        // TODO Auto-generated method stub
        return false;
    }
    /**
     * @param player
     *           the player that will be set.
     */
    @Override
    public void setPlayer(final Player player) {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
    }
    /**
     * @param bullet
     *          the bullet to add to the bulletList of the Enemies.
     */
    @Override
    public void addEnemyBullet(final Bullet bullet) {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
        return null;
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
     * refresh shot ratio every delta time.
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
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
        return null;
    }

}
