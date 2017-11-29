package com.apekshapms.controller;

import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.Patient;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class PatientHistoryController implements Controller{
    @FXML
    private Button nextButton;

    @FXML
    private TextArea txtHistory;

    @FXML
    private TextArea txtSurgical;

    @FXML
    private TextArea txtAllergy;

    @FXML
    private TextArea txtSocial;

    @FXML
    private TextArea txtFamily;


    private Patient patient;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nextButton.setOnAction(event -> {
            patient.setHistory(txtHistory.getText());
            patient.setSurgical(txtSurgical.getText());
            patient.setAllergy(txtAllergy.getText());
            patient.setSocial(txtSocial.getText());
            patient.setFamily(txtFamily.getText());

            UI ui = UIFactory.getUI(UIName.ASSIGNING);
            Parent parent = ui.getParent();
            AssigningController controller = (AssigningController) ui.getController();
            controller.showPatient(parent);
            DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
            dashboardController.setWorkspace(parent);
        });
    }

    @Override
    public void refreshView() {

    }


    public void showPatient(Patient patient) {
        this.patient = patient;
    }

    @FXML
    void handleBackToButton(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.NEW_PATIENT);
        Parent parent = ui.getParent();
        NewPatientController newPatientController = (NewPatientController) ui.getController();
        //controller.showPatient(patient);
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);

    }


}
