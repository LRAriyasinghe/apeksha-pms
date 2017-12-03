package com.apekshapms.database.connector;

import com.apekshapms.database.Connector;
import com.apekshapms.main.Main;
import com.apekshapms.model.BonemarrowReport;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoneMarrowConnector extends Connector {
    /*private Main mainApp;

    public void newBoneMarrowReport(BonemarrowReport bonemarrowReport) {
        try {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "testreport(test_Id,patient_Id, patient_name, date,type, labAssistaant_emp_Id,remarks) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, bonemarrowReport.getTestID());
            preparedStatement.setString(2, bonemarrowReport.getPatientID());
            preparedStatement.setString(3, bonemarrowReport.getPatientName());
            preparedStatement.setString(4, String.valueOf(bonemarrowReport.getDate()));
            preparedStatement.setString(5, bonemarrowReport.getTestType());
            preparedStatement.setString(6, bonemarrowReport.getReference());
            preparedStatement.setString(7, bonemarrowReport.getRemarks());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement preparedStatement2 = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "bonemarrow_report(TestID,Patient_Id, BMBx, TrephineBMBx) " +
                    "VALUES(?, ?, ?, ?)");

            preparedStatement2.setString(1, bonemarrowReport.getTestID());
            preparedStatement2.setString(2, bonemarrowReport.getPatientID());
            preparedStatement2.setString(3, bonemarrowReport.getBMBx());
            preparedStatement2.setString(4, bonemarrowReport.getTrephineBMBx());

            preparedStatement2.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
