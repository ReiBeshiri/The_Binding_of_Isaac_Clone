package controller.event;

import proxyutility.SceneType;
/**
 *Event by pressing a button.
 */
public class ButtonEventImpl implements ButtonEvent {
    private final ButtonType buttonType;
    private SceneType gameState;
    /**
     * The class constructor.
     * @param type What the button do.
     * @param state The scene when the button was pressed.
     */
    public ButtonEventImpl(final ButtonType type, final SceneType state) {
        this.buttonType = type;
        this.gameState = state;
    }
    /**
     * Get the message of event.
     * @return The message of event.
     */
    @Override
    public String getEvent() {
        return buttonType.toString();
    }
    /**
     * Return The scene when the button was pressed.
     */
    @Override
    public SceneType getGameState() {
        return this.gameState;
    }

}
