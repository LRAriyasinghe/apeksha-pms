package com.apekshapms.database.connector;

import com.apekshapms.database.Connector;
import com.apekshapms.model.SystemMessage;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageConnector extends Connector {
    public void newMessage(SystemMessage systemMessage){
        try {
            //Add New Messages form Consultant Doctor to Lab Assistant
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO messages(patient_id,consultant_id,labassistant_id,message,status,workedstatus,sendDate,receivedDate) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, systemMessage.getPatientId());
            preparedStatement.setString(2,systemMessage.getCounsultantId());
            preparedStatement.setString(3, "");
            preparedStatement.setString(4, systemMessage.getMessage());
            preparedStatement.setString(5, "Unread");
            preparedStatement.setString(6, "");
            preparedStatement.setString(7, String.valueOf(systemMessage.getSendDate()));
            preparedStatement.setString(8, String.valueOf("0000-00-00"));

            preparedStatement.execute();

        }catch (Exception e){
            System.err.println(e);
        }

    }

    public void updateMessage(SystemMessage systemMessage){
        try {
            //Update New Messages after the seen by Lab Assistant
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("UPDATE messages SET "+
                    "labassistant_id= ?,"+
                    "status = ?,"+
                    "workedstatus = ?,"+
                    "receivedDate = ? "+
                    "WHERE (?)");

            preparedStatement.setString(1, systemMessage.getLabAssistantId());
            preparedStatement.setString(2, "Read");
            preparedStatement.setString(3, systemMessage.getWorkedStatus());
            preparedStatement.setString(4, String.valueOf(systemMessage.getReceivedDate()));

            preparedStatement.execute();

        }catch (Exception e){
            System.err.println(e);
        }

    }
}
