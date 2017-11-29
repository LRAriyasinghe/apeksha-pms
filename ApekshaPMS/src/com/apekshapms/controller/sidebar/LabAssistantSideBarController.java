package com.apekshapms.controller.sidebar;

import com.apekshapms.controller.Controller;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.ui.UIName;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class LabAssistantSideBarController implements Controller{

    @FXML
    private Button addReportButton;

    @FXML
    private Button addDetailsButton;

    @FXML
    private Button checkReportButton;

    @FXML
    void handleAddDetailsButtonAction(ActionEvent event) {UIFactory.launchUI(UIName.ADD_DETAILS, true);}

    @FXML
    void handleAddReportButtonAction(ActionEvent event) {UIFactory.launchUI(UIName.ADD_REPORT, true);}

    @FXML
    void handleCheckReportButtonAction(ActionEvent event) {UIFactory.launchUI(UIName.CHECK_REPORT, true);}

    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
