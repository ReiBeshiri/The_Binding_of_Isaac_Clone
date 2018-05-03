package view;

import java.util.List;
import javafx.application.Application;
import javafx.event.Event;
import model.GameObject;
import view.util.OptionsViewUtil;
/**
 * Class that represent view. 
 *
 */
public class ViewImpl implements View {

    /**
     * 
     */
    @Override
    public void render(final List<GameObject> list) {
        // TODO Auto-generated method stub

    }
    /**
     * 
     */
    @Override
    public void roomChanged() {
        // TODO Auto-generated method stub

    }
    /**
     * 
     */
    @Override
    public void playerLifeChanged() {
        // TODO Auto-generated method stub

    }

    /**
     * 
     */
    @Override
    public void viewStart() {
        ViewManagerImpl.get().setHeight(OptionsViewUtil.getStandardRes().getHeight());
        ViewManagerImpl.get().setWidth(OptionsViewUtil.getStandardRes().getWidth());
        Application.launch(ViewManagerImpl.class, "");
    }
    /**
     * 
     */
    @Override
    public void notifyEvent(final Event e) {

    }
    /**
     * 
     */
    @Override
    public void changeBossDoorStatus(final boolean open) {

    }
    /**
     * 
     */
    @Override
    public void changeShoopDoorStatus(final boolean open) {

    }

}
