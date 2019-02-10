package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import sample.AboutWindow;
import sample.logic.RandomNumberInRange;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button closeButton;
    @FXML
    private Button fullscreenButton;

    @FXML
    private Button randomNumGenButton;
    @FXML
    private Text randomNumberText;


    @FXML
    private Label choiceBoxLabel;

    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu menuBarFile;
    @FXML
    private MenuItem menuBarFileClose;
    @FXML
    private Menu menuBarEdit;
    @FXML
    private MenuItem menuBarEditDelete;
    @FXML
    private Menu menuBarHelp;
    @FXML
    private MenuItem menuBarHelpAbout;

    @FXML
    private ChoiceBox<String> choiceBox;
    private ObservableList<String> choiceBoxLis = FXCollections.observableArrayList("Male", "Female", "Not sure");

    @FXML
    void initialize() {

        //close button
        //System.out.println(closeButton.isCancelButton());
        closeButton.setOnAction(event -> {
            System.out.println("closeButton pressed");
            closeButtonAction();
        });
        //close button from menu bar
        menuBarFileClose.setOnAction(event -> closeButtonAction());

        //fullscreen
        fullscreenButton.setOnAction(event -> {
            System.out.println("Fullscreen button pressed");
            fullscreenButtonAction();
        });

        //choice box
        choiceBox.setValue(choiceBoxLis.get(0));
        choiceBox.setItems(choiceBoxLis);

        //status of choice box
        choiceBoxLabel.setText("You are " + choiceBox.getValue().toLowerCase());
        choiceBox.setOnAction(event -> choiceBoxLabel.setText("You are " + choiceBox.getValue().toLowerCase()));

        //generate random number button
        randomNumGenButton.setOnAction(event -> randomNumberText
                .setText(String.valueOf(RandomNumberInRange.randomize(0, 50))));

        //about window
        AboutWindow aw = new AboutWindow();

        menuBarHelpAbout.setOnAction(event -> {
            try {
                aw.displayAboutWindow("About", "about text");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        //make scene draggable
        makeDraggable(true);

    }

    @FXML
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

    private Stage stage;
    private double x, y;

    @FXML
    private void makeDraggable(boolean state){
        if (state){
            anchorPane.setOnMousePressed(mouseEvent -> {
                x = mouseEvent.getSceneX();
                y = mouseEvent.getSceneY();
            });

            anchorPane.setOnMouseDragged(mouseEvent -> {
                stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
                stage.setX(mouseEvent.getScreenX() - x);
                stage.setY(mouseEvent.getScreenY() - y);
            });
        } else {

        }


    }
}
