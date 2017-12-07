package com.apekshapms.database.connector;

import com.apekshapms.database.Connector;
import com.apekshapms.main.Main;
import com.apekshapms.model.Employee;
import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeConnector extends Connector {
    private Main mainApp;
    public void newEmployee(Employee employee){
        System.out.println("Ok");
        try {
            //System.out.println("Ok");

            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "employee(emp_Id, firstName, lastName,door_No, " +
                    "street,city,district,nic_No," +
                    "contact_No,bank,Branch,department,type,dob) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
            preparedStatement.setString(1, employee.getId());
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

            System.out.println("Ok");


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Message");
           alert.setHeaderText("");
           alert.setContentText("Succussfully Added");
           alert.showAndWait();alert.setOnCloseRequest(e -> alert.close());


            preparedStatement.execute();


        } catch (SQLException e) {

            e.printStackTrace();
        }

    }
}
