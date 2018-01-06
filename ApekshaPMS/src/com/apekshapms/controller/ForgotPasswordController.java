package com.apekshapms.controller;

import com.apekshapms.validation.Patient_Registration.ValideEmployeeID;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ForgotPasswordController implements Controller {

    @FXML
    private AnchorPane loginBackground;

    @FXML
    private TextArea messageTextArea;

    @FXML
    private TextField empidTextField;

    @FXML
    private Button backButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button sendButton;

    @FXML
    private DatePicker date;

    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Send Button action Event
        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String id = empidTextField.getText();
                //Check the Employee Validity
                if (ValideEmployeeID.validate_allEmployeeId(id)){
                    Connection connection = new com.apekshapms.database.Connector().getConnection();
                    try {
                        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO adminMessage(message, date, Employee_emp_Id, status) VALUES( ?, ?, ?, ?)");
                        //PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO messages(patient_id,consultant_id,labassistant_id,message,status,workedstatus,sendDate,receivedDate) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
                        preparedStatement.setString(1,messageTextArea.getText());
                        preparedStatement.setString(2, String.valueOf(date.getValue()));
                        preparedStatement.setString(3,empidTextField.getText());
                        preparedStatement.setString(4, "Unread");
                        preparedStatement.execute();

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Message Sending Successfully!");

                        alert.showAndWait();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }else{
                    //Not available employee in the SYstem then display message box
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Look, an Error Dialog");
                    alert.setContentText("Ooops, there was an error Your ID is Incorrect.!");

                    alert.showAndWait();
                }



            }
        });

        //Cancel Button Action Event

        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            //System is Exit
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        //Back Button Action Event
        //Go to Login UI
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/com/apekshapms/ui/view/login.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root, 498, 400);
                Stage stage = new Stage();
                stage.setTitle("Apeksha Hospital Maharagama");
                stage.setScene(scene);
                stage.show();
            }
        });

    }
}
