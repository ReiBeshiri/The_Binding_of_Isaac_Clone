package controller.util;

/**
 * Utility class used to calculate bonus time at the ending of the game.
 *
 */
public final class ScoreCalculator {

    private static final int DELTA_CURVE_MOLTIPLICATOR = 1000;
    private static final int DELTA_CURVE_DIVISOR = 200000;

    private ScoreCalculator() { }

    /**
     * Method used to calculate points based on elapsed time.
     * @param timeElapsed time elapsed.
     * @return Bonus time.
     */
    public static int bonusTime(final int timeElapsed) {
        return DELTA_CURVE_MOLTIPLICATOR * (int) Math.exp(-(Math.pow(timeElapsed, 2)) / DELTA_CURVE_DIVISOR); //Bisogna guardarci meglio;
    }
}
