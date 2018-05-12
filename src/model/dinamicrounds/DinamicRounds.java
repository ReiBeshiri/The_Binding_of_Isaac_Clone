package model.dinamicrounds;

import java.util.List;

import model.animated.Animated;

/**
 * Dinamic Rounds Interface. 
 */
public interface DinamicRounds {
    /**
     * generate a random Monster.
     * @return the list of the enemy to spawn.
     */
    List<Animated> generateMonster();
    /**
     * 
     * @return the number of monsters to genrate besed on the round.
     */
    int numberOfEnemyToGenerate();
}
