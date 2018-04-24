package controller;

import java.util.Set;

import input.Command;
/**
 *
 */
public interface KeyMovementListener {
    /**
     * 
     * @param d s.
     */
    void addMovement(Command d);
    /**
     * 
     * @param d s.
     */
    void removeMovement(Command d);
}
