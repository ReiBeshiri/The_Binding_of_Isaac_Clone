package view;

import java.util.List;
import controller.observer.Observer;
import controller.util.Score;
import controller.event.Event;
import model.animated.Animated;
import model.room.Room;
/**
 * View class. This class communicate with controller.
 */
public interface View {
    /**
     * Render new scene.
     * @param list Lit of objects to render.
     */
    void render(List<Animated> list);

    /**
     * Render new Room.
     * @param room room.
     */
    void roomChanged(Room room);

    /**
     * Render new playerLife.
     * @param life life.
     */
    void playerLifeChanged(int life);

    /**
     * Start view.
     * 
     */
    void viewStart();

    /**
     * Notify event to observer.
     * @param e Event received.
     */
    void notifyEvent(Event e);

    /**
     * Add observer for view.
     * @param obs Observer.
     */
    void addObserver(Observer obs);

    /**
     * Set drawer instance.
     * @param drawer drawer manager.
     */
    void setDrawer(DrawerManager drawer);

    /**
     * Return reference to drawer manager.
     * @return reference to drawer.
     */
    DrawerManager getDrawerReference();

    /**
     * Redraw.
     */
    void redraw();

    /**
     * Receive scoreboard from controller.
     * @param score scoreboard.
     */
    void setScoreBoard(List<Score> score);

    /**
     * Return true if godmode is selected.
     * @return if godmode is selected or not.
     */
    boolean isGodModeSelected();

    /**
     * Return if infinity mode is selected.
     * @return if infinity mode is selected.
     */
    boolean isInfinityModeSelected();

    /**
     * Setter for initial height.
     * @param h initial height.
     */
    void setInitialHeight(double h);

    /**
     * Setter for initial width.
     * @param w initial width.
     */
    void setInitialWidth(double w);

    /**
     * Setter for world height.
     * @param wh world height.
     */
    void setWorldHeight(double wh);

    /**
     * Setter for world width.
     * @param ww world width.
     */
    void setWorldWidth(double ww);

    /**
     * Setter for world height proportion.
     * @param whProp world height proportion.
     */
    void setWorldHeightProportion(double whProp);

    /**
     * Setter for world width proportion.
     * @param wwProp world width proportion.
     */
    void setWorldWidthProportion(double wwProp);

    /**
     * Method used in new game for init time canvas.
     */
    void initTimeCanvas();

    /**
     * Method used to notify that player was dead. 
     */
    void notifyGameOverEvent();

    /**
     * Method used to notify that player win game and defeated boss. 
     */
    void notifyWinGameEvent();
}
