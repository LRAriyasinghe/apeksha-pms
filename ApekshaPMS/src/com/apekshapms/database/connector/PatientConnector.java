package com.apekshapms.database.connector;

import com.apekshapms.database.Connector;
import com.apekshapms.model.Patient;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientConnector extends Connector {
    public void newPatient(Patient patient){
        try {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "patient(nic, first_name, middle_name, last_name, gender, dob, " +
                    "blood_group_id, ethnicity_id, description) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, patient.getNic());
            preparedStatement.setString(2, patient.getFirstName());
            preparedStatement.setString(3, patient.getMiddleName());
            preparedStatement.setString(4, patient.getLastName());
            preparedStatement.setString(5, patient.getGender().getTag());
            preparedStatement.setDate(6, java.sql.Date.valueOf(patient.getDob()));
            preparedStatement.setInt(7, patient.getBloodGroupObjectProperty().getId());
            preparedStatement.setInt(8, patient.getEthnicityObjectProperty().getId());
            preparedStatement.setString(9, patient.getDescription());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
