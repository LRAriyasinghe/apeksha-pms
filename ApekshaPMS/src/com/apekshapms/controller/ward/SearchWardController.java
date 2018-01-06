package com.apekshapms.controller.ward;

import com.apekshapms.controller.Controller;
import com.apekshapms.database.Connector;
import com.apekshapms.factory.UIFactory;
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

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchWardController implements Controller{
    //Create Array for store patient data
    ObservableList<Ward> data = FXCollections.observableArrayList();
    PreparedStatement preparedStatement = null;
    ResultSet rs= null;
    //Create list for the Patient store while searching Patient
    FilteredList<Ward> filteredList = new FilteredList<>(data,e->true);



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
    private TextField nameTextField;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private TextField maxPatientCountTextField;
    @FXML
    private TextField supervisorTextField;
    @FXML
    private Button saveButton;
    @FXML
    private Button deleteButton;




    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        //Select Coloumns of the table

        idTableColumn.setCellValueFactory(new PropertyValueFactory<Ward,String>("WardID"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<Ward,String>("WardName"));
        descriptionTableColumn.setCellValueFactory(new PropertyValueFactory<Ward,String>("Description"));
        maxPatientCountTableColumn.setCellValueFactory(new PropertyValueFactory<Ward,String>("MaxPatient_Count"));
        genderTableColumn.setCellValueFactory(new PropertyValueFactory<Ward,String>("Gender_acceptence"));
        supervisorTableColumn.setCellValueFactory(new PropertyValueFactory<Ward,String>("Supervisor"));
        loadDatabaseWard();
        searchWard();

        //Update the ward Details
        saveButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if(isInputValid()) {
                    if(isTextFieldsValid()){
                    java.lang.String query = "update ward set Ward_name=?, Description=?, Max_patients=?, Supervisor=? where Ward_id='" + searchTextField.getText() + "' or Ward_name='" + nameTextField.getText() + "'";
                    try {
                        Connection connection = new Connector().getConnection();
                        preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1, nameTextField.getText());
                        preparedStatement.setString(2, descriptionTextArea.getText());
                        preparedStatement.setString(3, maxPatientCountTextField.getText());
                        preparedStatement.setString(4, supervisorTextField.getText());


                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);//Patient Register Confirmation Dialog box
                        alert.setTitle("SuccessFul");
                        alert.setHeaderText("Look, a Confirmation Dialog");
                        alert.setContentText("Ward Details Successfully Updated");

                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == ButtonType.OK) {

                            System.out.println("Yes");
                            preparedStatement.execute();
                            preparedStatement.close();
                            loadDatabaseWard();

                            // LabReportServices.addFullBloodReport(fullBloodReport);
                        } else {
                            UIFactory.launchUI(UIName.WARD_MANAGEMENT, true);
                            // ... user chose CANCEL or closed the dialog
                        }


                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            }
        });

        //Delete ward details (Here, Ward details flag)
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(isInputValid()){
                java.lang.String name = "null";
                try {
                    Connection connection = new Connector().getConnection();
                    Ward ward = (Ward) wardTableView.getSelectionModel().getSelectedItem();
                    java.lang.String query = "delete from ward where Ward_id=?";
                    preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, ward.getWardID());
                    name = ward.getWardID();
                    preparedStatement.executeUpdate();

                    preparedStatement.close();
                    rs.close();

                    //Delete ward Confirmation Dialog box
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("SuccessFul");
                    alert.setHeaderText("Look, a Confirmation Dialog");
                    alert.setContentText("Ready to delete Ward Details.Are you Okay?");

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
                loadDatabaseWard();
            }
            }}
        );

    }
    //Select Patient and add to TableView
    public void loadDatabaseWard(){

        try {
            Connection connection = new Connector().getConnection();
            nameTextField.clear();
            descriptionTextArea.clear();
            maxPatientCountTextField.clear();
            supervisorTextField.clear();
            data.clear();

            //data.clear();

            preparedStatement = connection.prepareStatement("select * from ward");
            rs=preparedStatement.executeQuery();
            while (rs.next()){
                data.add(new Ward(
                        rs.getString("Ward_id"),
                        rs.getString("Ward_name"),
                        rs.getString("Description"),
                        rs.getString("Max_patients"),
                        rs.getString("Gender_acceptence"),
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
    //Search Field Validation Part
    private boolean isInputValid(){
        java.lang.String errorMessage = "";

        if (searchTextField.getText() == null || searchTextField.getText().length() == 0) {
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
    //Search Field Validation Part
    private boolean isTextFieldsValid() {
        java.lang.String errorMessage = "";

        java.lang.String expression = "^[a-zA-Z]*$";
        java.lang.String regex = "[0-9]+";


        CharSequence inputStr1 = nameTextField.getText();
        Pattern pattern1 = Pattern.compile(expression);
        Matcher matcher1 = pattern1.matcher(inputStr1);

        if (nameTextField.getText() == null || nameTextField.getText().length() == 0 || !matcher1.matches()) {
            errorMessage += "Not a valid Ward Name!\n";
        }

        CharSequence inputStr2 = descriptionTextArea.getText();
        Pattern pattern2 = Pattern.compile(expression);
        Matcher matcher2 = pattern2.matcher(inputStr2);

        if (descriptionTextArea.getText() == null || descriptionTextArea.getText().length() == 0 || descriptionTextArea.getText().length() >= 20 || !matcher2.matches()) {
            errorMessage += "Not a valid description!\n";
        }

        if (maxPatientCountTextField.getText() == null || maxPatientCountTextField.getText().length() ==0 || maxPatientCountTextField.getText().matches(regex) == false) {
            errorMessage += "Not a Max Patient Value!\n";
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


            return false;

        }


    }

public void showOnClick() //Load table view detailsls to text field
    {
        try{
            Connection connection = new Connector().getConnection();
            Ward ward=(Ward) wardTableView.getSelectionModel().getSelectedItem();
            java.lang.String query = "select ward_name,Description,Max_patients,Supervisor from patient";
            preparedStatement=connection.prepareStatement(query);


            nameTextField.setText(ward.getWardName());
            descriptionTextArea.setText(ward.getDescription());
            maxPatientCountTextField.setText(ward.getMaxPatient_Count());
            supervisorTextField.setText(ward.getSupervisor());
            searchTextField.setText(ward.getWardID());


        }catch (SQLException e){
            e.printStackTrace();
        }
    }

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
