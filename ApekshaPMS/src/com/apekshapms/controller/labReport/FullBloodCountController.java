package com.apekshapms.controller.labReport;


import com.apekshapms.controller.Controller;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.FullBloodReport;
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

public class FullBloodCountController implements Controller{
    @FXML
    private TextField TypeTextField;

    @FXML
    private  TextField TestIDTextField;

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
    private TextField WBCTextField;

    @FXML
    private TextField NETextField;

    @FXML
    private TextField HimoglobinTextField;

    @FXML
    private TextField PlateletsTextField;

    @FXML
    private Button SubmitButton;

    @FXML
    private Button CancelButton;

    private FullBloodReport fullBloodReport = new FullBloodReport();

    public void initialize(URL location, ResourceBundle resources) {
        SubmitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (isInputValid()) {
                    try {
                        fullBloodReport.setTestID(TestIDTextField.getText());
                        fullBloodReport.setPatientID(PatientIDTextField.getText());
                        fullBloodReport.setPatientName(PatientNameTextField.getText());
                        fullBloodReport.setDate(dateDatePicker.getValue());
                        fullBloodReport.setTestType(TypeTextField.getText());
                        fullBloodReport.setReference(ReferenceTextField.getText());
                        fullBloodReport.setRemarks(RemarksTextField.getText());
                        fullBloodReport.setWBC(WBCTextField.getText());
                        fullBloodReport.setNE(NETextField.getText());
                        fullBloodReport.setHimoglobin(HimoglobinTextField.getText());
                        fullBloodReport.setPlateletes(PlateletsTextField.getText());



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
                        LabReportServices.addFullBloodReport(fullBloodReport);
                    }else {
                        UIFactory.launchUI(UIName.FULLBLOODCOUNT_REPORT, true);
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