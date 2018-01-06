package com.apekshapms.controller.labReport;


import com.apekshapms.controller.Controller;
import com.apekshapms.controller.DashboardController;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.LabReport;
import com.apekshapms.services.LabReportServices;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class UrineForBenceJonesProteinController implements Controller{

    @FXML
    private DatePicker date;

    @FXML
    private TextField PatientIDTextField;

    @FXML
    private Label ReportTypeLabel;

    @FXML
    private TextField PatientNameTextField;

    @FXML
    private TextField ReferenceTextField;

    @FXML
    private TextArea RemarksTextField;


    @FXML
    private TextField AlbumineTextField;

    @FXML
    private TextField BenceJonesProteinTextField;

    @FXML
    private Button SubmitButton;

    @FXML
    private Button CancelButton;

    private LabReport labReport ;

    @FXML
    private Button backButton;

    public void initialize(URL location, ResourceBundle resources) {
        labReport = new LabReport();
        SubmitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                labReport.setID(PatientIDTextField.getText());
                labReport.setName(PatientNameTextField.getText());
                labReport.setDate(date.getValue());
                labReport.setReference(ReferenceTextField.getText());
                labReport.setRemarks(RemarksTextField.getText());
                labReport.setAlbumine(AlbumineTextField.getText());
                labReport.setBenceJones(BenceJonesProteinTextField.getText());

                //LabReportServices.addLabReportUrine(labReport);

            }
        });

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // ... user chose Bach Button
                UI ui = UIFactory.getUI(UIName.ADD_REPORT);
                Parent parent = ui.getParent();
                DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
                dashboardController.setWorkspace(parent);

            }
        });

    }

    @Override
    public void refreshView() {

    }
}
