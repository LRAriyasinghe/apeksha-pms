package com.apekshapms.main;

import com.apekshapms.services.SystemServices;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/apekshapms/ui/view/login.fxml"));

        Scene scene = new Scene(root, 498, 400);

        stage.setTitle("Apeksha Hospital Maharagama");
        stage.setScene(scene);
        stage.show();
    }

    /*@Override
    public void start(Stage primaryStage) throws Exception{
        SystemServices.start();

        SystemServices.loadDashboard(primaryStage);
        primaryStage.setTitle("Apeksha Hospitals-Maharagama");

    }*/

    public static void main(String[] args) {
        launch(args);
    }

}
