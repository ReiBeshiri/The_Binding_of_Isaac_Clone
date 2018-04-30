package utility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import input.Command;
import model.hitbox.RectangularHitBox;
import model.inanimated.Door;
import model.animated.Animated;
import model.hitbox.CircleHitBox;
import model.room.*;

/**
 * Utility class for the collisions.
 */
public final class Collisions {

    public Collisions() {
        
    }
    
    /**
     * Checks if the Circle has collided with the room walls.
     * @param chb
     *          The CircleHitBox entity.
     * @return A boolean, true if the entity has collided with the walls, false otherwise.
     */
    public static boolean checkBoundaryCollision(final CircleHitBox chb, final Room rectRoom) {
        final RectangularHitBox room=(RectangularHitBox)rectRoom.getHitBox();
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
            chb.changePosition(room.getX() + room.getWidth() - chb.getRadius(), chb.getY());
        }
        //left wall
        if(chb.getX() - chb.getRadius() < room.getX()) {
            result = true;
            chb.changePosition(room.getX() + chb.getRadius(), chb.getY());
        }
        return result;
    }
    
    /**
     * Checks if the second Animated object has collided with the first Animated object.
     * @param a1
     *          The first Animated entity.
     * @param a2
     *          The second Animated entity.
     * @return
     *          A collection of blocked movements.
     */
    public static Collection<Command> entityCollision(Animated a1, Animated a2){
        return entityCollision((CircleHitBox)a1.getHitBox(), (CircleHitBox)a2.getHitBox());
    }
    
    /**
     * Checks if the second Circle has collided with the first Circle.
     * @param ch1
     *          The first HitBox.
     * @param ch2
     *           The second HitBox.
     * @return A collection of blocked movements.
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
   
    /**
     * Checks if the second Circle (player) has collided with the Rectangle (door).
     * @param chb
     *          The player HitBox.
     * @param rhb
     *          The door HitBox.
     * @return True if the collision occurred, false otherwise. 
     */
    private boolean doorPlayerCollision(final CircleHitBox chb, final RectangularHitBox rhb) {
        final double distX = Math.abs(chb.getX() - rhb.getX() - rhb.getWidth() / 2);
        final double distY = Math.abs(chb.getY() - rhb.getY() - rhb.getHeight() / 2);
        
        if (distX > ((rhb.getWidth() / 2) + chb.getRadius()) || distY > ((rhb.getHeight() / 2) + chb.getRadius())) {
            return false;
        }
        if (distX <= (rhb.getWidth() / 2) || distY <= (rhb.getHeight() / 2)) {
            return true;
        }
        final double dx = distX - (rhb.getWidth() / 2);
        final double dy = distY - (rhb.getHeight() / 2);
        return (dx * dx + dy * dy <= (chb.getRadius() * chb.getRadius()));
    }

}

