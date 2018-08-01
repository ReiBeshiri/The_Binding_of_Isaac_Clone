package model.inanimated;

import model.hitbox.HitBox;
import proxyutility.ImageType;
/**
 * 
 * Button implements.
 *
 */
public class ButtonImpl extends AbstractInanimated implements Button {
    private ImageType btnImg;

    /**
     * 
     * @param h HitBox.
     * @param pressed State of the button.
     */
    public ButtonImpl(final HitBox h, final boolean pressed) {
        super(h, pressed);
        btnImg = ImageType.BUTTON_UP;
    }

    /**
     * Return true if the button is pressed, false otherwise.
     */
    @Override
    public boolean isPressed() {
        return super.isEnable();
    }

    /**
     * @param press The state of the button.
     */
    @Override
    public void setPressed(final boolean press) {
        super.setEnable(press);
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
}
