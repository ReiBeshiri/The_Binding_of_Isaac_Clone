package model.room;

import java.util.List;

import model.hitbox.HitBox;
import model.inanimated.Button;
import model.inanimated.Door;
import model.inanimated.Wall;
/**
 * 
 * MainRoom implements.
 *
 */
public class MainRoom extends AbstractRoom {
    private final Button button;

    /**
     * Constructor for the room.
     * @param h HitBox of MainRoom.
     * @param doors MainRoom's doors.
     * @param button MainRoom's button.
     * @param walls list of the walls in the room.
     */
    public MainRoom(final HitBox h, final List<Door> doors, final Button button, final List<Wall> walls) {
        super(h, doors, walls);
        this.button = button;
    }

    /**
     * 
     * @return MainRoom's button.
     */
    public Button getButton() {
        return button;
    }
}
