package controller.event;

import proxyutility.SceneType;
/**
 *Event by pressing a button.
 */
public interface ButtonEvent extends Event {
    /**
     * @return The scene when the button was pressed.
     */
    SceneType getGameState();
}
