package view;

import java.util.List;
import controller.Observer;
import input.ScenePanel;
/**
 * generic type of scene.
 */
public interface GenericScene {
    /**
     * getter for a scene represented by this class.
     * @return enum type of this scene.
     */
    ScenePanel getSceneType();
    /**
     * Observer of a specific scene.
     * @return list of observersOfThisScene.
     */
    List<Observer> getObserverList();
    /**
     * Add observer for a specific scene.
     */
    void addSceneObservers();
}
