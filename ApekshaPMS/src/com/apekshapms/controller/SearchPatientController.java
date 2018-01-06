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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;


import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchPatientController implements Controller{
    ObservableList<Patient> data = FXCollections.observableArrayList(); //Create Array for store patient data
    PreparedStatement preparedStatement = null;
    ResultSet rs= null;
    FilteredList<Patient> filteredList = new FilteredList<>(data,e->true); //Create list for the Patient store while searching Patient

    @FXML
    private AnchorPane navigationPane;

    @FXML
    private TextArea reasonForDeleteTextField;

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
    private ComboBox<java.lang.String> districtComboBox;
    @FXML
    private TextField occupationTextField;
    @FXML
    private Button saveButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button backButton;

    private ObservableList district = FXCollections.observableArrayList();


    @FXML
    void handleCancelButton(ActionEvent event) {
    }

    @FXML
    void handleEditButton(ActionEvent event) {
    }



    @Override
    public void refreshView() {
    }

    //Select Table Column
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        district.addAll("Jaffna","Kilinochchi","Mannar","Mullaitivu","Vavuniya","Puttalam","Kurunegala","Gampaha","Colombo","Kalutara","Anuradhapura","Polonnaruwa","Matale","Kandy","Nuwara Eliya","Kegalle","Ratnapura","Trincomalee","Batticaloa","Ampara","Badulla","Monaragala","Hambantota","Matara","Galle");
        districtComboBox.setItems(district);

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

        //Update the Patient details based on the Id or Name
        saveButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if(isInputValid()) {
                    if (isTextFieldsValid()) {
                        java.lang.String query = "update patient set first_name=?, last_name=?, occupation=?, contact_No=?, address=?, city=?, district=? where patient_Id='" + patientIdTextField.getText() + "' || first_name='" + patientNameTextField.getText() + "'"; //SQL query for updating patient details
                        try {
                            Connection connection = new Connector().getConnection();
                            preparedStatement = connection.prepareStatement(query);
                            preparedStatement.setString(1, firstnameTextField.getText());
                            preparedStatement.setString(2, lastnameTextField.getText());
                            preparedStatement.setString(3, occupationTextField.getText());
                            preparedStatement.setString(4, contactnoTextField.getText());
                            preparedStatement.setString(5, addressTextField.getText());
                            preparedStatement.setString(6, cityTextField.getText());
                            preparedStatement.setString(7, districtComboBox.getValue());

                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);//Patient Register Confirmation Dialog box
                            alert.setTitle("SuccessFul");
                            alert.setHeaderText("Look, a Confirmation Dialog");
                            alert.setContentText("Do you need to Update patient details?");

                            Optional<ButtonType> result = alert.showAndWait();
                            if (result.get() == ButtonType.OK) {

                                System.out.println("Yes");
                                preparedStatement.execute();
                                Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);//Patient Update successful Message box
                                alert1.setTitle("SuccessFul");
                                alert1.setHeaderText("Look, a Success Dialog");
                                alert1.setContentText("Patient Details Successfully Updated");


                                preparedStatement.close();
                                loadDatabasePatient();

                                // LabReportServices.addFullBloodReport(fullBloodReport);
                            } else {
                                UIFactory.launchUI(UIName.SEARCH_PATIENT, true);
                                // ... user chose CANCEL or closed the dialog
                            }


                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        );

        //Without delete the patient details from database update the flag of the 'state' coloumn to '0'
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(isInputValid()){
                java.lang.String name = "null";
                try {
                    Connection connection = new Connector().getConnection();
                    Patient patient = (Patient) tableSearch.getSelectionModel().getSelectedItem();
                    java.lang.String query = "update patient set state = '0',del_date_time = NOW(),reson=? where patient_Id='" + patientIdTextField.getText() + "' || first_name='" + patientNameTextField.getText() + "'";

                    preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, reasonForDeleteTextField.getText());
                    name = patient.getId();
                    preparedStatement.executeUpdate();
                    preparedStatement.close();
                    rs.close();

                    //Patient Register Confirmation Dialog box
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("SuccessFul");
                    alert.setHeaderText("Look, a Confirmation Dialog");
                    alert.setContentText("Flaged the Patient details");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {

                        System.out.println("Yes");
                        // LabReportServices.addFullBloodReport(fullBloodReport);
                    } else {
                        UIFactory.launchUI(UIName.SEARCH_PATIENT, true);
                        // ... user chose CANCEL or closed the dialog
                    }


                } catch (SQLException e) {
                    e.printStackTrace();
                }
                loadDatabasePatient();
            }
            }
        }
        );
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UI ui = UIFactory.getUI(UIName.PATIENT_DASHBOARD);
                Parent parent = ui.getParent();
                DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
                dashboardController.setWorkspace(parent);
            }
        });
    }

    //Select Patient and add to TableView
    public void loadDatabasePatient(){

        //Clear all field values
        try {
            Connection connection = new Connector().getConnection();

            firstnameTextField.clear();
            lastnameTextField.clear();
            occupationTextField.clear();
            contactnoTextField.clear();
            addressTextField.clear();
            cityTextField.clear();
            districtComboBox.setValue("");
            patientIdTextField.clear();
            patientNameTextField.clear();
            data.clear();


            preparedStatement = connection.prepareStatement("select * from patient where state LIKE '1'");
            rs=preparedStatement.executeQuery();
            while (rs.next()){
                data.add(new Patient(
                        rs.getString("patient_Id"),
                        rs.getString("title"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("nic_No"),
                        rs.getDate("dob").toLocalDate(),
                        rs.getString("gender"),
                        rs.getString("occupation"),
                        rs.getString("civil_Status"),
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
    //Load table view detailsls to text field
    public void showOnClick()
    {
        try{
            Connection connection = new Connector().getConnection();
            Patient patient=(Patient)tableSearch.getSelectionModel().getSelectedItem();
            java.lang.String query = "select patient_Id,first_name,last_name,occupation,contact_No,address,city,district from patient";
            preparedStatement=connection.prepareStatement(query);

            patientIdTextField.setText(patient.getId());
            patientNameTextField.setText(patient.getFirstName());
            firstnameTextField.setText(patient.getFirstName());
            lastnameTextField.setText(patient.getLastName());
            occupationTextField.setText(patient.getOccupation());
            contactnoTextField.setText(patient.getTelephone());
            addressTextField.setText(patient.getAddress());
            cityTextField.setText(patient.getCity());
            districtComboBox.setValue(patient.getDistrict());

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Search Field Validation Part
    private boolean isInputValid(){
        java.lang.String errorMessage = "";

        if (patientIdTextField.getText() == null || patientIdTextField.getText().length() == 0 || patientNameTextField.getText() == null || patientNameTextField.getText().length() == 0) {
            errorMessage += "Not a Valid Search Field.Please enter a valid search input!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {

            //Alert For Invalid TextFields
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Look, a Warning Dialog");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            // Show the error message

            System.out.println("Validation Successfully Fail");
            return false;
        }
    }

    //Validate the updated fields
    private boolean isTextFieldsValid(){
        java.lang.String errorMessage = "";

        java.lang.String expression = "^[a-zA-Z]*$";
        java.lang.String regex = "[0-9]+";


        CharSequence inputStr1 = firstnameTextField.getText();
        Pattern pattern1 = Pattern.compile(expression);
        Matcher matcher1 = pattern1.matcher(inputStr1);

        if (firstnameTextField.getText() == null || firstnameTextField.getText().length() == 0 || !matcher1.matches()) {
            errorMessage += "Not a valid FirstName!\n";
        }
        CharSequence inputStr2 = lastnameTextField.getText();
        Pattern pattern2 = Pattern.compile(expression);
        Matcher matcher2 = pattern2.matcher(inputStr2);

        if (lastnameTextField.getText() == null || lastnameTextField.getText().length() == 0 || !matcher2.matches()) {
            errorMessage += "Not a valid lastname!\n";
        }
        CharSequence inputStr3 = cityTextField.getText();
        Pattern pattern3 = Pattern.compile(expression);
        Matcher matcher3 = pattern3.matcher(inputStr3);

        if (cityTextField.getText() == null || cityTextField.getText().length() == 0 || !matcher3.matches()) {
            errorMessage += "Not a valid City!\n";
        }
        if (districtComboBox.getValue() == null || districtComboBox.getValue().length() == 0) {
            errorMessage += "Not a Valid Update!\n";
        }
        CharSequence inputStr4 = occupationTextField.getText();
        Pattern pattern4 = Pattern.compile(expression);
        Matcher matcher4 = pattern4.matcher(inputStr4);

        if (occupationTextField.getText() == null || occupationTextField.getText().length() == 0 || !matcher4.matches()) {
            errorMessage += "Not a valid Occupation!\n";
        }


        if (contactnoTextField.getText() == null || contactnoTextField.getText().length() != 10 || contactnoTextField.getText().matches(regex) == false) {
            errorMessage += "No valid Contact Number!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {

            //Alert For Invalid TextFields
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Look, a Warning Dialog");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            // Show the error message

            System.out.println("Validation Successfully Fail");
            return false;
        }
    }


    //This methos for use Searching Patient by ID,Name
    @FXML
    public void searchPatient() {
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

    //This methos for use Searching Patient by FName,Lname,City,District,Address..
    @FXML
    public void searchPatientName() {
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
