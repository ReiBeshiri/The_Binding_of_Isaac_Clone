package controller.event;

import proxyutility.SceneType;

/**
 *
 */
public class ButtonEventImpl implements ButtonEvent {
    private final ButtonType buttonType;
    private SceneType gameState;
    /**
     * 
     * @param type s.
     * @param state s.
     */
    public ButtonEventImpl(final ButtonType type, final SceneType state) {
        this.buttonType = type;
        this.gameState = state;
    }
    /**
     * 
     */
    @Override
    public String getEvent() {
        return buttonType.toString();
    }
    /**
     * 
     */
    @Override
    public SceneType getGameState() {
        return this.gameState;
    }

}
