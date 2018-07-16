package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import controller.event.KeyEvent;
import controller.observer.ButtonObserver;
import controller.observer.KeyObserver;
import controller.observer.Observer;
import javafx.application.Application;
import controller.event.ButtonEvent;
import controller.event.Event;
import model.GameObject;
import utility.ProportionUtility;
import view.util.OptionsViewUtil;

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
     * @return Only instance of this class.
     */
    public static View get() {
        if (Objects.isNull(view)) {
            view = new ViewImpl();
        }
        return view;
    }

    /**
     * 
     */
    @Override
    public void render(final List<GameObject> list) {
        // TODO Auto-generated method stub

    }

    /**
     * 
     */
    @Override
    public void roomChanged() {
        // TODO Auto-generated method stub

    }

    /**
     * 
     */
    @Override
    public void playerLifeChanged() {
        // TODO Auto-generated method stub

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
            observers.stream().filter(x -> x instanceof ButtonObserver).forEach(x -> ((ButtonObserver) x).notifyEvent(e));
        }
    }

    /**
     * 
     */
    @Override
    public void changeBossDoorStatus(final boolean open) {

    }

    /**
     * 
     */
    @Override
    public void changeShoopDoorStatus(final boolean open) {

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

}
