package utility;
/**
 * Proportion Utility class.
 */
public final class ProportionUtility {
    private ProportionUtility() {
    }
    private static final double PROPORTION_PLAYER_ENEMY = 10;
    private static final double PROPORTION_BOSS = 5;
    private static final double PROPORTION_WALL = 15;
    private static final double PROPORTION_BULLET = 30;
    private static final double PROPORTION_BUTTON = 30;
    private static final double PROPORTION_DOOR_WIDTH = 15;
    private static final double PROPORTION_DOOR_HEIGHT = 120;
    private static final double PROPORTION_ITEMSHOP = 30;
    private static final double HEIGHT = 600;
    private static final double WIDTH = 800;
    private static final double PLAYER_BULLET_SPEED = 20;
    private static final double PLAYER_BULLET_RANGE = 400;
    private static final int BOSS_LIFE = 30;
    private static final double BOSS_VEL = 20;
    private static final double BOSS_BULLET_RNG = 500;
    private static final double BOSS_SHOT_RATIO = 0.4;
    /**
     *
     */
    public void updateDimension() {
    }
    /**
     * @return the bullet velocity of the player.
     */
    public static double getPlayerBulletSpeed() {
        return ProportionUtility.PLAYER_BULLET_SPEED;
    }
    /**
     * @return boss life.
     */
    public static int getBossLife() {
        return ProportionUtility.BOSS_LIFE;
    }
    /**
     * @return boss velocity.
     */
    public static double getBossVel() {
        return ProportionUtility.BOSS_VEL;
    }
    /**
     * @return boss bullet shot ratio.
     */
    public static double getBossShotRatio() {
        return ProportionUtility.BOSS_SHOT_RATIO;
    }
    /**
     * @return boss bullet range.
     */
    public static double getBossBulletRng() {
        return ProportionUtility.BOSS_BULLET_RNG;
    }
    /**
     * @return the bullet range of the player.
     */
    public static double getPlayerBulletRange() {
        return ProportionUtility.PLAYER_BULLET_RANGE;
    }
    /**
     * @return get radius animated obj like enemy & player.
     */
    public static double getRadiusPlayer() {
        return ProportionUtility.HEIGHT /  ProportionUtility.PROPORTION_PLAYER_ENEMY;
    }
    /**
     * @return get radius animated obj like enemy & player.
     */
    public static double getRadiusEnemy() {
        return ProportionUtility.HEIGHT /  ProportionUtility.PROPORTION_PLAYER_ENEMY;
    }
    /**
     * @return get radius bullet.
     */
    public static double getRadiusBullet() {
        return ProportionUtility.HEIGHT / ProportionUtility.PROPORTION_BULLET;
    }
    /**
     * @return get radius boss.
     */
    public static double getRadiusBoss() {
        return ProportionUtility.HEIGHT / ProportionUtility.PROPORTION_BOSS;
    }
    /**
     * @return get radius button.
     */
    public static double getRadiusButton() {
        return ProportionUtility.HEIGHT / ProportionUtility.PROPORTION_BUTTON;
    }
    /**
     * @return get the height of the door (120).
     */
    public static double getHeightDoor() {
        return ProportionUtility.PROPORTION_DOOR_HEIGHT;
    }
    /**
     * @return get the width of the door (15).
     */
    public static double getWidthDoor() {
        return ProportionUtility.PROPORTION_DOOR_WIDTH;
    }
    /**
     * @return get item shop radius.
     */
    public static double getRadiusItemShop() {
        return ProportionUtility.HEIGHT / ProportionUtility.PROPORTION_ITEMSHOP;
    }
    /**
     * @return the width of the wall.
     * The dimension is based on the height of the Room (15).
     */
    public static double getWallsWidth() {
        return ProportionUtility.PROPORTION_WALL;
    }
    /**
     * @return the height of the wall.
     * The dimension is based on the height of the Room (15).
     */
    public static double getWallsHeight() {
        return ProportionUtility.PROPORTION_WALL;
    }
    /**
     * @return width of the room minus the dimension of the walls.
     * So it return the actual dimension of the playable room.
     */
    public static double getWidth() {
        return ProportionUtility.WIDTH - getWallsWidth() * 2;
    }
    /**
     * @return height of the room minus the dimension of the walls.
     * So it return the actual dimension of the playable room.
     */
    public static double getHeight() {
        return ProportionUtility.HEIGHT - getWallsWidth() * 2;
    }
}
