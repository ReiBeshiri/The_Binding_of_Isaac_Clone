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
    void initGame();
    /**
     * s.
     */
    void mainLoop();
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
}
