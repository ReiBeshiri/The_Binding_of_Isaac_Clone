package view.util;
/**
 * Utility class meant to keep views values e.g. fps, resolution and god mode.
 */
public class OptionsViewUtil {
    private static final Tuple<Integer,Integer> STANDARD_RES = new Tuple<Integer,Integer>(1280, 720);
    
    private static Tuple<Integer,Integer> selectedRes = STANDARD_RES;
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
    
    //TO DO: FPS & GOD mode
}