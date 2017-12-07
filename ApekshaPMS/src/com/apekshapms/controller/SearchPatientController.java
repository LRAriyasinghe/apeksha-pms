package com.apekshapms.controller;

import com.apekshapms.database.Connector;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.Patient;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import com.sun.org.apache.xpath.internal.operations.String;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
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

        idTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("patient_Id"));
        titleTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("title"));
        firstNameTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("first_name"));
        lastNameTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("last_name"));
        nicTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("nic_No"));
        dobTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,LocalDate>("dob"));
        genderTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("gender"));
        occupationTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("occupation"));
        civilTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("civil_Status"));
        contactTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("contact_No"));
        addressTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("address"));
        cityTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("city"));
        districtTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("distric"));
        regDocTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("registerDoctor_emp_Id"));
        consultantTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("consultant_emp_Id"));
        detailsTableColumn.setCellValueFactory(new PropertyValueFactory<Patient,String>("additional_Details"));
        loadDatabasePatient(); //Load patient into the TableView
        searchPatient(); //Searching Patient by ID,Name
        searchPatientName(); //Searching Patient by FName,Lname,City,District,Address
    }


    public void loadDatabasePatient(){ //Select Patient and add to TableView


        try {
            Connection connection = new Connector().getConnection();
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
