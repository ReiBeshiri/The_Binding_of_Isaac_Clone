package view.util;
/**
 * Utility class meant to keep views values e.g. fps, resolution and god mode.
 */
public class OptionsViewUtil {
    private static final Tuple<Integer,Integer> STANDARD_RES = new Tuple<Integer,Integer>(1280, 720);
    private static Tuple<Integer,Integer> selectedRes = STANDARD_RES;
    
    private static final int STANDARD_FPS = 60;
    private static int selectedFPS = STANDARD_FPS;
    
    private static boolean godMode;
    private OptionsViewUtil() {
        
    }
    /**
     * Getter of the standard resolution.
     * @return The standard resolution memorized in STANDARD_RES
     */
    public static Tuple<Integer, Integer> getStandardRes(){
        return STANDARD_RES;
    }
    /**
     * Setter used to set a different resolution.
     * @param value The selected value in the options view.
     */
    public static void setResolution(final Tuple<Integer, Integer> value) {
        selectedRes=value;
    }
    /**
     * Getter for the currently selected resolution.
     * @return The selected resolution in the options view.
     */
    public static Tuple<Integer, Integer> getSelectedRes(){
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
    public static boolean getGodMode() {
        return godMode;
    }
    /**
     * Setter used for the God Mode option.
     * @param value True if the option is selected, false otherwise.
     */
    public static void setGodMode(final boolean value) {
        godMode = value;
    }
}