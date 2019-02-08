package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        //primary stage configuration
        primaryStage.setTitle("TestFX");
        primaryStage.setOpacity(1.0);
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        //primaryStage.setResizable(false);

        Text textDem = new Text("Text demonstration");
        textDem.setLayoutX(0);
        textDem.setLayoutY(100);
        Group group = new Group(textDem);

        primaryStage.setScene(new Scene(root, 800, 600));


        primaryStage.show();
        System.out.println("В теле метода start");

    }


    @Override
    public void stop(){
        System.out.println("В теле метода stop");
    }
}
