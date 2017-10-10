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

    private static void initializeSession() {Session.patientConnector = new PatientConnector();}

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


    public static void loadRegisterDoctorDashboard(Stage primaryStage) {
        UI ui = UIFactory.getNewUI(UIName.REGISTER_DOCTOR_DASHBOARD);
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

    public static void loadLabAssistantDashboard(Stage primaryStage) {
        UI ui = UIFactory.getNewUI(UIName.LAB_ASSISTANT_DASHBOARD);
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

    public static void loadConsultantDashboard(Stage primaryStage) {
        UI ui = UIFactory.getNewUI(UIName.CONSULTANT_DASHBOARD);
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

    public static void loadAdminDashboard(Stage primaryStage) {
        UI ui = UIFactory.getNewUI(UIName.ADMIN_DASHBOARD);
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

    public static void loadLogin(Stage primaryStage) {
        UI ui = UIFactory.getNewUI(UIName.LOGIN);
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
