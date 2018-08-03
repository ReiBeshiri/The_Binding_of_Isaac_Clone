package model.strategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import input.Command;
import model.animated.Bullet;
import model.animated.BulletImpl;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import proxyutility.ImageType;
import utility.ModelUtility;
import static input.Command.DOWN;
import static input.Command.UP;
import static input.Command.LEFT;
import static input.Command.RIGHT;

/**
 * Class that represent player bullet's type.
 * 
 */
public class PlayerProjectile implements ProjectileType {

    /**
     * Shoot single bullet for player.
     */
    @Override
    public Collection<Bullet> shoot(final HitBox sender, final double range, final double vel,
            final ImageType bulletImg, final int damage, final double radius) {
        final List<Command> shotCommand = ModelUtility.getListShotsCommand();
        Command dirToShoot = null;
        double x = sender.getX();
        double y = sender.getY();
        final double r = ((CircleHitBox) sender).getRadius();
        if (shotCommand.contains(LEFT)) {
            dirToShoot = LEFT;
            x -= r;
        } else if (shotCommand.contains(RIGHT)) {
            dirToShoot = RIGHT;
            x += r;
        } else if (shotCommand.contains(UP)) {
            dirToShoot = UP;
            y -= r;
        } else if (shotCommand.contains(DOWN)) {
            dirToShoot = DOWN;
            y += r;
        }
        if (dirToShoot != null) {
            final List<Bullet> shots = new ArrayList<>();
            shots.add(new BulletImpl(new CircleHitBox(x, y, radius), vel, new SimplyDirectionMovement(dirToShoot),
                    range, bulletImg, damage));
            return shots;
        }
        return Collections.emptyList();
    }

}
