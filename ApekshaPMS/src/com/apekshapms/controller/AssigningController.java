package com.apekshapms.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AssigningController implements Initializable {

    @FXML
    private AnchorPane backgroundAssignAnchorPane;

    @FXML
    private Button btnBack2;

    @FXML
    private Button btnsubmit1;

    @FXML
    private Button btnCancel2;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnsubmit1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }
}
