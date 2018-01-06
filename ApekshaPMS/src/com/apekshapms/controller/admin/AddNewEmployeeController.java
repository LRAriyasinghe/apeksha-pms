package com.apekshapms.controller.admin;

import com.apekshapms.controller.Controller;
import com.apekshapms.controller.DashboardController;
import com.apekshapms.database.Connector;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.Employee;
import com.apekshapms.services.EmployeeServices;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import com.mysql.jdbc.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.sql.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.ResourceBundle;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javafx.scene.input.KeyCode.R;
import static javafx.scene.input.KeyCode.U;


public class AddNewEmployeeController implements Controller {
    @FXML
    private AnchorPane backgroundAnchorPane;

    @FXML
    private TextField txtIdNo;

    @FXML
    private TextField txtFirstname;

    @FXML
    private TextField txtDoorNo;

    @FXML
    private TextField txtStreet;

    @FXML
    private TextField txtBank;

    @FXML
    private TextField txtBranch;

    @FXML
    private TextField txtContactNo;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtLastname;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtDepartment;

    @FXML
    private DatePicker dobDayePicker;

    @FXML
    private TextField txtBankacc;

    @FXML
    private Button submit;

    @FXML
    private TextArea txtAddress;


    @FXML
    private Button backButton;

    @FXML
    private Button CancelButton;

    @FXML
    private ChoiceBox<String> districtChoiceBox;

    @FXML
    private ChoiceBox<String> genderChoiceBox;

    @FXML
    private ChoiceBox<String> titleChoiceBox;


    @FXML
    private ChoiceBox<String> typeChoiceBox;

   @FXML
   private ChoiceBox<String> gradeChoiceBox;


   //Get Observable List for Above District
    private ObservableList distrct = FXCollections.observableArrayList();

    //Get Observable List for Above Employee Type
    private ObservableList type = FXCollections.observableArrayList();

    ////Get Observable List for Above Grade
   private ObservableList grade = FXCollections.observableArrayList();

    //Get Observable List for Above Gender
    private ObservableList gender = FXCollections.observableArrayList();

    //Get Observable List for Above Title
    private ObservableList title = FXCollections.observableArrayList();

    //Get new Employee
    private Employee employee;

    //Handle Action Event for Back button then go to the Employee Dashboard
    @FXML
    void handleBackOnAction(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.EMPLOYEE_DASHBOARD);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);

    }




    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Adding all District  for District ChoiceBox
        distrct.addAll("Jaffna", "Kilinochchi", "Mannar", "Mullaitivu", "Vavuniya", "Puttalam", "Kurunegala", "Gampaha", "Colombo", "Kalutara", "Anuradhapura", "Polonnaruwa", "Matale", "Kandy", "Nuwara Eliya", "Kegalle", "Ratnapura", "Trincomalee", "Batticaloa", "Ampara", "Badulla", "Monaragala", "Hambantota", "Matara", "Galle");
        districtChoiceBox.setItems(distrct);
        districtChoiceBox.setValue("Colombo");

        //Adding all Employee Type  for Type ChoiceBox
        type.addAll("Admin", "Consultant", "Lab Assistent", "Register Doctor", "Non Employee");
        typeChoiceBox.setItems(type);
        typeChoiceBox.setValue("Admin");

        //Adding all Employee grade  for grade ChoiceBox
        grade.addAll("A","B","C");
        gradeChoiceBox.setItems(grade);
        gradeChoiceBox.setValue("A");

        //Adding  Gender  for Gender ChoiceBox
        gender.addAll("Male","Female");
        genderChoiceBox.setItems(gender);
        genderChoiceBox.setValue("Male");

        //Adding Title Type  for Title ChoiceBox
        title.addAll("Mr","Mrs");
        titleChoiceBox.setItems(title);
        titleChoiceBox.setValue("Mr");

        //get New Employee
        employee = new Employee();

        //Action event for Submit Butoon
        submit.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {

                        //String id = txtIdNo.getText();
                        //Check Validity empty input
                        if (isInputValid()) {


                            //employee.setId(txtIdNo.getText());
                            employee.setFirstName(txtFirstname.getText());
                            employee.setLastName(txtLastname.getText());
                            employee.setDoorNu(txtDoorNo.getText());
                            employee.setStreet(txtStreet.getText());
                            employee.setCity(txtCity.getText());
                            employee.setDistric(districtChoiceBox.getValue());
                            employee.setNic(txtNic.getText());
                            employee.setContactNu(txtContactNo.getText());
                            employee.setBank(txtBank.getText());
                            employee.setBranch(txtBranch.getText());
                            employee.setDepartment(txtDepartment.getText());
                            employee.setType(typeChoiceBox.getValue());
                            employee.setDob(dobDayePicker.getValue());
                            employee.setBank_acc_nu(txtBankacc.getText());
                            employee.setGrade(gradeChoiceBox.getValue());
                            employee.setAddress(txtAddress.getText());
                            employee.setGender(genderChoiceBox.getValue());
                           employee.setTitle(titleChoiceBox.getValue());

                            System.out.println(titleChoiceBox.getValue());

                            //System.out.println("Ok");
                            EmployeeServices.addEmployee(employee); //Add new Employee
                            System.out.println("fgffgfgfgffggfg");


                            //Add New Admin
                          if (typeChoiceBox.getValue()=="Admin"){
                              employee.setId(String.valueOf(new AddNewEmployeeController().employeeid()));

                              System.out.println("gunawar");
                                EmployeeServices.addNewSystemEmployee(employee);

                                EmployeeServices.addNewAdmin(employee);




                            }
                            //Add new Consultant
                            else if(typeChoiceBox.getValue()=="Consultant"){

                              employee.setId(String.valueOf(new AddNewEmployeeController().employeeid()));
                                System.out.println("gunawar");
                                EmployeeServices.addNewSystemEmployee(employee);
                                EmployeeServices.addNewConsultant(employee);

                            }
                          //Add new Lab Assistant
                            else if(typeChoiceBox.getValue()=="Lab Assistent"){

                              employee.setId(String.valueOf(new AddNewEmployeeController().employeeid()));
                                System.out.println("gunawar");
                                EmployeeServices.addNewSystemEmployee(employee);
                                EmployeeServices.addNewLabAssistant(employee);




                            }
                            //Add new Register Docter
                          else if(typeChoiceBox.getValue()=="Register Doctor"){

                              employee.setId(String.valueOf(new AddNewEmployeeController().employeeid()));
                              System.out.println("gunawar");
                              EmployeeServices.addNewSystemEmployee(employee);
                              EmployeeServices.addNewRegisterDoctor(employee);

                          }
                          //Add non system employee
                            else if(typeChoiceBox.getValue()=="Non Employee"){

                              employee.setId(String.valueOf(new AddNewEmployeeController().employeeid()));
                              System.out.println("gunawar");

                              EmployeeServices.addNewNonSystemEmployeee(employee);

                          }
                            txtFirstname.setText("");
                            txtLastname.setText("");
                            txtDoorNo.setText("");
                            txtStreet.setText("");
                            txtCity.setText("");
                            txtNic.setText("");
                            txtContactNo.setText("");
                            txtBank.setText("");
                            txtBranch.setText("");
                            txtDepartment.setText("");
                            txtBankacc.setText("");
                            txtAddress.setText("");
                        }



                    }
                });


        //Cancel Button Action event
        CancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UI ui = UIFactory.getUI(UIName.APEKSHA_HOME);
                Parent parent = ui.getParent();
                DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
                dashboardController.setWorkspace(parent);
            }
        });


    }



    //Validation
    private boolean isInputValid() {
        String errorMessage = "";

         String expression = "^[a-zA-Z]*$";

        CharSequence inputStr1 = txtDoorNo.getText();
        Pattern pattern1 = Pattern.compile(expression);
        Matcher matcher1 = pattern1.matcher(inputStr1);

        if (txtDoorNo.getText() == null || txtDoorNo.getText().length() == 0||!matcher1.matches()) {
            errorMessage += "No valid Door No!\n";
        }

        CharSequence inputStr2 = txtStreet.getText();
        Pattern pattern2 = Pattern.compile(expression);
        Matcher matcher2 = pattern2.matcher(inputStr2);

        if (txtStreet.getText() == null || txtStreet.getText().length() == 0||txtDoorNo.getText().length() >=20||!matcher2.matches()) {
            errorMessage += "No valid Street!\n";
        }

        CharSequence inputStr3 = txtCity.getText();
        Pattern pattern3 = Pattern.compile(expression);
        Matcher matcher3 = pattern3.matcher(inputStr3);

        if (txtCity.getText() == null || txtCity.getText().length() == 0||txtDoorNo.getText().length() >=20||!matcher3.matches()) {
            errorMessage += "No valid City!\n";
        }

        CharSequence inputStr4 = txtDepartment.getText();
        Pattern pattern4 = Pattern.compile(expression);
        Matcher matcher4 = pattern4.matcher(inputStr4);

        if (txtDepartment.getText() == null || txtDepartment.getText().length() == 0||txtDoorNo.getText().length() >=20||!matcher4.matches()) {
            errorMessage += "No valid Department!\n";
        }
        String regex = "[0-9]+";

        if (txtContactNo.getText() == null || txtContactNo.getText().length() != 10 || txtContactNo.getText().matches(regex) == false) {
            errorMessage += "No valid Contact Number!\n";
        }
        if (!txtNic.getText().trim().matches("^[0-9]{9}[V]$") || txtNic.getText() == null || txtNic.getText().length() != 10) {
            errorMessage += "No valid NIC!\n";
        }

        if (txtBankacc.getText() == null || txtBankacc.getText().length() == 0|| txtBankacc.getText().matches(regex) == false) {
            errorMessage += "No valid Bank Account!\n";
        }
        CharSequence inputStr6 = txtFirstname.getText();
        Pattern pattern6 = Pattern.compile(expression);
        Matcher matcher6 = pattern6.matcher(inputStr6);
        if (txtFirstname.getText() == null || txtFirstname.getText().length() == 0||!matcher6.matches()) {
            errorMessage += "No valid First Name!\n";
        }
        CharSequence inputStr7 = txtBank.getText();
        Pattern pattern7 = Pattern.compile(expression);
        Matcher matcher7 = pattern7.matcher(inputStr7);
        if (txtBank.getText() == null || txtBank.getText().length() == 0||!matcher7.matches()) {
            errorMessage += "No valid Bank!\n";
        }
        CharSequence inputStr8 = txtBranch.getText();
        Pattern pattern8 = Pattern.compile(expression);
        Matcher matcher8 = pattern8.matcher(inputStr8);
        if (txtBranch.getText() == null || txtBranch.getText().length() == 0||!matcher8.matches()) {
            errorMessage += "No valid Branch!\n";
        }
        CharSequence inputStr9 = txtLastname.getText();
        Pattern pattern9 = Pattern.compile(expression);
        Matcher matcher9 = pattern9.matcher(inputStr9);
        if (txtLastname.getText() == null || txtLastname.getText().length() == 0||!matcher9.matches()) {
            errorMessage += "No valid Last Name!\n";
        }

        if (txtAddress.getText() == null || txtAddress.getText().length() == 0) {
            errorMessage += "No valid Address!\n";
        }

        if (dobDayePicker.getValue() == null || dobDayePicker.getValue().lengthOfYear() == 0) {
            errorMessage += "No valid Date!\n";
        }



        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //get current date time with Date()
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        System.out.println(dobDayePicker.getValue());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1, date2;
        try {
            date1 = sdf.parse(dateFormat.format(date));
            date2 = sdf.parse(String.valueOf(dobDayePicker.getValue()));

            if (date2.compareTo(date1) > 0) {
                //System.out.println("Date1 is after Date2");
                errorMessage += "No valid Date!\n";
            }


        } catch (ParseException e) {
            // e.printStackTrace();
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


        //get the Maximim Employee ID in the database
    public int employeeid() {
        Connection connection = (Connection) new Connector().getConnection();
        int tempEmpId = 0;
        try {
            System.out.println("dulk");
            PreparedStatement pr = (PreparedStatement) connection.prepareStatement("SELECT MAX(emp_id) FROM employee");
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                tempEmpId= rs.getInt(1);
            }
            System.out.println("temEmpl");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tempEmpId;


    }


}

