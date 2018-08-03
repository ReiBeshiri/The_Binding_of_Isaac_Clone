package model.animated;

/**
 * Enum. that represnet all type of entities.
 *
 */
public enum EntityStats {
    /**
     * player stats.
     */
    PLAYER(6, 7, 0, 40, 1, 400, 10, 10),
    /**
     * static enemy stats.
     */
    STATIC_ENEMY(4, 0, 300, 45, 1, 400, 10, 7),
    /**
     * Movable enemy stats.
     */
    MOVEABLE_ENEMY(3, 5, 500, 50, 1, 400, 10, 8),
    /**
     * Boss stats.
     */
    BOSS(30, 0, 5000, 50, 1, 500, 14, 11);

    private int life;
    private double vel;
    private int points;
    private double shootRatio;
    private double bulletDamage;
    private double bulletRange;
    private double bulletRadius;
    private double bulletVel;

    /**
     * Constructor for enum.
     * 
     * @param l
     *            life.
     * @param v
     *            velocity.
     * @param points
     *            point.
     * @param sR
     *            shoot ratio.
     * @param bulletDamage
     *            bullet damage.
     * @param bulletRange
     *            bullet range.
     * @param bulletRadius
     *            bullets radius.
     * @param bulletVel
     *            bullet velocity.
     */
    EntityStats(final int l, final double v, final int points, final double sR, final double bulletDamage,
            final double bulletRange, final double bulletRadius, final double bulletVel) {
        life = l;
        vel = v;
        this.points = points;
        shootRatio = sR;
        this.bulletDamage = bulletDamage;
        this.bulletRange = bulletRange;
        this.bulletRadius = bulletRadius;
        this.bulletVel = bulletVel;
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

    /**
     * @return bullet range.
     */
    public double getBulletRange() {
        return bulletRange;
    }

    /**
     * @return bullet damage.
     */
    public double getBulletDamage() {
        return bulletDamage;
    }

    /**
     * @return bullet radius.
     */
    public double getBulletRadius() {
        return bulletRadius;
    }

    /**
     * @return bullet velocity.
     */
    public double getBulletVel() {
        return bulletVel;
    }
}
