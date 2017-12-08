package com.apekshapms.controller.admin;

/**
 * Created by Thilina on 10/21/2017.
 * Univercity of Colombo School of Computing
 */
import com.apekshapms.controller.Controller;
import com.apekshapms.database.Connector;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.Employee;
//import com.sun.jdi.connect.Connector;
import com.apekshapms.model.Patient;
import com.apekshapms.ui.UIName;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;
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
    private TextField fisrtNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField nicTextField;

    @FXML
    private TextField typeTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField districtTextField;

    @FXML
    private TextField contactNuTextField;

    @FXML
    private TextField departmentTextField;

    @FXML
    private HBox buttonHBox;

    @FXML
    private Button backButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField searchEmpNameTextField;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        employeeTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        empIDColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("id"));
        fnameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("firstName"));
        lnameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastName"));
        nicColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("nic"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("type"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("city"));
        districColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("distric"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("contactNu"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("department"));
        loadDatabaseData(); //Load to data to TableView
        searchEmployee(); //Search Employee


        updateButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

                java.lang.String query = "update employee set firstName=?, lastName=?, city=?, district=?, contact_No=?, department=? where emp_Id='"+searchEmpNameTextField.getText()+"' or firstName='" + fisrtNameTextField.getText() +"' or lastName='" + lastNameTextField.getText() + "'";
                try{
                    Connection connection = new Connector().getConnection();
                    preparedStatement=connection.prepareStatement(query);
                    preparedStatement.setString(1,fisrtNameTextField.getText());
                    preparedStatement.setString(2,lastNameTextField.getText());
                    preparedStatement.setString(3,cityTextField.getText());
                    preparedStatement.setString(4,districtTextField.getText());
                    preparedStatement.setString(5,contactNuTextField.getText());
                    preparedStatement.setString(6,departmentTextField.getText());

                    preparedStatement.execute();
                    preparedStatement.close();
                    loadDatabaseData();

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);//Patient Register Confirmation Dialog box
                    alert.setTitle("SuccessFul");
                    alert.setHeaderText("Look, a Confirmation Dialog");
                    alert.setContentText("Employee Details Successfully Updated");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {

                        System.out.println("Yes");
                        // LabReportServices.addFullBloodReport(fullBloodReport);
                    }else {
                        UIFactory.launchUI(UIName.ADMIN_SEARCH_EMPLOYEE, true);
                        // ... user chose CANCEL or closed the dialog
                    }


                }
                catch (SQLException e){
                    e.printStackTrace();
                }

            }
        });


        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                java.lang.String name="null";
                try{
                    Connection connection = new Connector().getConnection();
                    Employee employee=(Employee) employeeTable.getSelectionModel().getSelectedItem();
                    java.lang.String query = "delete from employee where emp_Id=? or or firstName='" + fisrtNameTextField.getText() + "' or lastName='" + lastNameTextField.getText() + "'";
                    preparedStatement=connection.prepareStatement(query);
                    preparedStatement.setString(1,employee.getId());

                    name=employee.getId();
                    preparedStatement.executeUpdate();

                    preparedStatement.close();
                    rs.close();
                    loadDatabaseData();

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);//Patient Register Confirmation Dialog box
                    alert.setTitle("SuccessFul");
                    alert.setHeaderText("Look, a Confirmation Dialog");
                    alert.setContentText("Ready to delete the employee details.Are you Okay?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {

                        System.out.println("Yes");
                        // LabReportServices.addFullBloodReport(fullBloodReport);
                    }else {
                        UIFactory.launchUI(UIName.ADMIN_SEARCH_EMPLOYEE, true);
                        // ... user chose CANCEL or closed the dialog
                    }



                }catch (SQLException e){
                    e.printStackTrace();
                }


            }
        });




    }

    public void loadDatabaseData(){ //Load Data In to TableView
        try {
            Connection connection = new Connector().getConnection();

            fisrtNameTextField.clear();
            lastNameTextField.clear();
            cityTextField.clear();
            districtTextField.clear();
            contactNuTextField.clear();
            departmentTextField.clear();
            data.clear();

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


    public void showOnClick() //Load table view detailsls to text field
    {
        try{
            Connection connection = new Connector().getConnection();
            Employee employee=(Employee)employeeTable.getSelectionModel().getSelectedItem();
            java.lang.String query = "select firstName,lastName,city,district,contact_No,department from employee";
            preparedStatement=connection.prepareStatement(query);

            fisrtNameTextField.setText(employee.getFirstName());
            lastNameTextField.setText(employee.getLastName());
            cityTextField.setText(employee.getCity());
            districtTextField.setText(employee.getDistric());
            contactNuTextField.setText(employee.getContactNu());
            departmentTextField.setText(employee.getDepartment());

        }catch (SQLException e){
            e.printStackTrace();
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

    @FXML
    void displayEmployee(MouseEvent event) {
        //employeeTable.getSelectionModel().getSelectedItem();


    }


}

