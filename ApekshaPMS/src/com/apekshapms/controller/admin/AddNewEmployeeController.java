package com.apekshapms.controller.admin;

import com.apekshapms.controller.Controller;
import com.apekshapms.model.Employee;
import com.apekshapms.services.EmployeeServices;
import com.apekshapms.services.PatientServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;

public class AddNewEmployeeController implements Controller {
    @FXML
    private AnchorPane backgroundAnchorPane;

    @FXML
    private TextField txtIdNo;

    @FXML
    private TextField txtTtile;

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
    private TextField txtLastname;

    @FXML
    private TextField txtNic;

    @FXML
    private TextArea txtAddress;

    @FXML
    private Button submit;

    @FXML
    private Button backButton;

    @FXML
    private Button CancelButton;

    @FXML
    private RadioButton rbtnMarried;

    @FXML
    private RadioButton rbtnUnmarried;

    @FXML
    private ChoiceBox<String> districtChoiceBox;

    @FXML
    private ChoiceBox<String> employeeTypeChoiceBox;

    private ObservableList distrct = FXCollections.observableArrayList();

    private ObservableList type = FXCollections.observableArrayList();

    private Employee employee = new Employee();

    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        distrct.addAll("Jaffna","Kilinochchi","Mannar","Mullaitivu","Vavuniya","Puttalam","Kurunegala","Gampaha","Colombo","Kalutara","Anuradhapura","Polonnaruwa","Matale","Kandy","Nuwara Eliya","Kegalle","Ratnapura","Trincomalee","Batticaloa","Ampara","Badulla","Monaragala","Hambantota","Matara","Galle");
        districtChoiceBox.setItems(distrct);
        districtChoiceBox.setValue("Colombo");

        type.addAll("Admin","Consultant","Lab Assistent","Register Doctor","Non Employee");
        employeeTypeChoiceBox.setItems(type);
        employeeTypeChoiceBox.setValue("Admin");

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                EmployeeServices.addEmployee(employee);
            }
        });


    }

}
