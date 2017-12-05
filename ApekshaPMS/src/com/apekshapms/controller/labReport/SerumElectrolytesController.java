package com.apekshapms.controller.labReport;


import com.apekshapms.controller.Controller;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.LabReport;
import com.apekshapms.model.SerumElectrolytesReport;
import com.apekshapms.services.LabReportServices;
import com.apekshapms.ui.UIName;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class SerumElectrolytesController implements Controller{
    @FXML
    private TextField typeTextField;

    @FXML
    private TextField testIDTextField;

    @FXML
    private DatePicker dateDatePicker;

    @FXML
    private TextField PatientIDTextField;

    @FXML
    private TextField PatientNameTextField;

    @FXML
    private TextField ReferenceTextField;

    @FXML
    private TextArea RemarksTextField;

    @FXML
    private TextField SodiumTextField;

    @FXML
    private TextField PotassiumTextField;



    @FXML
    private Button SubmitButton;

    @FXML
    private Button CancelButton;

    private SerumElectrolytesReport serumElectrolytesReport = new SerumElectrolytesReport();

    public void initialize(URL location, ResourceBundle resources) {
        SubmitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (isInputValid()) {
                    try {
                        serumElectrolytesReport.setTestID(testIDTextField.getText());
                        serumElectrolytesReport.setPatientID(PatientIDTextField.getText());
                        serumElectrolytesReport.setPatientName(PatientNameTextField.getText());
                        serumElectrolytesReport.setDate(dateDatePicker.getValue());
                        serumElectrolytesReport.setTestType(typeTextField.getText());
                        serumElectrolytesReport.setReference(ReferenceTextField.getText());
                        serumElectrolytesReport.setRemarks(RemarksTextField.getText());
                        serumElectrolytesReport.setSodium(SodiumTextField.getText());
                        serumElectrolytesReport.setPotassium(PotassiumTextField.getText());

                    }catch (Exception e){
                        System.err.println(e);
                    }
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);//Patient Register Confirmation Dialog box
                    alert.setTitle("Confirmation Dialog");
                    alert.setHeaderText("Look, a Confirmation Dialog");
                    alert.setContentText("Are you ok with this?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {

                        System.out.println("Yes");
                        LabReportServices.addSerumElectrolytesReport(serumElectrolytesReport);
                    }else {
                        UIFactory.launchUI(UIName.SERUMCALCIUM_REPORT, true);
                        // ... user chose CANCEL or closed the dialog
                    }

                }

            }
        });
    }

    @Override
    public void refreshView() {

    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (PatientIDTextField.getText() == null || PatientIDTextField.getText().length() == 0) {
            errorMessage += "Not a valid Patient ID!\n";
        }
        if (PatientNameTextField.getText() == null || PatientNameTextField.getText().length() == 0) {
            errorMessage += "No valid Patient name ID!\n";
        }
        if (testIDTextField.getText() == null || testIDTextField.getText().length() == 0) {
            errorMessage += "No valid TestId ID!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Look, a Warning Dialog");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            System.out.println("Successfully Fail");

            return false;
        }
    }

}//Class Finish






