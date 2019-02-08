package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button closeButton;

    @FXML
    private Label testLabel;

    @FXML
    private Button fullscreenButton;

    @FXML
    void initialize() {

        //close button
        closeButton.setOnAction(event -> {
            System.out.println("closeButton pressed");
            closeButtonAction();
        });

        //fullscreen
        fullscreenButton.setOnAction(event -> {
            System.out.println("Fullscreen button pressed");
            fullscreenButtonAction();
        });
    }

    private void fullscreenButtonAction() {
        // get a handle to the stage
        Stage stage = (Stage) fullscreenButton.getScene().getWindow();
        // check fullscreen state and enter or exit it.
        if (stage.isFullScreen()) {
            stage.setFullScreen(false);
        } else {
            stage.setFullScreen(true);
        }
    }

    @FXML
    private void closeButtonAction(){
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
