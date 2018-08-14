package model.inanimated;

import model.hitbox.HitBox;
import utility.ImageType;

/**
 * 
 * Button implementation.
 *
 */
public class ButtonImpl implements Button {

    private ImageType btnImg;
    private final HitBox hitBox;
    private boolean status;

    /**
     * Constructor for this class.
     * 
     * @param h
     *            HitBox.
     * @param pressed
     *            State of the button.
     */
    public ButtonImpl(final HitBox h, final boolean pressed) {
        hitBox = h;
        this.status = pressed;
        btnImg = ImageType.BUTTON_UP;
    }

    /**
     * Return true if the button is pressed, false otherwise.
     */
    @Override
    public boolean isPressed() {
        return status;
    }

    /**
     * Set status of the button.
     * 
     * @param press
     *            The state of the button.
     */
    @Override
    public void setPressed(final boolean press) {
        status = press;
        if (press) {
            btnImg = ImageType.BUTTON_DOWN;
        } else {
            btnImg = ImageType.BUTTON_UP;
        }
    }

    /**
     * Return image that represent current status of button.
     */
    @Override
    public ImageType getImageType() {
        return btnImg;
    }

    /**
     * Getter for HitBox.
     */
    @Override
    public HitBox getHitBox() {
        return hitBox;
    }

    /**
     * Setter for HitBox.
     * Not used in button.
     */
    @Override
    public void setHitBox(final HitBox h) { }
}
