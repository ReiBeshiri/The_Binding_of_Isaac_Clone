package worldevent;

import utils.SceneType;
/**
 *  Class that represent change of scene.
 *
 */
public class SceneChangedImpl implements SceneChanged {
    private final SceneType scene;
    /**
     * 
     * @param s Next scene.
     */
    public SceneChangedImpl(final SceneType s) {
        scene = s;
    }
    /**
     * Next scene.
     */
    @Override
    public SceneType getNextScene() {
        return scene;
    }

}
