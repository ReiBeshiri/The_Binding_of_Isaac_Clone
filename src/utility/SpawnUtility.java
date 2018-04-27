package utility;
/**
 *
 */
public final class SpawnUtility {
    private SpawnUtility() {
    }
    private static final double XSTANDARD = ProportionUtility.getWidth() / 5;
    private static final double YSTANDARD = ProportionUtility.getHeigth() / 4;
    //this first set of spawns are the spawn in the top of the map.
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
    /**
     * @return x axis spawn B.
     */
    public static double getSpawnBX() {
        return XSTANDARD * 2;
    }
    /**
     * @return y axis spawn B.
     */
    public static double getSpawnBY() {
        return YSTANDARD;
    }
    /**
     * @return x axis spawn C.
     */
    public static double getSpawnCX() {
        return XSTANDARD * 3;
    }
    /**
     * @return y axis spawn C.
     */
    public static double getSpawnCY() {
        return YSTANDARD;
    }
    /**
     * @return x axis spawn D.
     */
    public static double getSpawnDX() {
        return XSTANDARD * 4;
    }
    /**
     * @return y axis spawn D.
     */
    public static double getSpawnDY() {
        return YSTANDARD;
    }
  //this second set of spawns are the spawn in the bottom of the map.
    /**
     * @return x axis spawn E.
     */
    public static double getSpawnEX() {
        return XSTANDARD;
    }
    /**
     * @return y axis spawn E.
     */
    public static double getSpawnEY() {
        return YSTANDARD * 3;
    }
    /**
     * @return x axis spawn F.
     */
    public static double getSpawnFX() {
        return XSTANDARD * 2;
    }
    /**
     * @return y axis spawn F.
     */
    public static double getSpawnFY() {
        return YSTANDARD * 3;
    }
    /**
     * @return x axis spawn G.
     */
    public static double getSpawnGX() {
        return XSTANDARD * 3;
    }
    /**
     * @return y axis spawn G.
     */
    public static double getSpawnGY() {
        return YSTANDARD * 3;
    }
    /**
     * @return x axis spawn H.
     */
    public static double getSpawnHX() {
        return XSTANDARD * 4;
    }
    /**
     * @return y axis spawn H.
     */
    public static double getSpawnHY() {
        return YSTANDARD * 3;
    }
}
