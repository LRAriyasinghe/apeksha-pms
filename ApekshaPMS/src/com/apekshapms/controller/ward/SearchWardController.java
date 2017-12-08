package com.apekshapms.controller.ward;

import com.apekshapms.controller.Controller;
import com.apekshapms.database.Connector;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.Patient;
import com.apekshapms.model.Ward;
import com.apekshapms.ui.UIName;
import com.sun.org.apache.xpath.internal.operations.String;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class SearchWardController implements Controller{
    ObservableList<Ward> data = FXCollections.observableArrayList(); //Create Array for store patient data
    PreparedStatement preparedStatement = null;
    ResultSet rs= null;
    FilteredList<Ward> filteredList = new FilteredList<>(data,e->true); //Create list for the Patient store while searching Patient

    @FXML
    private AnchorPane navigationPane;

    @FXML
    private javafx.scene.control.Label lblSearch;

    @FXML
    private javafx.scene.control.TextField patientIdTextField;

    @FXML
    private javafx.scene.control.TextField patientNameTextField;

    @FXML
    private AnchorPane managePane;

    @FXML
    private TableView<Ward> wardTableView;

    @FXML
    private TableColumn<Ward, String> idTableColumn;

    @FXML
    private TableColumn<Ward, String> nameTableColumn;

    @FXML
    private TableColumn<Ward, String> descriptionTableColumn;

    @FXML
    private TableColumn<Ward, String> maxPatientCountTableColumn;
    @FXML
    private TableColumn<Ward, String> genderTableColumn;

    @FXML
    private TableColumn<Ward, String> supervisorTableColumn;



    @FXML
    private TextField searchTextField;
    @FXML
    private TextField idTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private TextField maxPatientCountTextField;
    @FXML
    private TextField supervisorTextField;
    @FXML
    private Button saveButton;




    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        //Select Coloumns of the table

        idTableColumn.setCellValueFactory(new PropertyValueFactory<Ward,String>("WardID"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Ward,String>("WardName"));
        descriptionTableColumn.setCellValueFactory(new PropertyValueFactory<Ward,String>("Description"));
        maxPatientCountTableColumn.setCellValueFactory(new PropertyValueFactory<Ward,String>("Max_patients"));
        genderTableColumn.setCellValueFactory(new PropertyValueFactory<Ward,String>("Gender_acceptence"));
        supervisorTableColumn.setCellValueFactory(new PropertyValueFactory<Ward,String>("Supervisor"));
        loadDatabaseWard();
        searchWard();

    }


    public void loadDatabaseWard(){ //Select Patient and add to TableView


        try {
            Connection connection = new Connector().getConnection();


            //data.clear();

            preparedStatement = connection.prepareStatement("select Ward_id,Ward_name,Description,Max_patients,Gender_acceptence,Supervisor from ward");
            rs=preparedStatement.executeQuery();
            while (rs.next()){
                data.add(new Ward(
                        rs.getString("Ward_id"),
                        rs.getString("Ward_name"),
                        rs.getString("Description"),
                        rs.getString("Max_patients"),
                        rs.getBoolean("Gender_acceptence"),
                        rs.getString("Supervisor")
                ));
                wardTableView.setItems(data);
                wardTableView.setTableMenuButtonVisible(true);
            }
            preparedStatement.close(); //Close the Connection
            rs.close();

        }catch (Exception e){
            System.err.println(e);
        }
    }

        /*saveButton.setOnAction(new EventHandler<ActionEvent>(){
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
        }*/
      /*  );
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
            loadDatabaseWard();

            }
        }
        );



    }

*/


   /* public void showOnClick() //Load table view detailsls to text field
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
    }*/


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
    public void searchWard() { //This methos for use Searching Patient by ID,Name
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate((Predicate<? super Ward>)ward->{
                if (newValue==null||newValue.isEmpty()){
                    return true;
                }
                java.lang.String lowerCaseFilter = newValue.toLowerCase();
                if (ward.getWardID().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if(ward.getWardName().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                return false;
            });

        });
        SortedList<Ward> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(wardTableView.comparatorProperty());
        wardTableView.setItems(sortedList);

    }



}
