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
    private List<Room> listRoom = new ArrayList<>();
    private final RoomFactory rf = new RoomFactoryImpl();
    private final HitBox hbRoom = new RectangularHitBox(ProportionUtility.getWidth() / 2, ProportionUtility.getHeight() / 2, ProportionUtility.getWidth(), ProportionUtility.getHeight());
    private final HitBox hbDoorr = new RectangularHitBox(ModelUtility.getWorldWidth() - ProportionUtility.getWidthDoor(), ModelUtility.getWorldHeight() / 2 - ProportionUtility.getHeightDoor() / 2,  ProportionUtility.getHeightDoor(), ProportionUtility.getWidthDoor());
    private final HitBox hbDoorl = new RectangularHitBox(0, ModelUtility.getWorldHeight() / 2, ProportionUtility.getHeightDoor() + ProportionUtility.getWidthDoor(), ProportionUtility.getWidthDoor() * 2);
    private final HitBox hbBtn = new CircleHitBox(ProportionUtility.getWidth() / 2, ProportionUtility.getHeight() / 2, ProportionUtility.getRadiusButton());
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
        this.rightDoorFromMainToShop = new DoorImpl(hbDoorr, false, RoomEnum.SHOPROOM, ImageType.RIGHT_SHOP_DOOR_LOCKED);
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
     * The Boss stays in the right spot and shots to the left.
     * @return create boss room.
     */
    private Room createBossRoom() {
        this.rightDoorFromBossToShop = new DoorImpl(hbDoorl, false, RoomEnum.MAINROOM, ImageType.LEFT_BOSS_DOOR);
        List<Door> ld = new ArrayList<>();
        ld.add(this.rightDoorFromBossToShop);
        this.bossHB = new CircleHitBox(ProportionUtility.getWidth(), ProportionUtility.getHeight() / 2, ProportionUtility.getRadiusBoss());
        this.bossMov = new Motionless();
        this.bossShot = new BossSimpleComboProjectile(Command.LEFT, ProportionUtility.getRadiusBullet(), this.BOSS_SHOTS);
        this.bossAI = new BossAI(this.bossMov, this.bossShot);
        this.boss = new EnemyImpl(ProportionUtility.getBossVel(), ProportionUtility.getBossLife(), this.bossHB, this.bossAI, this.BOSS_POINTS, ProportionUtility.getBossBulletRng(), ImageType.BOSS_ENEMY, ProportionUtility.getBossShotRatio(), ImageType.BOSS_BULLET);
        Room bossRoom = rf.createBossRoom(hbRoom, ld, (Enemy) this.boss, lw);
        return bossRoom;
    }

    /**
     * create walls.
     */
    private void createWalls() {
//        double y = ProportionUtility.getWallStandard();
//        double x = 0;
//        for (int i = 0; i < (ModelUtility.getWorldHeight() - ProportionUtility.getHeightDoor()) / ProportionUtility.getWallRangeSide() - 1; i++) {
//            HitBox hb = new RectangularHitBox(x, y, ProportionUtility.getWallRangeSide(), ProportionUtility.getWallStandard());
//            Wall wall = new WallImpl(hb, false, ImageType.MAP_VERTICAL_BORDER);
//            this.lw.add(wall);
//            y += ProportionUtility.getWallRangeSide();
//            if (ProportionUtility.getWallRangeSide() * ((ModelUtility.getWorldHeight() - ProportionUtility.getHeightDoor()) / ProportionUtility.getWallRangeSide()) / 2 + ProportionUtility.getWallStandard() - y < ModelUtility.getEpsilon()) {
//                y = y + ProportionUtility.getHeightDoor();
//            }
//        }
//        y = ProportionUtility.getWallStandard();
//        for (int i = 0; i < (ModelUtility.getWorldHeight() - ProportionUtility.getHeightDoor()) / ProportionUtility.getWallRangeSide() - 1; i++) {
//            HitBox hb = new RectangularHitBox(ProportionUtility.getWidth() + ProportionUtility.getWallStandard() * 2, y, ProportionUtility.getWallRangeSide(), ProportionUtility.getWallStandard());
//            Wall wall = new WallImpl(hb, false, ImageType.MAP_VERTICAL_BORDER);
//            this.lw.add(wall);
//            y += ProportionUtility.getWallRangeSide();
//            if ((ProportionUtility.getWallRangeSide() * (ModelUtility.getWorldHeight() - ProportionUtility.getHeightDoor()) / ProportionUtility.getWallRangeSide()) / 2 + ProportionUtility.getWallStandard() - y < ModelUtility.getEpsilon()) {
//                y = y + ProportionUtility.getHeightDoor();
//            }
//        }
//        y = 0;
//        x = 0;
//        for (int i = 0; i < ModelUtility.getWorldWidth() / ProportionUtility.getWallRangeTopdown(); i++) {
//            HitBox hb = new RectangularHitBox(x, y, ProportionUtility.getWallStandard(), ProportionUtility.getWallRangeTopdown());
//            Wall wall = new WallImpl(hb, false, ImageType.MAP_HORIZONTAL_BORDER);
//            this.lw.add(wall);
//            x += ProportionUtility.getWallRangeTopdown();
//        }
//        x = 0;
//        y = ModelUtility.getWorldWidth();
//        for (int i = 0; i < ModelUtility.getWorldWidth() / ProportionUtility.getWallRangeTopdown(); i++) {
//            HitBox hb = new RectangularHitBox(x, y, ProportionUtility.getWallStandard(), ProportionUtility.getWallRangeTopdown());
//            Wall wall = new WallImpl(hb, false, ImageType.MAP_HORIZONTAL_BORDER);
//            this.lw.add(wall);
//            x += ProportionUtility.getWallRangeTopdown();
//        }
        final double wallVerticalWidth = 15;
        final double wallHorizontalWidth = 30;
        final double wallVerticalHeight = 30;
        final double wallHorizontalHeight = 15;
        for (double i = 0; i < ModelUtility.getWorldWidth(); i += wallHorizontalWidth) {
            lw.add(new WallImpl(new RectangularHitBox(i, 0, wallHorizontalHeight, wallHorizontalWidth), false,
                    ImageType.MAP_VERTICAL_BORDER));
            lw.add(new WallImpl(new RectangularHitBox(i, ModelUtility.getWorldHeight() - wallHorizontalHeight,
                    wallHorizontalHeight, wallHorizontalWidth), false, ImageType.MAP_VERTICAL_BORDER));
        }
        for (double i = wallHorizontalHeight; i < ModelUtility.getWorldHeight()
                - wallHorizontalHeight; i += wallVerticalHeight) {
            if ((ModelUtility.getWorldHeight() / 2 - ProportionUtility.getHeightDoor() / 2) - i < ModelUtility.getEpsilon() && !this.considerDoor) {
                this.considerDoor = true;
                i += ProportionUtility.getHeightDoor();
            }
            lw.add(new WallImpl(new RectangularHitBox(0, i, wallVerticalHeight, wallVerticalWidth), false,
                    ImageType.MAP_HORIZONTAL_BORDER));
            lw.add(new WallImpl(new RectangularHitBox(ModelUtility.getWorldWidth() - wallVerticalWidth, i,
                    wallVerticalHeight, wallVerticalWidth), false, ImageType.MAP_HORIZONTAL_BORDER));
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
}
