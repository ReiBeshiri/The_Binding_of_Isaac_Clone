package model.inanimated;

import model.hitbox.HitBox;
/**
 * 
 * Door implements.
 *
 */
public class DoorImpl extends AbstractInanimated implements Door {
    /**
     * 
     * @param h HitBox.
     * @param open State of the door.
     */
    public DoorImpl(final HitBox h, final boolean open) {
        super(h, open);
    }
    /**
     * Return true if the door is open, false otherwise.
     */
    @Override
    public boolean isOpen() {
        return super.isEnable();
    }
}
