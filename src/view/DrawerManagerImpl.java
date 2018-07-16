package view;

import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import model.animated.Animated;
import model.room.Room;
import timer.Time;

/**
 * Drawer manager.
 *
 */
public class DrawerManagerImpl implements DrawerManager {

    private final Canvas gameCanvas;
    private final Canvas timercanvas;
    private final Canvas hearthCanvas;
    private final GraphicsContext gcGameCanvas;
    private final GraphicsContext gcTimerCanvas;
    private final GraphicsContext gcHearthCanvas;
    private List<Animated> entities;
    private Room room;
    private int life;
    private Time time;

    /**
     * Constructor for drawer manager.
     * 
     * @param gameCanvas
     *            main canvas of the game.
     * @param timerCanvas
     *            canvas timer.
     * @param hearthCanvas
     *            canvas for player life.
     */
    public DrawerManagerImpl(final Canvas gameCanvas, final Canvas timerCanvas, final Canvas hearthCanvas) {
        this.gameCanvas = gameCanvas;
        this.timercanvas = timerCanvas;
        this.hearthCanvas = hearthCanvas;
        gcGameCanvas = gameCanvas.getGraphicsContext2D();
        gcTimerCanvas = timerCanvas.getGraphicsContext2D();
        gcHearthCanvas = hearthCanvas.getGraphicsContext2D();
    }

    /**
     * Event that occur when time change.
     */
    @Override
    public void notifyTimeChange(final Time t) {
        time = t;
    }

    /**
     * Set player life.
     */
    @Override
    public void setPlayerLife(final int life) {
        this.life = life;
    }

    /**
     * Set list of entities.
     */
    @Override
    public void setAnimatedEntities(final List<Animated> entities) {
        this.entities = entities;
    }

    /**
     * Actual room.
     */
    @Override
    public void setRoom(final Room room) {
        this.room = room;
    }

    /**
     * Method used to draw entire scene of the game.
     */
    @Override
    public void draw() {

    }

    private void drawEntities() {

    }

    private void drawRoom() {

    }

    private void drawTime() {

    }

    private void drawPlayerLife() {

    }
}
