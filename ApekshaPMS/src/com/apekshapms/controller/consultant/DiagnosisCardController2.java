package com.apekshapms.controller.consultant;

import com.apekshapms.controller.Controller;
import com.apekshapms.controller.DashboardController;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.DiagnosisCard;
import com.apekshapms.model.PatientHistory;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

//controller of DiagnosisCardcontroller2.fxml

public class DiagnosisCardController2 implements Controller {

    @FXML
    private AnchorPane backgroundAnchorPane;

    @FXML
    private TextArea txtHistoryOfPreseComp;

    @FXML
    private TextArea txtSurgicalHis;

    @FXML
    private TextArea txtAllergyHis;

    @FXML
    private TextArea txtSocialHis;

    @FXML
    private TextArea txtFamilyHis;

    @FXML
    private Button nextButton;

    @FXML
    private Button backButton;

    @FXML
    private Button cancelButton;

    private DiagnosisCard diagnosisCard;

    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nextButton.setOnAction(e-> {
            //if (isInputValid()) {


            UI ui = UIFactory.getUI(UIName.DIAGNOSIS_CARD3);
            Parent parent = ui.getParent();
            DiagnosisCardController3 controller = (DiagnosisCardController3) ui.getController();
            controller.setFields(diagnosisCard);
            DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
            dashboardController.setWorkspace(parent);
            //}
        });
        backButton.setOnAction(e->{
            //if (isInputValid()) {



            UI ui = UIFactory.getUI(UIName.DIAGNOSIS_CARD1);
            Parent parent = ui.getParent();
            DiagnosisCardController1 controller = (DiagnosisCardController1) ui.getController();
            controller.setfields(diagnosisCard);
            DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
            dashboardController.setWorkspace(parent);
            //}
        });

    }

    public void setFields(DiagnosisCard diagnosisCard){

            this.diagnosisCard=diagnosisCard;
            PatientHistory patientHistory = diagnosisCard.getPatientHistory();
            txtHistoryOfPreseComp.setText(patientHistory.getPresentComplaint());
            txtSurgicalHis.setText(patientHistory.getSurgicalHistory());
            txtAllergyHis.setText(patientHistory.getAllegiHistory());
            txtSocialHis.setText(patientHistory.getSocialHistory());
            txtFamilyHis.setText(patientHistory.getFamilyHistory());


        }



}

