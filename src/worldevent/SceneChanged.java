package worldevent;

import input.Scene;
/**
 * Notify when the scene change.
 *
 */
public interface SceneChanged {
    /**
     * 
     * @return Next scene.
     */
    Scene getNextScene();
}
