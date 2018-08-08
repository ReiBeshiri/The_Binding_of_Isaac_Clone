package view;

import static view.utility.SceneType.LEADERBOARD;

import javafx.event.Event;
/**
 * Class that represent leaderboard view.
 *
 */
public class LeaderboardScene extends AbstractGenericScene {

    /**
     * Constructor for this scene.
     */
    public LeaderboardScene() {
        super(LEADERBOARD);
    }

    /**
     * Exit status for this scene.
     */
    @Override
    public void exitStatus() { 
        ViewManagerImpl.get().pop();
    }

    /**
     * Events that can occur in this scene.
     */
    @Override
    public void checkSceneHandler(final Event e) { }

    /**
     * Set scene listener.
     */
    @Override
    public void setSceneListener() { }

    /**
     * Remove scene listener.
     */
    @Override
    public void removeSceneListener() { }
}
