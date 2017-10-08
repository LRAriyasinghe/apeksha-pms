package com.apekshapms.controller;

import com.apekshapms.model.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;

import java.util.Date;
import java.util.ResourceBundle;

import static javafx.scene.input.KeyCode.T;

//import com.apekshapms.database.connector.PatientConnector.pat_id;

public class SearchPatientController implements Controller<Patient>{

    @FXML
    private Label lblSearchPatient;

    @FXML
    public static TextField txtSearchPatient;

    @FXML
    private TableView<Patient> tableSearch;

    @FXML
    private TableColumn<Patient , String> tblColoumnId;

    @FXML
    private TableColumn<Patient , String> tblColoumnTitle;

    @FXML
    private TableColumn<Patient , String> tblColoumnFirsName;

    @FXML
    private TableColumn<Patient , String> tblColoumnLastName;

    @FXML
    private TableColumn<Patient , String> tblColoumnNic;

    @FXML
    private TableColumn<Patient , Date> tblColoumnDob;

    @FXML
    private TableColumn<Patient , String> tblColoumnGender;

    @FXML
    private TableColumn<Patient , String> tblColoumnOccupation;

    @FXML
    private TableColumn<Patient , String> tblColoumnStatus;

    @FXML
    private TableColumn<Patient , String> tblColoumnInfo;




    @FXML
    private Button btnCancelPatient;

    @FXML
    private Button btnEditPatient;

    @FXML
    private Button btnSavePatient;


    @FXML
    private Button btnSearchPatient;


    public SearchPatientController(){

    }

    @Override
    public void refreshView() {

    }

   public void refreshView(Patient patient1){

       public ObservableList<Patient> list = FXCollections.observableArrayList()(

       tblColoumnId.setCellValueFactory(new PropertyValueFactory<>(patient1.getId()));
       tblColoumnTitle.setCellValueFactory(new PropertyValueFactory<>(patient1.getTitle()));
       tblColoumnFirsName.setCellValueFactory(new PropertyValueFactory<>(patient1.getFirstName()));
       tblColoumnLastName.setCellValueFactory(new PropertyValueFactory<>(patient1.getLastName()));
       tblColoumnNic.setCellValueFactory(new PropertyValueFactory<>(patient1.getNicNo()));
       tblColoumnDob.setCellValueFactory(new PropertyValueFactory<T>,ObservableValue<T>(patient1.getDob()));
       tblColoumnGender.setCellValueFactory(new PropertyValueFactory<>(patient1.isMale()));
       tblColoumnOccupation.setCellValueFactory(new PropertyValueFactory<>(patient1.getOccupation()));
       tblColoumnStatus.setCellValueFactory(new PropertyValueFactory<>(patient1.isCivil()));
       tblColoumnInfo.setCellValueFactory(new PropertyValueFactory<>(patient1.getDetails()));
       )
   }


   /* private boolean isInputValid() {
        String errorMessage = "";

        if (txtSearchPatient.getText() == null || txtSearchPatient.getText().length() == 0) {
            errorMessage += "No valid ID!\n";
        }
        if (errorMessage.length() == 0) {
                return true;
        } else {


                // Show the error message
                //Dialogs.showErrorDialog(dialogStage, errorMessage,
                //"Please correct invalid fields", "Invalid Fields")
            System.out.println("Successfully Fail");
            //Alert alert = new Alert(Alert.AlertType.WARNING);
            //alert.setTitle("Warning Dialog");
            //alert.setHeaderText("Look, a Warning Dialog");
            //alert.setContentText(errorMessage);

            //alert.showAndWait();
                // Dialogs.showWarningDialog(new Stage(), "Careful with the next step!", "Warning Dialog", "title");

            return false;

            }

    }*/
}
