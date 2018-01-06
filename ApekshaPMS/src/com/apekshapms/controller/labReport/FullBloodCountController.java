package com.apekshapms.controller.labReport;


import com.apekshapms.controller.Controller;
import com.apekshapms.controller.DashboardController;
import com.apekshapms.database.Connector;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.FullBloodReport;
import com.apekshapms.model.LabReport;
import com.apekshapms.services.LabReportServices;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import com.mysql.jdbc.Connection;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FullBloodCountController implements Controller{
    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    private  TextField testIDTextField;

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

    @FXML
    private Button backButton;

    //Create an Observale list  called 'Cancer Type' to store cancer types
    private ObservableList CancerType = FXCollections.observableArrayList();


    private FullBloodReport fullBloodReport = new FullBloodReport();

    public void initialize(URL location, ResourceBundle resources) {
        CancerType.addAll("BoneMarrow","Creactive","FullBlood","LipidProfile","LiverFunction","SerumCalcium","SerumElectrolytes","serumProtein","Thyroid","UFRC","UrineForBence");
        typeComboBox.setItems(CancerType);

        //Add Full blood Report to the system
        SubmitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String id = PatientIDTextField.getText();
                String emid = ReferenceTextField.getText();
                if (isInputValid()){
                    if (idPatientCkeck(id)){
                        if (idlabassistentCkeck(emid)){
                            try {
                                fullBloodReport.setTestID(testIDTextField.getText());
                                fullBloodReport.setPatientID(PatientIDTextField.getText());
                                fullBloodReport.setPatientName(PatientNameTextField.getText());
                                fullBloodReport.setDate(dateDatePicker.getValue());
                                fullBloodReport.setTestType(typeComboBox.getValue());
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
                            alert.setContentText("Are you ready to insert the report?");

                            Optional<ButtonType> result = alert.showAndWait();
                            if (result.get() == ButtonType.OK) {

                                System.out.println("Yes");
                                LabReportServices.addFullBloodReport(fullBloodReport);
                            }else {
                                UIFactory.launchUI(UIName.FULLBLOODCOUNT_REPORT, true);
                                // ... user chose CANCEL or closed the dialog
                            }
                        }else{
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Message");
                            alert.setHeaderText("");
                            alert.setContentText("Inavalid Lab Assistant ID");
                            alert.showAndWait();
                        }

                    }else{


                        Alert alert1 = new Alert(Alert.AlertType.WARNING);
                        alert1.setTitle("Message");
                        alert1.setHeaderText("");
                        alert1.setContentText("Inavalid Patient ID");
                        alert1.showAndWait();
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
//Check whether the input fields are valid
    private boolean isInputValid() {
        String errorMessage = "";
        String expression = "^[a-zA-Z]*$";

        if (PatientIDTextField.getText() == null || PatientIDTextField.getText().length() == 0) {
            errorMessage += "Not a valid Patient ID!\n";
        }


        CharSequence inputStr1 = PatientNameTextField.getText();
        Pattern pattern1 = Pattern.compile(expression);
        Matcher matcher1 = pattern1.matcher(inputStr1);

        if (PatientNameTextField.getText() == null || PatientNameTextField.getText().length() == 0||PatientNameTextField.getText().length() >=20||!matcher1.matches()) {
            errorMessage += "No valid Patient Name!\n";
        }
        if (testIDTextField.getText() == null || testIDTextField.getText().length() == 0||testIDTextField.getText().length() >=20) {
            errorMessage += "No valid TestId ID!\n";
        }
        String regex = "[0-9]+";
        if (HimoglobinTextField.getText().matches(regex) == false||HimoglobinTextField.getText().length() >=20) {
            errorMessage += "Not a valid Himoglobin !\n";
        } else {
            final String checkage = HimoglobinTextField.getText();
            float value = Float.parseFloat(checkage);                             //check range

            if (!(value >= 0 && value <= 40)) {
                errorMessage += "Not valid Himoglobin!\n";
            }
        }
        /*if (WBCTextField.getText().matches(regex) == false||WBCTextField.getText().length() >=20) {
            errorMessage += "Not a valid WBC !\n";
        }*/

        if (NETextField.getText().matches(regex) == false||NETextField.getText().length() >=20) {
            errorMessage += "Not a valid NET !\n";
        } else {
            final String checkage = NETextField.getText();
            float value = Float.parseFloat(checkage);                             //check range

            if (!(value >= 0 && value <= 40)) {
                errorMessage += "Not valid NET!\n";
            }
        }

        if (PlateletsTextField.getText().matches(regex) == false||PlateletsTextField.getText().length() >=20) {
            errorMessage += "Not a valid Platelets!\n";
        } else {
            final String checkage = PlateletsTextField.getText();
            float value = Float.parseFloat(checkage);                             //check range

            if (!(value >= 50 && value <= 270)) {
                errorMessage += "Not valid Plateles!\n";
            }
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


        } catch (ParseException e) {

            // e.printStackTrace();
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
    //Check whether the Id of Patient is valid
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
    //Check whether the id of lab assistant is valid
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


}//Class Finish