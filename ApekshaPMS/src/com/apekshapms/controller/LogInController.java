package com.apekshapms.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInController implements Controller {

    @FXML
    private TextField txtUserName;

    @FXML
    private PasswordField passwdfieldPassWord;

    @FXML
    private Button btnLogIn;

    @Override
    public void refreshView() {

    }
    public void btnLogInOnAction(ActionEvent actionEvent){

        String username = txtUserName.getText();
        String password = passwdfieldPassWord.getText();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
