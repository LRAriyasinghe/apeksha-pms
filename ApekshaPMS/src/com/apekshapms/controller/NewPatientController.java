package com.apekshapms.controller;

import com.apekshapms.database.Connector;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.Patient;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class NewPatientController implements Controller {


    @FXML
    private AnchorPane backgroundAnchorPane;

    @FXML
    private TextField txtIdNo;

    @FXML
    private TextField txtFirstname;

    @FXML
    private TextField txtOccupation;

    @FXML
    private RadioButton Male;

    @FXML
    private RadioButton Female;

    @FXML
    private DatePicker DOB;

    @FXML
    private TextField txtContactNo;

    @FXML
    private TextField txtCity;

    @FXML
    private ChoiceBox<String> districtChoiceBox;

    @FXML
    private TextField txtLastname;

    @FXML
    private TextField txtNic;

    @FXML
    private TextArea txtAddress;

    @FXML
    private Button nextButton;

    @FXML
    private Button backButton;

    @FXML
    private Button CancelButton;

    @FXML
    private RadioButton rbtnMarried;

    @FXML
    private RadioButton rbtnUnmarried;

    @FXML
    private RadioButton mrTitleRadioButton;

    @FXML
    private RadioButton mrsTitleRadionButton;

    @FXML
    private RadioButton missTitleRadioButton;

    @FXML
    private ChoiceBox titleChoiceBox;

    @FXML
    private ChoiceBox<String> genderChoiceBox;

    @FXML
    private ChoiceBox<String> civilChoiceBox;


    private Patient patient;

    private ObservableList distrct = FXCollections.observableArrayList();
    private ObservableList titles = FXCollections.observableArrayList();
    private ObservableList gender = FXCollections.observableArrayList();
    private ObservableList civil = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Add Items to  Title Choice Box
        titles.addAll("Mr","Mrs","Miss");
        titleChoiceBox.setItems(titles);
        titleChoiceBox.setValue("Mr");

        //Add Items to District Choice Box
        distrct.addAll("Jaffna","Kilinochchi","Mannar","Mullaitivu","Vavuniya","Puttalam","Kurunegala","Gampaha","Colombo","Kalutara","Anuradhapura","Polonnaruwa","Matale","Kandy","Nuwara Eliya","Kegalle","Ratnapura","Trincomalee","Batticaloa","Ampara","Badulla","Monaragala","Hambantota","Matara","Galle");
        districtChoiceBox.setItems(distrct);
        districtChoiceBox.setValue("Colombo");

        //Add Item to Gender Choice Box
        gender.addAll("Male","Female");
        genderChoiceBox.setItems(gender);
        genderChoiceBox.setValue("Male");

        //Add Item to Civil Status Choice Box
        civil.addAll("Single","Married");
        civilChoiceBox.setItems(civil);
        civilChoiceBox.setValue("Single");

        //Set values to placeholders
        txtNic.setPrefColumnCount(10);
        DOB.setPromptText("mm-dd-yyyy");
        txtNic.setPromptText("xxxxxxxxxV/E");





        //Get new Patient
        patient = new Patient();

        //Next Button Action Event
        nextButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (isInputValid()) {

                patient.setId(txtIdNo.getId());
                System.out.println(txtIdNo.getText());

                patient.setTitle(String.valueOf(titleChoiceBox.getValue()));
                System.out.println(titleChoiceBox.getValue());

                patient.setFirstName(txtFirstname.getText());
                System.out.println(txtFirstname.getText());

                patient.setLastName(txtLastname.getText());
                System.out.println(txtLastname.getText());

                patient.setNicNo(txtNic.getText());
                System.out.println(txtNic.getText());

                patient.setDob(DOB.getValue());
                System.out.println(DOB.getValue());

                patient.setMale(genderChoiceBox.getValue());
                System.out.println(genderChoiceBox.getValue());

                patient.setOccupation(txtOccupation.getText());
                System.out.println(txtOccupation.getText());

                patient.setTelephone(txtContactNo.getText());
                System.out.println(txtContactNo.getText());

                patient.setCity(txtCity.getText());
                System.out.println(txtCity.getText());

                patient.setDistrict(districtChoiceBox.getValue());
                System.out.println(districtChoiceBox.getValue());

                patient.setAddress(txtAddress.getText());
                System.out.println(txtAddress.getText());

                patient.setCivil(civilChoiceBox.getValue());
                System.out.println(civilChoiceBox.getValue());


                //Get this Patient And Go to the History UI
                UI ui = UIFactory.getUI(UIName.PATIENT_HISTORY);
                Parent parent = ui.getParent();
                PatientHistoryController controller = (PatientHistoryController) ui.getController();
                controller.showPatient(patient);
                DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
                dashboardController.setWorkspace(parent);
            }
            }
        });

        //Cancel Button Action Event
        CancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UI ui = UIFactory.getUI(UIName.APEKSHA_HOME);
                Parent parent = ui.getParent();
                DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
                dashboardController.setWorkspace(parent);
            }
        });


    }


    @Override
    public void refreshView() {

    }

        //Check Validation
    private boolean isInputValid() {
        String errorMessage = "";

        if (txtFirstname.getText() == null || txtFirstname.getText().length() == 0) {
            errorMessage += "No valid First Namer!\n";
        }
        if (txtLastname.getText() == null || txtLastname.getText().length() == 0) {
            errorMessage += "No valid Last Name!\n";
        }
        if (txtNic.getText() == null || txtNic.getText().length() == 0) {
            errorMessage += "No valid NIC!\n";
        }
        if (DOB.getValue() == null || DOB.getValue().lengthOfYear() == 0) {
            errorMessage += "No valid Date Of Birth!\n";
        }

        if (txtOccupation.getText() == null || txtOccupation.getText().length() == 0) {
            errorMessage += "No valid Occupation!\n";
        }
        if (txtContactNo.getText() == null || txtContactNo.getText().length() == 0) {
            errorMessage += "No valid Contact Number!\n";
        }
        if (txtCity.getText() == null || txtCity.getText().length() == 0) {
            errorMessage += "No valid City!\n";
        }
        if (districtChoiceBox.getValue() == null || districtChoiceBox.getValue().length() == 0) {
            errorMessage += "No valid District!\n";
        }
        if (txtAddress.getText() == null || txtAddress.getText().length() == 0) {
            errorMessage += "No valid Address!\n";
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //get current date time with Date()
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        System.out.println(DOB.getValue());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1, date2;
        try {
            date1 = sdf.parse(dateFormat.format(date));
            date2 = sdf.parse(String.valueOf(DOB.getValue()));

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
            // "Please correct invalid fields", "Invalid Fields");
            System.out.println("Successfully Fail");

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Look, a Warning Dialog");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;

        }
    }

    //Get the Maximum Patient ID in the database
    public String getPatientIdAuto(){
        Connection connection = new Connector().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT MAX(patient_Id) FROM Patient");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                txtIdNo.setText(resultSet.getString(1));
            }
            return txtIdNo.getText();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
