package worldevent;

import input.ScenePanel;
/**
 * Notify when the scene change.
 *
 */
public interface SceneChanged {
    /**
     * 
     * @return Next scene.
     */
    ScenePanel getNextScene();
}
