package com.apekshapms.validation.Patient_Registration;

import java.sql.*;

/**
 * Created by Thilina on 9/8/2017.
 * Univercity of Colombo School of Computing
 */
public class ValidateSearchConsultant {
    public static boolean validate_consultant(String emp_id){ //Validate Consultant Doctor ID in the consultant Table
        try {
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/apekshahospitalmaharagama?", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from consultant where emp_Id=?");
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
