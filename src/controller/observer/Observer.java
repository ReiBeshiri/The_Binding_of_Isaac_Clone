package controller.observer;

import controller.event.Event;
/**
 *
 */
public interface Observer {
    /**
     * 
     * @param event s.
     * @param <E> s.
     */
    <E extends Event> void notifyEvent(E event);
}
