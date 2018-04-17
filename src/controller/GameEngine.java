package controller;
/**
 * 
 * Interface.
 *
 */
public interface GameEngine extends WorldEventListener, KeyShootListener, KeyMovementListener {
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
    void getActualTime(); //Deve essere time
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
}
