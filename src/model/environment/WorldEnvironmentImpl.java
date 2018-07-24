package model.environment;

import java.util.ArrayList;
import java.util.List;

import model.ai.AI;
import model.ai.BossAI;
import model.animated.Animated;
import model.animated.Enemy;
import model.animated.EnemyFactoryImpl;
import model.animated.EnemyImpl;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import model.hitbox.RectangularHitBox;
import model.inanimated.Button;
import model.inanimated.ButtonImpl;
import model.inanimated.Door;
import model.inanimated.DoorImpl;
import model.inanimated.HeartImpl;
import model.inanimated.Inanimated;
import model.inanimated.Wall;
import model.room.Room;
import model.room.RoomFactory;
import model.room.RoomFactoryImpl;
import model.strategy.ChasePlayerProjectile;
import model.strategy.FollowPlayerMovement;
import model.strategy.MovementStrategy;
import model.strategy.ProjectileType;
import proxyutility.ImageType;
import utility.ModelUtility;
import utility.ProportionUtility;
import utility.RoomEnum;
import utility.SpawnUtility;
/**
 * World Environment Impl. 
 */
public class WorldEnvironmentImpl implements WorldEnvironment {
    private List<Room> listRoom;
    private final RoomFactory rf = new RoomFactoryImpl();
    private final HitBox hbRoom = new RectangularHitBox(ProportionUtility.getWidth() / 2, ProportionUtility.getHeight() / 2, ProportionUtility.getWidth(), ProportionUtility.getHeight());
    private final HitBox hbDoorr = new RectangularHitBox(ProportionUtility.getWidth() - 1, ProportionUtility.getHeight() / 2, ProportionUtility.getWidthDoor(), ProportionUtility.getHeightDoor());
    private final HitBox hbDoorl = new RectangularHitBox(ProportionUtility.getWallsWidth() + 1, ProportionUtility.getHeight() / 2, ProportionUtility.getWidthDoor(), ProportionUtility.getHeightDoor());
    private final HitBox hbBtn = new CircleHitBox(ProportionUtility.getWidth() / 2, ProportionUtility.getHeight() / 2, ProportionUtility.getRadiusButton());
    private Door rightDoorFromMainToShop;
    private Door leftDoorFromShopToMain;
    private Door rightDoorFromShopToBoss;
    private Door rightDoorFromBossToShop;
    private List<Wall> lw;
    private List<Inanimated> items;
    private Animated boss;
    private static final int BOSS_POINTS = 1000;
    private HitBox bossHB;
    private MovementStrategy bossMov;
    private ProjectileType bossShot;
    private AI bossAI;

    /**
     * Create rooms.
     * The first Room of the list is the MainRoom.
     * The second Room of the list is the ShopRoom.
     * The third Room of the list is the BossRoom.
     */
    @Override
    public List<Room> createWorld() {
        createWalls();
        listRoom.add(createMainRoom());
        listRoom.add(createShopRoom());
        listRoom.add(createBossRoom());
        return listRoom;
    }

    /**
     * @return create main room.
     */
    private Room createMainRoom() {
        this.rightDoorFromMainToShop = new DoorImpl(hbDoorr, false, RoomEnum.SHOPROOM, ImageType.RIGHT_SHOP_DOOR_LOCKED);
        Button bt = new ButtonImpl(hbBtn, false);
        List<Door> ld = new ArrayList<>();
        ld.add(this.rightDoorFromMainToShop);
        Room mainRoom = rf.createMainRoom(hbRoom, ld, bt, lw);
        return mainRoom;
    }

    /**
     * @return create shop room.
     */
    private Room createShopRoom() {
        this.leftDoorFromShopToMain = new DoorImpl(hbDoorl, false, RoomEnum.MAINROOM, ImageType.LEFT_SHOP_DOOR_LOCKED);
        this.rightDoorFromShopToBoss = new DoorImpl(hbDoorl, false, RoomEnum.MAINROOM, ImageType.RIGHT_BOSS_DOOR);
        List<Door> ld = new ArrayList<>();
        ld.add(this.leftDoorFromShopToMain);
        ld.add(this.rightDoorFromShopToBoss);
        HitBox hb = new CircleHitBox(SpawnUtility.getSpawnBX(), SpawnUtility.getSpawnBY(), ProportionUtility.getRadiusButton());
        items.add(new HeartImpl(hb, true));
        Room shopRoom = rf.createShopRoom(hbRoom, ld, items, lw);
        return shopRoom;
    }

    /**
     * @return create boss room.
     */
    private Room createBossRoom() {
        this.rightDoorFromBossToShop = new DoorImpl(hbDoorl, false, RoomEnum.MAINROOM, ImageType.LEFT_BOSS_DOOR);
        List<Door> ld = new ArrayList<>();
        ld.add(this.rightDoorFromBossToShop);
        this.bossHB = new CircleHitBox(ProportionUtility.getWidth() / 2, ProportionUtility.getHeight() / 2, ProportionUtility.getRadiusBoss());
        this.bossMov = new FollowPlayerMovement();
        this.bossShot = new ChasePlayerProjectile(ProportionUtility.getRadiusBullet());
        this.bossAI = new BossAI(this.bossMov, this.bossShot);
        this.boss = new EnemyImpl(ProportionUtility.getBossVel(), ProportionUtility.getBossLife(), this.bossHB, this.bossAI, this.BOSS_POINTS, ProportionUtility.getBossBulletRng(), ImageType.BOSS_ENEMY, ProportionUtility.getBossShotRatio(), ImageType.BOSS_BULLET);
        Room bossRoom = rf.createBossRoom(hbRoom, ld, (Enemy) this.boss, lw);
        return bossRoom;
    }

    /**
     * create walls.
     */
    private void createWalls() {
    }

    /**
     * @return rightDoorFromMainToShop.
     */
    @Override
    public Door getRightDoorFromMainToShop() {
        return this.rightDoorFromMainToShop;
    }

    /**
     * @return leftDoorFromShopToMain.
     */
    @Override
    public Door getLeftDoorFromShopToMain() {
        return this.leftDoorFromShopToMain;
    }

    /**
     * @return rightDoorFromShopToBoss.
     */
    @Override
    public Door getRightDoorFromShopToBoss() {
        return this.rightDoorFromShopToBoss;
    }

    /**
     * @return rightDoorFromBossToShop.
     */
    @Override
    public Door getLeftDoorFromBossToShop() {
        return this.rightDoorFromBossToShop;
    }

    /**
     * @return boss.
     */
    public Animated getBoss() {
        return this.boss;
    }

    /**
     * @return list of items in the shop.
     */
    @Override
    public List<Inanimated> getItems() {
        return this.items;
    }
}
