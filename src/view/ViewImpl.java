package view;

import java.util.List;
import javafx.application.Application;
import javafx.event.Event;
import model.GameObject;
/**
 * Class that represent view. 
 *
 */
public class ViewImpl implements View {
    private int heigth;
    private int width;

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
    public void setHeight(final int h) {
        heigth = h;
    }
    /**
     * 
     */
    @Override
    public void setWidth(final int w) {
        width = w;
    }
    /**
     * 
     */
    @Override
    public void viewStart() {
        Application.launch(ViewManagerImpl.class, "");
    }
    /**
     * 
     */
    @Override
    public void notifyEvent(final Event e) {
        // TODO Auto-generated method stub

    }
    @Override
    public void changeBossDoorStatus(final boolean open) {
        
    }
    @Override
    public void changeShoopDoorStatus(final boolean open) {
        
    }

}
