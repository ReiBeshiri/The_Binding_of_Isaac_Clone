package model.rounds;

import java.util.List;

import model.animated.Animated;

/**
 * Dynamic Rounds Interface. 
 */
public interface DinamicRounds {
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
