package utility;

import java.util.List;

import input.Command;
import model.animated.Animated;
import model.animated.Player;
import model.hitbox.HitBox;
import model.room.Room;
/**
 * 
 *
 */
public final class ModelUtility {
    /**
     * Private Constructor for static class.
     */
    private ModelUtility() {
    }
    private static Animated player; 
    private static Room room;
    private static List<Command> listCommand;
    /**
     * @return player.
     */
    public static Animated getPlayer() {
        return player;
    }
    /**
     * @return player hitbox.
     */
    public static HitBox getPlayerHitBox() {
        return player.getHitBox();
    }
    /**
     * @return room.
     */
    public static Room getRoom() {
        return room;
    }
    /**
     * @return List of Command.
     */
    public static List<Command> getListCommand() {
        return listCommand;
    }
    /**
     * @param player 
     *          the new player to update.
     */
    public void updatePlayerModelUtility(final Animated player) {
        ModelUtility.player = player;
    }
    /**
     * @param room
     *          the new room.
     */
    public void updateRoomModelUtility(final Room room) {
        ModelUtility.room = room;
    }
    /**
     * @param list
     *          the new list.
     */
    public void updateListCommandModelUtility(final List<Command> list) {
        ModelUtility.listCommand = list;
    }
}
