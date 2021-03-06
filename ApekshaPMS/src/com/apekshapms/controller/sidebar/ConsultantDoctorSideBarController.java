package com.apekshapms.controller.sidebar;

import com.apekshapms.controller.Controller;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.ui.UIName;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ConsultantDoctorSideBarController implements Controller {

    @FXML
    private Button newPatientButton;

    @FXML
    private Button searchPatientButton;

    @FXML
    private Button messageButton;

    @FXML
    private Button diagnosisCardButton;

    @FXML
    void handleNewPatientButtonAction(ActionEvent event) {

    }

    @FXML
    void handleViewPatientAction(ActionEvent event) {

    }

    @Override
    public void refreshView() {

    }

    //All action event for Every Button
    @Override
    public void initialize(URL location, ResourceBundle resources) {


        messageButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIFactory.launchUI(UIName.SEND_MESSAGES, true);
            }
        });

        searchPatientButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIFactory.launchUI(UIName.SEARCH_PATIENT, true);
            }
        });

        diagnosisCardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIFactory.launchUI(UIName.SEARCH_PATIENT_DIAGNOSIS, true);
            }
        });

    }
}
