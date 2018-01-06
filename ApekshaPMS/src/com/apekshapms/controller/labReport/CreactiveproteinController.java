package com.apekshapms.controller.labReport;


import com.apekshapms.controller.Controller;
import com.apekshapms.controller.DashboardController;
import com.apekshapms.database.Connector;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.CreactiveproteinReport;
import com.apekshapms.model.LabReport;
import com.apekshapms.services.LabReportServices;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import com.mysql.jdbc.PreparedStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreactiveproteinController implements Controller{
    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    private TextField TestIDTextField;

    @FXML
    private DatePicker dateDatePicker;

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

    @FXML
    private Button backButton;
    private ObservableList CancerType = FXCollections.observableArrayList();



    private CreactiveproteinReport creactiveproteinReport = new CreactiveproteinReport();

    public void initialize(URL location, ResourceBundle resources) {
        CancerType.addAll("BoneMarrow","Creactive","FullBlood","LipidProfile","LiverFunction","SerumCalcium","SerumElectrolytes","serumProtein","Thyroid","UFRC","UrineForBence");
        typeComboBox.setItems(CancerType);

        SubmitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (isInputValid()) {
                    try {
                        creactiveproteinReport.setTestID(TestIDTextField.getText());
                        creactiveproteinReport.setPatientID(PatientIDTextField.getText());
                        creactiveproteinReport.setPatientName(PatientNameTextField.getText());
                        creactiveproteinReport.setDate(dateDatePicker.getValue());
                        creactiveproteinReport.setTestType(typeComboBox.getValue());
                        creactiveproteinReport.setReference(ReferenceTextField.getText());
                        creactiveproteinReport.setRemarks(RemarksTextField.getText());
                        creactiveproteinReport.setCreactiveprotein(CreactiveproteinTextField.getText());
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
                        LabReportServices.addCreactiveProteinReport(creactiveproteinReport);
                    }else {
                        UIFactory.launchUI(UIName.BONEMARROW_REPORT, true);
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
        String expression = "^[a-zA-Z]*$";


        if (PatientIDTextField.getText() == null || PatientIDTextField.getText().length() == 0) {
            errorMessage += "Not a valid Patient ID!\n";
        }
        if (ReferenceTextField.getText() == null || ReferenceTextField.getText().length() == 0) {
            errorMessage += "Not a valid Reference By!\n";
        }


        CharSequence inputStr1 = PatientNameTextField.getText();
        Pattern pattern1 = Pattern.compile(expression);
        Matcher matcher1 = pattern1.matcher(inputStr1);

        if (PatientNameTextField.getText() == null || PatientNameTextField.getText().length() == 0||PatientNameTextField.getText().length() >=20||!matcher1.matches()) {
            errorMessage += "No valid Patient Name!\n";
        }
        if (TestIDTextField.getText() == null || TestIDTextField.getText().length() == 0||TestIDTextField.getText().length() >=20) {
            errorMessage += "No valid TestId ID!\n";
        }

        if (dateDatePicker.getValue() == null || dateDatePicker.getValue().lengthOfYear() == 0) {
            errorMessage += "Not a valid Date!\n";
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dat = new Date();
        System.out.println(dateFormat.format(dat));
        System.out.println(dateDatePicker.getValue());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1, date2;
        try {
            date1 = sdf.parse(dateFormat.format(dat));
            date2 = sdf.parse(String.valueOf(dateDatePicker.getValue()));

            if (date2.compareTo(date1) > 0) {
                //System.out.println("Date1 is after Date2");
                errorMessage += "No valid Date!\n";
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Look, a Warning Dialog");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            System.out.println("Successfully Fail");

            return false;
        }
    }
    private boolean idPatientCkeck(String patientid){
        Connection connection = (Connection) new Connector().getConnection();
        try {
            PreparedStatement pr = (PreparedStatement) connection.prepareStatement("SELECT * FROM patient WHERE patient_Id= ?");
            pr.setString(1,patientid);
            ResultSet rs = pr.executeQuery();
            if(rs.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private boolean idlabassistentCkeck(String empid){
        Connection connection = (Connection) new Connector().getConnection();
        try {
            PreparedStatement pr = (PreparedStatement) connection.prepareStatement("SELECT * FROM employee WHERE emp_Id= ?");
            pr.setString(1,empid);
            ResultSet rs = pr.executeQuery();
            if(rs.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}

//Class Finish

