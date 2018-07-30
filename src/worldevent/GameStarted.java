package worldevent;
/**
 * Notify game start.
 */
public class GameStarted implements WorldEvent {
    private final int life;
    /**
     * @param life inital life.
     */
    public GameStarted(final int life) {
        this.life = life;
    }

    /**
     * @return player initial life.
     */
    public int getLife() {
        return this.life;
    }
}