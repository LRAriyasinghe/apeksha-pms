package com.apekshapms.controller.main;

import com.apekshapms.controller.Controller;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.ui.UIName;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class AdminDashboardController implements Controller{

    @FXML
    private AnchorPane workspaceAnchorPane;

    @FXML
    private Button patientButton;
    @FXML
    private Button employeeButton;
    @FXML
    private Button reportdButton;
    @FXML
    private Button wardButton;
    @FXML
    private Button treatmentButton;
   /* @FXML
    private ImageView profile;
    @FXML
    private Button txtEdit;
    @FXML
    private Button txtLogOut;
    */


    private static final Duration WORKSPACE_ANIMATE_TIME = Duration.millis(400);

    public AdminDashboardController() {
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Rectangle clipRectangle = new Rectangle(1100, 700);
        workspaceAnchorPane.setClip(clipRectangle);

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


        patientButton.setOnAction(event -> UIFactory.launchUI(UIName.PATIENT_DASHBOARD, true));

        employeeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIFactory.launchUI(UIName.EMPLOYEE_DASHBOARD, true);
            }
        });

        reportdButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIFactory.launchUI(UIName.REPORT_DASHBOARD, true);
            }
        });

        wardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {UIFactory.launchUI(UIName.WARD_DASHBOARD, true);}
        });

        treatmentButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {UIFactory.launchUI(UIName.TREATMENT_DASHBOARD, true);}
        });
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

    public void setWorkspace(Parent parent) {
        if (!(workspaceAnchorPane.getChildren().size() > 0 && workspaceAnchorPane.getChildren().get(0).equals(parent))) {
            slideInParent(parent);
        }
    }
}
