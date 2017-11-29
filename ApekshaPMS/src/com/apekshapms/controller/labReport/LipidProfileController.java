package com.apekshapms.controller.labReport;


import com.apekshapms.controller.Controller;
import com.apekshapms.model.LabReport;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class LipidProfileController implements Controller{


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
    private TextArea RemarksTextField;

    @FXML
    private TextField SerumCholestrolTextField;

    @FXML
    private TextField SerumTriglyceridesTextField;

    @FXML
    private TextField HDLCholestrolTextField;

    @FXML
    private TextField LDLCholestrolTextField;

    @FXML
    private TextField VLDLTextField;

    @FXML
    private TextField CHOLHDLTextField;

    @FXML
    private TextField LDLHDLTextField;

    @FXML
    private Button SubmitButton;

    @FXML
    private Button CancelButton;

    private LabReport labReport;

    public void initialize(URL location, ResourceBundle resources) {
        SubmitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                labReport.setID(PatientIDTextField.getText());
                labReport.setName(PatientNameTextField.getText());
                labReport.setDate(date.getValue());
                labReport.setReference(ReferenceTextField.getText());
                labReport.setRemarks(RemarksTextField.getText());
                labReport.setSerChol(SerumCholestrolTextField.getText());
                labReport.setSerTri(SerumTriglyceridesTextField.getText());
                labReport.setHDLChol(HDLCholestrolTextField.getText());
                labReport.setLDLChol(LDLCholestrolTextField.getText());
                labReport.setVLDL(VLDLTextField.getText());
                labReport.setCHOLHDL(CHOLHDLTextField.getText());
                labReport.setLDLHDL(LDLHDLTextField.getText());


                //LabReportServices.addLabReport(labReport);


            }
        });
    }

    @Override
    public void refreshView() {

    }
}
