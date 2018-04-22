package controller.event;

import input.SceneType;

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
