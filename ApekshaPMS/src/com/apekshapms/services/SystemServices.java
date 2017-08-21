package com.apekshapms.services;

import com.apekshapms.database.connector.PatientConnector;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.main.Session;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class SystemServices {
    public static void start() {
        SystemServices.initializeSession();
        UIFactory.initializeAllUIs();
    }

    public static void exit() {
        Platform.exit();
        System.exit(0);
    }

    private static void initializeSession() {
        Session.patientConnector = new PatientConnector();
    }

    public static void loadDashboard(Stage primaryStage) {
        UI ui = UIFactory.getNewUI(UIName.DASHBOARD);
        ui.getController().refreshView();
        Scene scene = new Scene(ui.getParent(), 1300, 700);
        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                SystemServices.exit();
            }
        });

        primaryStage.setScene(scene);

        Platform.runLater(() -> primaryStage.show());
    }
}
