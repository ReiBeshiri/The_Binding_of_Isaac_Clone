package worldevent;

import input.ScenePanel;
/**
 *  Class that represent change of scene.
 *
 */
public class SceneChangedImpl implements SceneChanged {
    private final ScenePanel scene;
    /**
     * 
     * @param s Next scene.
     */
    public SceneChangedImpl(final ScenePanel s) {
        scene = s;
    }
    /**
     * Next scene.
     */
    @Override
    public ScenePanel getNextScene() {
        return scene;
    }

}
