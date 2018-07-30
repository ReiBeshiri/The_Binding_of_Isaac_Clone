package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import controller.event.KeyEvent;
import controller.observer.ButtonObserver;
import controller.observer.KeyObserver;
import controller.observer.Observer;
import controller.util.Score;
import controller.util.ScoreList;
import javafx.application.Application;
import javafx.application.Platform;
import controller.event.ButtonEvent;
import controller.event.Event;
import model.GameObject;
import model.animated.Animated;
import model.room.Room;
import utility.ModelUtility;
import view.util.ViewUtils;

/**
 * Class that represent view.
 *
 */
public final class ViewImpl implements View {
    private final List<Observer> observers;
    private DrawerManager drawer;
    private static View view;

    /**
     * Private constructor for this class.
     */
    private ViewImpl() {
        observers = new ArrayList<>();
    }

    /**
     * Singleton for ViewImpl.
     * 
     * @return Only instance of this class.
     */
    public static View get() {
        if (Objects.isNull(view)) {
            view = new ViewImpl();
        }
        return view;
    }

    /**
     * Set animated entities list for drawer manager.
     * 
     * DA RIVEDERE DIPENDE SE ME LI PASSANO COSI' O NO...
     */
    @Override
    public void render(final List<GameObject> list) {
        drawer.setAnimatedEntities(
                list.stream()
                .filter(x -> x instanceof Animated)
                .map(x -> (Animated) x)
                .collect(Collectors.toList()));
        Platform.runLater(() -> drawer.draw());
    }

    /**
     * Set room for drawer manager.
     */
    @Override
    public void roomChanged(final Room room) {
        drawer.setRoom(room);
    }

    /**
     * Set player life for drawer manager.
     */
    @Override
    public void playerLifeChanged(final int life) {
        drawer.setPlayerLife(life);
    }

    /**
     * Entry method to start view.
     */
    @Override
    public void viewStart() {
        ViewManagerImpl.get().setHeight(ModelUtility.getWorldHeight() + ViewUtils.getStageDeltaHeight());
        ViewManagerImpl.get().setWidth(ModelUtility.getWorldWidth());
        Application.launch(LaunchClass.class, "");
    }

    /**
     * Event that notify events to controller.
     */
    @Override
    public void notifyEvent(final Event e) {
        if (e instanceof KeyEvent) {
            observers.stream().filter(x -> x instanceof KeyObserver).forEach(x -> ((KeyObserver) x).notifyEvent(e));
        } else if (e instanceof ButtonEvent) {
            observers.stream().filter(x -> x instanceof ButtonObserver)
                    .forEach(x -> ((ButtonObserver) x).notifyEvent(e));
        }
    }

    /**
     * Used to add observer for events.
     */
    @Override
    public void addObserver(final Observer obs) {
        observers.add(obs);
    }

    /**
     * Set drawer reference.
     */
    @Override
    public void setDrawer(final DrawerManager drawer) {
        this.drawer = drawer;
    }

    /**
     * Called when resize event occur.
     */
    @Override
    public void redraw() {
        drawer.resize();
    }

    /**
     * Set scoreboard list.
     */
    @Override
    public void setScoreBoard(final ScoreList<Score> score) {
        ViewUtils.setScoreBoard(score);
    }

    /**
     * Return status of godmode.
     */
    @Override
    public boolean isGodModeSelected() {
        return ViewUtils.isGodModeSelected();
    }

    /**
     * Return if infinity mode is selected.
     */
    @Override
    public boolean isInfinityModeSelected() {
        return ViewUtils.isInfinityModeSelected();
    }

    /**
     * Return reference to drawer manager.
     */
    @Override
    public DrawerManager getDrawerReference() {
        return drawer;
    }

}
