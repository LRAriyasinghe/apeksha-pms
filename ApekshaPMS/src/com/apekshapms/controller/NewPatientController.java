package com.apekshapms.controller;

import com.apekshapms.database.Connector;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;



import java.sql.*;
import java.net.URL;
import java.util.ResourceBundle;


import java.sql.SQLException;
import java.sql.Statement;


public class NewPatientController implements Initializable{
    @FXML
    private AnchorPane backgroundAnchorPane;

    @FXML
    private Label lblEmpId;
    @FXML
    private Label idLabel;
    @FXML
    private Label lblPassword;

    @FXML
    private TextField txtEmpId;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnSubmit;


    public NewPatientController() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       /* btnSubmit.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

                    Statement stat= Connector.getStatemennt();
                    try {

                            stat.executeUpdate("INSERT INTO usernamepassword(Emp_Id,Username,Password)VALUES('" + txtEmpId.getText() + "','" + txtUsername.getText() + "','" + txtPassword.getText() + "')");

                        //OptionPane.showMessageDialog(this,"Error! Succesfully added to the database","Unuccess!", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }


                }

            });*/
        }
    }

