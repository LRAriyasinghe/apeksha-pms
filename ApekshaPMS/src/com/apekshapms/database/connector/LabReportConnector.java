package com.apekshapms.database.connector;

import com.apekshapms.database.Connector;
import com.apekshapms.main.Main;
import com.apekshapms.model.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Thilina on 10/13/2017.
 * Univercity of Colombo School of Computing
 */
public class LabReportConnector extends Connector {
    private Main mainApp;
    public void newBoneMarrowReport(BonemarrowReport bonemarrowreport) {
        try {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "testreport(test_Id,patient_Id, patient_name, date,type, labAssistaant_emp_Id,remarks) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, bonemarrowreport.getTestID());
            preparedStatement.setString(2, bonemarrowreport.getPatientID());
            preparedStatement.setString(3, bonemarrowreport.getPatientName());
            preparedStatement.setString(4, String.valueOf(bonemarrowreport.getDate()));
            preparedStatement.setString(5, bonemarrowreport.getTestType());
            preparedStatement.setString(6, bonemarrowreport.getReference());
            preparedStatement.setString(7, bonemarrowreport.getRemarks());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement preparedStatement2 = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "bonemarrow_report(TestID,Patient_Id, BMBx, TrephineBMBx) " +
                    "VALUES(?, ?, ?, ?)");

            preparedStatement2.setString(1, bonemarrowreport.getTestID());
            preparedStatement2.setString(2, bonemarrowreport.getPatientID());
            preparedStatement2.setString(3, bonemarrowreport.getBMBx());
            preparedStatement2.setString(4, bonemarrowreport.getTrephineBMBx());

            preparedStatement2.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void newCreactiveProteinReport(CreactiveproteinReport creactiveproteinReport) {
        try {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "testreport(test_Id,patient_Id, patient_name, date,type, labAssistaant_emp_Id,remarks) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, creactiveproteinReport.getTestID());
            preparedStatement.setString(2, creactiveproteinReport.getPatientID());
            preparedStatement.setString(3, creactiveproteinReport.getPatientName());
            preparedStatement.setString(4, String.valueOf(creactiveproteinReport.getDate()));
            preparedStatement.setString(5, creactiveproteinReport.getTestType());
            preparedStatement.setString(6, creactiveproteinReport.getReference());
            preparedStatement.setString(7, creactiveproteinReport.getRemarks());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement preparedStatement2 = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "c_reactiveprotein_report(TestID,Patient_Id, c_reactive) " +
                    "VALUES(?, ?, ?)");

            preparedStatement2.setString(1, creactiveproteinReport.getTestID());
            preparedStatement2.setString(2, creactiveproteinReport.getPatientID());
            preparedStatement2.setString(3, creactiveproteinReport.getCreactiveprotein());


            preparedStatement2.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void newFullBloodReport(FullBloodReport fullBloodReport) {
        try {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "testreport(test_Id,patient_Id, patient_name, date,type, labAssistaant_emp_Id,remarks) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, fullBloodReport.getTestID());
            preparedStatement.setString(2, fullBloodReport.getPatientID());
            preparedStatement.setString(3, fullBloodReport.getPatientName());
            preparedStatement.setString(4, String.valueOf(fullBloodReport.getDate()));
            preparedStatement.setString(5, fullBloodReport.getTestType());
            preparedStatement.setString(6, fullBloodReport.getReference());
            preparedStatement.setString(7, fullBloodReport.getRemarks());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement preparedStatement2 = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "fullblood_report(TestID,Patient_Id, WBC,NE,Himoglobin,Platlets) " +
                    "VALUES(?, ?, ?, ?, ?, ?)");

            preparedStatement2.setString(1, fullBloodReport.getTestID());
            preparedStatement2.setString(2, fullBloodReport.getPatientID());
            preparedStatement2.setString(3, fullBloodReport.getWBC());
            preparedStatement2.setString(4, fullBloodReport.getNE());
            preparedStatement2.setString(5, fullBloodReport.getHimoglobin());
            preparedStatement2.setString(6, fullBloodReport.getPlateletes());



            preparedStatement2.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void newLipidProfileReport(LipidProfileReport lipidProfileReport) {
        try {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "testreport(test_Id,patient_Id, patient_name, date,type, labAssistaant_emp_Id,remarks) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, lipidProfileReport.getTestID());
            preparedStatement.setString(2, lipidProfileReport.getPatientID());
            preparedStatement.setString(3, lipidProfileReport.getPatientName());
            preparedStatement.setString(4, String.valueOf(lipidProfileReport.getDate()));
            preparedStatement.setString(5, lipidProfileReport.getTestType());
            preparedStatement.setString(6, lipidProfileReport.getReference());
            preparedStatement.setString(7, lipidProfileReport.getRemarks());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement preparedStatement2 = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "lipidprofile_report(TestID,Patient_Id, Serum_Cholostrol,Serum_Triglycer,HDL,LDL,VLDL,CHOL,LDLHDL) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement2.setString(1, lipidProfileReport.getTestID());
            preparedStatement2.setString(2, lipidProfileReport.getPatientID());
            preparedStatement2.setString(3, lipidProfileReport.getSerium_Colostrol());
            preparedStatement2.setString(4, lipidProfileReport.getSerium_Triglycerides());
            preparedStatement2.setString(5, lipidProfileReport.getHDL());
            preparedStatement2.setString(6, lipidProfileReport.getLDL());
            preparedStatement2.setString(7, lipidProfileReport.getVLDL());
            preparedStatement2.setString(8, lipidProfileReport.getCHOL());
            preparedStatement2.setString(9, lipidProfileReport.getLDLHDL());


            preparedStatement2.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
























    /*public void newLabReportUrine(LabReport labReport){
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

    }*/
}
