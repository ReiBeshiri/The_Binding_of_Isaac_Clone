package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import controller.event.KeyEvent;
import controller.observer.ButtonObserver;
import controller.observer.KeyObserver;
import controller.observer.Observer;
import javafx.application.Application;
import controller.event.ButtonEvent;
import controller.event.Event;
import model.GameObject;
import model.animated.Animated;
import model.room.Room;
import utility.ProportionUtility;

/**
 * Class that represent view.
 *
 */
public final class ViewImpl implements View {
    private final List<Observer> observers;
    private DrawerManager drawer;
    private static View view;

    /**
     * 
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
     */
    @Override
    public void render(final List<GameObject> list) {
        drawer.setAnimatedEntities(
                list.stream()
                .filter(x -> x instanceof Animated)
                .map(x -> (Animated) x)
                .collect(Collectors.toList()));
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
     * 
     */
    @Override
    public void viewStart() {
        ViewManagerImpl.get().setHeight(ProportionUtility.getHeigth());
        ViewManagerImpl.get().setWidth(ProportionUtility.getWidth());
        Application.launch(ViewManagerImpl.class, "");
    }

    /**
     * 
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
     * 
     */
    @Override
    public void addObserver(final Observer obs) {
        observers.add(obs);
    }

    /**
     * 
     */
    @Override
    public void setDrawer(final DrawerManager drawer) {
        this.drawer = drawer;
    }

    /**
     * 
     */
    @Override
    public void redraw() {
        drawer.draw();
    }

}
