package controller.event;

import input.ScenePanel;
/**
 *
 */
public class KeyEventImpl implements KeyEvent {
    private String key;
    private ScenePanel gameState;
    private KeyType type;
    /**
     * 
     * @param key s.
     * @param gameState s.
     * @param keyType s.
     */
    public KeyEventImpl(final String key, final ScenePanel gameState, final KeyType keyType) { //La key potrebbe avere un enum o una classe.
        this.key = key;
        this.gameState = gameState;
        this.type = keyType;
    }
    /**
     * 
     */
    @Override
    public String getEvent() {
        return this.key;
    }
    /**
     * 
     */
    @Override
    public ScenePanel getGameState() {
        return this.gameState;
    }
    /**
     * 
     */
    @Override
    public KeyType getType() {
        return this.type;
    }

}
