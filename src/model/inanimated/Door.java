package model.inanimated;
/**
 * 
 * Interface that represents inanimate object in the world.
 *
 */
public interface Door extends Inanimated {
    /**
     * 
     * @return if the door is open or not.
     */
    boolean isOpen();
    /**
     * 
     * @param open The state of the door.
     */
    void setOpen(boolean open);
}
