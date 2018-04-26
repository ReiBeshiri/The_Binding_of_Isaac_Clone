package view;

import java.util.List;
import javafx.event.Event;
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
     * Set initial height of window.
     * @param h Height.
     */
    void setHeight(int h);
    /**
     * Set initial Width of window.
     * @param w Width.
     */
    void setWidth(int w);
    /**
     * Check params and start view.
     */
    void viewStart();
    /**
     * Notify event to observer.
     * @param e Event received.
     */
    void notifyEvent(Event e);
}
