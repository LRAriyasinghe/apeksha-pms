package com.apekshapms.controller;

import com.apekshapms.factory.UIFactory;
import com.apekshapms.ui.UIName;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboardController implements Controller {



    @FXML
    private AnchorPane workSpaceAdmin;
    @FXML
    private Button empManageButton;
    @FXML
    private Button genReportsButton;
    @FXML
    private Button searchButton;



    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        empManageButton.setOnAction(event -> UIFactory.launchUI(UIName.SELECT_OPTIONS, true));

    }
}
