package com.apekshapms.controller;

import com.apekshapms.database.Connector;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.Patient;
<<<<<<< HEAD
import com.apekshapms.services.LabReportServices;
=======
import com.apekshapms.ui.UI;
>>>>>>> 37cfed48f33e8a87a7b86e52f38e36011ad10b9d
import com.apekshapms.ui.UIName;
import com.sun.org.apache.xpath.internal.operations.String;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
<<<<<<< HEAD
import javafx.scene.control.*;
=======
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
>>>>>>> 37cfed48f33e8a87a7b86e52f38e36011ad10b9d
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class SearchPatientController implements Controller{
    ObservableList<Patient> data = FXCollections.observableArrayList(); //Create Array for store patient data
    PreparedStatement preparedStatement = null;
    ResultSet rs= null;
    FilteredList<Patient> filteredList = new FilteredList<>(data,e->true); //Create list for the Patient store while searching Patient

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
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private  TextField contactnoTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField cityTextField;
    @FXML
    private TextField districtTextField;
    @FXML
    private TextField occupationTextField;
    @FXML
    private Button saveButton;
    @FXML
    private Button deleteButton;


    @FXML
    void handleCancelButton(ActionEvent event) {
    }

    @FXML
    void handleEditButton(ActionEvent event) {
    }



    @Override
    public void refreshView() {
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
        //Select Table Column

        idTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("id"));
        titleTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("title"));
        firstNameTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("firstName"));
        lastNameTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("lastName"));
        nicTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("nicNo"));
        dobTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,LocalDate>("dob"));
        genderTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("isMale"));
        occupationTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("occupation"));
        civilTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("isCivil"));
        contactTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("telephone"));
        addressTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("address"));
        cityTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("city"));
        districtTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("district"));
        regDocTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("registerDocId"));
        consultantTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("consultantId"));
        detailsTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("details"));
        loadDatabasePatient(); //Load patient into the TableView
        searchPatient(); //Searching Patient by ID,Name
        searchPatientName(); //Searching Patient by FName,Lname,City,District,Address


        saveButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

                java.lang.String query = "update patient set first_name=?, last_name=?, occupation=?, contact_No=?, address=?, city=?, district=? where patient_Id='"+patientIdTextField.getText()+"' or first_name='" + patientNameTextField.getText() +"'";
                try{
                    Connection connection = new Connector().getConnection();
                    preparedStatement=connection.prepareStatement(query);
                    preparedStatement.setString(1, firstnameTextField.getText());
                    preparedStatement.setString(2, lastnameTextField.getText());
                    preparedStatement.setString(3,occupationTextField.getText());
                    preparedStatement.setString(4,contactnoTextField.getText());
                    preparedStatement.setString(5,addressTextField.getText());
                    preparedStatement.setString(6,cityTextField.getText());
                    preparedStatement.setString(7,districtTextField.getText());

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);//Patient Register Confirmation Dialog box
                    alert.setTitle("SuccessFul");
                    alert.setHeaderText("Look, a Confirmation Dialog");
                    alert.setContentText("Patient Details Successfully Updated");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {

                        System.out.println("Yes");
                        preparedStatement.execute();
                        preparedStatement.close();
                        loadDatabasePatient();

                        // LabReportServices.addFullBloodReport(fullBloodReport);
                    }else {
                        UIFactory.launchUI(UIName.SEARCH_PATIENT, true);
                        // ... user chose CANCEL or closed the dialog
                    }


                }
                catch (SQLException e){
                    e.printStackTrace();
                }

            }
        }
        );
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                java.lang.String name="null";
                try{
                    Connection connection = new Connector().getConnection();
                    Patient patient=(Patient)tableSearch.getSelectionModel().getSelectedItem();
                    java.lang.String query = "delete from patient where patient_Id=?";
                    preparedStatement=connection.prepareStatement(query);
                    preparedStatement.setString(1,patient.getId());
                    name=patient.getId();
                    preparedStatement.executeUpdate();

                    preparedStatement.close();
                    rs.close();

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);//Patient Register Confirmation Dialog box
                    alert.setTitle("SuccessFul");
                    alert.setHeaderText("Look, a Confirmation Dialog");
                    alert.setContentText("Ready to delete the patient details.Are you Okay?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {

                        System.out.println("Yes");
                        // LabReportServices.addFullBloodReport(fullBloodReport);
                    }else {
                        UIFactory.launchUI(UIName.SEARCH_PATIENT, true);
                        // ... user chose CANCEL or closed the dialog
                    }



                }catch (SQLException e){
                    e.printStackTrace();
                }
                loadDatabasePatient();

            }
        }
        );



    }


    public void loadDatabasePatient(){ //Select Patient and add to TableView


        try {
            Connection connection = new Connector().getConnection();

            firstnameTextField.clear();
            lastnameTextField.clear();
            occupationTextField.clear();
            contactnoTextField.clear();
            addressTextField.clear();
            cityTextField.clear();
            districtTextField.clear();
            data.clear();

            preparedStatement = connection.prepareStatement("select * from patient");
            rs=preparedStatement.executeQuery();
            while (rs.next()){
                data.add(new Patient(
                        rs.getString("patient_Id"),
                        rs.getString("title"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("nic_No"),
                        rs.getDate("dob").toLocalDate(),
                        rs.getBoolean("gender"),
                        rs.getString("occupation"),
                        rs.getBoolean("civil_Status"),
                        rs.getString("contact_No"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("district"),
                        rs.getString("registerDoctor_emp_Id"),
                        rs.getString("consultant_emp_Id"),
                        rs.getString("additional_Details")
                ));
                tableSearch.setItems(data);
                tableSearch.setTableMenuButtonVisible(true);
            }
            preparedStatement.close(); //Close the Connection
            rs.close();

        }catch (Exception e){
            System.err.println(e);
        }
    }

    public void showOnClick() //Load table view detailsls to text field
    {
        try{
            Connection connection = new Connector().getConnection();
            Patient patient=(Patient)tableSearch.getSelectionModel().getSelectedItem();
            java.lang.String query = "select first_name,last_name,occupation,contact_No,address,city,district from patient";
            preparedStatement=connection.prepareStatement(query);

            firstnameTextField.setText(patient.getFirstName());
            lastnameTextField.setText(patient.getLastName());
            occupationTextField.setText(patient.getOccupation());
            contactnoTextField.setText(patient.getTelephone());
            addressTextField.setText(patient.getAddress());
            cityTextField.setText(patient.getCity());
            districtTextField.setText(patient.getDistrict());

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    /*saveButton.setOnAction(new EventHandler)
    //@FXML
    public void UpdatePatient(){//Method for updating details of the patient
        java.lang.String query = "update patient set first_name=?, last_name=?, occupation=?, contact_No=?, address=?, city=?, district=? where patient_Id='"+patientIdTextField.getText()+"'";
    try{
        Connection connection = new Connector().getConnection();
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(1, firstnameTextField.getText());
        preparedStatement.setString(2, lastnameTextField.getText());
        preparedStatement.setString(3,occupationTextField.getText());
        preparedStatement.setString(4,contactnoTextField.getText());
        preparedStatement.setString(5,addressTextField.getText());
        preparedStatement.setString(6,cityTextField.getText());
        preparedStatement.setString(7,districtTextField.getText());
        loadDatabasePatient();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);//Patient Register Confirmation Dialog box
        alert.setTitle("SuccessFul");
        alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText("Patient Details Successfully Updated");


    }
    catch (SQLException e){
        e.printStackTrace();
    }
    }*/

    @FXML
    public void searchPatient() { //This methos for use Searching Patient by ID,Name
        patientIdTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate((Predicate<? super Patient>)patient->{
                if (newValue==null||newValue.isEmpty()){
                    return true;
                }
                java.lang.String lowerCaseFilter = newValue.toLowerCase();
                if (patient.getId().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if(patient.getFirstName().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                return false;
            });

        });
        SortedList<Patient> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(tableSearch.comparatorProperty());
        tableSearch.setItems(sortedList);

    }

    @FXML
    public void searchPatientName() { //This methos for use Searching Patient by FName,Lname,City,District,Address...
        patientNameTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate((Predicate<? super Patient>)patient->{
                if (newValue==null||newValue.isEmpty()){
                    return true;
                }
                java.lang.String lowerCaseFilter = newValue.toLowerCase();
                if (patient.getFirstName().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if(patient.getLastName().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if(patient.getAddress().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if(patient.getCity().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if(patient.getDistrict().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if(patient.getNicNo().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                return false;
            });

        });
        SortedList<Patient> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(tableSearch.comparatorProperty());
        tableSearch.setItems(sortedList);

    }

}
