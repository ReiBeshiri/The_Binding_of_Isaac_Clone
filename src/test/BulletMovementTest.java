package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import input.Command;
import model.ai.BasicAI;
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
import model.strategy.FourWayProjectile;
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
        final double angle = 45;
        final Bullet bullet = new BulletImpl(new CircleHitBox(0, 0, 0.2), 1, new BulletMovement(angle), 10,
                ImageType.PLAYER_BULLET);
        bullet.update(1);
        assertEquals(Math.cos(angle * Math.PI / 180), bullet.getHitBox().getX());
        assertEquals(Math.sin(angle * Math.PI / 180), bullet.getHitBox().getY());
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
        final double resAngle1 = -135;
        final HitBox player1 = new CircleHitBox(0, 0, 3);
        final HitBox sender1 = new CircleHitBox(1, 1, 2);
        assertEquals(resAngle1,
                Math.atan2(player1.getY() - sender1.getY(), player1.getX() - sender1.getX()) * 180 / Math.PI);
    }

    @Test
    public void testComboBossBullets() {
        final Animated boss = new EnemyImpl(1, 3, new CircleHitBox(400, 300, 1),
                new BossAI(new Motionless(), new BossSimpleComboProjectile(Command.LEFT, 0.2, 10)), 10, 10,
                ImageType.BOSS_ENEMY, 0.3, ImageType.BOSS_BULLET);
        final List<Bullet> bullets = (List<Bullet>) boss.shot();
        assertFalse(bullets.isEmpty());
        assertTrue(bullets.size() == 10);
        IntStream.range(0, bullets.size()).forEach(x -> {
            final double xInit = bullets.get(x).getHitBox().getX();
            final double yInit = bullets.get(x).getHitBox().getY();
            bullets.get(x).update(1);
            assertEquals(xInit - 1, bullets.get(x).getHitBox().getX());
            assertEquals(yInit, bullets.get(x).getHitBox().getY());
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

    @Test
    public void fourWayBullets() {
        final Animated enemy = new EnemyImpl(1, 10, new CircleHitBox(1, 1, 2),
                new BasicAI(new Motionless(), new FourWayProjectile()), 10, 10, ImageType.BASIC_ENEMY, 0.3,
                ImageType.ENEMY_BULLET);
        final List<Bullet> bullets = (List<Bullet>) enemy.shot();

        assertTrue(bullets.size() == 4);

        //UP.
        final double xUp = bullets.get(0).getHitBox().getX();
        final double yUp = bullets.get(0).getHitBox().getY();
        bullets.get(0).update(1);
        assertEquals(xUp, bullets.get(0).getHitBox().getX());
        assertEquals(yUp - 1, bullets.get(0).getHitBox().getY());

        //DOWN
        final double xDown = bullets.get(1).getHitBox().getX();
        final double yDown = bullets.get(1).getHitBox().getY();
        bullets.get(1).update(1);
        assertEquals(xDown, bullets.get(1).getHitBox().getX());
        assertEquals(yDown + 1, bullets.get(1).getHitBox().getY());

        //LEFT
        final double xLeft = bullets.get(2).getHitBox().getX();
        final double yLeft = bullets.get(2).getHitBox().getY();
        bullets.get(2).update(1);
        assertEquals(xLeft - 1, bullets.get(2).getHitBox().getX());
        assertEquals(yLeft, bullets.get(2).getHitBox().getY());

        //RIGHT
        final double x = bullets.get(3).getHitBox().getX();
        final double y = bullets.get(3).getHitBox().getY();
        bullets.get(3).update(1);
        assertEquals(x + 1, bullets.get(3).getHitBox().getX());
        assertEquals(y, bullets.get(3).getHitBox().getY());
    }
}
