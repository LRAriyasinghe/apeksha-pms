package com.apekshapms.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javax.swing.text.TabableView;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchPatientController implements Controller{




    @FXML
    private Label lblSearchPatient;

    @FXML
    private TextField txtSearchPatient;

    @FXML
    private TabableView tableSearchPatient;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnSave;

    public SearchPatientController(){

    }

    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
