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
            System.out.println("Correct 2");

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


    public void newLiverFunctionReport(LiverFunctionReport liverFunctionReport) {
        try {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "testreport(test_Id,patient_Id, patient_name, date,type, labAssistaant_emp_Id,remarks) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, liverFunctionReport.getTestID());
            preparedStatement.setString(2, liverFunctionReport.getPatientID());
            preparedStatement.setString(3, liverFunctionReport.getPatientName());
            preparedStatement.setString(4, String.valueOf(liverFunctionReport.getDate()));
            preparedStatement.setString(5, liverFunctionReport.getTestType());
            preparedStatement.setString(6, liverFunctionReport.getReference());
            preparedStatement.setString(7, liverFunctionReport.getRemarks());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement preparedStatement2 = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "liverfunction_report(TestID,Patient_Id, Serum_Bilrubin,SGPT,SGOT,Serum_Alkaline,Serum_Creatinine,Serum_Calcium) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement2.setString(1, liverFunctionReport.getTestID());
            preparedStatement2.setString(2, liverFunctionReport.getPatientID());
            preparedStatement2.setString(3, liverFunctionReport.getSerum_Bilrubin());
            preparedStatement2.setString(4, liverFunctionReport.getSGPT());
            preparedStatement2.setString(5, liverFunctionReport.getSGOT());
            preparedStatement2.setString(6, liverFunctionReport.getSerum_Alkaline());
            preparedStatement2.setString(7, liverFunctionReport.getSerum_Creatinine());
            preparedStatement2.setString(8, liverFunctionReport.getSerum_Calcium());

            preparedStatement2.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void newSerumCalciumReport(SerumCalcuimReport serumCalcuimReport) {
        try {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "testreport(test_Id,patient_Id, patient_name, date,type, labAssistaant_emp_Id,remarks) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, serumCalcuimReport.getTestID());
            preparedStatement.setString(2, serumCalcuimReport.getPatientID());
            preparedStatement.setString(3, serumCalcuimReport.getPatientName());
            preparedStatement.setString(4, String.valueOf(serumCalcuimReport.getDate()));
            preparedStatement.setString(5, serumCalcuimReport.getTestType());
            preparedStatement.setString(6, serumCalcuimReport.getReference());
            preparedStatement.setString(7, serumCalcuimReport.getRemarks());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement preparedStatement2 = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "serum_calcium_report(TestID,Patient_Id, Free_calcium,Total_calcium) " +
                    "VALUES(?, ?, ?, ?)");

            preparedStatement2.setString(1, serumCalcuimReport.getTestID());
            preparedStatement2.setString(2, serumCalcuimReport.getPatientID());
            preparedStatement2.setString(3, serumCalcuimReport.getFreeCalcium());
            preparedStatement2.setString(4, serumCalcuimReport.getTotalCalcium());

            preparedStatement2.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void newSerumElectrolytesReport(SerumElectrolytesReport serumElectrolytesReport) {
        try {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "testreport(test_Id,patient_Id, patient_name, date,type, labAssistaant_emp_Id,remarks) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, serumElectrolytesReport.getTestID());
            preparedStatement.setString(2, serumElectrolytesReport.getPatientID());
            preparedStatement.setString(3, serumElectrolytesReport.getPatientName());
            preparedStatement.setString(4, String.valueOf(serumElectrolytesReport.getDate()));
            preparedStatement.setString(5, serumElectrolytesReport.getTestType());
            preparedStatement.setString(6, serumElectrolytesReport.getReference());
            preparedStatement.setString(7, serumElectrolytesReport.getRemarks());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement preparedStatement2 = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "serum_electrolytes(Testid,Patient_ID, Sodium,Potassium) " +
                    "VALUES(?, ?, ?, ?)");

            preparedStatement2.setString(1, serumElectrolytesReport.getTestID());
            preparedStatement2.setString(2, serumElectrolytesReport.getPatientID());
            preparedStatement2.setString(3, serumElectrolytesReport.getSodium());
            preparedStatement2.setString(4, serumElectrolytesReport.getPotassium());

            preparedStatement2.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void newSerumProteinReport(SerumProteinReport serumProteinReport) {
        try {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "testreport(test_Id,patient_Id, patient_name, date,type, labAssistaant_emp_Id,remarks) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, serumProteinReport.getTestID());
            preparedStatement.setString(2, serumProteinReport.getPatientID());
            preparedStatement.setString(3, serumProteinReport.getPatientName());
            preparedStatement.setString(4, String.valueOf(serumProteinReport.getDate()));
            preparedStatement.setString(5, serumProteinReport.getTestType());
            preparedStatement.setString(6, serumProteinReport.getReference());
            preparedStatement.setString(7, serumProteinReport.getRemarks());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement preparedStatement2 = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "serumprotein_report(Testid,Patient_ID,Albumin,Alpha1,Alpha2,Beta,Gamma) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?)");

            preparedStatement2.setString(1, serumProteinReport.getTestID());
            preparedStatement2.setString(2, serumProteinReport.getPatientID());
            preparedStatement2.setString(3, serumProteinReport.getAlbumin());
            preparedStatement2.setString(4, serumProteinReport.getAlpha1());
            preparedStatement2.setString(5, serumProteinReport.getAlpha2());
            preparedStatement2.setString(6, serumProteinReport.getBeta());
            preparedStatement2.setString(7, serumProteinReport.getGamma());

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
