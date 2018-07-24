package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import input.Command;
import model.ai.BossAI;
import model.animated.AbstractCharacter;
import model.animated.Animated;
import model.animated.Bullet;
import model.animated.BulletImpl;
import model.animated.EnemyImpl;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import model.strategy.BossAimedComboProjectile;
import model.strategy.BossSimpleComboProjectile;
import model.strategy.BulletMovement;
import model.strategy.Motionless;
import model.strategy.SimplyDirectionMovement;
import model.strategy.SingleDirectionProjectile;
import proxyutility.ImageType;

class BulletMovementTest {

    @Test
    public void testSimpleMovementBullet() {
        final Bullet bullet = new BulletImpl(new CircleHitBox(0, 0, 0.2), 1, new SimplyDirectionMovement(Command.RIGHT),
                10, ImageType.PLAYER_BULLET);
        bullet.update(1);
        assertEquals(1, bullet.getHitBox().getX());
        assertEquals(0, bullet.getHitBox().getY());
    }

    /**
     * Test of bullet shot in diagonal of canvas direction. Note: angle * Math.PI /
     * 180 -> conversion of the angle in radiant.
     */
    @Test
    public void testDiagonalMovementBullet() {
        final double angle = -45;
        final Bullet bullet = new BulletImpl(new CircleHitBox(0, 0, 0.2), 1, new BulletMovement(angle), 10,
                ImageType.PLAYER_BULLET);
        bullet.update(1);
        assertEquals(Math.sin(angle * Math.PI / 180), bullet.getHitBox().getX());
        assertEquals(Math.cos(angle * Math.PI / 180), bullet.getHitBox().getY());
    }

    /**
     * Test atan2 and the angle between player and enemy sender.
     */
    @Test
    public void testAimedMovementBullet() {
        final double resAngle = 135;
        final HitBox player = new CircleHitBox(0, 0, 3);
        final HitBox sender = new CircleHitBox(1, -1, 2);
        assertEquals(resAngle,
                Math.atan2(player.getY() - sender.getY(), player.getX() - sender.getX()) * 180 / Math.PI);
    }

    @Test
    public void testComboBossBullets() {
        final Animated boss = new EnemyImpl(10, 3, new CircleHitBox(400, 300, 1),
                new BossAI(new Motionless(), new BossSimpleComboProjectile(Command.LEFT, 0.2, 10)), 10, 10,
                ImageType.BOSS_ENEMY, 0.3, ImageType.BOSS_BULLET);
        final List<Bullet> bullets = (List<Bullet>) boss.shot();
        assertFalse(bullets.isEmpty());
        assertTrue(bullets.size() == 10);
        final List<HitBox> oldHitBox = bullets.stream()
                                              .map(x -> x.getHitBox())
                                              .collect(Collectors.toList());
        bullets.forEach(x -> x.update(1));
        IntStream.range(0, bullets.size())
                 .forEach(x -> {
                     assertEquals(oldHitBox.get(x).getX() - 1, bullets.get(x).getHitBox().getX() - 1);
                     assertEquals(oldHitBox.get(x).getY(), bullets.get(x).getHitBox().getY());
                 });
    }

    /**
     * Test used to check boss decision.
     */
    @Test
    public void testBossDecision() {
        final int bossDmg1 = 30;
        final int bossDmg2 = 25;
        final AbstractCharacter boss = new EnemyImpl(10, 50, new CircleHitBox(400, 300, 1),
                new BossAI(new Motionless(), new SingleDirectionProjectile(Command.LEFT, 0.2)), 10, 10,
                ImageType.BOSS_ENEMY, 0.3, ImageType.BOSS_BULLET);
        boss.decLife(bossDmg1);
        boss.getAI().nextPhaseStrategy(boss.getLife());
        assertTrue(boss.getAI().getMovementStrategy() instanceof Motionless);
        assertTrue(boss.getAI().getProjType() instanceof BossSimpleComboProjectile);
        boss.decLife(bossDmg2);
        boss.getAI().nextPhaseStrategy(boss.getLife());
        assertTrue(boss.getAI().getMovementStrategy() instanceof Motionless);
        assertTrue(boss.getAI().getProjType() instanceof BossAimedComboProjectile);
    }
}
