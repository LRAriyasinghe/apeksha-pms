package com.apekshapms.controller.admin;

/**
 * Created by Thilina on 10/21/2017.
 * Univercity of Colombo School of Computing
 */
import com.apekshapms.controller.Controller;
import com.apekshapms.controller.DashboardController;
import com.apekshapms.database.Connector;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.Employee;
//import com.sun.jdi.connect.Connector;
import com.apekshapms.model.Patient;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminSearchEmployeeController implements Controller {

    ObservableList<Employee> data = FXCollections.observableArrayList();
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    //Create list for the Employee store while searching Employee

    FilteredList<Employee> filteredList = new FilteredList<>(data, e->true);
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
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField nicTextField;

    @FXML
    private TextField typeTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private ComboBox<String> districtComboBox;

    @FXML
    private TextField contactNuTextField;

    @FXML
    private ComboBox<String> departmentComboBox;

    @FXML
    private Button cancelButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField searchEmpNameTextField;

    private ObservableList district = FXCollections.observableArrayList();
    private ObservableList department = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        district.addAll("Jaffna","Kilinochchi","Mannar","Mullaitivu","Vavuniya","Puttalam","Kurunegala","Gampaha","Colombo","Kalutara","Anuradhapura","Polonnaruwa","Matale","Kandy","Nuwara Eliya","Kegalle","Ratnapura","Trincomalee","Batticaloa","Ampara","Badulla","Monaragala","Hambantota","Matara","Galle");
        districtComboBox.setItems(district);
        department.addAll("OPD","Emergency","Child Unit","leukemia");
        departmentComboBox.setItems(department);

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
                if(isInputValid()) {
                    if(isTextFieldsValid()){
                    String query = "update employee set firstName=?, lastName=?, city=?, district=?, contact_No=?, department=? where emp_Id='" + searchEmpNameTextField.getText() + "' or firstName='" + firstNameTextField.getText() + "' or lastName='" + lastNameTextField.getText() + "'";
                    try {
                        Connection connection = new Connector().getConnection();
                        preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1, firstNameTextField.getText());
                        preparedStatement.setString(2, lastNameTextField.getText());
                        preparedStatement.setString(3, cityTextField.getText());
                        preparedStatement.setString(4, districtComboBox.getValue());
                        preparedStatement.setString(5, contactNuTextField.getText());
                        preparedStatement.setString(6, departmentComboBox.getValue());

                        preparedStatement.execute();
                        preparedStatement.close();
                        loadDatabaseData();

                        //Patient Register Confirmation Dialog box
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("SuccessFul");
                        alert.setHeaderText("Look, a Confirmation Dialog");
                        alert.setContentText("Employee Details Successfully Updated");

                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == ButtonType.OK) {

                            System.out.println("Yes");
                            // LabReportServices.addFullBloodReport(fullBloodReport);
                        } else {
                            UIFactory.launchUI(UIName.ADMIN_SEARCH_EMPLOYEE, true);
                            // ... user chose CANCEL or closed the dialog
                        }


                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                }
            }
        });
        // Flag the Employee from the database
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(isInputValid()){
                String name = "null";
                try {
                    Connection connection = new Connector().getConnection();
                    Employee employee = (Employee) employeeTable.getSelectionModel().getSelectedItem();
                    String query = "update employee set state = '0',del_date_time = NOW() where emp_Id='" + searchEmpNameTextField.getText() + "' or firstName='" + firstNameTextField.getText() + "' or lastName='" + lastNameTextField.getText() + "'";
                    preparedStatement = connection.prepareStatement(query);
                    name = employee.getId();
                    preparedStatement.executeUpdate();
                    preparedStatement.close();
                    rs.close();
                    loadDatabaseData();


                    //Patient Register Confirmation Dialog box
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("SuccessFul");
                    alert.setHeaderText("Look, a Confirmation Dialog");
                    alert.setContentText("Ready to delete the employee details.Are you Okay?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {

                        System.out.println("Yes");
                        // LabReportServices.addFullBloodReport(fullBloodReport);
                    } else {
                        UIFactory.launchUI(UIName.ADMIN_SEARCH_EMPLOYEE, true);
                        // ... user chose CANCEL or closed the dialog
                    }


                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            }
        });

        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UI ui = UIFactory.getUI(UIName.APEKSHA_HOME);
                Parent parent = ui.getParent();
                DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
                dashboardController.setWorkspace(parent);
            }
        });
    }

    public void loadDatabaseData(){ //Load Data In to TableView
        try {
            Connection connection = new Connector().getConnection();

            firstNameTextField.clear();
            lastNameTextField.clear();
            cityTextField.clear();
            contactNuTextField.clear();
            districtComboBox.setValue("");
            departmentComboBox.setValue("");
            searchEmpNameTextField.clear();
            data.clear();

            preparedStatement = connection.prepareStatement("select * from employee where state LIKE '1'");
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

    public void showOnClick() //Load table view details to text fields
    {
        try{
            Connection connection = new Connector().getConnection();
            Employee employee=(Employee)employeeTable.getSelectionModel().getSelectedItem();
            String query = "select firstName,lastName,city,district,contact_No,department from employee";
            preparedStatement=connection.prepareStatement(query);

            searchEmpNameTextField.setText(employee.getId());
            firstNameTextField.setText(employee.getFirstName());
            lastNameTextField.setText(employee.getLastName());
            cityTextField.setText(employee.getCity());
            districtComboBox.setValue(employee.getDistric());
            contactNuTextField.setText(employee.getContactNu());
            departmentComboBox.setValue(employee.getDepartment());

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void refreshView() {

    }

    //Search Field Validation Part
    private boolean isInputValid(){
        String errorMessage = "";

        if (searchEmpNameTextField.getText() == null || searchEmpNameTextField.getText().length() == 0) {
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
            //Dialogs.showWarningDialog(new Stage(), "Careful with the next step!", "Warning Dialog", "title");

            return false;
        }
    }
    private boolean isTextFieldsValid(){ //Validate the updated fields
        String errorMessage = "";

        String expression = "^[a-zA-Z]*$";
        String regex = "[0-9]+";


        CharSequence inputStr1 = firstNameTextField.getText();
        Pattern pattern1 = Pattern.compile(expression);
        Matcher matcher1 = pattern1.matcher(inputStr1);

        if (firstNameTextField.getText() == null || firstNameTextField.getText().length() == 0 || !matcher1.matches()) {
            errorMessage += "Not a valid FirstName!\n";
        }
        CharSequence inputStr2 = lastNameTextField.getText();
        Pattern pattern2 = Pattern.compile(expression);
        Matcher matcher2 = pattern2.matcher(inputStr2);

        if (lastNameTextField.getText() == null || lastNameTextField.getText().length() == 0 || !matcher2.matches()) {
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
        if (departmentComboBox.getValue() == null || departmentComboBox.getValue().length() == 0) {
            errorMessage += "Not a Valid Update!\n";
        }

        if (contactNuTextField.getText() == null || contactNuTextField.getText().length() != 10 || contactNuTextField.getText().matches(regex) == false) {
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

    //This methos for use Searching Patient by FName,Lname,City,District,Address...
    @FXML
    public void searchEmployee() {
        searchEmpNameTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate((Predicate<? super Employee>) employee->{
                if (newValue==null||newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (employee.getId().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if (employee.getFirstName().toLowerCase().contains(lowerCaseFilter)){
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

