package view.util;
/**
 * Utility class meant to keep views values e.g. fps, resolution and god mode.
 */
public final class ViewUtil {

    private static final double TIMER_CANVAS_H = 50;
    private static final double TIMER_CANVAS_W = 400;
    private static final double LIFE_CANVAS_H = 50;
    private static final double LIFE_CANVAS_W = 400;
    private static final double STAGE_DELTA_HEIGTH = 50;

    private static final Tupla<Integer, Integer> STANDARD_RES = new Tupla<Integer, Integer>(1280, 720);
    private static Tupla<Integer, Integer> selectedRes = STANDARD_RES;

    private static final int STANDARD_FPS = 60;
    private static int selectedFPS = STANDARD_FPS;

    private static boolean godMode;

    private ViewUtil() { }
    /**
     * Getter of the standard resolution.
     * @return The standard resolution memorized in STANDARD_RES
     */
    public static Tupla<Integer, Integer> getStandardRes() {
        return STANDARD_RES;
    }
    /**
     * Setter used to set a different resolution.
     * @param value The selected value in the options view.
     */
    public static void setResolution(final Tupla<Integer, Integer> value) {
        selectedRes = value;
    }
    /**
     * Getter for the currently selected resolution.
     * @return The selected resolution in the options view.
     */
    public static Tupla<Integer, Integer> getSelectedRes() {
        return selectedRes;
    }
    /**
     * Getter for the currently selected FPS.
     * @return The selected FPS in the options view.
     */
    public static int getFps() {
        return selectedFPS;
    }
    /**
     * Setter used to set a different FPS.
     * @param value The selected value in the options view.
     */
    public static void setFps(final int value) {
        selectedFPS = value;
    }
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
}
