package com.apekshapms.controller;

import com.apekshapms.model.Patient;
import com.apekshapms.services.PatientServices;
import com.apekshapms.validation.AlertDialog;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AssigningController implements Controller {

    @FXML
    private Button submitButton;

    @FXML
    private TextField txtRegisterDocId;

    @FXML
    private TextField txtConsultantId;

    @FXML
    private TextArea EEE;

    private Patient patient;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                patient.setRegisterDocId(txtRegisterDocId.getText());
                patient.setConsultantId(txtConsultantId.getText());
                patient.setDetails(EEE.getText());

                PatientServices.addPatient(patient);

                new AlertDialog(new Stage() , "Save Sucessful!", AlertDialog.ICON_INFO).showAndWait();

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
