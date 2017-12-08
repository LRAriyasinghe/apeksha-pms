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
            System.out.println("Lalanga");
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "ward(Ward_id,Ward_name, Description, Max_patients,Gender_acceptence,Supervisor) " +
                    "VALUES(?, ?, ?, ?, ?, ?)");

            System.out.println("Ariyasinghe");
            preparedStatement.setString(1, ward.getWardID());
            preparedStatement.setString(2, ward.getWardName());
            preparedStatement.setString(3, ward.getDescription());
            preparedStatement.setString(4, ward.getMaxPatient_Count());
            preparedStatement.setString(5, String.valueOf(ward.isMale()));
            preparedStatement.setString(6, ward.getSupervisor());
            preparedStatement.execute();


        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
