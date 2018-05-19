package model.animated;

/**
 * Defines all the bullets used in the game.
 */
public enum BulletType {
    /**
     * Bullets shot by the Player.
     */
    PLAYER_BULLET(1, 1000, 10),
    /**
     * Bullets shot by the Enemies.
     */
    ENEMY_BULLET(1, 1000, 10),
    /**
     * Bullets shot by the Boss.
     */
    BOSS_BULLET(1, 1500, 10);

    private final double damage;
    private final double range;
    private final double steps;
    BulletType(final double damage, final double range, final double steps) {
        this.damage = damage;
        this.range = range;
        this.steps = steps;
    }
    /**
     * Get the value of the damage.
     * @return The damage made by the bullet.
     */
    public double getDamage() {
        return damage;
    }
    /**
     * Get the value of the range.
     * @return The range of the bullet.
     */
    public double getRange() {
        return range;
    }
    /**
     * Get the value of the steps.
     * @return The steps of the bullet.
     */
    public double getSteps() {
        return steps;
    }
}
