package model.inanimated;

import proxyutility.ImageType;
import utility.RoomEnum;

/**
 * 
 * Interface that represents inanimate object in the world.
 *
 */
public interface Door extends Inanimated {
    /**
     * @return if the door is open or not.
     */
    boolean isOpen();
    /**
     * @param open The state of the door.
     */
    void setOpen(boolean open);
    /**
     * @return the destination of the door.
     */
    RoomEnum getDestination();
    /**
     * Set the image of the door.
     * @param img the new image to set.
     */
    void setImgDoor(ImageType img);
}
