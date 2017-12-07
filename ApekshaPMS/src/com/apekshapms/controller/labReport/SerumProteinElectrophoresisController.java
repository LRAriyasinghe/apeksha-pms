package com.apekshapms.controller.labReport;


import com.apekshapms.controller.Controller;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.SerumProteinReport;
import com.apekshapms.services.LabReportServices;
import com.apekshapms.ui.UIName;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class SerumProteinElectrophoresisController implements Controller{
   @FXML
    private TextField TypeTextField;

   @FXML
   private TextField TestIDTextField;

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
    private TextField AlbumineeTextField;

    @FXML
    private TextField Alpha1TextField;

    @FXML
    private TextField Alpha2TextField;

    @FXML
    private TextField BetaTextTextField;

    @FXML
    private TextField GammaTextField;

    @FXML
    private Button SubmitButton;

    @FXML
    private Button CancelButton;

    private SerumProteinReport serumProteinReport =  new SerumProteinReport();

    public void initialize(URL location, ResourceBundle resources) {
        SubmitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (isInputValid()) {
                    try {
                        serumProteinReport.setTestID(TestIDTextField.getText());
                        serumProteinReport.setPatientID(PatientIDTextField.getText());
                        serumProteinReport.setPatientName(PatientNameTextField.getText());
                        serumProteinReport.setDate(dateDatePicker.getValue());
                        serumProteinReport.setTestType(TestIDTextField.getText());
                        serumProteinReport.setReference(ReferenceTextField.getText());
                        serumProteinReport.setRemarks(RemarksTextField.getText());
                        serumProteinReport.setAlbumin(AlbumineeTextField.getText());
                        serumProteinReport.setAlpha1(Alpha1TextField.getText());
                        serumProteinReport.setAlpha2(Alpha2TextField.getText());
                        serumProteinReport.setBeta(BetaTextTextField.getText());
                        serumProteinReport.setGamma(GammaTextField.getText());

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
                        LabReportServices.addSerumProteinReport(serumProteinReport);
                    }else {
                        UIFactory.launchUI(UIName.SERUM_PROTEIN_REPORT, true);
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
        if (TypeTextField.getText() == null || TypeTextField.getText().length() == 0) {
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






