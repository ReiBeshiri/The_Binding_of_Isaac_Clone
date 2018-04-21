package view;

import java.util.ArrayList;
import java.util.List;

import controller.KeyObserver;
import controller.Observer;
import controller.event.KeyEventImpl;
import input.ScenePanel;
/**
 * 
 *
 */
public abstract class AbstractGenericScene implements GenericScene {
    private final ScenePanel scene;
    private final List<Observer> list;
    /**
     * 
     * @param s scene.
     */
    public AbstractGenericScene(final ScenePanel s) {
        scene = s;
        list = new ArrayList<>();
    }
    /**
     * 
     */
    @Override
    public ScenePanel getSceneType() {
        return scene;
    }
    /**
     * 
     */
    @Override
    public List<Observer> getObserverList() {
        return list;
    }
    /**
     * 
     */
    @Override
    public void addSceneObservers() { }

}
