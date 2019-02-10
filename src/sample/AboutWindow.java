package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AboutWindow {

    public void displayAboutWindow(String title, String aboutText) throws IOException {

        Stage aboutStage = new Stage();

        aboutStage.initModality(Modality.APPLICATION_MODAL);
        aboutStage.setTitle("About");

        Parent root = FXMLLoader.load(getClass().getResource("fxml/about.fxml"));

        Scene aboutScene = new Scene(root);
        aboutStage.setScene(aboutScene);
        aboutStage.show();


    }

}
