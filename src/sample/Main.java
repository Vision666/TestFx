package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init(){
        System.out.println("В методе init");
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml/sample.fxml"));

        //primary stage configuration
        primaryStage.setTitle("TestFX");
        primaryStage.setOpacity(1.0);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        //primaryStage.setResizable(false);

        Text textDem = new Text("Text demonstration");
        textDem.setLayoutX(200);
        textDem.setLayoutY(100);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        System.out.println("В теле метода start");

    }


    @Override
    public void stop(){
        System.out.println("В теле метода stop");
    }
}
