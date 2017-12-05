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

        getSubmit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                EmployeeServices.addEmployee(employee);
            }
        });


    }

    public AnchorPane getBackgroundAnchorPane() {
        return backgroundAnchorPane;
    }

    public void setBackgroundAnchorPane(AnchorPane backgroundAnchorPane) {
        this.backgroundAnchorPane = backgroundAnchorPane;
    }

    public TextField getTxtIdNo() {
        return txtIdNo;
    }

    public void setTxtIdNo(TextField txtIdNo) {
        this.txtIdNo = txtIdNo;
    }

    public TextField getTxtTtile() {
        return txtTtile;
    }

    public void setTxtTtile(TextField txtTtile) {
        this.txtTtile = txtTtile;
    }

    public TextField getTxtFirstname() {
        return txtFirstname;
    }

    public void setTxtFirstname(TextField txtFirstname) {
        this.txtFirstname = txtFirstname;
    }

    public TextField getTxtOccupation() {
        return txtOccupation;
    }

    public void setTxtOccupation(TextField txtOccupation) {
        this.txtOccupation = txtOccupation;
    }

    public RadioButton getMale() {
        return Male;
    }

    public void setMale(RadioButton male) {
        Male = male;
    }

    public RadioButton getFemale() {
        return Female;
    }

    public void setFemale(RadioButton female) {
        Female = female;
    }

    public DatePicker getDOB() {
        return DOB;
    }

    public void setDOB(DatePicker DOB) {
        this.DOB = DOB;
    }

    public TextField getTxtContactNo() {
        return txtContactNo;
    }

    public void setTxtContactNo(TextField txtContactNo) {
        this.txtContactNo = txtContactNo;
    }

    public TextField getTxtCity() {
        return txtCity;
    }

    public void setTxtCity(TextField txtCity) {
        this.txtCity = txtCity;
    }

    public TextField getTxtLastname() {
        return txtLastname;
    }

    public void setTxtLastname(TextField txtLastname) {
        this.txtLastname = txtLastname;
    }

    public TextField getTxtNic() {
        return txtNic;
    }

    public void setTxtNic(TextField txtNic) {
        this.txtNic = txtNic;
    }

    public TextArea getTxtAddress() {
        return txtAddress;
    }

    public void setTxtAddress(TextArea txtAddress) {
        this.txtAddress = txtAddress;
    }

    public Button getSubmit() {
        return submit;
    }

    public void setSubmit(Button submit) {
        this.submit = submit;
    }

    public Button getBackButton() {
        return backButton;
    }

    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    public Button getCancelButton() {
        return CancelButton;
    }

    public void setCancelButton(Button cancelButton) {
        CancelButton = cancelButton;
    }

    public RadioButton getRbtnMarried() {
        return rbtnMarried;
    }

    public void setRbtnMarried(RadioButton rbtnMarried) {
        this.rbtnMarried = rbtnMarried;
    }

    public RadioButton getRbtnUnmarried() {
        return rbtnUnmarried;
    }

    public void setRbtnUnmarried(RadioButton rbtnUnmarried) {
        this.rbtnUnmarried = rbtnUnmarried;
    }

    public ChoiceBox<String> getDistrictChoiceBox() {
        return districtChoiceBox;
    }

    public void setDistrictChoiceBox(ChoiceBox<String> districtChoiceBox) {
        this.districtChoiceBox = districtChoiceBox;
    }

    public ChoiceBox<String> getEmployeeTypeChoiceBox() {
        return employeeTypeChoiceBox;
    }

    public void setEmployeeTypeChoiceBox(ChoiceBox<String> employeeTypeChoiceBox) {
        this.employeeTypeChoiceBox = employeeTypeChoiceBox;
    }

    public ObservableList getDistrct() {
        return distrct;
    }

    public void setDistrct(ObservableList distrct) {
        this.distrct = distrct;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
