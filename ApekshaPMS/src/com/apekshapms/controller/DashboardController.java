package com.apekshapms.controller;

import com.apekshapms.main.Session;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable{

    @FXML
    private AnchorPane containerAnchorPane;

    @FXML
    private Button button1Button;
    @FXML
    private Button button2Button;
    @FXML
    private Button button3Button;
    @FXML
    private Button button4Button;
    @FXML
    private Button button5Button;

    public DashboardController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       /* button1Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/com/apekshapms/ui/view/NewPatient.fxml"));
                    containerAnchorPane.getChildren().add(root);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/


        button2Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("cat");
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/com/apekshapms/ui/view/EditPatientDetails.fxml"));
                    containerAnchorPane.getChildren().add(root);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Session.dashboardController = this;
    }

    public  void changeslide1(){
        //System.out.println("fhdgdgdg");
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/com/apekshapms/ui/view/PatientHistory.fxml"));

            containerAnchorPane.getChildren().clear();

            containerAnchorPane.getChildren().add(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void changeslide2(){
        //System.out.println("fhdgdgdg");
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/com/apekshapms/ui/view/Assigning.fxml"));

            containerAnchorPane.getChildren().clear();

            containerAnchorPane.getChildren().add(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
