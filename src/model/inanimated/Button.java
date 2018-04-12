package model.inanimated;
/**
 * 
 * Interface that represents buttons in the world.
 *
 */
public interface Button extends Inanimated {
    /**
     * 
     * @return return the status of the button.
     */
    boolean isPressed();
    /**
     * @param pressed The state of the button.
     */
    void setPressed(boolean pressed);
}
