package controller;

import input.Command;
/**
 * 
 */
public interface KeyShootListener {
    /**
     * 
     * @param d s.
     */
    void addShoot(Command d);
    /**
     * 
     * @param d s.
     */
    void removeShoot(Command d);
}
