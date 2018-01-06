package com.apekshapms.database.connector;

import com.apekshapms.database.Connector;
import com.apekshapms.model.SystemMessage;
import javafx.scene.control.Alert;

import java.sql.PreparedStatement;

public class MessageConnector extends Connector {
    //Send new Message
    public void newMessage(SystemMessage systemMessage){
        try {
            //Add New Messages form Consultant Doctor to Lab Assistant
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO messages(message,sendDate, status, workedstatus, receivedDate, Consultant_emp_Id,patient_Id, labAssistant_emp_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, systemMessage.getMessage());
            preparedStatement.setString(2, String.valueOf(systemMessage.getSendDate()));
            preparedStatement.setString(3, "Unread");
            preparedStatement.setString(4, "");
            preparedStatement.setString(5, String.valueOf("0000-00-00"));
            preparedStatement.setString(6, systemMessage.getCounsultantId());
            preparedStatement.setString(7, systemMessage.getPatientId());
            preparedStatement.setString(8, "");

            preparedStatement.execute();

        }catch (Exception e){
            System.err.println(e);
        }

    }

    //Update Message Status is "Read"
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
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Updated Message.!");

            alert.showAndWait();

        }catch (Exception e){
            System.err.println(e);
        }

    }
}
