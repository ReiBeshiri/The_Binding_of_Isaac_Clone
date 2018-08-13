package model.utility;

/**
 * Enumeration that represent rooms in game.
 */
public enum RoomEnum {

    /**
     * Boss room.
     */
    BOSSROOM(0),

    /**
     * Main room.
     */
    MAINROOM(1),

    /**
     * Shop room.
     */
    SHOPROOM(2);

    private final int x;

    /**
     * @param x the index.
     */
    RoomEnum(final int x) {
        this.x = x;
    }

    /**
     * @return the index of the room.
     */
    public int getIndex() {
        return x;
    }
}
