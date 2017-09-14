package com.apekshapms.database.connector;

import com.apekshapms.database.Connector;
import com.apekshapms.model.Employee;
import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserConnector extends Connector {

    public Employee getUserName(String username) {

        Employee employee = null;


        try {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("SELECT username,password FROM usernamepassword " +
                    "WHERE username = ?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String password = resultSet.getString("usernamepassword.password");

                employee.setUsername(username);
                employee.setPassword(password);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
}

