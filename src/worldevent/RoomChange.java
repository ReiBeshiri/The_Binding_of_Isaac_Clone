package worldevent;

import model.room.Room;

/**
 * Event change room.
 */
public class RoomChange implements WorldEvent {
    private final Room room;

    /**
     * @param room the room changed.
     */
    public RoomChange(final Room room) {
        this.room = room;
    }

    /**
     * @return the new room.
     */
    public Room getNewRoom() {
        return this.room;
    }
}
