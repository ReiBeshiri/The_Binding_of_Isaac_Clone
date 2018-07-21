package model.environment;

import java.util.ArrayList;
import java.util.List;

import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import model.hitbox.RectangularHitBox;
import model.inanimated.Button;
import model.inanimated.ButtonImpl;
import model.inanimated.Door;
import model.inanimated.DoorImpl;
import model.room.Room;
import model.room.RoomFactory;
import model.room.RoomFactoryImpl;
import proxyutility.ImageType;
import utility.ProportionUtility;
import utility.RoomEnum;
/**
 * World Environment Impl. 
 */
public class WorldEnvironmentImpl implements WorldEnvironment {
    private List<Room> listRoom;
    private RoomFactory rf = new RoomFactoryImpl();
    private HitBox hbRoom = new RectangularHitBox(ProportionUtility.getWidth() / 2, ProportionUtility.getHeight() / 2, ProportionUtility.getWidth(), ProportionUtility.getHeight());
    private HitBox hbDoorr = new RectangularHitBox(ProportionUtility.getWidth() - 1, ProportionUtility.getHeight() / 2, ProportionUtility.getWidthDoor(), ProportionUtility.getHeightDoor());
    private HitBox hbDoorl = new RectangularHitBox(ProportionUtility.getWallsWidth() + 1, ProportionUtility.getHeight() / 2, ProportionUtility.getWidthDoor(), ProportionUtility.getHeightDoor());
    private HitBox hbBtn = new CircleHitBox(ProportionUtility.getWidth() / 2, ProportionUtility.getHeight() / 2, ProportionUtility.getRadiusButton());
    private Door rightDoorFromMainToShop;
    private Door leftDoorFromShopToMain;
    private Door rightDoorFromShopToBoss;
    private Door rightDoorFromBossToShop;
    /**
     * Create rooms.
     * The first Room of the list is the MainRoom.
     * The second Room of the list is the ShopRoom.
     * The third Room of the list is the BossRoom.
     */
    @Override
    public List<Room> createWorld() {
        listRoom.add(createMainRoom());
        listRoom.add(createShopRoom());
        listRoom.add(createBossRoom());
        return listRoom;
    }
    private Room createMainRoom() {
        this.rightDoorFromMainToShop = new DoorImpl(hbDoorr, false, RoomEnum.SHOPROOM, ImageType.RIGHT_SHOP_DOOR_LOCKED);
        Button bt = new ButtonImpl(hbBtn, false);
        List<Door> ld = new ArrayList<>();
        ld.add(this.rightDoorFromMainToShop);
        Room mainRoom = rf.createMainRoom(hbRoom, ld, bt);
        return mainRoom;
    }
    private Room createShopRoom() {
        this.leftDoorFromShopToMain = new DoorImpl(hbDoorl, false, RoomEnum.MAINROOM, ImageType.LEFT_SHOP_DOOR_LOCKED);
        this.rightDoorFromShopToBoss = new DoorImpl(hbDoorl, false, RoomEnum.MAINROOM, ImageType.RIGHT_BOSS_DOOR);
        Button bt = new ButtonImpl(hbBtn, false);
        List<Door> ld = new ArrayList<>();
        ld.add(this.leftDoorFromShopToMain);
        ld.add(rightDoorFromShopToBoss);
        Room shopRoom = rf.createMainRoom(hbRoom, ld, bt);
        return shopRoom;
    }
    private Room createBossRoom() {
        this.rightDoorFromBossToShop = new DoorImpl(hbDoorl, false, RoomEnum.MAINROOM, ImageType.LEFT_BOSS_DOOR);
        Button bt = new ButtonImpl(hbBtn, false);
        List<Door> ld = new ArrayList<>();
        ld.add(this.rightDoorFromBossToShop);
        Room bossRoom = rf.createMainRoom(hbRoom, ld, bt);
        return bossRoom;
    }
}
