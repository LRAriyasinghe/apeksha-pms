package com.apekshapms.controller.admin;

import com.apekshapms.controller.Controller;
import com.apekshapms.controller.DashboardController;
import com.apekshapms.database.Connector;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.AdminMessage;
import com.apekshapms.model.SystemMessage;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import com.apekshapms.validation.Patient_Registration.ValidateLabAssistantID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AdminMessageController implements Controller {

    @FXML
    private AnchorPane backgroundAnchorPane;

    @FXML
    private Button backButton;

    @FXML
    private Button checkedButton;

    @FXML
    private TextArea receivedMessageTextArea;

    @FXML
    private TableView<AdminMessage> messageTableView;

    @FXML
    private TableColumn<AdminMessage, Integer> idTableColumn;

    @FXML
    private TableColumn<AdminMessage, String> employeeidTableColumn;

    @FXML
    private TableColumn<AdminMessage, String> messageTableColumn;

    @FXML
    private TableColumn<AdminMessage, String> statusTableColumn;

    @FXML
    private TableColumn<AdminMessage, LocalDate> receivedDateTableColumn;

    @FXML
    private Button loadNewMessagesButton;

    @FXML
    private Label notificationLable;

    @FXML
    private Button loadAllMessageButton;

    @FXML
    private Label messageIdLable;

    @FXML
    private Label messageEmployeeIDLable;

    @FXML
    private Button cancelButton;

    @FXML
    void showOnClicked(MouseEvent event) {
        showOnClicked();

    }

    //Array for Messages
    private ObservableList<AdminMessage> message = FXCollections.observableArrayList();

    @Override
    public void refreshView() {

    }

    //load the message in the TextField when a clicked TableView
    public void showOnClicked(){
        try {
            AdminMessage adminMessage = (AdminMessage) messageTableView.getSelectionModel().getSelectedItem();
            receivedMessageTextArea.setText(adminMessage.getAdminmessage());
            messageIdLable.setText(String.valueOf(adminMessage.getAdminmessageid()));
            messageEmployeeIDLable.setText(adminMessage.getEmp_Id());

        }catch (Exception e){
            e.getStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Message Id is Zero when a not load new message button
        messageIdLable.setText("");

        // Message Id is Zero when a not load new message button
        messageEmployeeIDLable.setText("");

        // Count the New Message and Set to Notification Lable
        countNewMessage();

        //Set to TableColumn to Values
        idTableColumn.setCellValueFactory(new PropertyValueFactory<AdminMessage,Integer>("adminmessageid"));
        employeeidTableColumn.setCellValueFactory(new PropertyValueFactory<AdminMessage,String>("emp_Id"));
        messageTableColumn.setCellValueFactory(new PropertyValueFactory<AdminMessage,String>("adminmessage"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<AdminMessage,String>("adminstatus"));
        receivedDateTableColumn.setCellValueFactory(new PropertyValueFactory<AdminMessage,LocalDate>("admindate"));

        //refresh TableView
        messageTableView.refresh();
        messageTableView.getItems().clear();

        //Load only new Messages
        loadNewMessages();

        // Action event for All Message button
        loadAllMessageButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                messageTableView.refresh();
                messageTableView.getItems().clear();
                loadAllMessages(); //load all messages
            }
        });

        // Action event for New Message button
        loadNewMessagesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                messageTableView.refresh();
                messageTableView.getItems().clear();
                loadNewMessages(); //Load only new Messages
            }
        });

        // Action event for Check button
        //when click the this button Status is update to like a "Read"
        checkedButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (isInputValid()) {
                    //String id = labAssistantIdTextField.getText(); //get the Lab Assistant ID

                        Connection connection = new Connector().getConnection();
                        PreparedStatement preparedStatement = null;
                        try {
                            preparedStatement = connection.prepareStatement("UPDATE adminMessage SET status='Read' WHERE id='" + messageIdLable.getText() + "'");
                            preparedStatement.execute();
                            messageTableView.getItems().clear();
                            loadNewMessages(); //load all messages
                            countNewMessage(); //Count updated new messages
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        sideBarcountNewMessage();

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText("Look, an information Dialog");
                        alert.setContentText("Status Updated Success!");
                        alert.showAndWait();


                }


            }
        });


        //Action event for Cancel Button
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UI ui = UIFactory.getUI(UIName.APEKSHA_HOME);
                Parent parent = ui.getParent();
                DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
                dashboardController.setWorkspace(parent);
            }
        });

    }

    //Select All Messages and add to TableView
    public void loadAllMessages(){
        try {
            Connection connection = new Connector().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,message,date,Employee_emp_Id,status FROM adminMessage");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                message.add(new AdminMessage(
                        rs.getInt("id"),
                        rs.getString("Employee_emp_Id"),
                        rs.getString("message"),
                        rs.getString("status"),
                        rs.getDate("date").toLocalDate()

                ));
                messageTableView.setItems(message);
                messageTableView.setTableMenuButtonVisible(true);
            }
            //Close the Connection
            preparedStatement.close();
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
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,message,date,Employee_emp_Id,status FROM adminMessage WHERE status='Unread'");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                message.add(new AdminMessage(
                        rs.getInt("id"),
                        rs.getString("Employee_emp_Id"),
                        rs.getString("message"),
                        rs.getString("status"),
                        rs.getDate("date").toLocalDate()

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
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(status) FROM adminMessage WHERE status='Unread'");
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
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(status) FROM adminMessage WHERE status='Unread'");
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


    //Check Validation
    private boolean isInputValid() {
        String errorMessage = "";

        if (receivedMessageTextArea.getText() == null || receivedMessageTextArea.getText().length() == 0) {
            errorMessage += "Please Select Message in the Table!\n";
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
