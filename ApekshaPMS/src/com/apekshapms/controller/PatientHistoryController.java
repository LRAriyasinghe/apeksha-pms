package com.apekshapms.controller;

import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.Patient;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class PatientHistoryController implements Controller{
    @FXML
    private Button nextButton;

    private Patient patient;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nextButton.setOnAction(event -> {
            UI ui = UIFactory.getUI(UIName.ASSIGNING);
            Parent parent = ui.getParent();
            AssigningController controller = (AssigningController) ui.getController();
            controller.showPatient(patient);
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
}
