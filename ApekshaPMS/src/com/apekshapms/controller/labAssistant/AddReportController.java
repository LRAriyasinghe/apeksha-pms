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
    //@FXML
    //private Button btnCreactiveReport;

    @FXML
    void handleaddNewReportButtonAction(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.LAB_OVERVIEW);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);
    }

    @FXML
    void handleBoneMarrowReportButtonAction(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.BONEMARROW_REPORT);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);
    }

    @FXML
    void handleCeativeReportButtonAction(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.CREACTIVEPROTEIN_REPORT);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);
    }

    @FXML
    void handleFullBloodReportButtonAction(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.FULLBLOODCOUNT_REPORT);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);
    }

    @FXML
    void handleLipidProfileReportButtonAction(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.LIPIDPROFILE_REPORT);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);
    }

    @FXML
    void handleLiverFunctionReportButtonAction(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.LIVERFUNCTION_REPORT);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);
    }

    @FXML
    void handleSerumCalciumReportButtonAction(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.SERUMCALCIUM_REPORT);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);
    }

    @FXML
    void handleSerumElectrolytesReportButtonAction(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.SERUM_ELECTROLYTES_REPORT);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);
    }
    @FXML
    void handleSerumProteinReportButtonAction(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.SERUM_PROTEIN_REPORT);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);
    }

    @FXML
    void handleThyroidReportButtonAction(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.THYROID_REPORT);
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
