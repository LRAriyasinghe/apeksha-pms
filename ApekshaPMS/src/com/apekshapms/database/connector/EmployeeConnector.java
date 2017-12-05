package com.apekshapms.database.connector;

import com.apekshapms.database.Connector;
import com.apekshapms.model.Employee;
import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeConnector extends Connector {
    public void newEmployee(Employee employee){
//        try {
//            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
//                    "patient(patient_Id,title, first_name, last_name,nic_No, dob,gender, " +
//                    "occupation, civil_Status, contact_No,address,city,district,registerDoctor_emp_Id," +
//                    "additional_Details,consultant_emp_Id) " +
//                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
//            preparedStatement.setString(1, employee.getId());
//            preparedStatement.setString(2, employee.getTitle());
//            preparedStatement.setString(3, patient.getFirstName());
//            preparedStatement.setString(4, patient.getLastName());
//            preparedStatement.setString(5, patient.getNicNo());
//            preparedStatement.setString(6, String.valueOf(patient.getDob()));
//            preparedStatement.setString(7, String.valueOf(patient.isMale()));
//            preparedStatement.setString(8, patient.getOccupation());
//            preparedStatement.setString(9, String.valueOf(patient.isCivil()));
//            preparedStatement.setString(10, patient.getTelephone());
//            preparedStatement.setString(11, patient.getAddress());
//            preparedStatement.setString(12, patient.getCity());
//            preparedStatement.setString(13, patient.getDistrict());
//            preparedStatement.setString(14, patient.getRegisterDocId());
//            preparedStatement.setString(15, patient.getDetails());
//            preparedStatement.setString(16, patient.getConsultantId());
//
//
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Message");
//            alert.setHeaderText("");
//            alert.setContentText("Succussfully Added");
//            alert.showAndWait();
//            alert.setOnCloseRequest(e -> alert.close());
//
//
//            preparedStatement.execute();
//
//
//        } catch (SQLException e) {
//
//            e.printStackTrace();
//        }


    }
}
