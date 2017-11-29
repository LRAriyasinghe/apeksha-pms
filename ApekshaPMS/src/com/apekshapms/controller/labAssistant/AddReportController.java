package com.apekshapms.controller.labAssistant;

import com.apekshapms.controller.Controller;
import com.apekshapms.controller.DashboardController;
import com.apekshapms.controller.PatientHistoryController;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Thilina on 10/28/2017.
 * Univercity of Colombo School of Computing
 */
public class AddReportController implements Controller {
    @FXML
    private Button addNewReportButton;

    @FXML
    void handleaddNewReportButtonAction(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.LAB_OVERVIEW);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);
    }

    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
