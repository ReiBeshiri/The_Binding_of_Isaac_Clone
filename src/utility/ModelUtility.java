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
    private static List<Command> listMovementCommand;
    private static List<Command> listShotsCommand;
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
     * @return List of Command for moving.
     */
    public static List<Command> getListMovementCommand() {
        return listMovementCommand;
    }
    /**
     * @return List of Command for shots.
     */
    public static List<Command> getListShotsCommand() {
        return listShotsCommand;
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
     * @param listShotsCommand
     *          the new list.
     * @param listMovementCommand
     *          the new list.
     */
    public void updateListCommandModelUtility(final List<Command> listMovementCommand, final List<Command> listShotsCommand) {
        ModelUtility.listMovementCommand = listMovementCommand;
        ModelUtility.listMovementCommand = listShotsCommand;
    }
}
