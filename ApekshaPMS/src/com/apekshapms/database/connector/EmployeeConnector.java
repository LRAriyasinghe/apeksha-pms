package com.apekshapms.database.connector;

import com.apekshapms.controller.Controller;
import com.apekshapms.database.Connector;
import com.apekshapms.main.Main;
import com.apekshapms.model.Employee;
import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeConnector extends Connector {
    private Main mainApp;
    public void newEmployee(Employee employee){
        try {
            //create prepare statement and insert query
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "employee(title,firstName,lastName,door_No, " +
                    "street,city,district,nic_No," +
                    "contact_No,bank,Branch,department,type,dob,bank_acc_no,grade,address,gender) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?)");
            //parse the value in to prepare statement
            preparedStatement.setString(1, employee.getTitle());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setString(4, employee.getDoorNu());
            preparedStatement.setString(5, employee.getStreet());
            preparedStatement.setString(6, employee.getCity());
            preparedStatement.setString(7, employee.getDistric());
            preparedStatement.setString(8, employee.getNic());
            preparedStatement.setString(9, employee.getContactNu());
            preparedStatement.setString(10, employee.getBank());
            preparedStatement.setString(11, employee.getBranch());
            preparedStatement.setString(12, employee.getDepartment());
            preparedStatement.setString(13, employee.getType());
            preparedStatement.setString(14, String.valueOf(employee.getDob()));
            preparedStatement.setString(15, employee.getBank_acc_nu());
            preparedStatement.setString(16, employee.getGrade());
            preparedStatement.setString(17,employee.getAddress());
            preparedStatement.setString(18,String.valueOf(employee.getGender()));

            preparedStatement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//input data insert into admin table
    public void newAdmin(Employee employee){
        try {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "admin(emp_Id,grade) " +
                    "VALUES(?,?)");
            preparedStatement.setString(1,employee.getId() );
            preparedStatement.setString(2, employee.getGrade());

            //succesfully insert into admin table after show succesfully massaage
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText("");
            alert.setContentText("Succussfully Added New Admin");
            alert.showAndWait();alert.setOnCloseRequest(e -> alert.close());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //input data insert into admin table
    public void newSystemEmployee(Employee employee){
        try {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "systememployee(emp_id,type) " +
                    "VALUES(?,?)");
            preparedStatement.setString(1,employee.getId());
            preparedStatement.setString(2, employee.getType());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void newConsultant(Employee employee){
        try {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "consultant(emp_id) " +
                    "VALUES(?)");
            preparedStatement.setString(1,employee.getId() );

            //succesfully insert into  table after show succesfully massaage
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText("");
            alert.setContentText("Succussfully Added New Consultant");
            alert.showAndWait();alert.setOnCloseRequest(e -> alert.close());

            preparedStatement.execute();


        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
    //input data insert into lab assistent table table
    public void newLabAssistant(Employee employee){
        try {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "labassistaant(emp_id,grade) " +
                    "VALUES(?,?)");


            preparedStatement.setString(1,employee.getId() );
            preparedStatement.setString(2,employee.getGrade());

            //succesfully insert into non system employee table after show succesfully massaage
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText("");
            alert.setContentText("Succussfully Added New Lab Assistent");
            alert.showAndWait();alert.setOnCloseRequest(e -> alert.close());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ////input data insert into registar doctor table
    public void newRegisterDoctor(Employee employee){
        try {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "registerdoctor(emp_id,grade) " +
                    "VALUES(?,?)");
            preparedStatement.setString(1,employee.getId() );
            preparedStatement.setString(2,employee.getGrade());

            //succesfully insert into non system employee table after show succesfully massaage
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText("");
            alert.setContentText("Succussfully Added New register doctor");
            alert.showAndWait();alert.setOnCloseRequest(e -> alert.close());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //input data insert into admin table
    public void newNonSystemEmployee(Employee employee){
        try {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "nonsystememployee(emp_id,type) " +
                    "VALUES(?,?)");

            preparedStatement.setString(1,employee.getId() );
            preparedStatement.setString(2,employee.getType());

            //succesfully insert into non system employee table after show succesfully massaage
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText("");
            alert.setContentText("Succussfully Added New Non System Employee");
            alert.showAndWait();alert.setOnCloseRequest(e -> alert.close());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


