package view;

import input.ScenePanel;

/**
 * 
 */
public interface View {
    /**
     * 
     * @param s Scene to change.
     */
    void changeScene(ScenePanel s);
    /**
     * 
     */
    void render();
}
