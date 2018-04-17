package view.util;

/**
 * Represents a tuple as one element, used to set the resolution.
 *
 * @param <Width>
 *              The type of the first element.
 * @param <Height>
 *              The type of the second element.
 */
public class Tuple<X, Y> {
    private final X x;
    private final Y y;
    /**
     * Constructor of the class.
     * @param x
     *          The Width element.
     * @param y
     *          The Height element.
     */
    public Tuple(final X x, final Y y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Getter for the Width.
     * @return The Width element.
     */
    public X getWidth() {
        return x;
    }
    /**
     * Getter for the Height.
     * @return The Height element.
     */
    public Y getHeight() {
        return y;
    }
}
