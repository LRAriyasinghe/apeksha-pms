package com.apekshapms.controller.consultant;

import com.apekshapms.controller.Controller;
import com.apekshapms.model.SystemMessage;
import com.apekshapms.services.MessageServices;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SendMessage implements Controller{

    @FXML
    private Button backButton;

    @FXML
    private TextField patientIdTextField;

    @FXML
    private TextField consultantIdTextField;

    @FXML
    private TextArea messageTextArea;

    @FXML
    private Button sendButton;

    @FXML
    private DatePicker sendDatePicker;

    private  SystemMessage systemMessage;

    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sendButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                systemMessage = new SystemMessage();
                systemMessage.setPatientId(patientIdTextField.getText());
                System.out.println(patientIdTextField.getText());
                systemMessage.setCounsultantId(consultantIdTextField.getText());
                System.out.println(consultantIdTextField.getText());
                systemMessage.setMessage(messageTextArea.getText());
                System.out.println(messageTextArea.getText());
                systemMessage.setSendDate(sendDatePicker.getValue());
                System.out.println(sendDatePicker.getValue());

                MessageServices.addMessage(systemMessage);

            }
        });

    }
}
