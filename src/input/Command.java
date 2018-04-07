package input;

/**
 * Enum that represent the possibility of command.
 */
public enum Command {
    /**
     * Command Up is represented by 0° angle.
     */
    UP(0),
    /**
     * Command Right is represented by 90° angle.
     */
    RIGHT(90),
    /**
     * Command Left is represented by -90° angle.
     */
    LEFT(-90),
    /**
     * Command Down is represented by 180° angle.
     */
    DOWN(180);
    private final double angle;

    /**
     * 
     * @param angle Angle of command.
     */
    Command(final double angle) {
        this.angle = angle;
    }

    /**
     *  Return angle of command.
     * @return angle.
     */
    public double getAngle() {
        return angle;
    }

    /**
     * 
     * @return Opposite command.
     */
    public Command getOppositeCommand() {
        if (this == DOWN) {
            return UP;
        } else if (this == UP) {
            return DOWN;
        } else if (this == LEFT) {
            return RIGHT;
        } else {
            return LEFT;
        }
    }
}
