package com.apekshapms.controller.sidebar;

import com.apekshapms.controller.Controller;
import com.apekshapms.controller.admin.AdminMessageController;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.AdminMessage;
import com.apekshapms.ui.UIName;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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

    @FXML
    private Button messageButton;

    @FXML
    private Label messageNotifiLable;

    @FXML
    private Button viewDiagnosisCardButton;

    @Override
    public void refreshView() {

    }


    //All action event for Every Button
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        patientButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) { UIFactory.launchUI(UIName.PATIENT_DASHBOARD, true); }
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

        messageButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) { UIFactory.launchUI(UIName.ADMIN_MESSAGE, true); }
        });

        viewDiagnosisCardButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                UIFactory.launchUI(UIName.SEARCH_PATIENT_DIAGNOSIS, true);
            }
        });


        getMessageNotifiLable().setText(String.valueOf(AdminMessageController.sideBarcountNewMessage())); //get to Message notification
    }

    public Label getMessageNotifiLable() {
        return messageNotifiLable;
    }

    public void setMessageNotifiLable(Label messageNotifiLable) {
        this.messageNotifiLable = messageNotifiLable;
    }
}
