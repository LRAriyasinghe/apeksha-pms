package com.apekshapms.controller;

import com.apekshapms.model.Patient;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javax.swing.table.TableColumn;
import javax.swing.text.TabableView;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchPatientController implements Controller{

    @FXML
    private Label lblSearchPatient;

    @FXML
    public static TextField txtSearchPatient;

    @FXML
    public static TabableView tableSearchPatient;

    @FXML
    public static TableColumn tblColoumnId;

    @FXML
    public static TableColumn tblColoumnTitle;

    @FXML
    public static TableColumn tblColoumnFirsName;

    @FXML
    public static TableColumn tblColoumnLastName;

    @FXML
    public static TableColumn tblColoumnNic;

    @FXML
    public static TableColumn tblColoumnDob;

    @FXML
    public static TableColumn tblColoumnGender;

    @FXML
    public static TableColumn tblColoumnOccupation;

    @FXML
    public static TableColumn tblColoumnStatus;

    @FXML
    public static TableColumn tblColoumnInfo;




    @FXML
    private Button btnCancelPatient;

    @FXML
    private Button btnEditPatient;

    @FXML
    private Button btnSavePatient;

    @FXML
    private Button btnSearchPatient;


    public SearchPatientController(){

    }

    @Override
    public void refreshView() {

    }
    public void refreshView(Patient patient){
        tblColoumnId.setHeaderValue(patient.getId());
        tblColoumnTitle.setHeaderValue(patient.getTitle());
        tblColoumnFirsName.setHeaderValue(patient.getFirstName());
        tblColoumnLastName.setHeaderValue(patient.getLastName());
        tblColoumnNic.setHeaderValue(patient.getNicNo());
        tblColoumnDob.setHeaderValue(patient.getDob());
        tblColoumnGender.setHeaderValue(patient.isMale());
        tblColoumnOccupation.setHeaderValue(patient.getOccupation());
        tblColoumnStatus.setHeaderValue(patient.isCivil());
        tblColoumnInfo.setHeaderValue(patient.getDetails());


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
