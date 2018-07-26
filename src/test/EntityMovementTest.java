package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import input.Command;
import model.ai.BasicAI;
import model.animated.AbstractCharacter;
import model.animated.Animated;
import model.animated.EnemyImpl;
import model.animated.PlayerImpl;
import model.hitbox.CircleHitBox;
import model.strategy.PlayerMovement;
import model.strategy.PlayerProjectile;
import model.strategy.SimplyDirectionMovement;
import proxyutility.ImageType;
import utility.ModelUtility;

class EntityMovementTest {

    @Test
    public void playerMovementTest() {

        final Animated player = new PlayerImpl(1, 6, new CircleHitBox(0, 0, 2),
                new BasicAI(new PlayerMovement(), new PlayerProjectile(0.2)), 2, ImageType.PLAYER, 0.3);

        // RIGHT MOVEMENT.
        final double oldX = player.getHitBox().getX();
        final double oldY = player.getHitBox().getY();
        ModelUtility.updateListCommandModelUtility(Arrays.asList(Command.RIGHT), null);
        player.update(1);
        assertEquals(oldX + 1, player.getHitBox().getX());
        assertEquals(oldY, player.getHitBox().getY());

        // UP MOVEMENT.
        final double oldXUp = player.getHitBox().getX();
        final double oldYUp = player.getHitBox().getY();
        ModelUtility.updateListCommandModelUtility(Arrays.asList(Command.UP), null);
        player.update(1);
        assertEquals(oldXUp, player.getHitBox().getX());
        assertEquals(oldYUp - 1, player.getHitBox().getY());

        // LEFT MOVEMENT.
        final double oldXLeft = player.getHitBox().getX();
        final double oldYLeft = player.getHitBox().getY();
        ModelUtility.updateListCommandModelUtility(Arrays.asList(Command.LEFT), null);
        player.update(1);
        assertEquals(oldXLeft - 1, player.getHitBox().getX());
        assertEquals(oldYLeft, player.getHitBox().getY());
 
        // DOWN MOVEMENT.
        final double oldXDown = player.getHitBox().getX();
        final double oldYDown = player.getHitBox().getY();
        ModelUtility.updateListCommandModelUtility(Arrays.asList(Command.DOWN), null);
        player.update(1);
        assertEquals(oldXDown, player.getHitBox().getX());
        assertEquals(oldYDown + 1, player.getHitBox().getY());
    }

    @Test
    public void enemySimpleMovementTest() {
        //UP MOVEMENT.
        final AbstractCharacter enemy = new EnemyImpl(1, 3, new CircleHitBox(0, 0, 2),
                new BasicAI(new SimplyDirectionMovement(Command.UP), null), 3, 3, null, 3, null);
        enemy.update(1);
        assertEquals(0, enemy.getHitBox().getX());
        assertEquals(-1, enemy.getHitBox().getY());

        //REVERSE (DOWN) MOVEMENT.
        enemy.getAI().setMovementStrategy(new SimplyDirectionMovement(Command.UP.getOppositeCommand()));
        enemy.update(1);
        assertEquals(0, enemy.getHitBox().getX());
        assertEquals(0, enemy.getHitBox().getY());

        //RIGHT MOVEMENT.
        enemy.getAI().setMovementStrategy(new SimplyDirectionMovement(Command.RIGHT));
        enemy.update(1);
        assertEquals(1, enemy.getHitBox().getX());
        assertEquals(0, enemy.getHitBox().getY());

        //REVERSE (LEFT) MOVEMENT.
        enemy.getAI().setMovementStrategy(new SimplyDirectionMovement(Command.RIGHT.getOppositeCommand()));
        enemy.update(1);
        assertEquals(0, enemy.getHitBox().getX());
        assertEquals(0, enemy.getHitBox().getY());
    }
}
