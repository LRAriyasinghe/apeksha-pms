package com.apekshapms.controller.labReport;


import com.apekshapms.controller.Controller;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.CreactiveproteinReport;
import com.apekshapms.model.LabReport;
import com.apekshapms.services.LabReportServices;
import com.apekshapms.ui.UIName;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class CreactiveproteinController implements Controller{
    @FXML
    private TextField TypeTextField;

    @FXML
    private TextField TestIDTextField;

    @FXML
    private DatePicker Datedatepicker;

    @FXML
    private TextField PatientIDTextField;

    @FXML
    private Label ReportTypeLabel;

    @FXML
    private TextField PatientNameTextField;

    @FXML
    private TextField ReferenceTextField;

    @FXML
    private TextArea RemarksTextField;

    @FXML
    private TextField CreactiveproteinTextField;

    @FXML
    private Button SubmitButton;

    @FXML
    private Button CancelButton;

    private CreactiveproteinReport creactiveproteinReport;

    public void initialize(URL location, ResourceBundle resources) {
        SubmitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (isInputValid()) {
                    try {
                        creactiveproteinReport.setTestID(TestIDTextField.getText());
                        creactiveproteinReport.setPatientID(PatientIDTextField.getText());
                        creactiveproteinReport.setPatientName(PatientNameTextField.getText());
                        creactiveproteinReport.setDate(Datedatepicker.getValue());
                        creactiveproteinReport.setTestType(TypeTextField.getText());
                        creactiveproteinReport.setReference(ReferenceTextField.getText());
                        creactiveproteinReport.setRemarks(RemarksTextField.getText());
                        creactiveproteinReport.setCreactiveprotein(CreactiveproteinTextField.getText());
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
                        LabReportServices.addCreactiveProteinReport(creactiveproteinReport);
                    }else {
                        UIFactory.launchUI(UIName.BONEMARROW_REPORT, true);
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
        if (TestIDTextField.getText() == null || TestIDTextField.getText().length() == 0) {
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