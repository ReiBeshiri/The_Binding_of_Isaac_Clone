package view;

import java.util.List;
import java.util.stream.IntStream;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import model.animated.Animated;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import model.room.Room;
import proxyutility.ImageType;
import proxyutility.ProxyImageLoader;
import timer.Time;
import utility.ModelUtility;
import view.util.Tupla;
import view.util.ViewUtil;

import java.util.LinkedList;

/**
 * Drawer manager.
 *
 */
public class DrawerManagerImpl implements DrawerManager {

    private final Canvas gameCanvas;
    private final Canvas timerCanvas;
    private final Canvas lifeCanvas;
    private final GraphicsContext gcGameCanvas;
    private final GraphicsContext gcTimerCanvas;
    private final GraphicsContext gcLifeCanvas;
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
     * @param lifeCanvas
     *            canvas for player life.
     */
    public DrawerManagerImpl(final Canvas gameCanvas, final Canvas timerCanvas, final Canvas lifeCanvas) {
        this.gameCanvas = gameCanvas;
        this.timerCanvas = timerCanvas;
        this.lifeCanvas = lifeCanvas;
        gcGameCanvas = gameCanvas.getGraphicsContext2D();
        gcTimerCanvas = timerCanvas.getGraphicsContext2D();
        gcLifeCanvas = lifeCanvas.getGraphicsContext2D();
        setCanvasDimension();
    }

    /**
     * Event that occur when time change.
     */
    @Override
    public void notifyTimeChange(final Time t) {
        time = t;
        drawTime();
    }

    /**
     * Set player life.
     */
    @Override
    public void setPlayerLife(final int life) {
        this.life = life;
        drawPlayerLife();
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
        drawRoom();
        drawEntities();
    }

    /**
     * Resize canvas dimension.
     */
    @Override
    public void resize() {
        final Tupla<Double, Double> gameCanvasDimension = getScaledDimension(
                new Tupla<Double, Double>(gameCanvas.getWidth(), gameCanvas.getHeight()),
                new Tupla<Double, Double>(ViewManagerImpl.get().getStageWidth(),
                        ViewManagerImpl.get().getStageHeight() - ViewUtil.getStageDeltaHeight()),
                new Tupla<Double, Double>(ModelUtility.getWorldWidthProp(), ModelUtility.getWorldHeightProp()),
                new Tupla<Double, Double>(ModelUtility.getWorldWidth(), ModelUtility.getWorldHeight()));
        gameCanvas.setHeight(gameCanvasDimension.getHeight());
        gameCanvas.setWidth(gameCanvasDimension.getWidth());
        gameCanvas.setTranslateX((ViewManagerImpl.get().getStageWidth() - gameCanvas.getWidth()) / 2);
        gameCanvas.setTranslateY((ViewManagerImpl.get().getStageHeight() - gameCanvas.getHeight()
                - (gameCanvas.getWidth() / ((ViewUtil.getTimerCanvasWidth() / ViewUtil.getStageDeltaHeight()) * 2)))
                / 2);

        timerCanvas.setWidth(gameCanvas.getWidth() / 2);
        timerCanvas
                .setHeight(timerCanvas.getWidth() / (ViewUtil.getTimerCanvasWidth() / ViewUtil.getStageDeltaHeight()));
        timerCanvas.setTranslateX(ViewManagerImpl.get().getStageWidth()
                - ((ViewManagerImpl.get().getStageWidth() - gameCanvas.getWidth()) / 2) - timerCanvas.getWidth());
        // timercanvas.setTranslateY(ViewManagerImpl.get().getStageHeight()
        // + (ViewManagerImpl.get().getStageHeight() - gameCanvas.getHeight() -
        // timercanvas.getHeight()) / 2);
        timerCanvas.setTranslateY(gameCanvas.getTranslateY() + gameCanvas.getHeight());

        lifeCanvas.setWidth(gameCanvas.getWidth() / 2);
        lifeCanvas.setHeight(lifeCanvas.getWidth() / (ViewUtil.getLifeCanvasWidth() / ViewUtil.getLifeCanvasHeight()));
        lifeCanvas.setTranslateX((ViewManagerImpl.get().getStageWidth() - gameCanvas.getWidth()) / 2);
        // lifeCanvas.setTranslateY(gameCanvas.getHeight()
        // + (ViewManagerImpl.get().getStageHeight() - gameCanvas.getHeight() -
        // lifeCanvas.getHeight()) / 2);
        lifeCanvas.setTranslateY(gameCanvas.getTranslateY() + gameCanvas.getHeight());

        draw();
    }

    private void drawEntities() {
        final Tupla<Double, Double> scalingFactor = computeScaleFactor(
                new Tupla<Double, Double>(gameCanvas.getWidth(), gameCanvas.getHeight()),
                new Tupla<Double, Double>(ModelUtility.getWorldWidth(), ModelUtility.getWorldHeight()));
        gcGameCanvas.save();
        gcGameCanvas.scale(scalingFactor.getWidth(), scalingFactor.getHeight());
        entities.forEach(x -> {
            // Safe-casting, all moving entities have a circle hitBox.
            final CircleHitBox hBox = (CircleHitBox) x.getHitBox();
            final double upperLeftX = hBox.getX() - hBox.getRadius();
            final double upperLeftY = hBox.getY() - hBox.getRadius();
            gcGameCanvas.drawImage(ProxyImageLoader.get().getImage(x.getImageType()), upperLeftX, upperLeftY,
                    2 * hBox.getRadius(), 2 * hBox.getRadius());
        });
        gcGameCanvas.restore();
    }

    private void drawRoom() {

    }

    private void drawTime() {
        gcTimerCanvas.save();
        gcTimerCanvas.clearRect(0, 0, timerCanvas.getWidth(), timerCanvas.getHeight());
        gcTimerCanvas.setFill(Color.DARKGRAY);
        gcTimerCanvas.fillRect(0, 0, timerCanvas.getWidth(), timerCanvas.getHeight());
        gcTimerCanvas.restore();
        gcTimerCanvas.save();
        gcTimerCanvas.setTextAlign(TextAlignment.RIGHT);
        gcTimerCanvas.setTextBaseline(VPos.CENTER);
        gcTimerCanvas.setFill(Color.WHITE);
        gcTimerCanvas.setFont(new Font(timerCanvas.getHeight() / ViewUtil.getTextTimerProp()));
        gcTimerCanvas.fillText(time.toString(), Math.round(timerCanvas.getWidth() / 2),
                Math.round(timerCanvas.getHeight() / 2), timerCanvas.getWidth());
        gcTimerCanvas.restore();
    }

    private void drawPlayerLife() {
        final Tupla<Double, Double> scaleFactor = computeScaleFactor(
                new Tupla<Double, Double>(lifeCanvas.getWidth(), lifeCanvas.getHeight()),
                new Tupla<Double, Double>(ViewUtil.getLifeCanvasWidth(), ViewUtil.getLifeCanvasHeight()));
        gcLifeCanvas.save();
        gcLifeCanvas.clearRect(0, 0, lifeCanvas.getWidth(), lifeCanvas.getHeight());
        gcLifeCanvas.setFill(Color.DARKGRAY);
        gcLifeCanvas.fillRect(0, 0, lifeCanvas.getWidth(), lifeCanvas.getHeight());
        gcLifeCanvas.scale(scaleFactor.getWidth(), scaleFactor.getHeight());
        final int completedHearth = life / 2;
        final int halfHeath = life - completedHearth > 0 ? 1 : 0;
        final double imgBlock = ((completedHearth + halfHeath) * ViewUtil.getHearthWidth())
                + (completedHearth + halfHeath - 1) * ViewUtil.getLifeCanvasWidth()
                        / ViewUtil.getHearthSpaceProportion();
        final double yDistance = (ViewUtil.getLifeCanvasHeight() - ViewUtil.getHearthHeight()) / 2;
        final List<Double> xDistances = new LinkedList<>();
        IntStream.range(0, completedHearth)
                .mapToDouble(x -> (ViewUtil.getLifeCanvasWidth() - imgBlock) / 2 + x * ViewUtil.getHearthWidth()
                        + x * ViewUtil.getLifeCanvasWidth() / ViewUtil.getHearthSpaceProportion())
                .forEach(x -> xDistances.add(x));
        IntStream.range(0, completedHearth).forEach(x -> {
            gcLifeCanvas.drawImage(ProxyImageLoader.get().getImage(ImageType.FULL_HEART), xDistances.get(x), yDistance);
        });
        if (halfHeath == 1) {
            gcLifeCanvas.drawImage(ProxyImageLoader.get().getImage(ImageType.HALF_HEART),
                    xDistances.get(xDistances.size() - 1), yDistance);
        }
        gcLifeCanvas.restore();
    }

    private Tupla<Double, Double> getScaledDimension(final Tupla<Double, Double> canvasSize,
            final Tupla<Double, Double> boundary, final Tupla<Double, Double> prop, final Tupla<Double, Double> max) {

        double canvasWidth = canvasSize.getWidth();
        double canvasHeight = canvasSize.getHeight();

        if (canvasSize.getWidth() > boundary.getWidth()) {
            canvasWidth = boundary.getWidth();
            canvasHeight = (canvasWidth * prop.getHeight()) / prop.getWidth();
        } else if (canvasSize.getHeight() > boundary.getHeight()) {
            canvasHeight = boundary.getHeight();
            canvasWidth = (prop.getWidth() * canvasHeight) / prop.getHeight();
        }
        if (canvasSize.getWidth() < boundary.getWidth()
                && boundary.getHeight() >= boundary.getWidth() * prop.getHeight() / prop.getWidth()) {
            canvasWidth = boundary.getWidth();
            canvasHeight = (canvasWidth * prop.getHeight()) / prop.getWidth();
        } else if (canvasSize.getHeight() < boundary.getHeight()
                && boundary.getWidth() >= boundary.getHeight() * prop.getWidth() / prop.getHeight()) {
            canvasHeight = boundary.getHeight();
            canvasWidth = (prop.getWidth() * canvasHeight) / prop.getHeight();
        }
        if (canvasHeight > max.getHeight()) {
            canvasHeight = max.getHeight();
        }
        if (canvasWidth > max.getWidth()) {
            canvasWidth = max.getWidth();
        }
        return new Tupla<Double, Double>(canvasHeight, canvasWidth);
    }

    private void setCanvasDimension() {
        gameCanvas.setHeight(ModelUtility.getWorldHeight());
        gameCanvas.setWidth(ModelUtility.getWorldWidth());
        timerCanvas.setHeight(ViewUtil.getTimerCanvasHeight());
        timerCanvas.setWidth(ViewUtil.getTimerCanvasWidth());
        lifeCanvas.setHeight(ViewUtil.getLifeCanvasHeight());
        lifeCanvas.setWidth(ViewUtil.getLifeCanvasWidth());
    }

    private Tupla<Double, Double> computeScaleFactor(final Tupla<Double, Double> canvasSize,
            final Tupla<Double, Double> boundarySize) {
        return new Tupla<Double, Double>(canvasSize.getWidth() / boundarySize.getWidth(),
                canvasSize.getHeight() / boundarySize.getHeight());
    }
}
