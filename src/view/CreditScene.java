package view;

import javafx.event.Event;
import static proxyutility.SceneType.CREDITS;
/**
 * Class that represent Credit scene.
 *
 */
public class CreditScene extends AbstractGenericScene {
    /**
     * 
     * @param s
     */
    public CreditScene() {
        super(CREDITS);
    }
    /**
     * 
     */
    @Override
    public void exitStatus() {
        //Use State factory.
        ViewManagerImpl.get().push(null);
    }
    /**
     * 
     */
    @Override
    public void checkSceneHandler(final Event e) { }

}
