package model;

import java.util.List;

import input.Command;
import model.animated.Player;
import model.hitbox.HitBox;
import model.room.Room;
/**
 * 
 *
 */
public class ModelUtilityImpl implements ModelUtility {
    private Player player;
    private Room room;
    private List<Command> listCommand;
    private HitBox hb;
    /**
     * @return player.
     */
    @Override
    public Player getPlayer() {
        return this.player;
    }
    /**
     * @return player hitbox.
     */
    @Override
    public HitBox getPlayerHitBox() {
        return this.hb;
    }
    /**
     * @return room.
     */
    @Override
    public Room getRoom() {
        return this.room;
    }
    /**
     * @return List of Command.
     */
    @Override
    public List<Command> getListCommand() {
        return this.listCommand;
    }

}
