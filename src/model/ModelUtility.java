package model;

import java.util.List;

import input.Command;
import model.animated.Player;
import model.hitbox.HitBox;
import model.room.Room;

/**
 * Model Utility Interface.
 *
 */
public interface ModelUtility {
    /**
     * 
     * @return the Player.
     */
    Player getPlayer();
    /**
     * 
     * @return Player HitBox.
     */
    HitBox getPlayerHitBox();
    /**
     * 
     * @return the Actual Room.
     */
    Room getRoom();
    /**
     * 
     * @return the List of the Command pressed.
     */
    List<Command> getListCommand();
}
