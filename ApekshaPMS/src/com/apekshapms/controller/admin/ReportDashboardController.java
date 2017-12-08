package com.apekshapms.controller.admin;

import com.apekshapms.controller.Controller;
import com.apekshapms.controller.DashboardController;
import com.apekshapms.controller.PatientHistoryController;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Thilina on 10/10/2017.
 * Univercity of Colombo School of Computing
 */
public class ReportDashboardController implements Controller {
    @FXML
    private Button addReportButton;

    @FXML
    private Button statisticalMaleFemaleDistrictButoon;

    @Override
    public void refreshView() {

    }

    @FXML
    void handleAnalysisallReportOnAction(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.STATISTICAL_ANALYSIS_ALL_GRAPHICAL_EXAMPLE);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);

    }

    @FXML
    void handleStatisticalOnAction(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.STATISTICAL_ANALYSIS_GRAPHICAL);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);

    }

    @FXML
    void handleMaleFemaleDistrictOnAction(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.STATISTICAL_ANALYSIS_GRAPHICAL_MALE_FEMALE_DISTRICT);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);
    }

    @FXML
    void handleCancerTypeCountOnAction(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.STATISTICAL_ANALYSIS_GRAPHICAL_CANCERTYPE_COUNT);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);
    }

    @FXML
    void handleCancerTypePieChartOnAction(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.STATISTICAL_ANALYSIS_GRAPHICAL_PIE_CHART);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);
    }

    @FXML
    void handleSearchOnAction(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.SEARCH_PATIENT);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);
    }





    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addReportButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UI ui = UIFactory.getUI(UIName.LAB_OVERVIEW);
                Parent parent = ui.getParent();
                DashboardController adminDashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
                adminDashboardController.setWorkspace(parent);
            }
        });

    }
}
