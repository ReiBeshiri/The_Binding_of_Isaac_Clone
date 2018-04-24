package controller;
/**
 * 
 * Interface.
 *
 */
public interface GameEngine {
    /**
     * s.
     */
    void initView();
    /**
     * s.
     */
    void newGame();
    /**
     * s.
     */
    void stopGameLoop();
    /**
     * s.
     */
    void resumeGameLoop();
    /**
     * s.
     */
    void gameOver();
    /**
     * s.
     */
    void victory();
    /**
     * s.
     * @return the gameLoop object.
     */
    GameLoop getGameLoop();
}
