package com.apekshapms.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class SelectOptionsController implements Controller{

    ObservableList<String> addNewEmpList = FXCollections.observableArrayList("Admin","Consultant","Lab Assistant","Register Doctor");


    @FXML
    private ChoiceBox addNewEmpChoice;
    @FXML
    private ChoiceBox searchEmpChoice;
    @FXML
    private ChoiceBox editEmpChoice;
    @FXML
    private Button newEmpButton;
    @FXML
    private Button searchEmpButton;
    @FXML
    private Button editEmpButton;


    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
