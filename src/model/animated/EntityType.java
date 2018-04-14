package model.animated;
/**
 * 
 *
 */
public enum EntityType {
    /**
     * 
     */
    PLAYER(6),
    /**
     * 
     */
    STATIC_ENEMY(4),
    /**
     * 
     */
    MOVEABLE_ENEMY(3),
    /**
     * 
     */
    BOSS(20);
    private int life;
    /**
     * 
     * @param l Life.
     */
    EntityType(final int l) {
        life = l;
    }
    /**
     * 
     * @return Life of entity.
     */
    public int getLife() {
        return life;
    }
}
