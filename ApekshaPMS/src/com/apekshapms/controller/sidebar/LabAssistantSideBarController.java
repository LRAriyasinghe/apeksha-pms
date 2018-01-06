package com.apekshapms.controller.sidebar;

import com.apekshapms.controller.Controller;
import com.apekshapms.controller.labAssistant.ReceivedMessageController;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.ui.UIName;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
    private Label massageNotificationLable;


    //All Sidebar Buyyon Action Event
    @FXML
    void handleAddDetailsButtonAction(ActionEvent event) {UIFactory.launchUI(UIName.ADD_DETAILS, true);}

    @FXML
    void handleAddReportButtonAction(ActionEvent event) {UIFactory.launchUI(UIName.ADD_REPORT, true);}

    @FXML
    void handleCheckReportButtonAction(ActionEvent event) {UIFactory.launchUI(UIName.CHECK_REPORT, true);}

    @FXML
    void handleReceivedMessagesButtonAction(ActionEvent event) {UIFactory.launchUI(UIName.RECEIVED_MESSAGES, true);}

    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Check report action event
        checkReportButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIFactory.launchUI(UIName.SEARCH_LAB_REPORT, true);
            }
        });
        getMassageNotificationLable().setText(String.valueOf(ReceivedMessageController.sideBarcountNewMessage()));
    }

    public void showUpdatedNewMessagesCount(){
        getMassageNotificationLable().setText(String.valueOf(ReceivedMessageController.sideBarcountNewMessage()));
    }

    public Label getMassageNotificationLable() {
        return massageNotificationLable;
    }

    public void setMassageNotificationLable(Label massageNotificationLable) {
        this.massageNotificationLable = massageNotificationLable;
    }
}
