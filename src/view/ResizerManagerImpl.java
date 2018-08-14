package view;

import javafx.scene.canvas.Canvas;
import view.utility.Tupla;
import view.utility.ViewUtils;

/**
 * Class that manage resize of canvas of the view.
 *
 */
public class ResizerManagerImpl implements ResizerManager {

    private final Canvas gameCanvas;
    private final Canvas timerCanvas;
    private final Canvas lifeCanvas;

    /**
     * Constructor for this class.
     * 
     * @param gameCanvas
     *            game canvas of the game.
     * @param timerCanvas
     *            canvas that contains time.
     * @param lifeCanvas
     *            canvas that contains lifes.
     */
    public ResizerManagerImpl(final Canvas gameCanvas, final Canvas timerCanvas, final Canvas lifeCanvas) {
        this.gameCanvas = gameCanvas;
        this.timerCanvas = timerCanvas;
        this.lifeCanvas = lifeCanvas;
    }

    /**
     * Method used to resize canvas when resize event occurs.
     */
    @Override
    public void resize() {
        final Tupla<Double, Double> gameCanvasDimension = getScaledDimension(
                new Tupla<Double, Double>(gameCanvas.getWidth(), gameCanvas.getHeight()),
                new Tupla<Double, Double>(ViewManagerImpl.get().getStageWidth(),
                        ViewManagerImpl.get().getStageHeight() - ViewUtils.getStageDeltaHeight()),
                new Tupla<Double, Double>(ViewUtils.getWorldWidthProp(), ViewUtils.getWorldHeightProp()),
                new Tupla<Double, Double>(ViewUtils.getWorldWidth(), ViewUtils.getWorldHeight()));
        gameCanvas.setHeight(gameCanvasDimension.getY());
        gameCanvas.setWidth(gameCanvasDimension.getX());
        gameCanvas.setTranslateX((ViewManagerImpl.get().getStageWidth() - gameCanvas.getWidth()) / 2);
        gameCanvas.setTranslateY((ViewManagerImpl.get().getStageHeight() - gameCanvas.getHeight()
                - (gameCanvas.getWidth() / (ViewUtils.getBottomCanvasProp() * 2))) / 2);

        timerCanvas.setWidth(gameCanvas.getWidth() / 2);
        timerCanvas.setHeight(timerCanvas.getWidth() / ViewUtils.getBottomCanvasProp());
        timerCanvas.setTranslateX(ViewManagerImpl.get().getStageWidth()
                - ((ViewManagerImpl.get().getStageWidth() - gameCanvas.getWidth()) / 2) - timerCanvas.getWidth());
        timerCanvas.setTranslateY(gameCanvas.getTranslateY() + gameCanvas.getHeight());

        lifeCanvas.setWidth(gameCanvas.getWidth() / 2);
        lifeCanvas.setHeight(lifeCanvas.getWidth() / ViewUtils.getBottomCanvasProp());
        lifeCanvas.setTranslateX((ViewManagerImpl.get().getStageWidth() - gameCanvas.getWidth()) / 2);
        lifeCanvas.setTranslateY(gameCanvas.getTranslateY() + gameCanvas.getHeight());
    }

    private Tupla<Double, Double> getScaledDimension(final Tupla<Double, Double> canvasSize,
            final Tupla<Double, Double> boundary, final Tupla<Double, Double> prop, final Tupla<Double, Double> max) {

        double canvasWidth = canvasSize.getX();
        double canvasHeight = canvasSize.getY();

        if (canvasSize.getX() > boundary.getX()) {
            canvasWidth = boundary.getX();
            canvasHeight = (canvasWidth * prop.getY()) / prop.getX();
        } else if (canvasSize.getY() > boundary.getY()) {
            canvasHeight = boundary.getY();
            canvasWidth = (prop.getX() * canvasHeight) / prop.getY();
        }
        if (canvasSize.getX() < boundary.getX() && boundary.getY() >= boundary.getX() * prop.getY() / prop.getX()) {
            canvasWidth = boundary.getX();
            canvasHeight = (canvasWidth * prop.getY()) / prop.getX();
        } else if (canvasSize.getY() < boundary.getY()
                && boundary.getX() >= boundary.getY() * prop.getX() / prop.getY()) {
            canvasHeight = boundary.getY();
            canvasWidth = (prop.getX() * canvasHeight) / prop.getY();
        }
        if (canvasHeight > max.getY()) {
            canvasHeight = max.getY();
        }
        if (canvasWidth > max.getX()) {
            canvasWidth = max.getX();
        }
        return new Tupla<Double, Double>(canvasWidth, canvasHeight);
    }
}
