package com.apekshapms.controller.consultant;


import com.apekshapms.controller.Controller;
import com.apekshapms.controller.DashboardController;
import com.apekshapms.database.connector.TreatmentConnector;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.main.Session;
import com.apekshapms.model.DiagnosisCard;
import com.apekshapms.model.Patient;
import com.apekshapms.model.Treatment;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import com.sun.org.apache.xpath.internal.operations.String;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
//controller of DiagnosisCardcontroller3.fxml
public class DiagnosisCardController3 implements Controller {


    @FXML
    private AnchorPane backgroundAnchorPane;

    @FXML
    private TextField txtConsultantName;

    @FXML
    private TextField txtDate;

    @FXML
    private TableView<Treatment> patientTableView;

    @FXML
    private TableColumn<Treatment, String> DateTableColumn;

    @FXML
    private TableColumn<Treatment, String> TimeTableColumn;

    @FXML
    private TableColumn<Treatment, String> VenueTableColumn;

    @FXML
    private TableColumn<Treatment, String> DiagnosisTableColumn;

    @FXML
    private TableColumn<Treatment, String> AdditionalDetailsTableColumn;

    @FXML
    private TableColumn<Treatment, String> NextVisitDetailsTableColumn;

    @FXML
    private TextField txtConsultantName1;

    @FXML
    private TextField txtConsultantName11;

    @FXML
    private TextField txtConsultantName12;

    @FXML
    private TextField txtConsultantName13;

    @FXML
    private AnchorPane backgroundAnchorPane1;

    @FXML
    private TextField txtDate1;


    @FXML
    private Button addButton;

    @FXML
    private Button backButton;

    @FXML
    private DatePicker datePicker;


    @FXML
    private TextField txtTime;

    @FXML
    private TextField txtVenue;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtAdditionalDet;

    @FXML
    private TextField txtTimeh;

    @FXML
    private TextField txtTimem;

    @FXML
    private TextField txtNextVisitDetails;

    private DiagnosisCard diagnosisCard;

    private ObservableList<Treatment> treatmentsob;


    @FXML
    private Button cancelButton;

    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        datePicker.setPromptText("yyyy-mm-dd");
        datePicker.setValue(LocalDate.now());

        backButton.setOnAction(e -> {
            //if (isInputValid()) {
            UI ui = UIFactory.getUI(UIName.DIAGNOSIS_CARD2);
            Parent parent = ui.getParent();
            DiagnosisCardController2 controller = (DiagnosisCardController2) ui.getController();


            controller.setFields(diagnosisCard);
            DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
            dashboardController.setWorkspace(parent);
            //}
        });
        addButton.setOnAction(e -> addButtonClicked());

        cancelButton.setOnAction(e -> cancelButtonClicked());

    }
    //set fields in DiagnosisCard3 and table
    public void setFields(DiagnosisCard diagnosisCard) {
        this.diagnosisCard = diagnosisCard;
        treatmentsob = diagnosisCard.getTreatments();
        DateTableColumn.setCellValueFactory(new PropertyValueFactory<Treatment, String>("Date"));
        TimeTableColumn.setCellValueFactory(new PropertyValueFactory<Treatment, String>("time"));
        VenueTableColumn.setCellValueFactory(new PropertyValueFactory<Treatment, String>("venue"));
        DiagnosisTableColumn.setCellValueFactory(new PropertyValueFactory<Treatment, String>("description"));
        patientTableView.setItems(treatmentsob);
        patientTableView.setTableMenuButtonVisible(true);

    }

    private void addButtonClicked() {

        Treatment treatment = new Treatment();
        if (isInputValid()) {
            treatment.setDate(datePicker.getValue());
            treatment.setTime(java.time.LocalTime.of(Integer.parseInt(txtTimeh.getText()), Integer.parseInt(txtTimem.getText())));
            treatment.setVenue(txtVenue.getText());
            treatment.setDescription(txtDescription.getText());
            treatment.setPatientId(diagnosisCard.getPatient().getId());
            treatment.setEmpId("1");
        }

        try {
            TreatmentConnector.newTreatment(treatment);
        } catch (Exception e) {
            e.printStackTrace();
        }


        patientTableView.getItems().add(treatment);

        datePicker.setValue(LocalDate.now());
        txtVenue.clear();
        txtDescription.clear();
        txtTimeh.clear();
        txtTimem.clear();
    }

    private void cancelButtonClicked() {

    }
//validation
    private boolean isInputValid() {
        java.lang.String errorMessage = "";

        if (txtVenue.getText() == null || txtVenue.getText().length() == 0) {
            errorMessage += "Not a valid Venue!\n";
        }
        if (txtDescription.getText() == null || txtDescription.getText().length() == 0) {
            errorMessage += "No valid Description!\n";
        }
        //if (txtNextVisitDetails.getText() == null || txtNextVisitDetails.getText().length() == 0) {
        //     errorMessage += "No valid Next Visit Details!\n";
        //  }
        if (datePicker.getValue() == null || datePicker.getValue().lengthOfYear() == 0) {
            errorMessage += "No valid Date!\n";
        }


        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //get current date time with Date()
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        System.out.println(datePicker.getValue());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1, date2;
        try {
            date1 = sdf.parse(dateFormat.format(date));
            date2 = sdf.parse(java.lang.String.valueOf(datePicker.getValue()));

            if (date2.compareTo(date1) > 0) {
                //System.out.println("Date1 is after Date2");
                errorMessage += "No valid Date!\n";
            }


        } catch (Exception e) {
            // e.printStackTrace();
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Look, a Warning Dialog");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            System.out.println("Successfully Fail");

            return false;
        }
    }

}
