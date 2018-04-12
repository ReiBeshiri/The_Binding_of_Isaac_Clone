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
public final class ModelUtilityImpl {
    /**
     * Private Constructor for static class.
     */
    private ModelUtilityImpl() {
    }
    private static Player player; 
    private static Room room;
    private static List<Command> listCommand;
    private static HitBox hb;
    /**
     * @return player.
     */
    public static Player getPlayer() {
        return player;
    }
    /**
     * @return player hitbox.
     */
    public static HitBox getPlayerHitBox() {
        return hb;
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
    public void updatePlayerModelUtility(final Player player) {
        ModelUtilityImpl.player = player;
    }
    /**
     * @param hb
     *          the new hb.
     */
    public void updatePlayerHBModelUtility(final HitBox hb) {
        ModelUtilityImpl.hb = hb;
    }
    /**
     * @param room
     *          the new room.
     */
    public void updateRoomModelUtility(final Room room) {
        ModelUtilityImpl.room = room;
    }
    /**
     * @param list
     *          the new list.
     */
    public void updateListCommandModelUtility(final List<Command> list) {
        ModelUtilityImpl.listCommand = list;
    }
}
