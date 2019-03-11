package com.shashanksirmour.me;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("WHATODO - Make Your Day ");

        //to change fx theme
        setUserAgentStylesheet(STYLESHEET_CASPIAN);

        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(800);
        primaryStage.show();
//        Image abc= new javafx.scene.image.Image(ikj.png);
//        primaryStage.getIcons().;


    }


    //stop initialize when application stops

    @Override
    public void stop() throws Exception {
        try {
            tododata.getInstence().storetodoitems();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void init() throws Exception {
        try {
            tododata.getInstence().loadtodoitems();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
