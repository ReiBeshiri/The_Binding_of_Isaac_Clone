package utility;

import java.util.List;

import input.Command;
import model.animated.Animated;
import model.animated.Player;
import model.hitbox.HitBox;
import model.room.Room;
import worldevent.WorldEvent;
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
    private static List<WorldEvent> listWorldEvent; //Communicate with Controller.
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
        return ModelUtility.listShotsCommand;
    }
    /**
     * Method to communicate with the Controller.
     *  the controller should only take this list from the model.
     * @return the WorldEvent list.
     */
    public static List<WorldEvent> getWorldEventList() {
        return listWorldEvent;
    }
    /**
     * @param player 
     *          the new player to update.
     */
    public static void updatePlayerModelUtility(final Animated player) {
        ModelUtility.player = player;
    }
    /**
     * @param list
     *          the new list.
     */
    public static void updateListWorldEvent(final List<WorldEvent> list) {
        ModelUtility.listWorldEvent = list;
    }
    /**
     * @param room update room.
     */
    public static void updateRoomModelUtility(final Room room) {
        ModelUtility.room = room;
    }
    /**
     * @param listShotsCommand
     *          the new list.
     * @param listMovementCommand
     *          the new list.
     */
    public static void updateListCommandModelUtility(final List<Command> listMovementCommand, final List<Command> listShotsCommand) {
        ModelUtility.listMovementCommand = listMovementCommand;
        ModelUtility.listShotsCommand = listShotsCommand;
    }
}
