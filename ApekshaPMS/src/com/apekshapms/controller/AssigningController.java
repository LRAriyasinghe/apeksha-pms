package com.apekshapms.controller;

import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.Patient;
import com.apekshapms.services.PatientServices;
import com.apekshapms.ui.UIName;
import com.apekshapms.validation.Patient_Registration.ValidateSearchConsultant;
import com.apekshapms.validation.Patient_Registration.ValidateSearchRegisterDoctor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Optional;
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
                if (isInputValid()){
                    String emp_idReg = txtRegisterDocId.getText();
                    String emp_idCons = txtConsultantId.getText();
                    if (ValidateSearchRegisterDoctor.validate_registerDoc(emp_idReg)){ //Check Registor Doctor ID
                        if (ValidateSearchConsultant.validate_consultant(emp_idCons)){ //Check Consultant Doctor ID



                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);//Patient Register Confirmation Dialog box
                            alert.setTitle("Confirmation Dialog");
                            alert.setHeaderText("Look, a Confirmation Dialog");
                            alert.setContentText("Are you ok with this?");

                            Optional<ButtonType> result = alert.showAndWait();
                            if (result.get() == ButtonType.OK){
                                patient.setRegisterDocId(txtRegisterDocId.getText());
                                patient.setConsultantId(txtConsultantId.getText());
                                patient.setDetails(EEE.getText());

                                PatientServices.addPatient(patient);
                            } else {
                                UIFactory.launchUI(UIName.NEW_PATIENT, true);
                                // ... user chose CANCEL or closed the dialog
                            }

                            //new AlertDialog(new Stage() , "Save Sucessful!", AlertDialog.ICON_INFO).showAndWait();

                        }else{
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Warning Dialog");
                            alert.setHeaderText("Look, a Warning Dialog");
                            alert.setContentText("Invalid Consultant ID.!");

                            alert.showAndWait();
                        }
                    }else{
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning Dialog");
                        alert.setHeaderText("Look, a Warning Dialog");
                        alert.setContentText("Invalid Regostor Doctor ID.!");

                        alert.showAndWait();
                    }
                }



            }
        });
    }

    @Override
    public void refreshView() {

    }

    public void showPatient(Patient patient) {
        this.patient = patient;
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (txtRegisterDocId.getText() == null || txtRegisterDocId.getText().length() == 0) {
            errorMessage += "No valid Register Doctor ID!\n";
        }
        if (txtConsultantId.getText() == null || txtConsultantId.getText().length() == 0) {
            errorMessage += "No valid Consultant Doctor ID!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {

            //Alert For Invalid TextFields
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Look, a Warning Dialog");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            // Show the error message
            //Dialogs.showErrorDialog(dialogStage, errorMessage,
            //"Please correct invalid fields", "Invalid Fields");
            System.out.println("Successfully Fail");
            //Dialogs.showWarningDialog(new Stage(), "Careful with the next step!", "Warning Dialog", "title");

            return false;

        }
    }
}
