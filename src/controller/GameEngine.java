package controller;

import java.util.List;

import controller.util.Score;

/**
 * Interface that manages all game situations.
 */
public interface GameEngine {
    /**
     * Initialize the view for the kts application.
     */
    void initView();
    /**
     * Create a new game.
     * @param name of the player.
     */
    void newGame(String name);
    /**
     * Stop the game.
     */
    void stopGame();
    /**
     * Resume the execution of the game.
     */
    void resumeGameLoop();
    /**
     * The player has lost.
     */
    void gameOver();
    /**
     * The player has won.
     */
    void victory();
    /**
     * Get the game loop.
     * @return the gameLoop object.
     */
    GameLoop getGameLoop();
    /**
     * Get the leaderboard.
     * @return the leaderboard.
     */
    List<Score> getLeaderboard();
    /**
     * Set the leaderboard.
     * @param list of new leaderboard.
     */
    void setLeaderboard(List<Score> list);
}
