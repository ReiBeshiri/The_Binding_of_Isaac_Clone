package utility;

/**
 * Class that represent player statistics.
 *
 */
public class StatisticImpl implements Statistic {

    private final int life;
    private final int bulletDamage;
    private final int points;
    private final double bulletRange;
    private final double vel;

    /**
     * Constructor for this class.
     * @param life life.
     * @param points points.
     * @param bulletDamage damage of bullets.
     * @param vel player vel.
     * @param bulletRange bullet range of bullets shot by player.
     */
    public StatisticImpl(final int life, final int points, final int bulletDamage, final double vel,
            final double bulletRange) {
        this.life = life;
        this.vel = vel;
        this.points = points;
        this.bulletDamage = bulletDamage;
        this.bulletRange = bulletRange;
    }

    /**
     * Return life of player.
     */
    @Override
    public int getLife() {
        return life;
    }

    /**
     * Return point of player. 
     */
    @Override
    public int getPoints() {
        return points;
    }

    /**
     * Return range of bullets shot by player.
     */
    @Override
    public double getBulletRange() {
        return bulletRange;
    }

    /**
     * Return bullet damage.
     */
    @Override
    public int getBulletDamage() {
        return bulletDamage;
    }

    /**
     * Return bullet velocity.
     */
    @Override
    public double getVel() {
        return vel;
    }

}
