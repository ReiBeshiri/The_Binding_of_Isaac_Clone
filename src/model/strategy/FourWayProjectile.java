package model.strategy;

import java.util.ArrayList;
import java.util.Collection;

import input.Command;
import model.animated.Bullet;
import model.animated.BulletImpl;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
/**
 * 
 * Shoots a bullet in the direction/s given.
 *
 */
public class FourWayProjectile implements ProjectileType {
    
    private double radius;
    /**
     * Constructs a new instance of an directional projectile.
     */
    public FourWayProjectile() {
        radius = 1;
    }

    @Override
    public Collection<Bullet> shoot(HitBox sender, Collection<Command> dir, double dt, double range, double vel) {
            final Collection<Bullet> bulletColl=new ArrayList<>();
            for(Command d : dir) {
                if(d == Command.UP) {
                    bulletColl.add(new BulletImpl(new CircleHitBox(sender.getX(), sender.getY(), radius), vel,
                            new SimplyDirectionMovement(Command.UP), range));
                }
                if(d == Command.DOWN) {
                    bulletColl.add(new BulletImpl(new CircleHitBox(sender.getX(), sender.getY(), radius), vel,
                            new SimplyDirectionMovement(Command.DOWN), range));
                }
                if(d == Command.LEFT) {
                    bulletColl.add(new BulletImpl(new CircleHitBox(sender.getX(), sender.getY(), radius), vel,
                            new SimplyDirectionMovement(Command.LEFT), range));
                }
                if(d == Command.RIGHT) {
                    bulletColl.add(new BulletImpl(new CircleHitBox(sender.getX(), sender.getY(), radius), vel,
                            new SimplyDirectionMovement(Command.RIGHT), range));
                }
            }
            return bulletColl;
    }

}
