package view.controller;

import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.util.Duration;
/**
 * Abstract class with the common behavior to all controller classes.
 */
public abstract class AbstractControllerFXML implements ControllerFXML{

    private FadeTransition fade;
    private static final int TRANSITION_TIME = 500;
    @Override
    public abstract Region getRoot();
    
    /**
     * see https://stackoverflow.com/questions/24978278/fade-in-fade-out-a-screen-in-javafx
     * Method used to apply a fade-in or fade-in transition to a window.
     * @param node
     *          The node on which we want to apply the transition.
     * @param from
     *          The start opacity value.
     * @param to
     *          The stop opacity value.
     */
    private void fadeAnimation(final Node node, final double from, final double to) {
        fade = new FadeTransition(Duration.millis(TRANSITION_TIME), node);
        fade.setFromValue(from);
        fade.setToValue(to);
        fade.play();
    }
    /**
     * Method used to apply a generic fade transition to a window
     * and to set the window that needs to appear.
     * @param node
     *          The node on which we want to apply the transition.
     * @param from
     *          The start opacity value.
     * @param to
     *          The stop opacity value.
     * @param toRun
     *          The window that needs to be opened at the end of the transition.
     */
    private void fadeAnimation(final Node node, final double from, final double to, Runnable toRun) {
        this.fadeAnimation(node, from, to);
        fade.setOnFinished(e -> toRun.run());
    }
    
    @Override
    public void closingFade(Runnable toRun) {
        this.getRoot().setDisable(true);
        this.fadeAnimation(this.getRoot(), 1.0, 0.0, toRun);
    }
    
    @Override
    public void openingFade() {
        this.getRoot().setDisable(false);
        this.fadeAnimation(this.getRoot(), 0.0, 1.0);
    }
    
}
