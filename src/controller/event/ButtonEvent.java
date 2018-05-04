package controller.event;

import proxyutility.SceneType;

/**
 *
 */
public interface ButtonEvent extends Event {
    /**
     * @return s.
     */
    SceneType getGameState();
}
