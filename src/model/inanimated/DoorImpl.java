package model.inanimated;

import model.hitbox.HitBox;
import model.utility.RoomEnum;
import utility.ImageType;

/**
 * 
 * Door implements.
 *
 */
public class DoorImpl implements Door {

    private final RoomEnum destination;
    private ImageType imgDoor;
    private final HitBox hitBox;
    private boolean status;

    /**
     * Constructor for this class.
     * 
     * @param h
     *            HitBox.
     * @param open
     *            State of the door.
     * @param destination
     *            Destination of the door.
     * @param imgDoor
     *            the image of the door.
     */
    public DoorImpl(final HitBox h, final boolean open, final RoomEnum destination, final ImageType imgDoor) {
        hitBox = h;
        status = open;
        this.destination = destination;
        this.imgDoor = imgDoor;
    }

    /**
     * Return true if the door is open, false otherwise.
     */
    @Override
    public boolean isOpen() {
        return status;
    }

    /**
     * Set door status.
     * 
     * @param open
     *            The state of the door.
     */
    @Override
    public void setOpen(final boolean open) {
        status = open;
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

    /**
     * set the new image of the door.
     */
    @Override
    public void setImgDoor(final ImageType img) {
        this.imgDoor = img;
    }

    /**
     * Getter for HitBox.
     */
    @Override
    public HitBox getHitBox() {
        return hitBox;
    }

    /**
     * Setter for hitBox.
     * Not used in doors.
     */
    @Override
    public void setHitBox(final HitBox h) { }
}
