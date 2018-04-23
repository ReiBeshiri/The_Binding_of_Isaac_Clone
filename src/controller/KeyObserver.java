package controller;

import controller.event.Event;
import controller.event.KeyEvent;
import controller.event.KeyType;
import input.Command;
import input.InputCommandType;
import input.SceneType;
import javafx.scene.input.KeyCode;
/**
 *
 */
public class KeyObserver implements Observer {
    /**
     * 
     */
    @Override
    public <E extends Event> void notifyEvent(final E event) {
        if (event instanceof KeyEvent) {
            final KeyEvent keyEvent = (KeyEvent) event;
            if (compare(keyEvent, KeyCode.ESCAPE.getName(), SceneType.GAME, KeyType.KEY_RELEASED)) {
                GameEngineImpl.get().stopGameLoop();
            } else if (compare(keyEvent, KeyCode.ESCAPE.getName(), SceneType.PAUSE, KeyType.KEY_RELEASED)) {
                GameEngineImpl.get().resumeGameLoop();
            }
            if (keyEvent.getType().equals(KeyType.KEY_PRESSED)) {
                key(keyEvent.getEvent(), true);
            } else if (keyEvent.getType().equals(KeyType.KEY_RELEASED)) {
                key(keyEvent.getEvent(), false);
            }
        }
    }
    //
    private boolean compare(final KeyEvent event, final String key, final SceneType scene, final KeyType type) {
        return event.getEvent().equals(key) && event.getGameState().equals(scene) && event.getType().equals(type);
    }
    //
    private void key(final String key, final boolean pressed) {
        switch (key) {
        case "W":
            if (pressed) {
                GameEngineImpl.get().addMovement(Command.UP);
            } else {
                GameEngineImpl.get().removeMovement(Command.UP);
            }
            break;
        case "A":
            if (pressed) {
                GameEngineImpl.get().addMovement(Command.LEFT);
            } else {
                GameEngineImpl.get().removeMovement(Command.LEFT);
                KeyCode.UP.getName();
            }
            break;
        case "S":
            if (pressed) {
                GameEngineImpl.get().addMovement(Command.DOWN);
            } else {
                GameEngineImpl.get().removeMovement(Command.DOWN);
            }
            break;
        case "D":
            if (pressed) {
                GameEngineImpl.get().addMovement(Command.RIGHT);
            } else {
                GameEngineImpl.get().removeMovement(Command.RIGHT);
            }
            break;
        case "Up":
            if (pressed) {
                GameEngineImpl.get().addShoot(Command.UP);
            } else {
                GameEngineImpl.get().removeShoot(Command.UP);
            }
            break;
        case "Left":
            if (pressed) {
                GameEngineImpl.get().addShoot(Command.LEFT);
            } else {
                GameEngineImpl.get().removeShoot(Command.LEFT);
            }
            break;
        case "Down":
            if (pressed) {
                GameEngineImpl.get().addShoot(Command.DOWN);
            } else {
                GameEngineImpl.get().removeShoot(Command.DOWN);
            }
            break;
        case "Right":
            if (pressed) {
                GameEngineImpl.get().addShoot(Command.RIGHT);
            } else {
                GameEngineImpl.get().removeShoot(Command.RIGHT);
            }
            break;
        default:
            break;
        }
    }
}