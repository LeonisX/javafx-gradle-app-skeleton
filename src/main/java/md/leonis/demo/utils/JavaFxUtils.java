package md.leonis.demo.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import md.leonis.demo.MainApp;

import java.io.IOException;

public class JavaFxUtils {

    private static BorderPane rootLayout;

    public static void showMainPane(Stage primaryStage) {
        primaryStage.setTitle("JavaFX application skeleton");
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(JavaFxUtils.class.getResource(Config.resourcePath + "MainStage.fxml"));
            rootLayout = loader.load();
            //PaneController controller = loader.getController();
            Scene scene = new Scene(rootLayout, 1280, 960);
            primaryStage.setScene(scene);

            showVoidPanel();

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showVoidPanel() {
        showPane("void.fxml");
    }

    public static void showPane(String resource) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(Config.resourcePath + resource));
            Parent parent = loader.load();
            Object controller = loader.getController();
            if (controller instanceof SubPane) ((SubPane) controller).init();
            rootLayout.setCenter(parent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showWindow(String resource, String title) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(Config.resourcePath + resource));
            Parent root = loader.load();
            Object controller = loader.getController();
            if (controller instanceof SubPane) ((SubPane) controller).init();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root, 640, 480));
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showAlert(String title, String header, String text, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(text);
        alert.showAndWait();
    }
}
