package worldevent;

import proxyutility.SceneType;
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
