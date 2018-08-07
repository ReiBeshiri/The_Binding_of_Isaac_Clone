package view.utility;

import java.util.List;
import controller.util.Score;

/**
 * Utility class meant to keep views values e.g. fps, resolution and god mode.
 */
public final class ViewUtils {

    private static final double TIMER_CANVAS_H = 50;
    private static final double TIMER_CANVAS_W = 550;
    private static final double LIFE_CANVAS_H = 50;
    private static final double LIFE_CANVAS_W = 550;
    private static final double STAGE_DELTA_HEIGTH = 75;
    private static final double TIMER_TEXT_FONT = 3;
    private static final double HEARTH_HEIGHT = 25;
    private static final double HEARTH_WIDTH = 30;
    private static final double SPACE_HEARTH_PROPORTION = 40;
    private static final double X_SCREEN_PROP = 1;
    private static final double Y_SCREEN_PROP = 1;
    private static final double BOTTOM_CANVAS_PROP = 11;

    private static boolean godMode;
    private static boolean infinityMode;
    private static double worldHeight;
    private static double worldWidth;
    private static double worldHeightProportion;
    private static double worldWidthProportion;
    private static int points;

    private static List<Score> leaderBoard; 

    private ViewUtils() { }

    /**
     * Getter for the God Mode option.
     * @return True if is selected, false otherwise.
     */
    public static boolean isGodModeSelected() {
        return godMode;
    }

    /**
     * Setter used for the God Mode option.
     * @param value True if the option is selected, false otherwise.
     */
    public static void setGodMode(final boolean value) {
        godMode = value;
    }

    /**
     * Getter for the infinity Mode option.
     * @return True if is selected, false otherwise.
     */
    public static boolean isInfinityModeSelected() {
        return infinityMode;
    }

    /**
     * Setter used for the infinity Mode option.
     * @param value True if the option is selected, false otherwise.
     */
    public static void setInfinityMode(final boolean value) {
        infinityMode = value;
    }

    /**
     * Get Height of canvas for the timer.
     * @return height of canvas for the timer.
     */
    public static double getTimerCanvasHeight() {
        return TIMER_CANVAS_H;
    }

    /**
     * Get Width of canvas for the timer.
     * @return width of canvas for the timer.
     */
    public static double getTimerCanvasWidth() {
        return TIMER_CANVAS_W;
    }

    /**
     * Get Height of canvas for the player life.
     * @return Height of canvas for the player life.
     */
    public static double getLifeCanvasHeight() {
        return LIFE_CANVAS_H;
    }

    /**
     * Get Width of canvas for the player life.
     * @return width of canvas for the player life.
     */
    public static double getLifeCanvasWidth() {
        return LIFE_CANVAS_W;
    }

    /**
     * Get stage delta height.
     * @return delta height of stage.
     */
    public static double getStageDeltaHeight() {
        return STAGE_DELTA_HEIGTH;
    }

    /**
     * Get proportion for timer font.
     * @return font proportion.
     */
    public static double getTextTimerProp() {
        return TIMER_TEXT_FONT;
    }

    /**
     * Get heath width.
     * @return hearth width.
     */
    public static double getHearthWidth() {
        return HEARTH_WIDTH;
    }

    /**
     * Get hearth height.
     * @return hearth height.
     */
    public static double getHearthHeight() {
        return HEARTH_HEIGHT;
    }

    /**
     * Get proportion of distance between two hearth. 
     * @return proportion of distance between two hearths.
     */
    public static double getHearthSpaceProportion() {
        return SPACE_HEARTH_PROPORTION;
    }

    /**
     * Set scoreboard passed by controller.
     * @param score scoreboard.
     */
    public static void setScoreBoard(final List<Score> score) {
        leaderBoard = score;
    }

    /**
     * Getter for scoreboard.
     * @return scoreboard.
     */
    public static List<Score> getScoreBoard() {
        return leaderBoard;
    }

    /**
     * X prop.
     * @return x proportion.
     */
    public static double getXScreenProp() {
        return X_SCREEN_PROP;
    }

    /**
     * Y prop.
     * @return y proportion.
     */
    public static double getYScreenProp() {
        return Y_SCREEN_PROP;
    }

    /**
     * Set world height.
     * @param wh world height.
     */
    public static void setWorldHeight(final double wh) {
        worldHeight = wh;
    }

    /**
     * Set world width.
     * @param ww world width.
     */
    public static void setWorldWidth(final double ww) {
        worldWidth = ww;
    }

    /**
     * Getter for world height.
     * @return world height.
     */
    public static double getWorldHeight() {
        return worldHeight;
    }

    /**
     * Getter for world width.
     * @return world width.
     */
    public static double getWorldWidth() {
        return worldWidth;
    }

    /**
     * Set world height proportion.
     * @param whP world height proportion.
     */
    public static void setWorldHeightProp(final double whP) {
        worldHeightProportion = whP;
    }

    /**
     * Set world width proportion.
     * @param wwP world width proportion.
     */
    public static void setWorldWidthProp(final double wwP) {
        worldWidthProportion = wwP;
    }

    /**
     * Getter for world height proportion.
     * @return world height proportion.
     */
    public static double getWorldHeightProp() {
        return worldHeightProportion;
    }

    /**
     * Getter for world width proportion.
     * @return world width proportion.
     */
    public static double getWorldWidthProp() {
        return worldWidthProportion;
    }

    /**
     * Getter for proportion of bottom canvas.
     * @return bottom canvas.
     */
    public static double getBottomCanvasProp() {
        return BOTTOM_CANVAS_PROP;
    }

    /**
     * Setter for points.
     * @param pts points obtained by player during game.
     */
    public static void setPoints(final int pts) {
        points = pts;
    }

    /**
     * Getter for points.
     * @return points obtained by player during game.
     */
    public static int getPoints() {
        return points;
    }
}
