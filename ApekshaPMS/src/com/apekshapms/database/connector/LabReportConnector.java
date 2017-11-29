package com.apekshapms.database.connector;

import com.apekshapms.database.Connector;
import com.apekshapms.main.Main;
import com.apekshapms.model.LabReport;
import com.apekshapms.model.LabReport2;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Thilina on 10/13/2017.
 * Univercity of Colombo School of Computing
 */
public class LabReportConnector extends Connector {
    private Main mainApp;
    public void newLabReport(LabReport labReport){
        try {
            PreparedStatement preparedStatement = (PreparedStatement)getConnection().prepareStatement("INSERT INTO " +
                    "report(patient_Id,title, first_name, last_name,nic_No, dob,gender, " +
                    "occupation, civil_Status) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, labReport.getID());
            preparedStatement.setString(2, labReport.getName());
            preparedStatement.setString(3, String.valueOf(labReport.getDate()));
            preparedStatement.setString(4, labReport.getSerB());
            preparedStatement.setString(5, labReport.getSGOT());
            preparedStatement.setString(6, labReport.getSGPT());
            preparedStatement.setString(7, labReport.getSerAlk());
            preparedStatement.setString(8, labReport.getSerCre());
            preparedStatement.setString(9, labReport.getSerCal());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void newLabReportUrine(LabReport labReport){
        try {
            PreparedStatement preparedStatement = (PreparedStatement)getConnection().prepareStatement("INSERT INTO " +
                    "urine_for_bence_jones_protein_report(patient_id,patient_name, reference, date,albumine, bencejones,remarks, " +
                    "occupation, civil_Status) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, labReport.getID());
            preparedStatement.setString(2, labReport.getName());
            preparedStatement.setString(3, labReport.getReference());
            preparedStatement.setString(4, String.valueOf(labReport.getDate()));
            preparedStatement.setString(5, labReport.getAlbumine());
            preparedStatement.setString(6, labReport.getBenceJones());
            preparedStatement.setString(7, labReport.getRemarks());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
