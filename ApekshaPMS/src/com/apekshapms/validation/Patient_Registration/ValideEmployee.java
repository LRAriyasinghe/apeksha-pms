package com.apekshapms.validation.Patient_Registration;

import com.apekshapms.database.Connector;

import java.sql.*;

/**
 * Created by Thilina on 9/14/2017.
 * Univercity of Colombo School of Computing
 */
public class ValideEmployee {
    public static boolean validate_login(String user, String pwd) {
        try {

            Connection connection = new Connector().getConnection();
            PreparedStatement pst = connection.prepareStatement("Select * from usernamepassword where username=? and password=?");
            pst.setString(1, user);
            pst.setString(2, pwd);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                return true;
            else
                return false;


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    }

