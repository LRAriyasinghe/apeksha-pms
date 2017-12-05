package com.apekshapms.controller.labReport;


import com.apekshapms.controller.Controller;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.BonemarrowReport;
import com.apekshapms.model.LabReport;
import com.apekshapms.services.LabReportServices;
import com.apekshapms.services.PatientServices;
import com.apekshapms.ui.UIName;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class BoneMarrowReportController implements Controller {

    @FXML
    private DatePicker date;

    @FXML
    private  TextField TypeTextField;

    @FXML
    private TextField PatientIDTextField;

    @FXML
    private TextField TestIDTextField;

    @FXML
    private TextField PatientNameTextField;

    @FXML
    private TextField ReferenceTextField;

    @FXML
    private TextArea RemarksTextField;

    @FXML
    private TextField BMBxTextField;

    @FXML
    private TextField TrephineBMBxTextField;

    @FXML
    private Button SubmitButton;

    @FXML
    private Button CancelButton;

    private BonemarrowReport bonemarrowreport = new BonemarrowReport();

    public void initialize(URL location, ResourceBundle resources) {
        SubmitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (isInputValid()) {
                    try {
                        System.out.printf("1");
                        bonemarrowreport.setPatientID(PatientIDTextField.getText());
                        System.out.printf("2");
                        bonemarrowreport.setTestType(TypeTextField.getText());
                        System.out.printf("3");
                        bonemarrowreport.setTestID(TestIDTextField.getText());
                        bonemarrowreport.setPatientName(PatientNameTextField.getText());
                        System.out.println("4");
                        bonemarrowreport.setDate(date.getValue());
                        System.out.println("5");
                        bonemarrowreport.setReference(ReferenceTextField.getText());
                        System.out.println("6");
                        bonemarrowreport.setRemarks(RemarksTextField.getText());
                        System.out.println("7");
                        bonemarrowreport.setBMBx(BMBxTextField.getText());
                        System.out.println("8");
                        bonemarrowreport.setTrephineBMBx(TrephineBMBxTextField.getText());
                        System.out.println("9");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);//Patient Register Confirmation Dialog box
                    alert.setTitle("Confirmation Dialog");
                    alert.setHeaderText("Look, a Confirmation Dialog");
                    alert.setContentText("Are you ok with this?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {

                        System.out.println("Yes");
                        LabReportServices.addBoneMarrowReport(bonemarrowreport);
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
