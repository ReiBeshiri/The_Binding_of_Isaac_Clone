package ktsapp;

import controller.GameEngineImpl;

/**
 * Main entry of the game.
 */
public final class KtsApp {
     private KtsApp() { }
    /**
     * Main program entry.
     * @param args params.
     */
    public static void main(final String[] args) {
        GameEngineImpl.get().initView();
    }

}
