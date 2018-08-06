package model.strategy;

import static model.animated.EntityStats.BOSS;

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
    private final int bulletNumber;

    /**
     * Constructor that initialize the common variables.
     * 
     * @param dir
     *            Direction where shoot the bullet.
     * @param n
     *            number of bullet to shoot.
     */
    public BossSimpleComboProjectile(final Command dir, final int n) {
        this.dir = dir;
        bulletNumber = n;
    }

    /**
     * Shoot bullet/s of boss.
     */
    @Override
    public final Collection<Bullet> shoot(final HitBox sender, final double range, final double vel,
            final ImageType bulletImg, final int damage, final double radius) {
        final double delta = (ProportionUtility.getHeight() - bulletNumber * radius * 2) / (bulletNumber + 1);
        return IntStream.range(0, bulletNumber)
                .mapToObj(x -> new CircleHitBox(sender.getX() - 2 * BOSS.getEntityRadius() - radius,
                        delta * (x + 1) + radius * 2 * x, radius))
                .map(x -> new BulletImpl(x, vel, new SimplyDirectionMovement(dir), range, bulletImg, damage))
                .collect(Collectors.toList());
    }
}
