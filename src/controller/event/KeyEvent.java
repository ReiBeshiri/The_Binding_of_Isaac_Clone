package controller.event;

import utils.SceneType;

/**
 * s.
 */
public interface KeyEvent extends Event {
    /**
     * @return s.
     */
    SceneType getGameState();
    /**
     * 
     * @return s.
     */
    KeyType getType(); 
}
