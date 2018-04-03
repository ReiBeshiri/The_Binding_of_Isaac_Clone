package utility;

import java.util.ArrayList;
import java.util.Collection;

import input.Command;
import model.Animated;
import model.hitbox.RectangularHitBox;
import model.hitbox.CircleHitBox;
/*import model.map.Room;*/ // <-- TO CHECK WHEN MAP & ROOMS ARE IMPLEMENTED

public final class Collisions {

    public Collisions() {
        
    }
    
    /* <-- TO DO: ADD IN THE HITBOX PACKAGE .changePosition -->*/
    /**
     * Checks if the Circle has collided with the room walls
     * @param chb
     *          The CircleHitBox entity
     * @return A boolean, true if the entity has collided with the walls, false otherwise
     *//*
    public static boolean checkBoundaryCollision(final CircleHitBox chb) {
        final RectangularHitBox room=Room.getRoomSpace();//returns a HitboxRectangle that defines the position, 
                                                         //width and height of the space where the player can move
                                                         //the walls MUST BE EXCLUDED. 
        boolean result=false;
        //top wall
        if(chb.getY() + chb.getRadius() > room.getX() + room.getHeight()) {
            result = true;
            chb.changePosition(chb.getX(), room.getX() + room.getHeight() - chb.getRadius());
        }
        //bottom wall
        if(chb.getY() - chb.getRadius() < room.getY()) {
           result = true;
           chb.changePosition(chb.getX(), room.getY() + chb.getRadius());
        }
        //right wall
        if(chb.getX() + chb.getRadius() > room.getX() + room.getWidth()) {
            result = true;
            chb.changePosition(room.getX() + room.getWidth() - chb.getRadius(), chb.getY())
        }
        //left wall
        if(chb.getX() - chb.getRadius() < room.getX()) {
            result = true;
            chb.changePosition(room.getX() + chb.getRadius(), chb.getY());
        }
        return result;
    }
    */
    
    /**
     * Checks if the second Circle has collided with the first Circle
     * @param ch1
     *          The first HitBox
     * @param ch2
     *           The second HitBox
     * @return A collection of blocked movements
     */
    public static Collection<Command> entityCollision(final CircleHitBox chb1, final CircleHitBox chb2){
        
        final Collection<Command> dir=new ArrayList<>();
        final double dx = chb2.getX() - chb1.getX();
        final double dy = chb2.getY() - chb1.getY();
        final double distance = Math.sqrt(dx * dx + dy * dy);
        
        if(distance<chb1.getRadius()+chb2.getRadius()) {
            if(dx>0) {
                dir.add(Command.LEFT);                
            } else {
                dir.add(Command.RIGHT);
            }
            if(dy<0) {
                dir.add(Command.DOWN);
            } else {
                dir.add(Command.UP);
            }
        }
        return dir;
    }

}

