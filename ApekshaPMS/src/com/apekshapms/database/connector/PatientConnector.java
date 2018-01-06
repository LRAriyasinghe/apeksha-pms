package com.apekshapms.database.connector;

import com.apekshapms.controller.DashboardController;
import com.apekshapms.database.Connector;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.main.Main;
import com.apekshapms.model.Patient;
import com.apekshapms.model.PatientHistory;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class PatientConnector extends Connector {
    private Main mainApp;
    String notification = "";
    String history = "";

    //Add new Patient
    public void newPatient(Patient patient){
        try {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "Patient(title, first_name, last_name,nic_No, dob,gender, " +
                    "occupation, civil_Status, contact_No,address,city,district,additional_Details,state,reson,del_date_time,Date_Joined,cancer_type,RegisterDoctor_emp_Id," +
                    "Consultant_emp_Id) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            //preparedStatement.setString(1, patient.getId());
            preparedStatement.setString(1, patient.getTitle());
            preparedStatement.setString(2, patient.getFirstName());
            preparedStatement.setString(3, patient.getLastName());
            preparedStatement.setString(4, patient.getNicNo());
            preparedStatement.setString(5, String.valueOf(patient.getDob()));
            preparedStatement.setString(6, String.valueOf(patient.isMale()));
            preparedStatement.setString(7, patient.getOccupation());
            preparedStatement.setString(8, String.valueOf(patient.isCivil()));
            preparedStatement.setString(9, patient.getTelephone());
            preparedStatement.setString(10, patient.getAddress());
            preparedStatement.setString(11, patient.getCity());
            preparedStatement.setString(12, patient.getDistrict());
            preparedStatement.setString(13, patient.getDetails());
            preparedStatement.setString(14, "1");
            preparedStatement.setString(15, "");
            preparedStatement.setString(16, "0000-00-00");
            preparedStatement.setString(17, String.valueOf(patient.getJoinedDate()));
            preparedStatement.setString(18, patient.getCancerType());
            preparedStatement.setString(19, patient.getRegisterDocId());
            preparedStatement.setString(20, patient.getConsultantId());

            //Final get the all Result in the MessageBox
            notification += "Patient ID : "+patient.getId();
            notification += "\nPatient Title : "+patient.getTitle();
            notification += "\nPatient First Name : "+patient.getFirstName();
            notification += "\nPatient Last Name : "+patient.getLastName();
            notification += "\nPatient NIC : "+patient.getNicNo();
            notification += "\nPatient Date of Birth : "+patient.getDob();
            notification += "\nPatient Gender : "+patient.isMale();
            notification += "\nPatient Occupation : "+patient.getOccupation();
            notification += "\nPatient Civil Status : "+patient.isCivil();
            notification += "\nPatient ITelephone NuD : "+patient.getTelephone();
            notification += "\nPatient Address : "+patient.getAddress();
            notification += "\nPatient City : "+patient.getCity();
            notification += "\nPatient District : "+patient.getDistrict();
            notification += "\nPatient Register Doctor ID : "+patient.getRegisterDocId();
            notification += "\nPatient Consultant Doctor ID : "+patient.getConsultantId();
            notification += "\nPatient Details : "+patient.getDetails();
            notification += "\nPatient Cancer Type : "+patient.getCancerType();
            notification += "\nPatient Joined Date : "+patient.getJoinedDate();



            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Look, a Confirmation Dialog");
            alert.setContentText("Are you ok with this add Patient in to the System ?\n"+notification);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                // ... user chose OK
                preparedStatement.execute();
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Message");
                alert1.setHeaderText("");
                alert1.setContentText("Succussfully Added Patient.!");
                alert1.showAndWait();
                alert1.setOnCloseRequest(e -> alert.close());
            } else {
                // ... user chose CANCEL or closed the dialog then go to the Back
                UI ui = UIFactory.getUI(UIName.NEW_PATIENT);
                Parent parent = ui.getParent();
                DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
                dashboardController.setWorkspace(parent);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    //Add new Patient History
    public void newHistory(Patient patient){
        try {
            PreparedStatement pr = (PreparedStatement) getConnection().prepareStatement("SELECT MAX(patient_Id) AS PID FROM Patient");
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                patient.setId(String.valueOf(rs.getInt(1)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "PatientHistory(patient_Id, present_Complaint, surgical_History, allegi_History, social_History, family_History)" +
                    "VALUES(?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, patient.getId());
            preparedStatement.setString(2, patient.getPresentComplaint());
            preparedStatement.setString(3, patient.getSurgicalHistory());
            preparedStatement.setString(4, patient.getAllegiHistory());
            preparedStatement.setString(5, patient.getSocialHistory());
            preparedStatement.setString(6, patient.getFamilyHistory());

            //Final get the all Result in the MessageBox
            history += "Present Complaint : "+patient.getPresentComplaint();
            history += "Surgical History : "+patient.getSurgicalHistory();
            history += "Alegi History : "+patient.getAllegiHistory();
            history += "Social History : "+patient.getSocialHistory();
            history += "Family History : "+patient.getFamilyHistory();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Look, a Confirmation Dialog");
            alert.setContentText("Are you ok with this add History.?\n"+history);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                // ... user chose OK
                preparedStatement.execute(); //Executed Query
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Message");
                alert1.setHeaderText("");
                alert1.setContentText("Succussfully Added Patient's History.!");
                alert1.showAndWait();

                alert1.setOnCloseRequest(e -> alert.close());
            } else {
                // ... user chose CANCEL or closed the dialog then go to the Back
                UI ui = UIFactory.getUI(UIName.NEW_PATIENT);
                Parent parent = ui.getParent();
                DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
                dashboardController.setWorkspace(parent);
            }








        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void searchPatient(Patient patient){
        try {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("SELECT * FROM patient");
            preparedStatement.setString(1, patient.getId());
            preparedStatement.setString(2, String.valueOf(patient.getTitle()));
            preparedStatement.setString(3, patient.getFirstName());
            preparedStatement.setString(4, patient.getLastName());
            preparedStatement.setString(5, patient.getNicNo());
            preparedStatement.setString(6, String.valueOf(patient.getDob()));
            preparedStatement.setString(7, String.valueOf(patient.isMale()));
            preparedStatement.setString(8, patient.getOccupation());
            preparedStatement.setString(9, String.valueOf(patient.isCivil()));
            preparedStatement.setString(10, patient.getTelephone());
            preparedStatement.setString(11, patient.getAddress());
            preparedStatement.setString(12, patient.getCity());
            preparedStatement.setString(13, patient.getDistrict());
            preparedStatement.setString(14, patient.getRegisterDocId());
            preparedStatement.setString(15, patient.getDetails());
            preparedStatement.setString(16, patient.getConsultantId());

            /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText("");
            alert.setContentText("Succussfully Added");
            alert.showAndWait();
            alert.setOnCloseRequest(e -> alert.close());
            */

            preparedStatement.execute();


        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public PatientHistory searchPatientHistoryFromIndex(int index){
        PatientHistory patientHistory=new PatientHistory();
        try {

            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("SELECT * FROM `patienthistory` WHERE patient_Id="+index);
            ResultSet resultSet;

            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                //patientHistory.setId(resultSet.getInt("patient_history_Id"));
                System.out.println(patientHistory.getId());
                patientHistory.setPatientid(resultSet.getString("patient_Id"));
                patientHistory.setPresentComplaint(resultSet.getString("present_Complaint"));
                patientHistory.setSurgicalHistory(resultSet.getString("surgical_History"));
                patientHistory.setAllegiHistory(resultSet.getString("allegi_History"));
                patientHistory.setSocialHistory(resultSet.getString("social_History"));
                patientHistory.setFamilyHistory(resultSet.getString("family_History"));}


            /*Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText("");
            alert.setContentText("Succussfully Added");
            alert.showAndWait();
            alert.setOnCloseRequest(e -> alert.close());
            */




        } catch (SQLException e) {

            e.printStackTrace();
        }

        return patientHistory;
    }


    public void deletePatient(Patient patient) {
        try {
            com.mysql.jdbc.PreparedStatement preparedStatement = (com.mysql.jdbc.PreparedStatement) getConnection().prepareStatement("DELETE FROM patient " +
                    "WHERE patient_Id = ?");
            preparedStatement.setString(1, patient.getId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePatient(Patient patient) {
        try {
            com.mysql.jdbc.PreparedStatement preparedStatement = (com.mysql.jdbc.PreparedStatement) getConnection().prepareStatement("UPDATE patient SET " +
                    "title = ?, " +
                    "first_name = ?, " +
                    "last_name = ?, " +
                    "nic_No = ?, " +
                    "dob = ?, " +
                    "gender = ?, " +
                    "occupation = ?, " +
                    "civil_Status = ? " +
                    "contact_No = ? " +
                    "address = ? " +
                    "city = ? " +
                    "district = ? " +
                    "registerDoctor_emp_Id = ? " +
                    "additional_Details = ? " +
                    "consultant_emp_Id = ? " +
                    "WHERE patient_Id = ?");
            preparedStatement.setString(1, String.valueOf(patient.getTitle()));
            preparedStatement.setString(2, patient.getFirstName());
            preparedStatement.setString(3, patient.getLastName());
            preparedStatement.setString(4, patient.getNicNo());
            preparedStatement.setString(5, String.valueOf(patient.getDob()));
            preparedStatement.setString(6, String.valueOf(patient.isMale()));
            preparedStatement.setString(7, patient.getOccupation());
            preparedStatement.setString(8, String.valueOf(patient.isCivil()));
            preparedStatement.setString(9, patient.getTelephone());
            preparedStatement.setString(10, patient.getAddress());
            preparedStatement.setString(11, patient.getCity());
            preparedStatement.setString(12, patient.getDistrict());
            preparedStatement.setString(13, patient.getRegisterDocId());
            preparedStatement.setString(14, patient.getDetails());
            preparedStatement.setString(15, patient.getConsultantId());

            preparedStatement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
