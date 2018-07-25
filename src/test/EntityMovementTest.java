package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.Collections;
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
        // RIGHT MOVEMENT.
        final Animated player = new PlayerImpl(1, 6, new CircleHitBox(0, 0, 2),
                new BasicAI(new PlayerMovement(), new PlayerProjectile(0.2)), 2, ImageType.PLAYER, 0.3);
        final double oldX = player.getHitBox().getX();
        final double oldY = player.getHitBox().getY();
        ModelUtility.updateListCommandModelUtility(Arrays.asList(Command.RIGHT), null);
        player.update(1);
        assertEquals(oldX + 1, player.getHitBox().getX());
        assertEquals(oldY, player.getHitBox().getY());

        // UP MOVEMENT.
        final double oldXUp = player.getHitBox().getX();
        final double oldYUp = player.getHitBox().getY();
        ModelUtility.updateListCommandModelUtility(Collections.emptyList(), null);
        ModelUtility.updateListCommandModelUtility(Arrays.asList(Command.UP), null);
        player.update(1);
        assertEquals(oldXUp, player.getHitBox().getX());
        assertEquals(oldYUp - 1, player.getHitBox().getY());
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
    }
}
