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
import utility.ProportionUtility;
import utility.RoomEnum;
/**
 * World Environment Impl. 
 */
public class WorldEnvironmentImpl implements WorldEnvironment {
    private List<Room> listRoom;
    private RoomFactory rf = new RoomFactoryImpl();
    private HitBox hbRoom = new RectangularHitBox(ProportionUtility.getWidth() / 2, ProportionUtility.getHeigth() / 2, ProportionUtility.getWidth(), ProportionUtility.getHeigth());
    private HitBox hbDoorr = new RectangularHitBox(ProportionUtility.getWidth() - 1, ProportionUtility.getHeigth() / 2, ProportionUtility.getWidthDoor(), ProportionUtility.getHeightDoor());
    private HitBox hbDoorl = new RectangularHitBox(1, ProportionUtility.getHeigth() / 2, ProportionUtility.getWidthDoor(), ProportionUtility.getHeightDoor());
    private HitBox hbBtn = new CircleHitBox(ProportionUtility.getWidth() / 2, ProportionUtility.getHeigth() / 2, ProportionUtility.getRadiusButton());
    /**
     * Create rooms.
     */
    @Override
    public List<Room> createWorld() {
        listRoom.add(createMainRoom());
        listRoom.add(createShopRoom());
        listRoom.add(createBossRoom());
        return listRoom;
    }
    private Room createMainRoom() {
        Door door1 = new DoorImpl(hbDoorl, false, RoomEnum.SHOPROOM);
        Door door2 = new DoorImpl(hbDoorr, false, RoomEnum.BOSSROOM);
        Button bt = new ButtonImpl(hbBtn, false);
        List<Door> ld = new ArrayList<>();
        ld.add(door1);
        ld.add(door2);
        Room mainRoom = rf.createMainRoom(hbRoom, ld, bt);
        return mainRoom;
    }
    private Room createShopRoom() {
        Door door1 = new DoorImpl(hbDoorl, false, RoomEnum.MAINROOM);
        Button bt = new ButtonImpl(hbBtn, false);
        List<Door> ld = new ArrayList<>();
        ld.add(door1);
        Room shopRoom = rf.createMainRoom(hbRoom, ld, bt);
        return shopRoom;
    }
    private Room createBossRoom() {
        Door door1 = new DoorImpl(hbDoorl, false, RoomEnum.MAINROOM);
        Button bt = new ButtonImpl(hbBtn, false);
        List<Door> ld = new ArrayList<>();
        ld.add(door1);
        Room bossRoom = rf.createMainRoom(hbRoom, ld, bt);
        return bossRoom;
    }
}
