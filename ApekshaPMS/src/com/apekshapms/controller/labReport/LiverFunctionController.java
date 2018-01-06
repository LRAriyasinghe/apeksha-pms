package com.apekshapms.controller.labReport;


import com.apekshapms.controller.Controller;
import com.apekshapms.controller.DashboardController;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.LabReport;
import com.apekshapms.model.LiverFunctionReport;
import com.apekshapms.services.LabReportServices;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class LiverFunctionController implements Controller{
    @FXML
    private ComboBox<String> typeComboBox;
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
    private TextField SerumBilTextField;

    @FXML
    private TextField SgptTextField;

    @FXML
    private TextField SgotTextField;

    @FXML
    private TextField SerumAlkTextField;

    @FXML
    private TextField SerumCreTextField;

    @FXML
    private TextField SerumCalTextField;

    @FXML
    private TextArea RemarksTextField;

    @FXML
    private Button SubmitButton;

    @FXML
    private Button CancelButton;

    @FXML
    private Button backButton;
    private ObservableList CancerType = FXCollections.observableArrayList();
    private LiverFunctionReport liverFunctionReport = new LiverFunctionReport();


    public void initialize(URL location, ResourceBundle resources) {
        CancerType.addAll("BoneMarrow","Creactive","FullBlood","LipidProfile","LiverFunction","SerumCalcium","SerumElectrolytes","serumProtein","Thyroid","UFRC","UrineForBence");
        typeComboBox.setItems(CancerType);
        SubmitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (isInputValid()) {
                    try {
                        liverFunctionReport.setTestID(TestIDTextField.getText());
                        liverFunctionReport.setPatientID(PatientIDTextField.getText());
                        liverFunctionReport.setPatientName(PatientNameTextField.getText());
                        liverFunctionReport.setDate(dateDatePicker.getValue());
                        liverFunctionReport.setTestType(typeComboBox.getValue());
                        liverFunctionReport.setReference(ReferenceTextField.getText());
                        liverFunctionReport.setRemarks(RemarksTextField.getText());
                        liverFunctionReport.setSerum_Bilrubin(SerumBilTextField.getText());
                        liverFunctionReport.setSGPT(SgptTextField.getText());
                        liverFunctionReport.setSGOT(SgotTextField.getText());
                        liverFunctionReport.setSerum_Alkaline(SerumAlkTextField.getText());
                        liverFunctionReport.setSerum_Creatinine(SerumCreTextField.getText());
                        liverFunctionReport.setSerum_Calcium(SerumCalTextField.getText());

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
                        LabReportServices.addLiverFunctionReport(liverFunctionReport);
                    }else {
                        UIFactory.launchUI(UIName.LIVERFUNCTION_REPORT, true);
                        // ... user chose CANCEL or closed the dialog
                    }

                }

            }
        });

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // ... user chose Bach Button
                UI ui = UIFactory.getUI(UIName.ADD_REPORT);
                Parent parent = ui.getParent();
                DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
                dashboardController.setWorkspace(parent);

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