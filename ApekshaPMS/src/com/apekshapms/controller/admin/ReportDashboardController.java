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
    private Button textualAnalysisButton;

    @FXML
    private  Button searchReportButton;

    @Override
    public void refreshView() {

    }


    //Action event for Statistical Button
    @FXML
    void handleMaleFemaleDistrictOnAction(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.STATISTICAL_ANALYSIS_ALL_GRAPHICAL_EXAMPLE);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Action button for Add report
        addReportButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UI ui = UIFactory.getUI(UIName.ADD_REPORT);
                Parent parent = ui.getParent();
                DashboardController adminDashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
                adminDashboardController.setWorkspace(parent);
            }
        });

        //Action Event For textual Button
        textualAnalysisButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UI ui = UIFactory.getUI(UIName.STATISTICAL_TEXTUAL_ANALYSIS);
                Parent parent = ui.getParent();
                DashboardController adminDashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
                adminDashboardController.setWorkspace(parent);
            }
        });

        //Action button for Search report
        searchReportButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UI ui = UIFactory.getUI(UIName.SEARCH_LAB_REPORT);
                Parent parent = ui.getParent();
                DashboardController adminDashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
                adminDashboardController.setWorkspace(parent);
            }
        });

    }
}
