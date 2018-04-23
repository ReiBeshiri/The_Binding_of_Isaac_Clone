package model.dinamicrounds;
/**
 * Dinamic Rounds Interface. 
 */
public interface DinamicRounds {
    /**
     * generate a random Monster.
     */
    void generateMonster();
    /**
     * Gives the current round.
     * @return the current round.
     */
    int getCurrentRound();
    /**
     * 
     * @return the number of monsters to genrate besed on the round.
     */
    int numerOfEnemyToGenerate();
}
