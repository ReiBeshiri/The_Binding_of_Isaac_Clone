package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import input.Command;
import model.ai.BasicAI;
import model.animated.Animated;
import model.animated.PlayerImpl;
import model.hitbox.CircleHitBox;
import model.strategy.PlayerMovement;
import model.strategy.PlayerProjectile;
import proxyutility.ImageType;
import utility.ModelUtility;

class EntityMovementTest {

    @Test
    public void playerMovementTest() {
        final Animated player = new PlayerImpl(1, 6, new CircleHitBox(0, 0, 2), new BasicAI(new PlayerMovement(), new PlayerProjectile(0.2)), 2,
                ImageType.PLAYER, 0.3);
        final double oldX = player.getHitBox().getX();
        final double oldY = player.getHitBox().getY();
        ModelUtility.updateListCommandModelUtility(Arrays.asList(Command.RIGHT), null);
        player.update(1);
        assertEquals(oldX + 1, player.getHitBox().getX());
        assertEquals(oldY, player.getHitBox().getY());
    }

}
