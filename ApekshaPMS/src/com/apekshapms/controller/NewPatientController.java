package com.apekshapms.controller;

import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.Patient;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class NewPatientController implements Controller {

    @FXML
    private Button nextButton;

    @FXML
    private TextField txtIdNo;

    @FXML
    private TextField txtTtile;

    @FXML
    private TextField txtFirstname;

    @FXML
    private TextField txtLastname;

    @FXML
    private DatePicker DOB;

    @FXML
    private RadioButton Male;

    @FXML
    private RadioButton Female;

    @FXML
    private TextField txtOccupation;

    @FXML
    private TextField txtContactNo;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtDistrict;

    @FXML
    private TextArea txtAddress;

    @FXML
    private ComboBox cmbCivil;

    private Patient patient;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UI ui = UIFactory.getUI(UIName.PATIENT_HISTORY);
                Parent parent = ui.getParent();
                PatientHistoryController controller = (PatientHistoryController) ui.getController();
                controller.showPatient(patient);
                DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
                dashboardController.setWorkspace(parent);
            }
        });
    }

    @Override
    public void refreshView() {

    }
}
