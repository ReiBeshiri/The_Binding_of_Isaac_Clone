package model.gameobject.inanimated;

import model.hitbox.HitBox;
/**
 * 
 * Button implements.
 *
 */
public class ButtonImpl extends AbstractInanimated implements Button {
    /**
     * 
     * @param h HitBox.
     * @param pressed State of the button.
     */
    public ButtonImpl(final HitBox h, final boolean pressed) {
        super(h, pressed);
    }
    /**
     * Return true if the button is pressed, false otherwise.
     */
    @Override
    public boolean isPressed() {
        return super.isEnable();
    }
}
