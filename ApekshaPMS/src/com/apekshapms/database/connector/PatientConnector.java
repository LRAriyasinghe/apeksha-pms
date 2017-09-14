package com.apekshapms.database.connector;

import com.mysql.jdbc.PreparedStatement;
import com.apekshapms.database.Connector;
import com.apekshapms.model.Patient;
import javafx.scene.control.Alert;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.apekshapms.controller.SearchPatientController.txtSearchPatient;
import static com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken.Name;
import static com.apekshapms.controller.SearchPatientController.*;

public class PatientConnector extends Connector {

    public PatientConnector() {


        try

        {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("SELECT patient_Id,title,first_name,last_name,nic_No,dob,gender,occupation,civil_Status,additional_Details FROM patient WHERE patient_Id = '"+txtSearchPatient+"'" );
            searchPatient(preparedStatement);

        } catch (
                SQLException e)

        {
            e.printStackTrace();
        }


    }

    public void searchPatient(PreparedStatement preparedStatement){


            try {

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    String id = resultSet.getString("patient.patient_Id");
                    String title = resultSet.getString("patient.title");
                    String firstName = resultSet.getString("patient.first_name");
                    String lastName = resultSet.getString("patient.last_name");
                    String nic = resultSet.getString("patient.nic_No");
                    String dob = resultSet.getString("patient.dob");
                    String gender= resultSet.getString("patient.gender");
                    String occupation = resultSet.getString("patient.occupation");
                    String civilStatus = resultSet.getString("patient.civil_Status");
                    String moreInfo = resultSet.getString("patient.additional_Details");

                    //Patient patient = new Patient(id, title, firstName, lastName, nic, dob, gender, occupation,civilStatus,moreInfo);

                    if(id.equals(txtSearchPatient.getText()))
                    {

                        tblColoumnId.setHeaderValue(id);
                        tblColoumnTitle.setHeaderValue(title);
                        tblColoumnFirsName.setHeaderValue(firstName);
                        tblColoumnLastName.setHeaderValue(lastName);
                        tblColoumnNic.setHeaderValue(nic);
                        tblColoumnDob.setHeaderValue(dob);
                        tblColoumnGender.setHeaderValue(gender);
                        tblColoumnOccupation.setHeaderValue(occupation);
                        tblColoumnStatus.setHeaderValue(civilStatus);
                        tblColoumnInfo.setHeaderValue(moreInfo);
                    }
                }

            } catch (SQLException e1) {
                e1.printStackTrace();
            }


    }



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

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText("");
            alert.setContentText("Succussfully Added");
            alert.showAndWait();
            alert.setOnCloseRequest(e -> alert.close());

            preparedStatement.execute();


        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
