package com.apekshapms.controller;

import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.Patient;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    @FXML
    private Button cancelButton;


    private Patient patient;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //get New PAtient
        patient = new Patient();

        //Next Button Action Even
        nextButton.setOnAction((ActionEvent event) -> {
            patient.setHistory(txtHistory.getText());
            patient.setSurgical(txtSurgical.getText());
            patient.setAllergy(txtAllergy.getText());
            patient.setSocial(txtSocial.getText());
            patient.setFamily(txtFamily.getText());

            //Go to the Assign UI
            UI ui = UIFactory.getUI(UIName.ASSIGNING);
            Parent parent = ui.getParent();
            AssigningController controller = (AssigningController) ui.getController();
            controller.showPatientAgain(patient);
            DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
            dashboardController.setWorkspace(parent);
        });

        //Cancel Button Action Event
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UI ui = UIFactory.getUI(UIName.APEKSHA_HOME);
                Parent parent = ui.getParent();
                DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
                dashboardController.setWorkspace(parent);
            }
        });
    }

    @Override
    public void refreshView() {

    }


    public void showPatient(Patient patient) {
        this.patient = patient;
    }


    //Back Button Action Event
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
