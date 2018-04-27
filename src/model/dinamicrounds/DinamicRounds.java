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
     * 
     * @return the number of monsters to genrate besed on the round.
     */
    int numerOfEnemyToGenerate();
}
