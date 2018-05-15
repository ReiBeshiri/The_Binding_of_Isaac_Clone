package model.rounds;

import java.util.List;

import model.animated.Animated;

/**
 * Class to create static rounds.
 * There will be K rounds generated statically, that means there will always be the same monsters.
 **/
public interface StaticRounds {
    /**
     * generate a random Monster.
     * @return the list of the enemy to spawn.
     */
    List<Animated> generateMonster();
    /**
     * 
     * @return the number of monsters to generate based on the round.
     */
    int numberOfEnemyToGenerate();
}
