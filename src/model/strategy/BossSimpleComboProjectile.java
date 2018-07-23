package model.strategy;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import input.Command;
import model.animated.Bullet;
import model.animated.BulletImpl;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import proxyutility.ImageType;
import utility.ProportionUtility;

/**
 * 
 * Class that represent collection of bullet shooted in same direction.
 *
 */
public class BossSimpleComboProjectile implements ProjectileType {

    private final Command dir;
    private final double radius;
    private final int bulletNumber;

    /**
     * Constructor that initialize the common variables.
     * 
     * @param dir
     *            Direction where shoot the bullet.
     * @param r
     *            radius of bullet.
     * @param n
     *            number of bullet to shoot.
     */
    public BossSimpleComboProjectile(final Command dir, final double r, final int n) {
        this.dir = dir;
        radius = r;
        bulletNumber = n;
    }

    /**
     * Shoot bullet/s of boss.
     */
    @Override
    public final Collection<Bullet> shoot(final HitBox sender, final double range, final double vel,
            final ImageType bulletImg) {
        final double delta = (ProportionUtility.getHeight() - bulletNumber * radius * 2)
                / (bulletNumber + 1);
        return IntStream.range(0, bulletNumber)
                        .mapToObj(x -> new CircleHitBox(sender.getX() - 2 * ProportionUtility.getRadiusBoss() - radius, delta * (x + 1) + radius * 2 * x, radius))
                        .map(x -> new BulletImpl(x, vel, new SimplyDirectionMovement(dir), range, bulletImg))
                        .collect(Collectors.toList());
    }
}
