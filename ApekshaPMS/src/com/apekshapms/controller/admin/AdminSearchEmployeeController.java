package com.apekshapms.controller.admin;

/**
 * Created by Thilina on 10/21/2017.
 * Univercity of Colombo School of Computing
 */
import com.apekshapms.controller.Controller;
import com.apekshapms.database.Connector;
import com.apekshapms.model.Employee;
//import com.sun.jdi.connect.Connector;
import com.apekshapms.model.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class AdminSearchEmployeeController implements Controller {

    ObservableList<Employee> data = FXCollections.observableArrayList();
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    FilteredList<Employee> filteredList = new FilteredList<>(data, e->true); //Create list for the Employee store while searching Employee

    private Employee employee;


    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private TableColumn<Employee, String> empIDColumn;

    @FXML
    private TableColumn<Employee, String> fnameColumn;

    @FXML
    private TableColumn<Employee, String> lnameColumn;

    @FXML
    private TableColumn<Employee, String> nicColumn;

    @FXML
    private TableColumn<Employee, String> typeColumn;

    @FXML
    private TableColumn<Employee, String> cityColumn;

    @FXML
    private TableColumn<Employee, String> districColumn;

    @FXML
    private TableColumn<Employee, String> contactColumn;

    @FXML
    private TableColumn<Employee, String> departmentColumn;

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

        empIDColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("emp_Id"));
        fnameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("firstName"));
        lnameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastName"));
        nicColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("nic_No"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("type"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("city"));
        districColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("district"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("contact_No"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("department"));

        try {
            loadDatabaseData(); //Load to data to TableView
            searchEmployee(); //Search Employee
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }

    public void loadDatabaseData() throws SQLException { //Load Data In to TableView
        try {
            Connection connection = new Connector().getConnection();
            preparedStatement = connection.prepareStatement("select * from employee");
            rs=preparedStatement.executeQuery();
            while (rs.next()){
                data.add(new Employee(
                        rs.getString("emp_Id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("nic_No"),
                        rs.getString("type"),
                        rs.getString("city"),
                        rs.getString("district"),
                        rs.getString("contact_No"),
                        rs.getString("department")

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

    @FXML
    public void searchEmployee() { //This methos for use Searching Patient by FName,Lname,City,District,Address...
        searchEmpNameTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate((Predicate<? super Employee>) employee->{
                if (newValue==null||newValue.isEmpty()){
                    return true;
                }
                java.lang.String lowerCaseFilter = newValue.toLowerCase();
                if (employee.getFirstName().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if(employee.getLastName().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if(employee.getCity().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if(employee.getId().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if(employee.getDistric().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if(employee.getNic().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                return false;
            });

        });
        SortedList<Employee> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(employeeTable.comparatorProperty());
        employeeTable.setItems(sortedList);

    }


}

