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
 * Interface.
 * World
 **/
public interface World {
    /**
     * It gives you a GameObject list with all the objects (elements).
     * 
     * @return Return a list of all the object in the current World state
     */
    List<GameObject> getAllElements();
    /**
     * get the current Room.
     * 
     * @return Return a Room type object that define the current room
     */
    Room getActualRoom();
    /**
     * if the player loses all the hearts the method should return true, false otherwise.
     * 
     * @return Return a boolean that define if the game is Over
     */
    boolean isGameOver();
    /**
     * if the Boss is defeated the method should return true, false otherwise.
     * 
     * @return Return a boolean that define if the Boss is defeated
     */
    boolean isBossDefeated();
    /**
     * 
     * @param player
     *          set the playable character
     */
    void setPlayer(Player player);
    /**
     * This method set the next round to be played.
     * 
     * Initially there are limited and defined rounds.
     */
    void setNextRound();
    /**
     * set the listener to the World.
     * 
     * @param listener
     *          the listener to be set
     */
    void setEventListener(WorldEvent listener);
    /**
     * This method removes a bullet from the World.
     * Usually when the bullet collides this other objects.
     * 
     * @param bullet
     *          the bulled to be deleted
     */
    void removeBullet(Bullet bullet);
    /**
     * This method removes a enemy from the World.
     * Usually when the enemy loses all his hearts.
     * 
     * @param enemy
     *          the enemy to be deleted
     */
    void removeEnemy(Enemy enemy);
    /**
     * When a command to shot is received, a shot is created in the World.
     * 
     * This method adds to a Bullet List of the player the new bullet created.
     * 
     * @param bullet
     *          the bullet that will be added to the List<Bullet>
     */
    void addPlayerBullet(Bullet bullet);
    /**
     * Within a delta time the enemy shots, a shot is created in the World.
     * 
     * This method adds to a Bullet List of the enemy the new bullet created.
     * 
     * @param bullet
     *          the bullet that will be added to the List<Bullet>
     */
    void addEnemyBullet(Bullet bullet);
    /**
     * TO BE CORRECTLY DEFINED.
     * 
     * @param deltaTime
     *                 DT to define
     * @param list
     *          list of command the player press
     */
    void update(double deltaTime, List<Command> list);
    /**
     * Add a new room.
     * 
     * @param newRoom
     *          the new room to add
     */
    void addRoom(Room newRoom);
    /**
     * This method return a Player type Object. 
     * 
     * @return Return the Player Object
     */
    Player getPlayer();
    /**
     * Add a Button to the World.
     * 
     * @param btn
     *          the button to add
     */
    void addButton(Button btn);
    /**
     * 
     * °°°°°° da rivedere, non sono sicuro °°°°°°.
     * 
     * Refresh the shot ratio of the enemies.
     * When an enemy could shot this method will be called in the update
     */
    void refreshShotRatio();
    /**
     * change button state.
     * @param effect
     *          true the button will be activated, false otherwise.
     */
    void setButton(boolean effect);
    /**
     * World will keep track of the commands pressed by the user (updateMethod will update this list). 
     * @return  the list of the commands pressed by the user
     * 
     */
    List<Command> getCommandList();
}
