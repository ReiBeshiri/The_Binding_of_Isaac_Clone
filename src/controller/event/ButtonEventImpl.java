package controller.event;

import controller.util.ButtonType;
/**
 *Event created by pressing a view button.
 */
public class ButtonEventImpl implements ButtonEvent {
    private final ButtonType buttonType;
    /**
     * The class constructor.
     * @param type is what the button do.
     */
    public ButtonEventImpl(final ButtonType type) {
        this.buttonType = type;
    }
    /**
     * Get the button pressed.
     */
    @Override
    public String getEvent() {
        return buttonType.toString();
    }
}
