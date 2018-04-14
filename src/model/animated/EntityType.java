package model.animated;
/**
 * 
 *
 */
public enum EntityType {
    /**
     * 
     */
    PLAYER(6, 3, 0),
    /**
     * 
     */
    STATIC_ENEMY(4, 0, 3),
    /**
     * 
     */
    MOVEABLE_ENEMY(3, 2, 5),
    /**
     * 
     */
    BOSS(20, 3, 50);
    private int life;
    private double vel;
    private int points;
    /**
     * 
     * @param l Life.
     */
    EntityType(final int l, final double v, final int points) {
        life = l;
        vel = v;
        this.points = points;
    }
    /**
     * 
     * @return Life of entity.
     */
    public int getLife() {
        return life;
    }
    /**
     * 
     * @return Vel of entity.
     */
    public double getVel() {
        return vel;
    }
    /**
     * 
     * @return Vel of entity.
     */
    public int getPoints() {
        return points;
    }
}
