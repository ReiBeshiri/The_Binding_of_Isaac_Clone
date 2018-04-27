package controller.observer;

import controller.GameEngineImpl;
import controller.event.ButtonEvent;
import controller.event.ButtonType;
import controller.event.Event;
/**
 *
 */
public class ButtonObserver implements Observer {
    /**
     * 
     */
    @Override
    public <E extends Event> void notifyEvent(final E event) {
        if (event instanceof ButtonEvent) {
            final ButtonEvent buttonEvent = (ButtonEvent) event;
            if (buttonEvent.getEvent().equals(ButtonType.START_GAME.toString())) {
                GameEngineImpl.get().newGame();
            } else if (buttonEvent.getEvent().equals(ButtonType.QUIT_GAME.toString())) {
                GameEngineImpl.get().stopGame();
            }
        }
    }

}
