package com.apekshapms.controller.sidebar;

import com.apekshapms.controller.Controller;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.ui.UIName;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterDoctorSideBarController implements Controller {

    @FXML
    private Button newPatientButton;

    @FXML
    private Button searchPatientButton;

    @FXML
    private Button issueDiagnizationButton;

    @FXML
    void handleNewPatientButtonAction(ActionEvent event) {
        UIFactory.launchUI(UIName.NEW_PATIENT, true);

    }

    @FXML
    void handleSearchPatientAction(ActionEvent event) {
        UIFactory.launchUI(UIName.SEARCH_PATIENT, true);

    }

    @FXML
    void issueDiagnizationButtonAction(ActionEvent event) {
        UIFactory.launchUI(UIName.SOME_LOGIN, true);

    }

    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
