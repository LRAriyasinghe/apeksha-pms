package com.apekshapms.controller.admin;

import com.apekshapms.controller.Controller;
import com.apekshapms.controller.DashboardController;
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
 * Created by Thilina on 10/10/2017.
 * Univercity of Colombo School of Computing
 */
public class EmployeeDashboardController implements Controller {
    @FXML
    private Button addEmployeeButton;

    //Action event for add New Employee Button
    @FXML
    void handleAddEmployeeOnAction(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.ADD_NEW_EMPLOYEE);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);

    }


    //Action event for Search Employee
    @FXML
    void handleSearchEmployeeButton(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.ADMIN_SEARCH_EMPLOYEE);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);

    }

    //Example
    @FXML
    void handleExampleButton(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.EXAMPLE);
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
