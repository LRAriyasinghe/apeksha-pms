package com.apekshapms.database.connector;

import com.apekshapms.database.Connector;
import com.apekshapms.main.Main;
import com.apekshapms.model.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import static com.apekshapms.controller.SearchPatientController.txtSearchPatient;

public class PatientConnector extends Connector {
    public HashMap<Integer, Patient> getPatientHashMap() {
        HashMap<Integer, Patient> patientHashMap = new HashMap<>();


        //public void checkPatientConnection() {


        try

        {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("SELECT patient_Id,title,first_name,last_name,nic_No,dob,gender,occupation,civil_Status,additional_Details FROM patient WHERE patient_Id = '" + txtSearchPatient + "'");
            searchPatient(preparedStatement, patientHashMap);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return patientHashMap;


    }

    public void searchPatient(PreparedStatement preparedStatement , HashMap<Integer, Patient> patientHashMap) {

        //PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("SELECT patient_Id,title,first_name,last_name,nic_No,dob,gender,occupation,civil_Status,additional_Details FROM patient WHERE patient_Id = '" + txtSearchPatient + "'");

        //searchPatient(preparedStatement);

        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            // ObservableList<Patient> data = FXCollections.observableArrayList();
            System.out.println(("Lalanga"));


            while (resultSet.next()) {


                String pat_id = resultSet.getString(1);
                String pat_title = resultSet.getString(2);
                String pat_firstName = resultSet.getString(3);
                String pat_lastName = resultSet.getString(4);
                String pat_nic = resultSet.getString(5);
                String pat_dob = resultSet.getString(6);
                String pat_gender = resultSet.getString(7);
                String pat_occupation = resultSet.getString(8);
                String pat_civilStatus = resultSet.getString(9);
                String pat_moreInfo = resultSet.getString(10);

                Patient patient1 = new Patient(pat_id, pat_title, pat_firstName, pat_lastName, pat_nic, pat_dob, pat_gender, pat_occupation, pat_civilStatus, pat_moreInfo);
                patientHashMap.put(Integer.parseInt(pat_id), patient1);

            }


        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

                       /* tblColoumnId.setCellValueFactory(new PropertyValueFactory<>(pat_id));
                        tblColoumnTitle.setCellValueFactory(new PropertyValueFactory<>(pat_title));
                        tblColoumnFirsName.setCellValueFactory(new PropertyValueFactory<>(pat_firstName));
                        tblColoumnLastName.setCellValueFactory(new PropertyValueFactory<>(pat_lastName));
                        tblColoumnNic.setCellValueFactory(new PropertyValueFactory<>(pat_nic));
                        tblColoumnDob.setCellValueFactory(new PropertyValueFactory<>(pat_dob));
                        tblColoumnGender.setCellValueFactory(new PropertyValueFactory<>(pat_gender));
                        tblColoumnOccupation.setCellValueFactory(new PropertyValueFactory<>(pat_occupation));
                        tblColoumnStatus.setCellValueFactory(new PropertyValueFactory<>(pat_civilStatus));
                        tblColoumnInfo.setCellValueFactory(new PropertyValueFactory<>(pat_moreInfo));*/









    public void newPatient(Patient patient){
        try {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "patient(patient_Id,title, first_name, last_name,nic_No, dob,gender, " +
                    "occupation, civil_Status, contact_No,address,city,district,registerDoctor_emp_Id," +
                    "additional_Details,consultant_emp_Id) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, patient.getId());
            preparedStatement.setString(2, patient.getTitle());
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
}
