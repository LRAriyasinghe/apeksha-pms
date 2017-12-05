package com.apekshapms.database.connector;

import com.apekshapms.database.Connector;
import com.apekshapms.main.Main;
import com.apekshapms.model.Ward;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WardConnector extends Connector {
    private Main mainApp;
    public void newWard(Ward ward){
        try{
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "Ward(Ward_id,Ward_name, Description, Max_patients,Gender_acceptence,Supervisor) " +
                    "VALUES(?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, ward.getWardID());
            preparedStatement.setString(2, ward.getWardName());
            preparedStatement.setString(3, ward.getDescription());
            preparedStatement.setString(4, ward.getMaxPatient_Count());
            preparedStatement.setString(5, String.valueOf(ward.isGenderaccept()));
            preparedStatement.setString(6, ward.getSupervisor());


        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
