package utility;
/**
 *
 */
public final class SpawnUtility {
    private SpawnUtility() {
    }
    private static final double XSTANDARD = ProportionUtility.getWidth() / 8;
    private static final double YSTANDARD = ProportionUtility.getHeigth() / 4;
    /**
     * @return x axis spawn A.
     */
    public static double getSpawnAX() {
        return XSTANDARD;
    }
    /**
     * @return y axis spawn A.
     */
    public static double getSpawnAY() {
        return YSTANDARD;
    }
}
