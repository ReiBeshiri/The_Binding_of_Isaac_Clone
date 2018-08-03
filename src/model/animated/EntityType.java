package model.animated;
/**
 * 
 *
 */
public enum EntityType {
    /**
     * player stats.
     */
    PLAYER(6, 5, 0, 50),
    /**
     * static enemy stats.
     */
    STATIC_ENEMY(4, 0, 3, 40),
    /**
     * Movable enemy stats.
     */
    MOVEABLE_ENEMY(3, 4, 5, 40),
    /**
     * Boss stats.
     */
    BOSS(20, 3, 50, 10);
    private int life;
    private double vel;
    private int points;
    private double shootRatio;

    /**
     * @param l life.
     * @param v vel.
     * @param points points.
     * @param sR shotRatio.
     */
    EntityType(final int l, final double v, final int points, final double sR) {
        life = l;
        vel = v;
        this.points = points;
        shootRatio = sR;
    }

    /**
     * @return Life of entity.
     */
    public int getLife() {
        return life;
    }

    /**
     * @return Vel of entity.
     */
    public double getVel() {
        return vel;
    }

    /**
     * @return Vel of entity.
     */
    public int getPoints() {
        return points;
    }

    /**
     * @return Shoot ratio.
     */
    public double getShotRatio() {
        return shootRatio;
    }
}
