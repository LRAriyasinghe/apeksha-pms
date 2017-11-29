package com.apekshapms.controller;

import com.apekshapms.factory.UIFactory;
import com.apekshapms.main.Main;
import com.apekshapms.model.Employee;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import javax.swing.text.html.ImageView;
import javax.xml.stream.Location;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class DashboardController implements Controller{

    @FXML
    private AnchorPane workspaceAnchorPane;
    @FXML
    private AnchorPane sideBarDownAnchorPane;

    @FXML
    private Button newPatientButton;
    @FXML
    private Button searchPatientButton;
    @FXML
    private Button issueDiagnizationCardButton;
   /* @FXML
    private ImageView profile;
    @FXML
    private Button txtEdit;
    @FXML
    private Button txtLogOut;
    */


    private static final Duration WORKSPACE_ANIMATE_TIME = Duration.millis(400);

    public DashboardController() {
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Rectangle clipRectangle = new Rectangle(1100, 700);
        Rectangle clipRectangle1 = new Rectangle(200,600);
        workspaceAnchorPane.setClip(clipRectangle);
        sideBarDownAnchorPane.setClip(clipRectangle1);

       /* txtEdit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIFactory.launchUI(UIName.SOME_LOGIN, true);
            }
        });

        txtLogOut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIFactory.launchUI(UIName.SOME_LOGIN, true);
            }
        });*/


       /*
        newPatientButton.setOnAction(event -> UIFactory.launchUI(UIName.NEW_PATIENT, true));

        searchPatientButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIFactory.launchUI(UIName.SEARCH_PATIENT, true);
            }
        });

        issueDiagnizationCardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIFactory.launchUI(UIName.SOME_LOGIN, true);
            }
        });
        */
    }

    @Override
    public void refreshView() {

    }

    private void slideInParent(Parent parent) {
        TranslateTransition parentInTranslation = new TranslateTransition(WORKSPACE_ANIMATE_TIME);
        parentInTranslation.setFromX(1100);
        parentInTranslation.setToX(0);
        parentInTranslation.setNode(parent);

        if (workspaceAnchorPane.getChildren().size() == 0) {
            workspaceAnchorPane.getChildren().add(parent);
            parentInTranslation.play();
        } else {
            Node childNode = workspaceAnchorPane.getChildren().get(0);
            workspaceAnchorPane.getChildren().add(parent);

            TranslateTransition childOutTranslation = new TranslateTransition(WORKSPACE_ANIMATE_TIME);
            childOutTranslation.setFromX(0);
            childOutTranslation.setToX(-1100);
            childOutTranslation.setNode(childNode);

            ParallelTransition parallelTransition = new ParallelTransition(parentInTranslation, childOutTranslation);
            parallelTransition.setOnFinished(event -> {
                Iterator<Node> nodeIterator = workspaceAnchorPane.getChildren().iterator();
                while (nodeIterator.hasNext()) {
                    nodeIterator.next();
                    if (nodeIterator.hasNext()) {
                        nodeIterator.remove();
                    }
                }
            });
            parallelTransition.play();
        }
    }

    private void slideBarParent(Parent parent) {
        TranslateTransition parentInTranslation = new TranslateTransition(WORKSPACE_ANIMATE_TIME);
        parentInTranslation.setFromX(1100);
        parentInTranslation.setToX(0);
        parentInTranslation.setNode(parent);

        if (sideBarDownAnchorPane.getChildren().size() == 0) {
            sideBarDownAnchorPane.getChildren().add(parent);
            parentInTranslation.play();
        } else {
            Node childNode = sideBarDownAnchorPane.getChildren().get(0);
            sideBarDownAnchorPane.getChildren().add(parent);

            TranslateTransition childOutTranslation = new TranslateTransition(WORKSPACE_ANIMATE_TIME);
            childOutTranslation.setFromX(0);
            childOutTranslation.setToX(-1100);
            childOutTranslation.setNode(childNode);

            ParallelTransition parallelTransition = new ParallelTransition(parentInTranslation, childOutTranslation);
            parallelTransition.setOnFinished(event -> {
                Iterator<Node> nodeIterator = sideBarDownAnchorPane.getChildren().iterator();
                while (nodeIterator.hasNext()) {
                    nodeIterator.next();
                    if (nodeIterator.hasNext()) {
                        nodeIterator.remove();
                    }
                }
            });
            parallelTransition.play();
        }
    }

    public void setWorkspace(Parent parent) {
        if (!(workspaceAnchorPane.getChildren().size() > 0 && workspaceAnchorPane.getChildren().get(0).equals(parent))) {
            slideInParent(parent);
        }
    }

    public void setSideBar(Parent parent) {
        if (!(sideBarDownAnchorPane.getChildren().size() > 0 && sideBarDownAnchorPane.getChildren().get(0).equals(parent))) {
            slideBarParent(parent);
        }
    }

    public static void loadSideBarRegisterDoctor(){
        UI ui = UIFactory.getUI(UIName.REGISTOR_DOCTOR_SIDEBAR);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setSideBar(parent);
    }

    public static void loadSideBarConsultantDoctor(){
        UI ui = UIFactory.getUI(UIName.CONSULTANT_DOCTOR_SIDEBAR);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setSideBar(parent);
    }

    public static void loadSideBarLabAssistant(){
        UI ui = UIFactory.getUI(UIName.LAB_ASSISTANT_SIDEBAR);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setSideBar(parent);
    }
}
