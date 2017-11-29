package com.apekshapms.controller.admin;

/**
 * Created by Thilina on 10/21/2017.
 * Univercity of Colombo School of Computing
 */
import com.apekshapms.controller.Controller;
import com.apekshapms.model.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AdminSearchEmployeeController implements Controller {

    ObservableList<Employee> data = FXCollections.observableArrayList();
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;

    private Connection connection;
    private String url;
    private String userName;
    private String password;
    private String dbName;

    private Employee employee;


    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private TableColumn<Employee, String> fnameColumn;

    @FXML
    private TableColumn<Employee, String> lnameColumn;

    @FXML
    private TableColumn<Employee, String> nicColumn;

    @FXML
    private TableColumn<Employee, String> typeColumn;

    @FXML
    private TableColumn<Employee, String> doorNuColumn;

    @FXML
    private TableColumn<Employee, String> streetColumn;

    @FXML
    private TableColumn<Employee, String> cityColumn;

    @FXML
    private TableColumn<Employee, String> districColumn;

    @FXML
    private TableColumn<Employee, String> contactColumn;

    @FXML
    private TableColumn<Employee, String> departmentColumn;

    @FXML
    private TableColumn<Employee, LocalDate> dobColumn;

    @FXML
    private TableColumn<Employee, String> bankColumn;

    @FXML
    private TableColumn<Employee, String> branchColumn;

    @FXML
    private TableColumn<Employee, String> empIDColumn;

    @FXML
    private HBox buttonHBox;

    @FXML
    private Button newButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField searchEmpNameTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        employeeTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        fnameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("firstName"));
        lnameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastName"));
        doorNuColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("door_No"));
        streetColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("street"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("city"));
        districColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("district"));
        nicColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("nic_No"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("contact_No"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("department"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("type"));
        //dobColumn.setCellValueFactory(new PropertyValueFactory<Employee,LocalDate>("dob"));
        empIDColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("emp_Id"));
        bankColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("bank"));
        branchColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("Branch"));
        try {
            loadDatabaseData();
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }

    public void loadDatabaseData() throws SQLException {
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
            preparedStatement = connection.prepareStatement("select * from employee");
            //preparedStatement = preparedStatement.getConnection().prepareStatement("select * from employee");
            rs=preparedStatement.executeQuery();

            while (rs.next()){
                data.add(new Employee(
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("door_No"),
                        rs.getString("street"),
                        rs.getString("city"),
                        rs.getString("district"),
                        rs.getString("nic_No"),
                        rs.getString("contact_No"),
                        rs.getString("department"),
                        rs.getString("type"),
                        rs.getString("emp_Id"),
                        rs.getString("bank"),
                        rs.getString("Branch")


                        ));
                employeeTable.setItems(data);
                employeeTable.setTableMenuButtonVisible(true);

            }
            preparedStatement.close();
            rs.close();
        }catch (Exception e){
            System.err.println(e);

        }


    }

    @FXML
    void handleDeleteButton(ActionEvent event) {

    }

    @FXML
    void handleUpdateButton(ActionEvent event) {

    }

    @FXML
    void hanldeNewButton(ActionEvent event) {

    }

    @Override
    public void refreshView() {

    }


}

