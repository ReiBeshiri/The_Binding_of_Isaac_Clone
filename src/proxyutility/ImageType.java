package proxyutility;
/**
 * Enum that represent different type of images.
 *
 */
public enum ImageType {
    /**
     * aimed enemy.
     */
    AIMED_ENEMY("AimedEnemy.png"),
    /**
     * basic enemy.
     */
    BASIC_ENEMY("BasicEnemy.png"),
    /**
     * boss.
     */
    BOSS_ENEMY("BossEnemy.png"),
    /**
     * full heart.
     */
    FULL_HEART("FullHeart.png"),
    /**
     * half hearth.
     */
    HALF_HEART("HalfHeart.png"),
    /**
     * left boss door.
     */
    LEFT_BOSS_DOOR("LeftBossDoor.png"),
    /**
     * left shop door locked.
     */
    LEFT_SHOP_DOOR_LOCKED("LeftShopDoorLocked.png"),
    /**
     * left shop door unlocked.
     */
    LEFT_SHOP_DOOP_UNLOCKED("LeftShopDoorUnlocked.png"),
    /**
     * Map horizontal border.
     */
    MAP_HORIZONTAL_BORDER("MapBorderHeight.png"),
    /**
     * Map vertical border.
     */
    MAP_VERTICAL_BORDER("MapBorderWidth.png"),
    /**
     * player.
     */
    PLAYER("Player.png"),
    /**
     * Right boss door.
     */
    RIGHT_BOSS_DOOR("RightBossDoor.png"),
    /**
     * Right shop door locked.
     */
    RIGHT_SHOP_DOOR_LOCKED("RightShopDoorLocked.png"),
    /**
     * Right shop door locked.
     */
    RIGHT_SHOP_DOOR_UNLOCKED("RightShopDoorUnlocked.png");

    private final String path;

    ImageType(final String path) {
        this.path = path;
    }
    /**
     * 
     * @return Return the image name.
     */
    public String getName() {
        return this.path;
    }
}