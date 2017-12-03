package com.apekshapms.controller.sidebar;

import com.apekshapms.controller.Controller;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.ui.UIName;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminSideBarController implements Controller{

    @FXML
    private Button patientButton;

    @FXML
    private Button employeeButton;

    @FXML
    private Button reportButton;

    @FXML
    private Button wardButton;

    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        patientButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                UIFactory.launchUI(UIName.PATIENT_DASHBOARD, true);

            }
        });

        employeeButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                UIFactory.launchUI(UIName.EMPLOYEE_DASHBOARD,true);
            }
        });

        reportButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                UIFactory.launchUI(UIName.REPORT_DASHBOARD,true);
            }
        });

        wardButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                UIFactory.launchUI(UIName.WARD_DASHBOARD,true);
            }
        });

    }

}
