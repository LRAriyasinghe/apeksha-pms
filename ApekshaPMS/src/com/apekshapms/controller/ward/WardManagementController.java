package com.apekshapms.controller.ward;

import com.apekshapms.controller.Controller;
import com.apekshapms.database.Connector;
import com.apekshapms.model.Patient;
import com.apekshapms.model.Ward;
import com.sun.org.apache.xpath.internal.operations.String;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.awt.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.Predicate;

/**
 * Created by Thilina on 10/15/2017.
 * Univercity of Colombo School of Computing
 */
public class WardManagementController implements Controller {
    ObservableList<Ward> data = FXCollections.observableArrayList(); //Create Array for store patient data
    PreparedStatement preparedStatement = null;
    ResultSet rs= null;
    FilteredList<Ward> filteredList = new FilteredList<>(data, e->true); //Create list for the Patient store while searching Patient


    @FXML
    private AnchorPane navigationPane;

    @FXML
    private Label lblSearch;

    @FXML
    private TextField patientIdTextField;

    @FXML
    private TextField patientNameTextField;

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

    public void searchWard(){


    }

}
