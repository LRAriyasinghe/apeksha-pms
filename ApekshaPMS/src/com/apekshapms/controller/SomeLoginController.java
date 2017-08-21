package com.apekshapms.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;


public class SomeLoginController implements Controller{
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


    public SomeLoginController() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        }

    @Override
    public void refreshView() {

    }
}

