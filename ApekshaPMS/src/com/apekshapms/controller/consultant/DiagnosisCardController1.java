package com.apekshapms.controller.consultant;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;


import com.apekshapms.controller.Controller;
import com.apekshapms.controller.DashboardController;
import com.apekshapms.controller.SearchPatientController;
import com.apekshapms.database.connector.TreatmentConnector;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.main.Session;
import com.apekshapms.model.DiagnosisCard;
import com.apekshapms.model.Patient;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
//import com.sun.jdi.connect.Connector;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;


//controller of DiagnosisCardcontroller1.fxml

public class DiagnosisCardController1 implements Controller {

    @FXML
    private AnchorPane backgroundAnchorPane;

    @FXML
    private TextField txtIdNo;

    @FXML
    private TextField txtTitle;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtOccupation;

    @FXML
    private RadioButton Male;

    @FXML
    private RadioButton Female;

    @FXML
    private RadioButton Other;

    @FXML
    private DatePicker DOB;

    @FXML
    private TextField txtContactNo;

    @FXML
    private ComboBox<?> cmbCivilStatus;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtDistrict;

    @FXML
    private TextField txtNIC;

    @FXML
    private TextField txtCivilStatus;

    @FXML
    private TextField txtGender;

    @FXML
    private TextArea txtAddress;

    @FXML
    private TextField txtConsultantName;

    @FXML
    private TextField txtDate;

    @FXML
    private Button BackButton;

    @FXML
    private Button NextButton;

    private Patient patient;

    private DiagnosisCard diagnosisCard;

    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        NextButton.setOnAction(e->{
                //if (isInputValid()) {

                diagnosisCard =new DiagnosisCard();
                diagnosisCard.setPatient(patient);
                diagnosisCard.setPatientHistory(Session.patientConnector.searchPatientHistoryFromIndex(Integer.parseInt(txtIdNo.getText())));
                diagnosisCard.setTreatments(TreatmentConnector.allTreatmentsOfPatient(Integer.parseInt(txtIdNo.getText())));
                UI ui = UIFactory.getUI(UIName.DIAGNOSIS_CARD2);
                Parent parent = ui.getParent();
                DiagnosisCardController2 controller = (DiagnosisCardController2) ui.getController();
                controller.setFields(diagnosisCard);
                DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
                dashboardController.setWorkspace(parent);
        //}
        });

        BackButton.setOnAction(e->{
            //if (isInputValid()) {



            UI ui = UIFactory.getUI(UIName.SEARCH_PATIENT_DIAGNOSIS);
            Parent parent = ui.getParent();
            SearchPatientController controller = (SearchPatientController) ui.getController();
            controller.loadDatabasePatient();
            DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
            dashboardController.setWorkspace(parent);
            //}
        });

    }

    public void setfields(DiagnosisCard diagnosisCard){
        this.diagnosisCard=diagnosisCard;
        this.patient=diagnosisCard.getPatient();
        txtIdNo.setText(patient.getId());
        txtTitle.setText(String.valueOf(patient.getTitle()));
        txtFullName.setText(patient.getFirstName()+" "+patient.getLastName());
        txtOccupation.setText(patient.getOccupation());
        if(!patient.isMale().isEmpty()){txtGender.setText("Male");}else txtGender.setText("Female");
        DOB.setValue(patient.getDob());
        txtContactNo.setText(patient.getTelephone());

        //no civil status here
        //cmbCivilStatus.setValue(patient.get);

        txtCity.setText(patient.getCity());
        txtDistrict.setText(patient.getDistrict());
        txtNIC.setText(patient.getNicNo());
        txtAddress.setText(patient.getAddress());

        //only show cons id
        txtConsultantName.setText(patient.getConsultantId());

        txtDate.setText(String.valueOf(LocalDate.now()));

    }




}




