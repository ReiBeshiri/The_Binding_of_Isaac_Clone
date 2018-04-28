package worldevent;

import utils.SceneType;
/**
 * Notify when the scene change.
 *
 */
public interface SceneChanged {
    /**
     * 
     * @return Next scene.
     */
    SceneType getNextScene();
}
