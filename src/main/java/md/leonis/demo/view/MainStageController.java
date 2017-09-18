package md.leonis.demo.view;

import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import md.leonis.demo.utils.Config;
import md.leonis.demo.utils.JavaFxUtils;

public class MainStageController {

    @FXML
    private Accordion accordion;

    @FXML
    private void initialize() {
        accordion.setExpandedPane(accordion.getPanes().get(0));
    }

    @FXML
    private void showPane() {
        JavaFxUtils.showPane("frames/Pane.fxml");
    }

    @FXML
    private void showAlert() {
        JavaFxUtils.showAlert("Predefined alert window", "Example of information alert", "Additional text description", Alert.AlertType.INFORMATION);
    }

    @FXML
    private void showWindow() {
        JavaFxUtils.showWindow("frames/Window.fxml", Config.exampleTitle);
    }

    public void showEmptyPane() {
        JavaFxUtils.showVoidPanel();
    }
}
