package view;

import javafx.application.Application;
import javafx.stage.Stage;
import view.util.SceneFactory;

/**
 * Class ised to lounch application.
 *
 */
public class LaunchClass extends Application {

    /**
     * Entry method of javaFX.
     */
    @Override
    public void start(final Stage primaryStage) throws Exception {
        ViewManagerImpl.get().setMainStage(primaryStage);
        primaryStage.setHeight(ViewManagerImpl.get().getStartedHeight());
        primaryStage.setWidth(ViewManagerImpl.get().getStartedWidth());
        ViewManagerImpl.get().push(SceneFactory.createMenuScene());
        primaryStage.widthProperty().addListener(o -> ViewManagerImpl.get().updateViewState());
        primaryStage.heightProperty().addListener(o -> ViewManagerImpl.get().updateViewState());
        primaryStage.setTitle("KTS");
        primaryStage.show();
    }

}
