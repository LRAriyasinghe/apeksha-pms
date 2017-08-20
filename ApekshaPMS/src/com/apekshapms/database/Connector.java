package com.apekshapms.database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connector{

    /*private String url;
    private String username;
    private String password;
    private String dbname;*/

    public static Statement getStatemennt() {

        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/apeksha_hospital_maharagama", "root", "");
            Statement stat = con.createStatement();
            return stat;
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return null;
    }

}