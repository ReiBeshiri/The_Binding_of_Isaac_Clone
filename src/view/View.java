package view;

import java.util.List;

import controller.observer.Observer;
import controller.event.Event;
import model.GameObject;
/**
 * View class. This class communicate with controller.
 */
public interface View {
    /**
     * Render new scene.
     * @param list Lit of objects to render.
     */
    void render(List<GameObject> list);
    /**
     * Render new Room.
     */
    void roomChanged();
    /**
     * Render new playerLife.
     */
    void playerLifeChanged();
    /**
     * Check params and start view.
     */
    void viewStart();
    /**
     * Notify event to observer.
     * @param e Event received.
     */
    void notifyEvent(Event e);
    /**
     * Change Boss door status.
     * @param open if the door is open or close.
     */
    void changeBossDoorStatus(boolean open);
    /**
     * Change Shop door status.
     * @param open if shop door is open. 
     */
    void changeShoopDoorStatus(boolean open);
    /**
     * Add observer for view.
     * @param obs Observer.
     */
    void addObserver(Observer obs);
}
