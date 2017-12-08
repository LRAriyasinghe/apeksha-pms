package com.apekshapms.controller.labAssistant;

import com.apekshapms.controller.Controller;
import com.apekshapms.controller.sidebar.LabAssistantSideBarController;
import com.apekshapms.database.Connector;
import com.apekshapms.model.SystemMessage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ReceivedMessageController implements Controller{

    @FXML
    private Button backButton;

    @FXML
    private Button checkedButton;

    @FXML
    private TextField labAssistantIdTextField;

    @FXML
    private TextArea receivedMessageTextArea;

    @FXML
    private TextArea checkedMessageTextArea;

    @FXML
    private TableView<SystemMessage> messageTableView;

    @FXML
    private TableColumn<SystemMessage, Integer> idTableColumn;

    @FXML
    private TableColumn<SystemMessage, String> patientIdTableColumn;

    @FXML
    private TableColumn<SystemMessage, String> consultantIdTableColumn;

    @FXML
    private TableColumn<SystemMessage, String> messageTableColumn;

    @FXML
    private TableColumn<SystemMessage, String> statusTableColumn;

    @FXML
    private TableColumn<SystemMessage, LocalDate> receivedDateTableColumn;

    @FXML
    private DatePicker checkedDatePicker;

    @FXML
    private Button loadNewMessagesButton;

    @FXML
    private Button loadAllMessageButton;

    @FXML
    private Label notificationLable;

    @FXML
    private Label messageIdLable;

    @FXML
    private Label messagePatientIdLable;

    private ObservableList<SystemMessage> message = FXCollections.observableArrayList();

    @Override
    public void refreshView() {

    }

    public void showOnClicked(){
        try {
            SystemMessage systemMessage = (SystemMessage)messageTableView.getSelectionModel().getSelectedItem();
            receivedMessageTextArea.setText(systemMessage.getMessage());
            messageIdLable.setText(String.valueOf(systemMessage.getMessageid()));
            messagePatientIdLable.setText(systemMessage.getPatientId());

        }catch (Exception e){
            e.getStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        messageIdLable.setText(""); // Message Id is Zero when a not load new message button
        messagePatientIdLable.setText(""); // Message Id is Zero when a not load new message button

        countNewMessage(); // Count the New Message and Set to Notification Lable

        //Set to TableColumn to Values
        idTableColumn.setCellValueFactory(new PropertyValueFactory<SystemMessage,Integer>("messageid"));
        patientIdTableColumn.setCellValueFactory(new PropertyValueFactory<SystemMessage,String>("patientId"));
        consultantIdTableColumn.setCellValueFactory(new PropertyValueFactory<SystemMessage,String>("counsultantId"));
        messageTableColumn.setCellValueFactory(new PropertyValueFactory<SystemMessage,String>("message"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<SystemMessage,String>("statusMessage"));
        receivedDateTableColumn.setCellValueFactory(new PropertyValueFactory<SystemMessage,LocalDate>("sendDate"));

        loadAllMessageButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                messageTableView.refresh();
                messageTableView.getItems().clear();
                loadAllMessages(); //load all messages
            }
        });

        loadNewMessagesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                messageTableView.refresh();
                messageTableView.getItems().clear();
                loadNewMessages(); //Load only new Messages
            }
        });

        checkedButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Connection connection = new Connector().getConnection();
                PreparedStatement preparedStatement = null;
                try {
                    preparedStatement = connection.prepareStatement("UPDATE messages SET labassistant_id = '" + labAssistantIdTextField.getText() + "', status='Read', workedstatus='" + checkedMessageTextArea.getText() + "', receivedDate='" + checkedDatePicker.getValue() + "' WHERE id='" + messageIdLable.getText() + "'");
                    preparedStatement.execute();
                    messageTableView.getItems().clear();
                    loadNewMessages(); //load all messages
                    countNewMessage(); //Count updated new messages
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });



    }

    public void loadAllMessages(){ //Select All Messages and add to TableView
        try {
            Connection connection = new Connector().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,patient_id,consultant_id,message,status,sendDate FROM messages");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                message.add(new SystemMessage(
                        rs.getInt("id"),
                        rs.getString("patient_id"),
                        rs.getString("consultant_id"),
                        rs.getString("message"),
                        rs.getString("status"),
                        rs.getDate("sendDate").toLocalDate()

                ));
                messageTableView.setItems(message);
                messageTableView.setTableMenuButtonVisible(true);
            }
            preparedStatement.close(); //Close the Connection
            rs.close();

        }catch (Exception e){
            e.getStackTrace();
            System.err.println(e);
        }
    }

    public void loadNewMessages(){ //Select New Messages and add to TableView


        try {
            Connection connection = new Connector().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,patient_id,consultant_id,message,status,sendDate FROM messages WHERE status='Unread'");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                message.add(new SystemMessage(
                        rs.getInt("id"),
                        rs.getString("patient_id"),
                        rs.getString("consultant_id"),
                        rs.getString("message"),
                        rs.getString("status"),
                        rs.getDate("sendDate").toLocalDate()

                ));
                messageTableView.setItems(message);
                messageTableView.setTableMenuButtonVisible(true);
            }
            preparedStatement.close(); //Close the Connection
            rs.close();

        }catch (Exception e){
            e.getStackTrace();
            System.err.println(e);
        }
    }

    public void countNewMessage(){ //Count All New Messages and Set to Notification
        try {
            Connection connection = new Connector().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(status) FROM messages WHERE status='Unread'");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                getNotificationLable().setText(String.valueOf(rs.getInt(1)));
            }
            preparedStatement.close(); //Close the Connection
            rs.close();

        }catch (Exception e){
            e.getStackTrace();
            System.err.println(e);
        }
    }

    public static Integer sideBarcountNewMessage(){ //Count All New Messages and Set to Notification in SideBar of Lab Assistant
        try {
            Connection connection = new Connector().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(status) FROM messages WHERE status='Unread'");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Integer count = Integer.valueOf(rs.getString(1));
                return count;
            }
            preparedStatement.close(); //Close the Connection
            rs.close();

        }catch (Exception e){
            e.getStackTrace();
            System.err.println(e);
        }
        return null;
    }

    public Label getNotificationLable() {
        return notificationLable;
    }

    public void setNotificationLable(Label notificationLable) {
        this.notificationLable = notificationLable;
    }
}
