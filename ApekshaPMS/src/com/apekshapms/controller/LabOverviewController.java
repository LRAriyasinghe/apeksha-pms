package com.apekshapms.controller;


import com.apekshapms.model.LabReport2;
import com.apekshapms.services.LabReportServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;


public class LabOverviewController implements Controller  {

    @FXML
    private TextField dateTextField;

    @FXML
    private TextField idTextField;

    @FXML
    private ComboBox reportComboBox;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField serumBilTextField;

    @FXML
    private TextField sgptTextField;

    @FXML
    private TextField sgotTextField;

    @FXML
    private TextField serumAlkTextField;

    @FXML
    private TextField serumCreTextField;

    @FXML
    private TextField serumCalTextField;

    @FXML
    private TextArea remarkTextField;

    @FXML
    private Button submitButton;

    @FXML
    private Button cancelButton;

    private LabReport2 labReport;

    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                labReport.setID(idTextField.getText());
                labReport.setName(nameTextField.getText());
                labReport.setDate(dateTextField.getText());
                labReport.setSerB(serumBilTextField.getText());
                labReport.setSGPT(sgptTextField.getText());
                labReport.setSGOT(sgotTextField.getText());
                labReport.setSerAlk(serumAlkTextField.getText());
                labReport.setSerCre(serumCreTextField.getText());
                labReport.setSerCal(serumCalTextField.getText());

                //LabReportServices.addLabReport(labReport);








            }
        });


    }
}