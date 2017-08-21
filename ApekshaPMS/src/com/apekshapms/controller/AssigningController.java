package com.apekshapms.controller;

import com.apekshapms.model.Patient;
import com.apekshapms.services.PatientServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AssigningController implements Controller {

    @FXML
    private Button submitButton;

    @FXML
    private TextField txtRegisterDocId;

    @FXML
    private TextField txtConsultantId;

    private TextField txtDetails;

    private Patient patient;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                patient.setRegisterDocId(txtRegisterDocId.getText());
                patient.setConsultantId(txtConsultantId.getText());
                patient.setDetails(txtDetails.getText());

                PatientServices.addPatient(patient);
            }
        });
    }

    @Override
    public void refreshView() {

    }

    public void showPatient(Patient patient) {
        this.patient = patient;
    }
}
