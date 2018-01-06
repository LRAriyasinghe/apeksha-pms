package com.apekshapms.validation.Patient_Registration;

import com.apekshapms.database.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Thilina on 9/8/2017.
 * Univercity of Colombo School of Computing
 */
public class ValidateLabAssistantID {
    public static boolean validate_labAssistantId(String emp_id){ //Validate Consultant Doctor ID in the consultant Table
        try {
            Connection connection = new Connector().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from LabAssistaant where emp_Id=?");
            preparedStatement.setString(1,emp_id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                return  true;
            }else {
                return false;
            }


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }



    }
}
