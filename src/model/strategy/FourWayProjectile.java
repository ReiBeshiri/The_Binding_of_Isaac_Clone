package model.strategy;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import model.animated.Bullet;
import model.animated.BulletImpl;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import static proxyutility.ImageType.ENEMY_BULLET;
import static input.Command.DOWN;
import static input.Command.UP;
import static input.Command.LEFT;
import static input.Command.RIGHT;

/**
 * 
 * Shoots a bullet in the direction/s given.
 *
 */
public class FourWayProjectile implements ProjectileType {
    private final double radius;

    /**
     * Constructs a new instance of an directional projectile.
     */
    public FourWayProjectile() {
        radius = 1;
    }

    /**
     * 
     */
    @Override
    public Collection<Bullet> shoot(final HitBox sender/* , final Collection<Command> dir, final double dt */,
            final double range, final double vel) {
        // final Collection<Bullet> bulletColl = new ArrayList<>();
        // for (final Command d : dir) {
        // if (d == Command.UP) {
        // bulletColl.add(new BulletImpl(new CircleHitBox(sender.getX(), sender.getY(),
        // radius), vel,
        // new SimplyDirectionMovement(Command.UP), range));
        // }
        // if (d == Command.DOWN) {
        // bulletColl.add(new BulletImpl(new CircleHitBox(sender.getX(), sender.getY(),
        // radius), vel,
        // new SimplyDirectionMovement(Command.DOWN), range));
        // }
        // if (d == Command.LEFT) {
        // bulletColl.add(new BulletImpl(new CircleHitBox(sender.getX(), sender.getY(),
        // radius), vel,
        // new SimplyDirectionMovement(Command.LEFT), range));
        // }
        // if (d == Command.RIGHT) {
        // bulletColl.add(new BulletImpl(new CircleHitBox(sender.getX(), sender.getY(),
        // radius), vel,
        // new SimplyDirectionMovement(Command.RIGHT), range));
        // }
        // }
        // return bulletColl;
        return Arrays.asList(UP, DOWN, LEFT, RIGHT).stream()
                .map(x -> new BulletImpl(new CircleHitBox(sender.getX(), sender.getY(), radius), vel,
                        new SimplyDirectionMovement(x), range, ENEMY_BULLET))
                .collect(Collectors.toList());
    }

}
