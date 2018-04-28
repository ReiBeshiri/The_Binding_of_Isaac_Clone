package controller.observer;

import controller.GameEngineImpl;
import controller.event.Event;
import controller.event.KeyEvent;
import controller.event.KeyType;
import input.Command;
import javafx.scene.input.KeyCode;
import proxyutility.SceneType;
/**
 *
 */
public class KeyObserver implements Observer {
    /**
     * 
     */
    @Override
    public <E extends Event> void notifyEvent(final E event) {
        if (event instanceof KeyEvent) { //Si potrebbe togliere; 
            final KeyEvent keyEvent = (KeyEvent) event;
            if (compare(keyEvent, KeyCode.ESCAPE.getName(), SceneType.GAME, KeyType.KEY_RELEASED)) {
                GameEngineImpl.get().stopGame();
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
                GameEngineImpl.get().getGameLoop().addMovement(Command.UP);
            } else {
                GameEngineImpl.get().getGameLoop().removeMovement(Command.UP);
            }
            break;
        case "A":
            if (pressed) {
                GameEngineImpl.get().getGameLoop().addMovement(Command.LEFT);
            } else {
                GameEngineImpl.get().getGameLoop().removeMovement(Command.LEFT);
                KeyCode.UP.getName();
            }
            break;
        case "S":
            if (pressed) {
                GameEngineImpl.get().getGameLoop().addMovement(Command.DOWN);
            } else {
                GameEngineImpl.get().getGameLoop().removeMovement(Command.DOWN);
            }
            break;
        case "D":
            if (pressed) {
                GameEngineImpl.get().getGameLoop().addMovement(Command.RIGHT);
            } else {
                GameEngineImpl.get().getGameLoop().removeMovement(Command.RIGHT);
            }
            break;
        case "Up":
            if (pressed) {
                GameEngineImpl.get().getGameLoop().addShoot(Command.UP);
            } else {
                GameEngineImpl.get().getGameLoop().removeShoot(Command.UP);
            }
            break;
        case "Left":
            if (pressed) {
                GameEngineImpl.get().getGameLoop().addShoot(Command.LEFT);
            } else {
                GameEngineImpl.get().getGameLoop().removeShoot(Command.LEFT);
            }
            break;
        case "Down":
            if (pressed) {
                GameEngineImpl.get().getGameLoop().addShoot(Command.DOWN);
            } else {
                GameEngineImpl.get().getGameLoop().removeShoot(Command.DOWN);
            }
            break;
        case "Right":
            if (pressed) {
                GameEngineImpl.get().getGameLoop().addShoot(Command.RIGHT);
            } else {
                GameEngineImpl.get().getGameLoop().removeShoot(Command.RIGHT);
            }
            break;
        default:
            break;
        }
    }
}
