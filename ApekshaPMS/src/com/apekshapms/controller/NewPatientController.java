package com.apekshapms.controller;

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

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class NewPatientController implements Controller {

    @FXML
    private Button nextButton;

    @FXML
    private TextField txtIdNo;

    @FXML
    private TextField txtTtile;

    @FXML
    private TextField txtFirstname;

    @FXML
    private TextField txtLastname;

    @FXML
    private TextField txtNic;

    @FXML
    private DatePicker DOB;

    @FXML
    private RadioButton Male;

    @FXML
    private RadioButton Female;

    @FXML
    private TextField txtOccupation;

    @FXML
    private TextField txtContactNo;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtDistrict;

    @FXML
    private ChoiceBox<String> districtChoiceBox;

    @FXML
    private TextArea txtAddress;

    @FXML
    private RadioButton rbtnMarried;

    @FXML
    private RadioButton rbtnUnmarried;

    @FXML
    private Button backButton;

    private Patient patient;

    private ObservableList distrct = FXCollections.observableArrayList();

    @FXML
    void handleBackOnAction(javafx.event.ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.EMTY);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);

    }

    @FXML
    void handleCancelOnAction(javafx.event.ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.EMTY);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        distrct.addAll("Jaffna","Kilinochchi","Mannar","Mullaitivu","Vavuniya","Puttalam","Kurunegala","Gampaha","Colombo","Kalutara","Anuradhapura","Polonnaruwa","Matale","Kandy","Nuwara Eliya","Kegalle","Ratnapura","Trincomalee","Batticaloa","Ampara","Badulla","Monaragala","Hambantota","Matara","Galle");
        districtChoiceBox.setItems(distrct);
        districtChoiceBox.setValue("Colombo");

        txtNic.setPrefColumnCount(10);
        DOB.setPromptText("mm-dd-yyyy");
        txtNic.setPromptText("xxxxxxxxxV/E");
        txtTtile.setPromptText("Mr/Mrs/Miss");

        ToggleGroup group = new ToggleGroup();
        Male.setToggleGroup(group);
        Female.setToggleGroup(group);
        Male.setSelected(true);

        ToggleGroup group1 = new ToggleGroup();
        rbtnMarried.setSelected(true);
        rbtnMarried.setToggleGroup(group1);
        rbtnUnmarried.setToggleGroup(group1);




        patient = new Patient();




        nextButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //if (isInputValid()) {

                patient.setId(txtIdNo.getText());
                patient.setTitle(txtTtile.getText());
                patient.setFirstName(txtFirstname.getText());
                patient.setLastName(txtLastname.getText());
                patient.setNicNo(txtNic.getText());
                patient.setDob(DOB.getValue());
                patient.setMale(Male.isSelected());
                patient.setOccupation(txtOccupation.getText());
                patient.setTelephone(txtContactNo.getText());
                patient.setCity(txtCity.getText());
                patient.setDistrict(districtChoiceBox.getValue());
                patient.setAddress(txtAddress.getText());
                patient.setCivil(rbtnMarried.isSelected());



                UI ui = UIFactory.getUI(UIName.PATIENT_HISTORY);
                Parent parent = ui.getParent();
                PatientHistoryController controller = (PatientHistoryController) ui.getController();
                controller.showPatient(patient);
                DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
                dashboardController.setWorkspace(parent);
            //}
            }
        });


    }



    @Override
    public void refreshView() {

    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (txtIdNo.getText() == null || txtIdNo.getText().length() == 0) {
            errorMessage += "No valid ID!\n";
        }
        if (txtTtile.getText() == null || txtTtile.getText().length() == 0) {
            errorMessage += "No valid Titlle!\n";
        }
        if (txtFirstname.getText() == null || txtFirstname.getText().length() == 0) {
            errorMessage += "No valid First Namer!\n";
        }
        if (txtLastname.getText() == null || txtLastname.getText().length() == 0) {
            errorMessage += "No valid Last Name!\n";
        }
        if(!txtNic.getText().trim().matches("^[0-9]{9}[V]$") || txtNic.getText() == null || txtNic.getText().length() != 10)
        {
            errorMessage += "No valid NIC!\n";
        }

        if (DOB.getValue() == null || DOB.getValue().lengthOfYear() == 0) {
            errorMessage += "No valid Date Of Birth!\n";
        }
        if (!Male.isSelected() ) {
            errorMessage += "No valid Male or Female!\n";
        }
        if (txtOccupation.getText() == null || txtOccupation.getText().length() == 0) {
            errorMessage += "No valid Occupation!\n";
        }
        String regex = "[0-9]+";
        if (txtContactNo.getText() == null || txtContactNo.getText().length() != 10||txtContactNo.getText().matches(regex)==false) {
            errorMessage += "No valid Contact Number!\n";
        }
       if (txtContactNo.getText().length() != 10) {
            errorMessage += "No valid Contact Number!\n";
        }

        if (txtCity.getText() == null || txtCity.getText().length() == 0) {
            errorMessage += "No valid City!\n";
        }
        if (txtDistrict.getText() == null || txtDistrict.getText().length() == 0) {
            errorMessage += "No valid District!\n";
        }
        if (txtAddress.getText() == null || txtAddress.getText().length() == 0) {
            errorMessage += "No valid Address!\n";
        }
        if (!rbtnMarried.isSelected()) {
            errorMessage += "No valid Married Or UnMarried!\n";
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
                System.out.println("Date1 is after Date2");
                errorMessage += "No valid Date!\n";

            }
        } catch (ParseException e) {
            e.printStackTrace();
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

}
