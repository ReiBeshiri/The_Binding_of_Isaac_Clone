package utility;
/**
 * Proportion Utility class.
 */
public final class ProportionUtility {
    private ProportionUtility() {
    }
    private static final double PROPORTION_PLAYER_ENEMY = 10;
    private static final double PROPORTION_BOSS = 5;
    private static final double PROPORTION_WALL = 100;
    private static final double PROPORTION_BULLET = 30;
    private static final double PROPORTION_BUTTON = 30;
    private static final double PROPORTION_DOOR = 5;
    private static final double PROPORTION_ITEMSHOP = 30;
    private static final double HEIGHT = 600;
    private static final double WIDTH = 800;
    /**
     *
     */
    public void updateDimension() {
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
     * @return get the height of the door.
     */
    public static double getHeightDoor() {
        return ProportionUtility.HEIGHT / ProportionUtility.PROPORTION_DOOR;
    }
    /**
     * @return get the width of the door.
     */
    public static double getWidthDoor() {
        return ProportionUtility.PROPORTION_DOOR;
    }
    /**
     * @return get item shop radius.
     */
    public static double getRadiusItemShop() {
        return ProportionUtility.HEIGHT / ProportionUtility.PROPORTION_ITEMSHOP;
    }
    /**
     * @return the dimension of the wall.
     * The dimension is based on the height of the Room (600 / 100).
     */
    public static double getWallsWidth() {
        return ProportionUtility.getHeigth() / ProportionUtility.PROPORTION_WALL;
    }
    /**
     * @return width of the room minus the dimension of the walls.
     * So it return the actual dimension of the playable room.
     */
    public static double getWidth() {
        return ProportionUtility.WIDTH - getWallsWidth() * 2;
    }
    /**
     * @return heigth of the room minus the dimension of the walls.
     * So it return the actual dimension of the playable room.
     */
    public static double getHeigth() {
        return ProportionUtility.HEIGHT - getWallsWidth() * 2;
    }
}
