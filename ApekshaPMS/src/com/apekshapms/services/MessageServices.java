package com.apekshapms.services;

import com.apekshapms.database.connector.MessageConnector;
import com.apekshapms.main.Session;
import com.apekshapms.model.SystemMessage;

public class MessageServices {
    public static void addMessage(SystemMessage systemMessage){
        MessageConnector messageConnector =new MessageConnector();
        messageConnector.newMessage(systemMessage);
        //Session.messageConnector.newMessage(systemMessage);
        }

    public static void updateMessage(SystemMessage systemMessage){
        MessageConnector messageConnector =new MessageConnector();
        messageConnector.updateMessage(systemMessage);
        //Session.messageConnector.newMessage(systemMessage);
    }
}
