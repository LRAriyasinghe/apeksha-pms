package com.apekshapms.controller;

import com.apekshapms.main.Session;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class EditPatientController implements Initializable {

    @FXML
    private AnchorPane backgroundAnchorPane;

    @FXML
    private Button btnNext1;

    @FXML
    private Button btnback1;

    @FXML
    private Button btncancel1;

    public EditPatientController(AnchorPane backgroundAnchorPane, Button btnNext1, Button btnback1) {
        this.backgroundAnchorPane = backgroundAnchorPane;
        this.btnNext1 = btnNext1;
        this.btnback1 = btnback1;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnNext1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Session.dashboardController.changeslide1();
            }


        });
    }
}
