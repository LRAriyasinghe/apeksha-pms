package com.apekshapms.database.connector;

import com.apekshapms.database.Connector;
import com.apekshapms.model.Patient;
import com.apekshapms.model.Treatment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class TreatmentConnector extends Connector {

    //Insert new Treatment
    public static void newTreatment(Treatment treatment) {


        try {

            Connection connection = new Connector().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `treatment`(`treat_Id`, `description`, `date`, `patient_Id`, `type`, `Consultant_id`, `venue`) " + "VALUES(?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, treatment.getDescription());
            preparedStatement.setString(3,String.valueOf(treatment.getDate()));//Timestamp.valueOf(LocalDateTime.of(Integer.parseInt(String.valueOf(treatment.getDate().getYear())),Integer.parseInt(String.valueOf(treatment.getDate().getMonth())),treatment.getDate().getDayOfMonth(),treatment.getTime().getHour(),treatment.getTime().getMinute())));
            preparedStatement.setString(4, treatment.getPatientId());
            preparedStatement.setString(5, treatment.getEmpId());
            preparedStatement.setString(6, treatment.getType());
            preparedStatement.setString(7, treatment.getVenue());
            preparedStatement.executeUpdate();
            //close the connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //retrive all treatments from
    public static ObservableList<Treatment> allTreatmentsOfPatient(int patientId) {
        ObservableList<Treatment> data = FXCollections.observableArrayList();

        try {
            Connection connection = new Connector().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from treatment WHERE patient_id=" + patientId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Treatment treatment = new Treatment();
                treatment.setTreatId(rs.getInt("treat_Id"));
                // treatment.setTreatName(rs.getString("treat_Name"));
                treatment.setDescription(rs.getString("description"));
                treatment.setDate(rs.getDate("date").toLocalDate());
                treatment.setPatientId(rs.getString("patient_Id"));
                //treatment.setEmpId(rs.getString("emp_Id"));
                treatment.setType(rs.getString("type"));
                treatment.setTime(rs.getTime("date").toLocalTime());
                treatment.setVenue(rs.getString("venue"));
                //treatment.setAdditionalDetails(rs.getString("additional_Details"));
                //treatment.setNextVisitDetails(rs.getString("next_Visit_Details"));
                data.add(treatment);
            }
            rs.close();
            preparedStatement.close(); //Close the Connection

        } catch (Exception e) {
            System.err.println(e);
        }


        return data;

    }


}
