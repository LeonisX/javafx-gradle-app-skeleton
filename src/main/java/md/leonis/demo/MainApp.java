package md.leonis.demo;

import javafx.application.Application;
import javafx.stage.Stage;
import md.leonis.demo.utils.Config;
import md.leonis.demo.utils.JavaFxUtils;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Config.loadProperties();
        JavaFxUtils.showMainPane(primaryStage);
    }
}
