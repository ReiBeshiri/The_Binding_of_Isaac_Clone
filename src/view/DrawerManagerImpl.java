package view;

import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import model.animated.Animated;
import model.inanimated.Door;
import model.room.Room;
import timer.Time;

/**
 * Drawer manager.
 *
 */
public class DrawerManagerImpl implements DrawerManager {

    private final Canvas gameCanvas;
    private final Canvas timercanvas;
    private final GraphicsContext gcGameCanvas;
    private final GraphicsContext gcTimerCanvas;

    /**
     * Constructor for drawer manager.
     * @param gameCanvas main canvas of the game.
     * @param timerCanvas canvas timer.
     */
    public DrawerManagerImpl(final Canvas gameCanvas, final Canvas timerCanvas) {
        this.gameCanvas = gameCanvas;
        this.timercanvas = timerCanvas;
        gcGameCanvas = gameCanvas.getGraphicsContext2D();
        gcTimerCanvas = timerCanvas.getGraphicsContext2D();
    }

    @Override
    public void drawAnimatedEntity(final List<Animated> list) {

    }

    @Override
    public void drawRoom(final Room room) {

    }

    @Override
    public void drawPlayerLife(final int life) {

    }

    @Override
    public void changeDoorStatus(final Door door) {

    }

    @Override
    public void notifyTimeChange(final Time t) {

    }
}
