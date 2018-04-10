package model.room;

import java.util.List;

import model.hitbox.HitBox;
import model.inanimated.Button;
import model.inanimated.Door;
/**
 * 
 * MainRoom implements.
 *
 */
public class MainRoom extends AbstractRoom {
    private final Button button;
    /**
     * 
     * @param h HitBox of MainRoom.
     * @param doors MainRoom's doors.
     * @param button MainRoom's button.
     */
    public MainRoom(final HitBox h, final List<Door> doors, final Button button) {
        super(h, doors);
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
