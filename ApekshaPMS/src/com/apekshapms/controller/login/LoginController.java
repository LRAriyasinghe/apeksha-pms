package com.apekshapms.controller.login;

import com.apekshapms.controller.Controller;
import com.apekshapms.controller.DashboardController;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.services.SystemServices;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Thilina on 9/14/2017.
 * Univercity of Colombo School of Computing
 */
public class LoginController implements Controller {
    @FXML
    private PasswordField txtpassword;

    @FXML
    private TextField txtusername;

    @FXML
    private Button btnlogin;

    @FXML
    private Button forgotPasswordButton;




    @Override
    public void refreshView() {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Forgot the pass owrd and then go to the forgote message center
        forgotPasswordButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/com/apekshapms/ui/view/ForgotPassWord.fxml"));
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



        //Login Button action
        btnlogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                /*


                String user = txtusername.getText();   // Collecting the input
                String pass = txtpassword.getText(); // Collecting the input

                //Check empty input
                if (isInputValid()){

                //Register Doctor Login
                if(validate_login_registor_doc(user,pass)){
                    Stage primaryStage = (Stage) btnlogin.getScene().getWindow();
                    SystemServices.loadDashboard(primaryStage);
                    DashboardController.loadSideBarRegisterDoctor();

                    UI ui = UIFactory.getUI(UIName.APEKSHA_HOME);
                    Parent parent = ui.getParent();
                    DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
                    dashboardController.setWorkspace(parent);
                }

                //Consultant Doctor Login
                else if (validate_login_consultant_doc(user,pass)){
                    Stage primaryStage = (Stage) btnlogin.getScene().getWindow();
                    SystemServices.loadDashboard(primaryStage);
                    DashboardController.loadSideBarConsultantDoctor();
                }
                // Lab Assistant Doctor Login
                else if (validate_login_lab_assistant(user,pass)){
                    Stage primaryStage = (Stage) btnlogin.getScene().getWindow();
                    SystemServices.loadDashboard(primaryStage);
                    DashboardController.loadSideBarLabAssistant();
                }

                // Admin Login
                else if (validate_login_admin(user,pass)){
                    Stage primaryStage = (Stage) btnlogin.getScene().getWindow();
                    SystemServices.loadDashboard(primaryStage);
                    DashboardController.loadSideBarAdmin();

                }
                //Invalid Login
                else{

                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                    alert1.setTitle("Message");
                    alert1.setHeaderText("");
                    alert1.setContentText("Invalid User Name Or Password..!\n Please Try Again Or Reset Password From Admin");
                    alert1.showAndWait();
                }//End login

                }//End Check empty Input
                */






                /*
                if (isInputValid()) {

                    String username = txtusername.getText();
                    String password = txtpassword.getText();
                    if (ValideEmployee.validate_login(username, password)) {

                    */

                Stage primaryStage = (Stage) btnlogin.getScene().getWindow();
                SystemServices.loadDashboard(primaryStage);

                DashboardController.loadSideBarRegisterDoctor();
                //DashboardController.loadSideBarConsultantDoctor();
                //DashboardController.loadSideBarLabAssistant();
                //DashboardController.loadSideBarAdmin();

                UIFactory.launchUI(UIName.DASHBOARD, true);

                /*


                    }

                }
                */



            }
        });


    }


    //Validate Empty Input
    private boolean isInputValid() {
        String errorMessage = "";

        if (txtusername.getText() == null || txtusername.getText().length() == 0) {
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


    //Another Login Button Action Event
    public void btnloginOnAction(ActionEvent actionEvent) {
        String username = txtusername.getText();
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


    //Check Validity of Register Doctor in the system
    private boolean validate_login_registor_doc(String user, String pwd) {
        try {
            Connection connection = new com.apekshapms.database.Connector().getConnection();
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM UsernamePassword INNER JOIN RegisterDoctor ON RegisterDoctor.emp_Id=UsernamePassword.SystemEmployee_emp_Id WHERE UsernamePassword.username=? AND UsernamePassword.password=?");
            pst.setString(1, user);
            pst.setString(2, pwd);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                return true;
            else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Check Validity of Consultant Doctor in the system
    private boolean validate_login_consultant_doc(String user, String pwd) {
        try {
            Connection connection = new com.apekshapms.database.Connector().getConnection();
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM UsernamePassword INNER JOIN consultant ON consultant.emp_Id=usernamePassword.SystemEmployee_emp_Id WHERE UsernamePassword.username=? AND UsernamePassword.password=?");
            pst.setString(1, user);
            pst.setString(2, pwd);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                return true;
            else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Check Validity of Lab Assitsant Doctor in the system
    private boolean validate_login_lab_assistant(String user, String pwd) {
        try {
            Connection connection = new com.apekshapms.database.Connector().getConnection();
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM UsernamePassword INNER JOIN labAssistaant ON labAssistaant.emp_Id=UsernamePassword.SystemEmployee_emp_Id WHERE UsernamePassword.username=? AND UsernamePassword.password=?");
            pst.setString(1, user);
            pst.setString(2, pwd);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                return true;
            else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Check Validity of Admin Doctor in the system
    private boolean validate_login_admin(String user, String pwd) {
        try {
            Connection connection = new com.apekshapms.database.Connector().getConnection();
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM UsernamePassword INNER JOIN admin ON admin.emp_Id=UsernamePassword.SystemEmployee_emp_Id WHERE UsernamePassword.username=? AND UsernamePassword.password=?");
            pst.setString(1, user);
            pst.setString(2, pwd);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                return true;
            else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
