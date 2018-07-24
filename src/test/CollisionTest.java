package test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import input.Command;
import model.animated.Animated;
import model.animated.BulletImpl;
import model.hitbox.CircleHitBox;
import model.strategy.BulletMovement;
import proxyutility.ImageType;
import utility.CollisionUtil;

class CollisionTest {

    @Test
    public void collisionBetweenCicles() {
        final CircleHitBox player = new CircleHitBox(10, 10, 2);
        final CircleHitBox bullet = new CircleHitBox(12, 10, 0.2);
        assertFalse(CollisionUtil.entityCollision(player, bullet).isEmpty());
    }

    @Test
    public void checkBlockedCommand() {
        final CircleHitBox player = new CircleHitBox(1, 1, 2);
        final CircleHitBox bullet = new CircleHitBox(1, 3, 0.2);
        assertTrue(CollisionUtil.entityCollision(bullet, player).size() == 1);
        assertTrue(CollisionUtil.entityCollision(bullet, player).contains(Command.DOWN));
        final CircleHitBox player1 = new CircleHitBox(1, 1, 2);
        final CircleHitBox bullet1 = new CircleHitBox(3, 1.5, 0.2);
        assertTrue(CollisionUtil.entityCollision(bullet1, player1).size() == 2);
        assertTrue(CollisionUtil.entityCollision(bullet1, player1).contains(Command.DOWN)
                && CollisionUtil.entityCollision(bullet1, player1).contains(Command.RIGHT));
        final CircleHitBox player2 = new CircleHitBox(3, 3, 2);
        final CircleHitBox bullet2 = new CircleHitBox(2, 2, 0.2);
        assertTrue(CollisionUtil.entityCollision(bullet2, player2).size() == 2);
        assertTrue(CollisionUtil.entityCollision(bullet2, player2).contains(Command.UP)
                && CollisionUtil.entityCollision(bullet2, player2).contains(Command.LEFT));
    }

    @Test
    public void collisionBetweenBulletAndPlayer() {
        final CircleHitBox player = new CircleHitBox(0, 0, 2);
        final CircleHitBox sender = new CircleHitBox(3, 3, 0.2);
        final double angle = Math.toDegrees(Math.atan2(player.getY() - sender.getY(), player.getX() - sender.getX()));
        final Animated bullet = new BulletImpl(sender, 1, new BulletMovement(angle), 10,
                ImageType.ENEMY_BULLET);
        boolean collisionDetected = false;
        for (int i = 0; i < 10; i++) {
            if (!CollisionUtil.entityCollision(player, (CircleHitBox) bullet.getHitBox()).isEmpty()) {
                collisionDetected = true;
                break;
            }
            bullet.update(1);
            System.out.println("x: " + bullet.getHitBox().getX() + "y: " + bullet.getHitBox().getY());
        }
        assertTrue(collisionDetected);
    }
}
