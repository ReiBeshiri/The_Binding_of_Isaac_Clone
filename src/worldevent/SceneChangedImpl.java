package worldevent;

import input.Scene;
/**
 *  Class that represent change of scene.
 *
 */
public class SceneChangedImpl implements SceneChanged {
    private final Scene scene;
    /**
     * 
     * @param s Next scene.
     */
    public SceneChangedImpl(final Scene s) {
        scene = s;
    }
    /**
     * Next scene.
     */
    @Override
    public Scene getNextScene() {
        return scene;
    }

}
