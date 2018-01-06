package com.apekshapms.controller.labAssistant;

import com.apekshapms.controller.Controller;
import com.apekshapms.database.Connector;
import com.apekshapms.model.SystemMessage;
import com.apekshapms.validation.Patient_Registration.ValidateLabAssistantID;
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

public class ReceivedMessageController implements Controller {

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

    //get Array list for message save
    private ObservableList<SystemMessage> message = FXCollections.observableArrayList();

    @Override
    public void refreshView() {

    }

    //message passing for Text Area when click row of Table View
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
        // Message Id is Zero when a not load new message button
        messageIdLable.setText("");

        // Message Id is Zero when a not load new message button
        messagePatientIdLable.setText("");

        // Count the New Message and Set to Notification Lable
        countNewMessage();

        //Set to TableColumn to Values
        idTableColumn.setCellValueFactory(new PropertyValueFactory<SystemMessage,Integer>("messageid"));
        patientIdTableColumn.setCellValueFactory(new PropertyValueFactory<SystemMessage,String>("patientId"));
        consultantIdTableColumn.setCellValueFactory(new PropertyValueFactory<SystemMessage,String>("counsultantId"));
        messageTableColumn.setCellValueFactory(new PropertyValueFactory<SystemMessage,String>("message"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<SystemMessage,String>("statusMessage"));
        receivedDateTableColumn.setCellValueFactory(new PropertyValueFactory<SystemMessage,LocalDate>("sendDate"));

        messageTableView.refresh();
        messageTableView.getItems().clear();
        //Load only new Messages
        loadNewMessages();

        //Loadd All Message on action event for All message button
        loadAllMessageButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                messageTableView.refresh();
                messageTableView.getItems().clear();
                loadAllMessages(); //load all messages
            }
        });

        //Loadd All new Message on action event for All new message button
        loadNewMessagesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                messageTableView.refresh();
                messageTableView.getItems().clear();
                //Load only new Messages
                loadNewMessages();
            }
        });

        //Action Event after checking message and updating status in database
        checkedButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (isInputValid()) {
                    String id = labAssistantIdTextField.getText(); //get the Lab Assistant ID
                    if(ValidateLabAssistantID.validate_labAssistantId(id)){
                        Connection connection = new Connector().getConnection();
                        PreparedStatement preparedStatement = null;
                        try {
                            preparedStatement = connection.prepareStatement("UPDATE messages SET labAssistant_emp_id = '" + labAssistantIdTextField.getText() + "', status='Read', workedstatus='" + checkedMessageTextArea.getText() + "', receivedDate='" + checkedDatePicker.getValue() + "' WHERE id='" + messageIdLable.getText() + "'");
                            preparedStatement.execute();
                            messageTableView.getItems().clear();
                            loadNewMessages(); //load all messages
                            countNewMessage(); //Count updated new messages
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        sideBarcountNewMessage();
                    }else{
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error Dialog");
                        alert.setHeaderText("Look, an Error Dialog");
                        alert.setContentText("Ooops, there was an error Lab Assistant ID is Invalide.!");
                        alert.showAndWait();

                    }
                }


            }
        });



    }

    //Select All Messages and add to TableView
    public void loadAllMessages(){
        try {
            Connection connection = new Connector().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,patient_Id,Consultant_emp_Id,message,status,sendDate FROM messages");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                message.add(new SystemMessage(
                        rs.getInt("id"),
                        rs.getString("patient_Id"),
                        rs.getString("Consultant_emp_Id"),
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

    //Select New Messages and add to TableView
    public void loadNewMessages(){


        try {
            Connection connection = new Connector().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,patient_Id,Consultant_emp_Id,message,status,sendDate FROM messages WHERE status='Unread'");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                message.add(new SystemMessage(
                        rs.getInt("id"),
                        rs.getString("patient_Id"),
                        rs.getString("Consultant_emp_Id"),
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

    //Count All New Messages and Set to Notification
    public void countNewMessage(){
        try {
            Connection connection = new Connector().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(status) FROM messages WHERE status='Unread'");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                getNotificationLable().setText(String.valueOf(rs.getInt(1)));
            }
            //Close the Connection
            preparedStatement.close();
            rs.close();

        }catch (Exception e){
            e.getStackTrace();
            System.err.println(e);
        }
    }

    //Count All New Messages and Set to Notification in SideBar of Lab Assistant
    public static Integer sideBarcountNewMessage(){
        try {
            Connection connection = new Connector().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(status) FROM messages WHERE status='Unread'");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Integer count = Integer.valueOf(rs.getString(1));
                return count;
            }
            //Close the Connection
            preparedStatement.close();
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


    //Validation
    private boolean isInputValid() {
        String errorMessage = "";

        if (receivedMessageTextArea.getText() == null || receivedMessageTextArea.getText().length() == 0) {
            errorMessage += "Please Select Message in the Table!\n";
        }
        if (checkedDatePicker.getValue() == null || checkedDatePicker.getValue().lengthOfYear() == 0) {
            errorMessage += "Please Select Date!\n";
        }
        if (checkedMessageTextArea.getText() == null || checkedMessageTextArea.getText().length() == 0) {
            errorMessage += "Please Type here Confirms Messages!\n";
        }
        if (labAssistantIdTextField.getText() == null || labAssistantIdTextField.getText().length() == 0) {
            errorMessage += "Please Type Here Lab Assistant Doctor ID.!!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {


            // Show the error message
            //Dialogs.showErrorDialog(dialogStage, errorMessage,
            //"Please correct invalid fields", "Invalid Fields");
            System.out.println("Successfully Fail");

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Look, a Warning Dialog");
            alert.setContentText(errorMessage);

            alert.showAndWait();
            // Dialogs.showWarningDialog(new Stage(), "Careful with the next step!", "Warning Dialog", "title");

            return false;

        }
    }
}
