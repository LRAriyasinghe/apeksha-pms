package com.apekshapms.main;

import com.apekshapms.services.SystemServices;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        SystemServices.start();

        SystemServices.loadDashboard(primaryStage);
        primaryStage.setTitle("Apeksha Hospitals-Maharagama");

    }

    public static void main(String[] args) {
        launch(args);
    }

}
