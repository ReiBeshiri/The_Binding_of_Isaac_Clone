package model.dinamicrounds;

import utility.ModelUtility;

/**
 *
 */
public class DinamicRoundsImpl implements DinamicRounds {
    private static final int MAXENEMY = 7;
    /**
     * Generate a random Monster. 
     */
    @Override
    public void generateMonster() {
        // TODO Auto-generated method stub

    }
    /**
     * @return the number of monsters to generate.
     */
    @Override
    public int numerOfEnemyToGenerate() {
        return getCurrentRound() < DinamicRoundsImpl.MAXENEMY ? getCurrentRound() : DinamicRoundsImpl.MAXENEMY; 
    }
    /**
     * @return the current rounds, so the difficulty can be adapted.
     */
    private int getCurrentRound() {
        return ModelUtility.getCurrentRound();
    }
}
