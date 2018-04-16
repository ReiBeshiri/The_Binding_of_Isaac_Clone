package controller;

import worldevent.WorldEvent;
/** 
 *
 */
public interface WorldEventListener {
    /**
     * 
     * @param we s.
     */
    void notifyEvent(WorldEvent we);
}
