package utility;

/**
 * Proportion Utility class.
 */
public final class ProportionUtility {

    private static final double PROPORTION_PLAYER_ENEMY = 25;
    private static final double PROPORTION_BOSS = 5;
    private static final double PROPORTION_WALL = 15;
    private static final double PROPORTION_WALL_RANGE_SIDE = 30;
    private static final double PROPORTION_WALL_RANGE_TOPDOWN = 40;
    private static final double PROPORTION_BULLET = 50;
    private static final double PROPORTION_BUTTON = 40;
    private static final double PROPORTION_DOOR_WIDTH = 15;
    private static final double PROPORTION_DOOR_HEIGHT = 90;
    private static final double PROPORTION_ITEMSHOP = 30;
    private static final double HEIGHT = 600;
    private static final double WIDTH = 800;
    private static final double PLAYER_BULLET_RATIO = 500000000;
    private static final double PLAYER_BULLET_RANGE = 400;
    private static final double BOSS_VEL = 20;
    private static final double BOSS_BULLET_RNG = 500;
    private static final double BOSS_SHOT_RATIO = 0.4;
    private static final double PLAYER_VEL = 20;
    private static final double WALLVERTICALWIDTH = 15;
    private static final double WALLHORIZONTALWIDTH = 30;
    private static final double WALLVERTICALLHEIGHT = 30;
    private static final double WALLHORIZONTALHEIGHT = 15;
    private static final int PLAYER_LIFE = 6;
    private static final int BOSS_LIFE = 30;

    private ProportionUtility() { }

    /**
     * @return the bullet velocity of the player.
     */
    public static double getPlayerBulletRatio() {
        return ProportionUtility.PLAYER_BULLET_RATIO;
    }

    /**
     * @return wall vertical width (15).
     */
    public static double getWallVerticalWidth() {
        return ProportionUtility.WALLVERTICALWIDTH;
    }

    /**
     * @return wall vertical height (30).
     */
    public static double getWallVerticalHeight() {
        return ProportionUtility.WALLVERTICALLHEIGHT;
    }

    /**
     * @return wall horizontal width (30).
     */
    public static double getWallHorizontalWidth() {
        return ProportionUtility.WALLHORIZONTALWIDTH;
    }

    /**
     * @return wall horizontal height (15).
     */
    public static double getWallHorizontalHeight() {
        return ProportionUtility.WALLHORIZONTALHEIGHT;
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
     * @return wall range side (30).
     */
    public static double getWallRangeSide() {
        return ProportionUtility.PROPORTION_WALL_RANGE_SIDE;
    }

    /**
     * @return wall range top down (40).
     */
    public static double getWallRangeTopdown() {
        return ProportionUtility.PROPORTION_WALL_RANGE_TOPDOWN;
    }

    /**
     * @return velocity of the player.
     */
    public static double getPlayerVel() {
        return ProportionUtility.PLAYER_VEL;
    }

    /**
     * @return life of the player.
     */
    public static int getPlayerLife() {
        return ProportionUtility.PLAYER_LIFE;
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
     * @return get the height of the door (90).
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
     * @return the width or height of the wall.
     * The dimension is based on the height or the width of the wall (15).
     */
    public static double getWallStandard() {
        return ProportionUtility.PROPORTION_WALL;
    }

    /**
     * @return width of the room minus the dimension of the walls.
     * So it return the actual dimension of the playable room.
     */
    public static double getWidth() {
        return ProportionUtility.WIDTH - getWallStandard() * 2;
    }

    /**
     * @return height of the room minus the dimension of the walls.
     * So it return the actual dimension of the playable room.
     */
    public static double getHeight() {
        return ProportionUtility.HEIGHT - getWallStandard() * 2;
    }
}
