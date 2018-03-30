package input;
/**
 * Enum that represent the possibility of command.
 */
public enum Command {
    /**
     * 
     */
    UP(0),
    /**
     * 
     */
    RIGHT(90),
    /**
     * 
     */
    LEFT(-90),
    /**
     * 
     */
    DOWN(180);
    private final int angle;
    /**
     * 
     * @param angle
     */
    Command(final int angle) {
        this.angle = angle;
    }
    /**
     * 
     * @return angle.
     */
    public int getAngle() {
        return angle;
    }
}
