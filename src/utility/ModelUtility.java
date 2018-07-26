package utility;

import java.util.List;
import input.Command;
import model.GameObject;
import model.animated.Animated;
import model.hitbox.HitBox;
import model.room.Room;
import worldevent.WorldEvent;

/**
 * Utility used to obtain information of model.
 *
 */
public final class ModelUtility {

    private static final double WORLD_HEIGHT = 600;
    private static final double WORLD_WIDTH = 800;
    private static final double WORLD_WIDTH_PROP = 4;
    private static final double WORLD_HEIGHT_PROP = 3;
    private static int currentRound;
    private static Animated player; 
    private static Room room;
    private static List<Command> listMovementCommand; //The list of the movement of the player.
    private static List<Command> listShotsCommand;
    private static List<GameObject> listGameObject;
    private static List<WorldEvent> listWorldEvent; //Communicate with Controller.

    /**
     * Private Constructor for static class.
     */
    private ModelUtility() { }

    /**
     * @return player.
     */
    public static Animated getPlayer() {
        return player;
    }

    /**
     * @return list Game Object.
     */
    public static List<GameObject> getGameObject() {
        return listGameObject;
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
     * @return current Round.
     */
    public static int getCurrentRound() {
        return currentRound;
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

    /**
     * @param newCurrent new current round to update.
     */
    public static void updateCurrentRound(final int newCurrent) {
        ModelUtility.currentRound = newCurrent;
    }

    /**
     * @param list game object.
     *          the new list.
     */
    public static void updateListGameObject(final List<GameObject> list) {
        ModelUtility.listGameObject = list;
    }

    /**
     * World height.
     * @return world height (600).
     */
    public static double getWorldHeight() {
        return WORLD_HEIGHT;
    }

    /**
     * World width.
     * @return world width (800).
     */
    public static double getWorldWidth() {
        return WORLD_WIDTH;
    }

    /**
     * World height proportion.
     * @return world height proportion.
     */
    public static double getWorldHeightProp() {
        return WORLD_HEIGHT_PROP;
    }

    /**
     * World width proportion.
     * @return world width proportion.
     */
    public static double getWorldWidthProp() {
        return WORLD_WIDTH_PROP;
    }
}
