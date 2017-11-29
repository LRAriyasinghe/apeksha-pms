package com.apekshapms.controller.labReport;


import com.apekshapms.controller.Controller;
import com.apekshapms.model.LabReport;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;


public class LiverFunctionController implements Controller{

    @FXML
    private DatePicker date;

    @FXML
    private TextField PatientIDTextField;

    @FXML
    private Label ReportTypeLabel;

    @FXML
    private TextField PatientNameTextField;

    @FXML
    private TextField ReferenceTextField;

    @FXML
    private TextField SerumBilTextField;

    @FXML
    private TextField SgptTextField;

    @FXML
    private TextField SgotTextField;

    @FXML
    private TextField SerumAlkTextField;

    @FXML
    private TextField SerumCreTextField;

    @FXML
    private TextField SerumCalTextField;

    @FXML
    private TextArea RemarksTextField;

    @FXML
    private Button SubmitButton;

    @FXML
    private Button CancelButton;

    private LabReport labReport;




    public void refreshView() {

    }

    public void initialize(URL location, ResourceBundle resources) {
        SubmitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                labReport.setID(PatientIDTextField.getText());
                labReport.setName(PatientNameTextField.getText());
                labReport.setDate(date.getValue());
                labReport.setReference(ReferenceTextField.getText());
                labReport.setRemarks(RemarksTextField.getText());
                labReport.setSerB(SerumBilTextField.getText());
                labReport.setSGPT(SgptTextField.getText());
                labReport.setSGOT(SgotTextField.getText());
                labReport.setSerAlk(SerumAlkTextField.getText());
                labReport.setSerCre(SerumCreTextField.getText());
                labReport.setSerCal(SerumCalTextField.getText());

                //LabReportServices.addLabReport(labReport);


            }
        });
    }}