package com.apekshapms.controller.admin;

import com.apekshapms.controller.Controller;
import com.apekshapms.controller.DashboardController;
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
public class WardDashboardController implements Controller {

    @FXML
    private Button wardManagementButton;
    @FXML
    private Button wardDeleteButton;


    //Action button for New ward
    @FXML
    void handleNewWardButtonAction(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.NEW_WARD);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);
    }

    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Actioneent for Ward Management
        wardManagementButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UI ui = UIFactory.getUI(UIName.WARD_MANAGEMENT);
                Parent parent = ui.getParent();
                DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
                dashboardController.setWorkspace(parent);
            }
        });


    }
}
