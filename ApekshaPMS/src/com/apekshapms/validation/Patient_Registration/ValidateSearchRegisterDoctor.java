package com.apekshapms.validation.Patient_Registration;

import java.sql.*;

/**
 * Created by Thilina on 9/8/2017.
 * Univercity of Colombo School of Computing
 */
public class ValidateSearchRegisterDoctor {
    public static boolean validate_registerDoc(String emp_id){ //Validate Register Doctor ID in the registerdoctor Table
        try {
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/apekshahospitalmaharagama?", "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from registerdoctor where emp_Id=?");
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
