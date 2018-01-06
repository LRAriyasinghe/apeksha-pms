package com.apekshapms.validation.Patient_Registration;

import com.apekshapms.database.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValideEmployeeID {

    public static boolean validate_allEmployeeId(String emp_id){ //Validate CAll employee ID
        try {
            Connection connection = new Connector().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Employee WHERE emp_Id=?");
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
