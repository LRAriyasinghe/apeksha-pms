package com.apekshapms.controller.admin;

import com.apekshapms.controller.Controller;
import com.apekshapms.controller.DashboardController;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.Employee;
import com.apekshapms.services.EmployeeServices;
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
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AddNewEmployeeController implements Controller {
    @FXML
    private AnchorPane backgroundAnchorPane;

    @FXML
    private TextField txtIdNo;

    @FXML
    private TextField txtFirstname;

    @FXML
    private TextField txtDoorNo;

    @FXML
    private TextField txtStreet;

    @FXML
    private TextField txtBank;

    @FXML
    private TextField txtBranch;

    @FXML
    private TextField txtContactNo;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtLastname;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtDepartment;

    @FXML
    private DatePicker dobDayePicker;

    @FXML
    private Button submit;

    @FXML
    private Button backButton;

    @FXML
    private Button CancelButton;

    @FXML
    private ChoiceBox<String> districtChoiceBox;

    @FXML
    private ChoiceBox<String> typeChoiceBox;

    private ObservableList distrct = FXCollections.observableArrayList();

    private ObservableList type = FXCollections.observableArrayList();

    private Employee employee;

    @FXML
    void handleBackOnAction(javafx.event.ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.EMPLOYEE_DASHBOARD);
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
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        distrct.addAll("Jaffna", "Kilinochchi", "Mannar", "Mullaitivu", "Vavuniya", "Puttalam", "Kurunegala", "Gampaha", "Colombo", "Kalutara", "Anuradhapura", "Polonnaruwa", "Matale", "Kandy", "Nuwara Eliya", "Kegalle", "Ratnapura", "Trincomalee", "Batticaloa", "Ampara", "Badulla", "Monaragala", "Hambantota", "Matara", "Galle");
        districtChoiceBox.setItems(distrct);
        districtChoiceBox.setValue("Colombo");

        type.addAll("Admin", "Consultant", "Lab Assistent", "Register Doctor", "Non Employee");
        typeChoiceBox.setItems(type);
        typeChoiceBox.setValue("Admin");
        employee = new Employee();
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                submit.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (isInputValid()) {

                            employee.setId(txtIdNo.getText());
                            employee.setFirstName(txtFirstname.getText());
                            employee.setLastName(txtLastname.getText());
                            employee.setDoorNu(txtDoorNo.getText());
                            employee.setStreet(txtStreet.getText());
                            employee.setCity(txtCity.getText());
                            employee.setDistric(districtChoiceBox.getValue());
                            employee.setNic(txtNic.getText());
                            employee.setContactNu(txtContactNo.getText());
                            employee.setBank(txtBank.getText());
                            employee.setBranch(txtBranch.getText());
                            employee.setDepartment(txtDepartment.getText());
                            employee.setType(typeChoiceBox.getValue());
                            employee.setDob(dobDayePicker.getValue());

                            //System.out.println("Ok");
                            EmployeeServices.addEmployee(employee);
                            //System.out.println("Ok");
                        }
                    }
                });
            }
        });
    }

    private boolean isInputValid() {
        String errorMessage = "";


        if (txtIdNo.getText() == null || txtIdNo.getText().length() == 0) {
            errorMessage += "No valid ID!\n";
        }
        if (dobDayePicker.getValue() == null || dobDayePicker.getValue().lengthOfYear() == 0) {
            errorMessage += "No valid Date Of Birth!\n";
        }


        if (txtFirstname.getText() == null || txtFirstname.getText().length() == 0) {
            errorMessage += "No valid First Namer!\n";
        }
        if (txtLastname.getText() == null || txtLastname.getText().length() == 0) {
            errorMessage += "No valid Last Name!\n";
        }


        if (txtDoorNo.getText() == null || txtDoorNo.getText().length() == 0) {
            errorMessage += "No valid Door No!\n";
        }
        if (txtStreet.getText() == null || txtStreet.getText().length() == 0) {
            errorMessage += "No valid Street!\n";
        }
        if (txtCity.getText() == null || txtCity.getText().length() == 0) {
            errorMessage += "No valid City!\n";
        }

        if (txtBank.getText() == null || txtBank.getText().length() == 0) {
            errorMessage += "No valid Bank!\n";
        }
        if (txtBranch.getText() == null || txtBranch.getText().length() == 0) {
            errorMessage += "No valid Branch!\n";
        }
        if (txtDepartment.getText() == null || txtDepartment.getText().length() == 0) {
            errorMessage += "No valid Department!\n";
        }
        String regex = "[0-9]+";
        if (txtContactNo.getText() == null || txtContactNo.getText().length() != 10 || txtContactNo.getText().matches(regex) == false) {
            errorMessage += "No valid Contact Number!\n";
        }
        if (!txtNic.getText().trim().matches("^[0-9]{9}[V]$") || txtNic.getText() == null || txtNic.getText().length() != 10) {
            errorMessage += "No valid NIC!\n";
        }


        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //get current date time with Date()
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        System.out.println(dobDayePicker.getValue());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1, date2;
        try {
            date1 = sdf.parse(dateFormat.format(date));
            date2 = sdf.parse(String.valueOf(dobDayePicker.getValue()));

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
}

