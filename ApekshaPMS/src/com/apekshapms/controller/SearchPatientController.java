package com.apekshapms.controller;

import com.apekshapms.model.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SearchPatientController implements Controller{
    ObservableList<Patient> data = FXCollections.observableArrayList();
    PreparedStatement preparedStatement = null;
    ResultSet rs= null;

    private Connection connection;
    private String url;
    private String userName;
    private String password;
    private String dbName;

    @FXML
    private AnchorPane navigationPane;

    @FXML
    private HBox searchPane;

    @FXML
    private Label lblSearch;

    @FXML
    private TextField patientIdTextField;

    @FXML
    private TextField patientNameTextField;

    @FXML
    private AnchorPane managePane;

    @FXML
    private TableView<Patient> tableSearch;

    @FXML
    private TableColumn<Patient, String> idTableColumn;

    @FXML
    private TableColumn<Patient, String> titleTableColumn;

    @FXML
    private TableColumn<Patient, String> firstNameTableColumn;

    @FXML
    private TableColumn<Patient, String> lastNameTableColumn;

    @FXML
    private TableColumn<Patient, String> nicTableColumn;

    @FXML
    private TableColumn<Patient, LocalDate> dobTableColumn;

    @FXML
    private TableColumn<Patient, String> genderTableColumn;

    @FXML
    private TableColumn<Patient, String> occupationTableColumn;

    @FXML
    private TableColumn<Patient, String> civilTableColumn;

    @FXML
    private TableColumn<Patient, String> contactTableColumn;

    @FXML
    private TableColumn<Patient, String> addressTableColumn;

    @FXML
    private TableColumn<Patient, String> cityTableColumn;

    @FXML
    private TableColumn<Patient, String> districtTableColumn;

    @FXML
    private TableColumn<Patient, String> regDocTableColumn;

    @FXML
    private TableColumn<Patient, String> consultantTableColumn;

    @FXML
    private TableColumn<Patient, String> detailsTableColumn;

    @FXML
    private AnchorPane editPane;

    @FXML
    private Button btnSavePatient;

    @FXML
    private Button btnEditPatient;

    @FXML
    private Button btnCancelPatient;

    @FXML
    void handleCancelButton(ActionEvent event) {

    }

    @FXML
    void handleEditButton(ActionEvent event) {

    }

    @FXML
    void handleSaveButton(ActionEvent event) {

    }

    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("patient_Id"));
        titleTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("patient_Id"));
        firstNameTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("patient_Id"));
        lastNameTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("patient_Id"));
        nicTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("patient_Id"));
        dobTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,LocalDate>("patient_Id"));
        genderTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("patient_Id"));
        occupationTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("patient_Id"));
        civilTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("patient_Id"));
        contactTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("patient_Id"));
        addressTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("patient_Id"));
        cityTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("patient_Id"));
        districtTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("patient_Id"));
        regDocTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("patient_Id"));
        consultantTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("patient_Id"));
        detailsTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("patient_Id"));




    }
    /*

    public void loadDatabasePatient(){
        try {
            url = "jdbc:mysql://" + "localhost" + ":3306/";
            userName = "root";
            password = "";
            dbName = "apekshahospitalmaharagama";

            try {
                connection  =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/apekshahospitalmaharagama", "root", "");
                //connection = (Connection) DriverManager.getConnection(url + dbName, userName, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            preparedStatement = connection.prepareStatement("select * from patient");
            //preparedStatement = preparedStatement.getConnection().prepareStatement("select * from employee");
            rs=preparedStatement.executeQuery();

            while (rs.next()){
                data.add(new Patient(
                        rs.getString("patient_Id"),
                        rs.getString("title"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("nic_No"),
                        //rs.getString("dob"),
                        //rs.getString("gender"),
                        rs.getString("occupation"),
                        //rs.getString("civil_Status"),
                        rs.getString("contact_No"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("distric"),
                        rs.getString("registerDoctor_emp_Id"),
                        rs.getString("consultant_emp_Id"),
                        rs.getString("additional_Details")

                ));
            }

        }catch (Exception e){
            System.err.println(e);
        }
    }
    */
}
