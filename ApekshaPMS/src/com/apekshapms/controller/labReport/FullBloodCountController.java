package com.apekshapms.controller.labReport;


import com.apekshapms.controller.Controller;
import com.apekshapms.model.LabReport;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class FullBloodCountController implements Controller{

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
    private TextField WBCTextField;

    @FXML
    private TextField NETextField;

    @FXML
    private TextField HimoglobinTextField;

    @FXML
    private TextField PlateletsTextField;

    @FXML
    private Button SubmitButton;

    @FXML
    private Button CancelButton;

    private LabReport labReport ;

    public void initialize(URL location, ResourceBundle resources) {
        SubmitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                labReport.setID(PatientIDTextField.getText());
                labReport.setName(PatientNameTextField.getText());
                labReport.setDate(date.getValue());
                labReport.setReference(ReferenceTextField.getText());
                labReport.setRemarks(RemarksTextField.getText());
                labReport.setWBC(WBCTextField.getText());
                labReport.setNE(NETextField.getText());
                labReport.setHb(HimoglobinTextField.getText());
                labReport.setPlatelet(PlateletsTextField.getText());


            }});}


    @Override
    public void refreshView() {

    }
}
