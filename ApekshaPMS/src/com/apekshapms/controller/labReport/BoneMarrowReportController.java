package com.apekshapms.controller.labReport;


import com.apekshapms.controller.Controller;
import com.apekshapms.controller.DashboardController;
import com.apekshapms.database.Connector;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.BonemarrowReport;
import com.apekshapms.model.LabReport;
import com.apekshapms.services.LabReportServices;
import com.apekshapms.services.PatientServices;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import com.mysql.jdbc.Connection;
import com.sun.org.apache.bcel.internal.generic.Select;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BoneMarrowReportController implements Controller {

    @FXML
    private DatePicker date;

    @FXML
    private ComboBox<String> typeComboBox;

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

    private ObservableList CancerType = FXCollections.observableArrayList();


    @Override
    public void refreshView() {

    }


    //Create the Object of Bonemarrow Report Model
    private BonemarrowReport bonemarrowreport = new BonemarrowReport();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CancerType.addAll("BoneMarrow","Creactive","FullBlood","LipidProfile","LiverFunction","SerumCalcium","SerumElectrolytes","serumProtein","Thyroid","UFRC","UrineForBence");
        typeComboBox.setItems(CancerType);

        //Insert BoneMarrow Report to the system
        SubmitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String id = PatientIDTextField.getText();
                String emid = ReferenceTextField.getText();
                System.out.println("okokokookk");
                if (isInputValid() && idPatientCkeck(id) && idlabassistentCkeck(emid)) {
                    try {
                        bonemarrowreport.setPatientID(PatientIDTextField.getText());
                        bonemarrowreport.setTestType(typeComboBox.getValue());
                        bonemarrowreport.setTestID(TestIDTextField.getText());
                        bonemarrowreport.setPatientName(PatientNameTextField.getText());
                        bonemarrowreport.setDate(date.getValue());
                        bonemarrowreport.setReference(ReferenceTextField.getText());
                        bonemarrowreport.setRemarks(RemarksTextField.getText());
                        bonemarrowreport.setBMBx(BMBxTextField.getText());
                        bonemarrowreport.setTrephineBMBx(TrephineBMBxTextField.getText());
                    }
                    catch (Exception e){
                        System.err.println(e);
                    }
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);//Patient Register Confirmation Dialog box
                    alert.setTitle("Confirmation Dialog");
                    alert.setHeaderText("Look, a Confirmation Dialog");
                    alert.setContentText("Are you ready to insert the report?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {

                        System.out.println("Yes");
                        LabReportServices.addBoneMarrowReport(bonemarrowreport);
                    }else {
                        UIFactory.launchUI(UIName.FULLBLOODCOUNT_REPORT, true);
                        // ... user chose CANCEL or closed the dialog
                    }


                    PatientIDTextField.setText("");
                    typeComboBox.setValue("");
                    TestIDTextField.setText("");
                    PatientNameTextField.setText("");
                    ReferenceTextField.setText("");
                    RemarksTextField.setText("");
                    BMBxTextField.setText("");
                    TrephineBMBxTextField.setText("");


                } else {
                    if (!(idPatientCkeck(id))) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Message");
                        alert.setHeaderText("");
                        alert.setContentText("Inavalid Patient ID");
                        alert.showAndWait();
                    }
                    if(idlabassistentCkeck(emid))
                    {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Message");
                        alert.setHeaderText("");
                        alert.setContentText("Inavalid Lab Assistant ID");
                        alert.showAndWait();



                    }
                }
            }}
        );
    }
    //Check whether all inputs are valid
    private boolean isInputValid() {
        String errorMessage = "";
        String expression = "^[a-zA-Z]*$";

        if (PatientIDTextField.getText() == null || PatientIDTextField.getText().length() == 0) {
            errorMessage += "Not a valid Patient ID!\n";
        }

        /*if (TestIDTextField.getText() == null || TestIDTextField.getText().length() == 0||TestIDTextField.getText().length() >=20) {
            errorMessage += "Not a valid Test ID!\n";
        }*/

        if (ReferenceTextField.getText() == null || ReferenceTextField.getText().length() == 0) {
            errorMessage += "Not a valid Reference By!\n";
        }
        if (date.getValue() == null || date.getValue().lengthOfYear() == 0) {
            errorMessage += "Not a valid Date!\n";
        }

        CharSequence inputStr1 = PatientNameTextField.getText();
        Pattern pattern1 = Pattern.compile(expression);
        Matcher matcher1 = pattern1.matcher(inputStr1);

        if (PatientNameTextField.getText() == null || PatientNameTextField.getText().length() == 0||PatientNameTextField.getText().length() >=20||!matcher1.matches()) {
            errorMessage += "Not a valid PatientName!\n";
        }


        String regex = "[0-9]+";
        if (BMBxTextField.getText().matches(regex) == false||BMBxTextField.getText().length() ==0) {
            errorMessage += "Not a valid BMSX!\n";
        } else {
            final String checkage = BMBxTextField.getText();
            float value = Float.parseFloat(checkage);                             //check range


        }

        if (TrephineBMBxTextField.getText().matches(regex) == false||TrephineBMBxTextField.getText().length() ==0) {
            errorMessage += "Not a valid Trephine BMSX!\n";
        } else {
            final String checkage = BMBxTextField.getText();
            float value = Float.parseFloat(checkage);                             //check range


        }


        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //get current date time with Date()
        Date dat = new Date();
        System.out.println(dateFormat.format(dat));
        System.out.println(date.getValue());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1, date2;
        try {
            date1 = sdf.parse(dateFormat.format(dat));
            date2 = sdf.parse(String.valueOf(date.getValue()));

            if (date2.compareTo(date1) > 0) {
                //System.out.println("Date1 is after Date2");
                errorMessage += "No valid Date!\n";
            }


        } catch (ParseException e) {
            // e.printStackTrace();
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
    //Check whther the patient ID is valid
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
    //Check wether thw id of lab assistant is valid
    private boolean idlabassistentCkeck(String empid){
        Connection connection = (Connection) new Connector().getConnection();
        try {
            PreparedStatement pr = (PreparedStatement) connection.prepareStatement("SELECT * FROM labassistaant WHERE emp_Id= ?");
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
    private boolean labassistentCkeck(String patientid){
    Connection connection = (Connection) new Connector().getConnection();
        try {
        PreparedStatement pr = (PreparedStatement) connection.prepareStatement("SELECT * FROM patient WHERE patient_id=?");
        ResultSet rs = pr.executeQuery();
        String a = rs.getString(patientid);
        typeComboBox.setValue(a);


    } catch (SQLException e) {
        e.printStackTrace();
    }
                    return false;

    }}



