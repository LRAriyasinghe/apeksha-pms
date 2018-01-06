package com.apekshapms.controller.consultant;

import com.apekshapms.controller.Controller;
import com.apekshapms.model.SystemMessage;
import com.apekshapms.services.MessageServices;
import com.apekshapms.validation.Patient_Registration.ValidatePatientID;
import com.apekshapms.validation.Patient_Registration.ValidateSearchConsultant;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class SendMessage implements Controller{

    @FXML
    private Button backButton;

    @FXML
    private TextField patientIdTextField;

    @FXML
    private TextField consultantIdTextField;

    @FXML
    private TextArea messageTextArea;

    @FXML
    private Button sendButton;

    @FXML
    private DatePicker sendDatePicker;

    private  SystemMessage systemMessage;

    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Actiont event for Send messages Button
        sendButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                String patient_id = patientIdTextField.getText();
                String emp_id = consultantIdTextField.getText();

                //Check validity in textField
                if (isInputValid()) {

                    //Check validity for Patient in the databse
                    if (ValidatePatientID.validate_patientId(patient_id)) {

                        if (ValidateSearchConsultant.validate_consultant(emp_id)) {
                            systemMessage = new SystemMessage();
                            systemMessage.setPatientId(patientIdTextField.getText());
                            systemMessage.setCounsultantId(consultantIdTextField.getText());
                            systemMessage.setMessage(messageTextArea.getText());
                            systemMessage.setSendDate(sendDatePicker.getValue());

                            MessageServices.addMessage(systemMessage);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Information Dialog");
                            alert.setHeaderText(null);
                            alert.setContentText("Send Message to Lab Assistant Doctor..!");
                            alert.showAndWait();


                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Error Dialog");
                            alert.setHeaderText("Look, an Error Dialog");
                            alert.setContentText("Ooops, there was an error Consultant ID is Invalide.!");
                            alert.showAndWait();

                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Dialog");
                        alert.setHeaderText("Look, an Error Dialog");
                        alert.setContentText("Ooops, there was an error Patient ID is Invalide.!!");
                        alert.showAndWait();

                    }

                }


            }
        });

    }

    //Check validity for inputs
    private boolean isInputValid() {
        String errorMessage = "";

        if (patientIdTextField.getText() == null || patientIdTextField.getText().length() == 0) {
            errorMessage += "Please Type Here Patient ID!\n";
        }
        if (sendDatePicker.getValue() == null || sendDatePicker.getValue().lengthOfYear() == 0) {
            errorMessage += "Please Select Date!\n";
        }
        if (messageTextArea.getText() == null || messageTextArea.getText().length() == 0) {
            errorMessage += "Please Type here Messages!\n";
        }
        if (consultantIdTextField.getText() == null || consultantIdTextField.getText().length() == 0) {
            errorMessage += "Please Type Here Consultant Doctor ID.!!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {


            // Show the error message
            //Dialogs.showErrorDialog(dialogStage, errorMessage,
            //"Please correct invalid fields", "Invalid Fields");
            System.out.println("Successfully Fail");

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Look, a Warning Dialog");
            alert.setContentText(errorMessage);

            alert.showAndWait();
            // Dialogs.showWarningDialog(new Stage(), "Careful with the next step!", "Warning Dialog", "title");

            return false;

        }
    }
}
