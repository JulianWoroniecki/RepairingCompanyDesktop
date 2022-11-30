package com.example.repairingcompanyadmin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class HelloApplication extends Application {

    static ResourceBundle bundle = ResourceBundle.getBundle("Language");
    @Override
    public void start(Stage stage) throws IOException {
        StageSetter.buildStage(stage,"MainMenu.fxml","Main Menu",bundle);
    }

    public static void main(String[] args) {
        launch();
    }
}