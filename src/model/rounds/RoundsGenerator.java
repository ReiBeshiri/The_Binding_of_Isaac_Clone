package model.rounds;

import java.util.List;
import model.animated.Enemy;


/**
 * There will be K rounds generated statically, that means there will always be the same monsters.
 * 
 **/
public interface RoundsGenerator {

    /**
     * generate a random Monster.
     * @return the list of the enemy to spawn.
     */
    List<Enemy> generateMonster();
}
