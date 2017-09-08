package com.apekshapms.database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connector{
    private Connection connection;
    private String url;
    private String userName;
    private String password;
    private String dbName;

    public Connector() {
        url = "jdbc:mysql://" + "localhost" + ":3306/";
        userName = "root";
        password = "";
        dbName = "apekshahospitalmaharagama";

        try {
            connection  =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/apekshahospitalmaharagama", "root", "");
            //connection = (Connection) DriverManager.getConnection(url + dbName, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

}