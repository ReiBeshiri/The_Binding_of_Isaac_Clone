package controller.event;

import input.ScenePanel;

/**
 * s.
 */
public interface KeyEvent extends Event {
    /**
     * @return s.
     */
    ScenePanel getGameState();
    /**
     * 
     * @return s.
     */
    KeyType getType(); 
}
