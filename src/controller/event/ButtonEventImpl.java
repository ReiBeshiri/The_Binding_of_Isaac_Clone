package controller.event;
/**
 *
 */
public class ButtonEventImpl implements ButtonEvent {
    private final ButtonType buttonType;
    /**
     * 
     * @param type s.
     */
    public ButtonEventImpl(final ButtonType type) {
        this.buttonType = type;
    }
    /**
     * 
     */
    @Override
    public String getEvent() {
        return buttonType.toString();
    }

}
