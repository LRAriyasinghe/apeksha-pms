package com.apekshapms.controller.login;

import com.apekshapms.controller.Controller;
import com.apekshapms.controller.DashboardController;
import com.apekshapms.controller.PatientHistoryController;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.services.SystemServices;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import com.apekshapms.validation.Patient_Registration.ValideEmployee;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Thilina on 9/14/2017.
 * Univercity of Colombo School of Computing
 */
public class LoginController implements Controller {
    @FXML
    private TextField txtusename;

    @FXML
    private TextField txtpassword;

    @FXML
    private Button btnlogin;


    @Override
    public void refreshView() {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnlogin.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                /*
                if (isInputValid()) {

                    String username = txtusename.getText();
                    String password = txtpassword.getText();
                    if (ValideEmployee.validate_login(username, password)) {
                    */
                Stage primaryStage = (Stage) btnlogin.getScene().getWindow();
                SystemServices.loadDashboard(primaryStage);
                //DashboardController.loadSideBarRegisterDoctor();
                //DashboardController.loadSideBarConsultantDoctor();
                //DashboardController.loadSideBarLabAssistant();
                DashboardController.loadSideBarLabAssistant();

                //DashboardController.loadSideBarAdmin();



                        //UIFactory.launchUI(UIName.DASHBOARD, true);
                        /*

                    }

                }
                */


            }
        });


    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (txtusename.getText() == null || txtusename.getText().length() == 0) {
            errorMessage += "No valid Username!\n";
        }
        if (txtpassword.getText() == null || txtpassword.getText().length() == 0) {
            errorMessage += "No valid Password!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {

            //Alert For Invalid TextFields
            // Show the error message
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Look, a Warning Dialog");
            alert.setContentText(errorMessage);
            alert.showAndWait();

            System.out.println("Successfully Fail");


            return false;

        }
    }

    public void btnloginOnAction(ActionEvent actionEvent) {
        String username = txtusename.getText();
        String password = txtpassword.getText();

        //Employee employee = UserServices.getUser(username);

        /*if (null == employee) {
            messageLabel.setText("Incorrect username");
            messageLabel.setVisible(true);
        } else if (!employee.getPassword().equals(password)) {
            messageLabel.setText("Incorrect password");
            messageLabel.setVisible(true);
        } else {
            Session.currentUser = employee;
            */
        Stage primaryStage = (Stage) btnlogin.getScene().getWindow();
        SystemServices.loadDashboard(primaryStage);
    }


}
