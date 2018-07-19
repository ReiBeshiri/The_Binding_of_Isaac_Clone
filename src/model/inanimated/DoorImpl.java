package model.inanimated;

import model.hitbox.HitBox;
import proxyutility.ImageType;
import utility.RoomEnum;
/**
 * 
 * Door implements.
 *
 */
public class DoorImpl extends AbstractInanimated implements Door {
    private RoomEnum destination;
    private ImageType imgDoor;
    /**
     * 
     * @param h HitBox.
     * @param open State of the door.
     * @param destination Destination of the door.
     */
    public DoorImpl(final HitBox h, final boolean open, final RoomEnum destination) {
        super(h, open);
        this.destination = destination;
    }
    /**
     * Return true if the door is open, false otherwise.
     */
    @Override
    public boolean isOpen() {
        return super.isEnable();
    }
    /**
     * 
     * @param open The state of the door.
     */
    @Override
    public void setOpen(final boolean open) {
        super.setEnable(open);
    }
    /**
     * Get destination of this door.
     */
    @Override
    public RoomEnum getDestination() {
        return this.destination;
    }
    /**
     * Return image that represent current status of door.
     */
    @Override
    public ImageType getImageType() {
        return imgDoor;
    }
}
