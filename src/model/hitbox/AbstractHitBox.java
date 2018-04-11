package model.hitbox;

/**
 * Abstract HotBox to avoid the initialization of HitBox. Only the subclass can
 * be initialized.
 */
public abstract class AbstractHitBox implements HitBox {
    private double x;
    private double y;

    /**
     * 
     * @param x
     *            Initial X value.
     * @param y
     *            Initial Y value.
     */
    public AbstractHitBox(final double x, final double y) {
        changePosition(x, y);
    }
    /**
     * 
     */
    @Override
    public void changePosition(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 
     */
    @Override
    public double getX() {
        return x;
    }

    /**
     * 
     */
    @Override
    public double getY() {
        return y;
    }

}
