package view.util;

/**
 * Represents a tuple as one element, used to set the resolution.
 *
 * @param <Width>
 *              The type of the first element.
 * @param <Height>
 *              The type of the second element.
 */
public class Tuple<Width, Height> {
    private final Width x;
    private final Height y;
    /**
     * Constructor of the class.
     * @param x
     *          The Width element.
     * @param y
     *          The Height element.
     */
    public Tuple(final Width x, final Height y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Getter for the Width.
     * @return The Width element.
     */
    public Width getWidth() {
        return x;
    }
    /**
     * Getter for the Height.
     * @return The Height element.
     */
    public Height getHeight() {
        return y;
    }
}
