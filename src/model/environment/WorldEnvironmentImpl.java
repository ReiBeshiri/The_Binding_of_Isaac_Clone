package model.environment;

import java.util.ArrayList;
import java.util.List;

import input.Command;
import model.ai.AI;
import model.ai.BossAI;
import model.animated.Animated;
import model.animated.Enemy;
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
import model.inanimated.WallImpl;
import model.room.Room;
import model.room.RoomFactory;
import model.room.RoomFactoryImpl;
import model.strategy.BossSimpleComboProjectile;
import model.strategy.Motionless;
import model.strategy.MovementStrategy;
import model.strategy.ProjectileType;
import proxyutility.ImageType;
import utility.ModelUtility;
import utility.ProportionUtility;
import utility.RoomEnum;
import utility.SpawnUtility;

/**
 * World Environment Implement. 
 */
public class WorldEnvironmentImpl implements WorldEnvironment {
    private final List<Room> listRoom = new ArrayList<>();
    private final RoomFactory rf = new RoomFactoryImpl();
    private final HitBox hbRoom = new RectangularHitBox(ProportionUtility.getWallVerticalWidth(), ProportionUtility.getWallHorizontalHeight(), ProportionUtility.getHeight(), ProportionUtility.getWidth());
    private final HitBox hbDoorr = new RectangularHitBox(ModelUtility.getWorldWidth() - ProportionUtility.getWidthDoor(), ModelUtility.getWorldHeight() / 2 - ProportionUtility.getHeightDoor() / 2,  ProportionUtility.getHeightDoor(), ProportionUtility.getWidthDoor());
    private final HitBox hbDoorl = new RectangularHitBox(0, ModelUtility.getWorldHeight() / 2, ProportionUtility.getHeightDoor() + ProportionUtility.getWidthDoor(), ProportionUtility.getWidthDoor() * 2);
    private final HitBox hbBtn = new CircleHitBox(ModelUtility.getWorldWidth() / 2, ModelUtility.getWorldHeight() / 2, ProportionUtility.getRadiusButton());
    private final Button bt = new ButtonImpl(hbBtn, false);
    private Door rightDoorFromMainToShop;
    private Door leftDoorFromShopToMain;
    private Door rightDoorFromShopToBoss;
    private Door rightDoorFromBossToShop;
    private final List<Wall> lw = new ArrayList<>();
    private final List<Inanimated> items = new ArrayList<>();
    private Animated boss;
    private static final int BOSS_POINTS = 1000;
    private static final int BOSS_SHOTS = 10;
    private HitBox bossHB;
    private MovementStrategy bossMov;
    private ProjectileType bossShot;
    private AI bossAI;
    private boolean considerDoor = false;

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
        List<Wall> lwMain = new ArrayList<>();
        this.rightDoorFromMainToShop = new DoorImpl(hbDoorr, false, RoomEnum.SHOPROOM, ImageType.RIGHT_SHOP_DOOR_LOCKED);
        List<Door> ld = new ArrayList<>();
        lwMain.addAll(this.lw);
        lwMain.addAll(wallMainRoom());
        ld.add(this.rightDoorFromMainToShop);
        Room mainRoom = rf.createMainRoom(hbRoom, ld, bt, lwMain);
        return mainRoom;
    }

    /**
     * @return create shop room.
     */
    private Room createShopRoom() {
        this.leftDoorFromShopToMain = new DoorImpl(hbDoorl, false, RoomEnum.MAINROOM, ImageType.LEFT_SHOP_DOOR_LOCKED);
        this.rightDoorFromShopToBoss = new DoorImpl(hbDoorr, false, RoomEnum.MAINROOM, ImageType.RIGHT_BOSS_DOOR);
        List<Door> ld = new ArrayList<>();
        ld.add(this.leftDoorFromShopToMain);
        ld.add(this.rightDoorFromShopToBoss);
        HitBox hb = new CircleHitBox(SpawnUtility.getSpawnBX(), SpawnUtility.getSpawnBY(), ProportionUtility.getRadiusButton());
        items.add(new HeartImpl(hb, true));
        Room shopRoom = rf.createShopRoom(hbRoom, ld, items, lw);
        return shopRoom;
    }

    /**
     * The Boss stays in the right spot and shots to the left.
     * @return create boss room.
     */
    private Room createBossRoom() {
        this.rightDoorFromBossToShop = new DoorImpl(hbDoorl, false, RoomEnum.MAINROOM, ImageType.LEFT_BOSS_DOOR);
        List<Door> ld = new ArrayList<>();
        ld.add(this.rightDoorFromBossToShop);
        this.bossHB = new CircleHitBox(SpawnUtility.getSpawnXEnterLeftDoor(), SpawnUtility.getSpawnYEnterLeftDoor(), ProportionUtility.getRadiusBoss());
        this.bossMov = new Motionless();
        this.bossShot = new BossSimpleComboProjectile(Command.LEFT, ProportionUtility.getRadiusBullet(), WorldEnvironmentImpl.BOSS_SHOTS);
        this.bossAI = new BossAI(this.bossMov, this.bossShot);
        this.boss = new EnemyImpl(ProportionUtility.getBossVel(), ProportionUtility.getBossLife(), this.bossHB, this.bossAI, WorldEnvironmentImpl.BOSS_POINTS, ProportionUtility.getBossBulletRng(), ImageType.BOSS_ENEMY, ProportionUtility.getBossShotRatio(), ImageType.BOSS_BULLET);
        Room bossRoom = rf.createBossRoom(hbRoom, ld, (Enemy) this.boss, lw);
        return bossRoom;
    }

    /**
     * create walls.
     */
    private void createWalls() {
        for (double i = 0; i < ModelUtility.getWorldWidth(); i += ProportionUtility.getWallHorizontalWidth()) {
            lw.add(new WallImpl(new RectangularHitBox(i, 0, ProportionUtility.getWallHorizontalHeight(), ProportionUtility.getWallHorizontalWidth()), false,
                    ImageType.MAP_VERTICAL_BORDER));
            lw.add(new WallImpl(new RectangularHitBox(i, ModelUtility.getWorldHeight() - ProportionUtility.getWallHorizontalHeight(),
                    ProportionUtility.getWallHorizontalHeight(), ProportionUtility.getWallHorizontalWidth()), false, ImageType.MAP_VERTICAL_BORDER));
        }
        for (double i = ProportionUtility.getWallHorizontalHeight(); i < ModelUtility.getWorldHeight()
                - ProportionUtility.getWallHorizontalHeight(); i += ProportionUtility.getWallVerticalHeight()) {
            if ((ModelUtility.getWorldHeight() / 2 - ProportionUtility.getHeightDoor() / 2) - i < ModelUtility.getEpsilon() && !this.considerDoor) {
                this.considerDoor = true;
                i += ProportionUtility.getHeightDoor();
            }
            lw.add(new WallImpl(new RectangularHitBox(0, i, ProportionUtility.getWallVerticalHeight(), ProportionUtility.getWallVerticalWidth()), false,
                    ImageType.MAP_HORIZONTAL_BORDER));
            lw.add(new WallImpl(new RectangularHitBox(ModelUtility.getWorldWidth() - ProportionUtility.getWallVerticalWidth(), i,
                    ProportionUtility.getWallVerticalHeight(), ProportionUtility.getWallVerticalWidth()), false, ImageType.MAP_HORIZONTAL_BORDER));
        }
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

    /**
     * @return the button of the main room.
     */
    @Override
    public Button getButton() {
        return this.bt;
    }

    /**
     * @return the hb of the playable room.
     */
    @Override
    public HitBox getRoomHB() {
        return this.hbRoom;
    }

    /**
     * @return wall main room.
     */
    private List<Wall> wallMainRoom() {
        List<Wall> l = new ArrayList<>();
        for (double i = ModelUtility.getWorldHeight() / 2 - ProportionUtility.getHeightDoor() / 2; i < ModelUtility.getWorldHeight() / 2 + ProportionUtility.getHeightDoor() / 2; i += ProportionUtility.getWallVerticalHeight()) {
            l.add(new WallImpl(new RectangularHitBox(0, i, ProportionUtility.getWallVerticalHeight(), ProportionUtility.getWallVerticalWidth()), false, ImageType.MAP_HORIZONTAL_BORDER));
        }
        return l;
    }
}
