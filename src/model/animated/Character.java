package model.animated;

import model.ai.AI;

/**
 * Interface that represent character of the game.
 *
 */
public interface Character extends Shooter {

    /**
     * Method to expose the AI only to subclass.
     * 
     * @return AI.
     */
    AI getAI();
}
