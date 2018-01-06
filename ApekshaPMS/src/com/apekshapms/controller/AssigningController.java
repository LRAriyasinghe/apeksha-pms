package com.apekshapms.controller;

import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.*;
import com.apekshapms.services.PatientServices;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import com.apekshapms.validation.Patient_Registration.ValidateSearchConsultant;
import com.apekshapms.validation.Patient_Registration.ValidateSearchRegisterDoctor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import com.apekshapms.database.Connector;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;

public class AssigningController implements Controller {

    ObservableList<Employee> empdata = FXCollections.observableArrayList();
    //ObservableList<RegisterDocter> registerDoc = FXCollections.observableArrayList();
    //ObservableList<Consultant> consultant = FXCollections.observableArrayList();
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;

    @FXML
    private Button submitButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField txtRegisterDocId;

    @FXML
    private TextField txtConsultantId;

    @FXML
    private TextArea EEE;

    @FXML
    private TableView<Employee> docterTable;

    @FXML
    private TableColumn<Employee, String> firstnameColumn;

    @FXML
    private TableColumn<Employee, String> lastnameColumn;

    @FXML
    private TableColumn<Employee, String> typeColumn;

    @FXML
    private TableColumn<Employee, String> idColumn;

    @FXML
    private ListView<String> registerDocListView;

    @FXML
    private ListView<String> consultantDocListView;

    @FXML
    private ChoiceBox<String> cancerTypeChoiceBox;

    @FXML
    private DatePicker joinedDatePicker;

    private Patient patient;

    private ObservableList<String> cancerType = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Load ListView In Register Doctors
        fillListView1();
        //Load ListView In Consultant Doctors
        fillListView12();
        // load Cancer Type to ChoiceBox
        //checkCencerItems();

        //registerDocListView.getItems().addAll("a","b","c");
        //consultantDocListView.getItems().addAll("a","b","c");
        //registerDocListView.getItems().add(String.valueOf(registerDoc));
        //consultantDocListView.getItems().add(String.valueOf(consultant));

        //Load Doctors TavleView
        addedDocterTable();

        //Add Cancer Type to Choice Box
        cancerType.addAll("Lung","Brain","Bladder","Leukemia","Breast","Oral","Oesophagus","Prostate","Colon","Thyroid","Other");
        cancerTypeChoiceBox.setItems(cancerType);

        //Get New Patient
        patient = new Patient();

        //Submit Button Action Event
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Check Validity
                if (isInputValid()){
                    String emp_idReg = txtRegisterDocId.getText();
                    String emp_idCons = txtConsultantId.getText();

                    //Check Registor Doctor Availability
                    if (ValidateSearchRegisterDoctor.validate_registerDoc(emp_idReg)){
                        //Check Consultant Doctor Availability
                        if (ValidateSearchConsultant.validate_consultant(emp_idCons)){
                            System.out.println("Separated");
                            patient.setRegisterDocId(txtRegisterDocId.getText());
                            System.out.println(txtRegisterDocId.getText());
                                patient.setConsultantId(txtConsultantId.getText());
                            System.out.println(txtConsultantId.getText());
                                patient.setDetails(EEE.getText());
                            System.out.println(EEE.getText());
                                patient.setCancerType(cancerTypeChoiceBox.getValue());
                            System.out.println(cancerTypeChoiceBox.getValue());
                                patient.setJoinedDate(joinedDatePicker.getValue());
                            System.out.println(joinedDatePicker.getValue());
                            System.out.println("Data all get");

                            //Get the Patient and Go to the Patient Service
                            PatientServices.addPatient(patient);
                            PatientServices.addHistory(patient);

                        }else{
                            //Message box if Consultant Doctor is Unavailable
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Warning Dialog");
                            alert.setHeaderText("Look, a Warning Dialog");
                            alert.setContentText("Invalid Consultant ID.!");
                            alert.showAndWait();
                        }
                    }else{
                        //Message box if Register Doctor is Unavailable
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning Dialog");
                        alert.setHeaderText("Look, a Warning Dialog");
                        alert.setContentText("Invalid Regostor Doctor ID.!");
                        alert.showAndWait();
                    }
                }



            }
        });

        //Mouse Action Event for Displaying Register Doctor list view when Clicked
        registerDocListView.setOnMouseClicked((MouseEvent mouseEvent) ->{

            try {
                Connection connection = new Connector().getConnection();
                preparedStatement = connection.prepareStatement("select emp_Id from RegisterDoctor");
                rs=preparedStatement.executeQuery();
                while (rs.next()){
                    txtRegisterDocId.setText(rs.getString("emp_Id"));

                }
                preparedStatement.close();
                rs.close();
            }catch (Exception e){
                System.err.println(e);

            }

        });

        //Mouse Action Event for Displaying Consultant Doctor list view when Clicked
        consultantDocListView.setOnMouseClicked((MouseEvent mouseEvent) ->{
            try {
                Connection connection = new Connector().getConnection();
                preparedStatement = connection.prepareStatement("select emp_Id from Consultant");
                rs=preparedStatement.executeQuery();
                while (rs.next()){
                    txtConsultantId.setText(rs.getString("emp_Id"));

                }
                preparedStatement.close();
                rs.close();
            }catch (Exception e){
                System.err.println(e);

            }

        });


        //Cancel button Action Event go to the Home Page
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UI ui = UIFactory.getUI(UIName.APEKSHA_HOME);
                Parent parent = ui.getParent();
                DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
                dashboardController.setWorkspace(parent);
            }
        });
    }


    //Load  Table View in All Doctors
    private void loadDocterDetails() {
        try {
            Connection connection = new Connector().getConnection();
            preparedStatement = connection.prepareStatement("select emp_Id,firstName,lastName,type from Employee");
            rs=preparedStatement.executeQuery();
            while (rs.next()){
                empdata.add(new Employee(
                        rs.getString("emp_id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("type")
                ));
                docterTable.setItems(empdata);
                docterTable.setTableMenuButtonVisible(true);
            }
            preparedStatement.close();
            rs.close();
        }catch (Exception e){
            System.err.println(e);

        }
    }

    //Load Register Doctor ListView
    private void fillListView1(){
        try {
            Connection connection = new Connector().getConnection();
            preparedStatement = connection.prepareStatement("select emp_Id from RegisterDoctor");
            rs=preparedStatement.executeQuery();
            while (rs.next()){
                String current = rs.getString("emp_Id");
                ObservableList<String> list = FXCollections.observableArrayList(current);
                registerDocListView.getItems().addAll(list);
            }
            preparedStatement.close();
            rs.close();
        }catch (Exception e){
            System.err.println(e);

        }

    }

    //Load Consultant Doctor ListView
    private void fillListView12(){
        try {
            Connection connection = new Connector().getConnection();
            preparedStatement = connection.prepareStatement("select emp_Id from Consultant");
            rs=preparedStatement.executeQuery();
            while (rs.next()){
                String current = rs.getString("emp_Id");
                ObservableList<String> list = FXCollections.observableArrayList(current);
                consultantDocListView.getItems().addAll(list);
            }
            preparedStatement.close();
            rs.close();
        }catch (Exception e){
            System.err.println(e);

        }

    }

    //Add Doctors To the Table
    private  void addedDocterTable(){
        docterTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        idColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("id"));
        firstnameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("firstName"));
        lastnameColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("lastName"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("type"));
        loadDocterDetails();

    }

    @Override
    public void refreshView() {

    }

    public void showPatient(Patient patient) {
        this.patient = patient;
    }

    //check the validity of the input
    private boolean isInputValid() {
        String errorMessage = "";

        if (txtRegisterDocId.getText() == null || txtRegisterDocId.getText().length() == 0) {
            errorMessage += "No valid Register Doctor ID!\n";
        }
        if (txtConsultantId.getText() == null || txtConsultantId.getText().length() == 0) {
            errorMessage += "No valid Consultant Doctor ID!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {

            //Alert For Invalid TextFields
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Look, a Warning Dialog");
            alert.setContentText(errorMessage);
            alert.showAndWait();

            // Show the error message
            //Dialogs.showErrorDialog(dialogStage, errorMessage,
            //"Please correct invalid fields", "Invalid Fields");
            System.out.println("Validation Successfully Fail");
            //Dialogs.showWarningDialog(new Stage(), "Careful with the next step!", "Warning Dialog", "title");

            return false;

        }
    }

    //Show the Patient
    public void showPatientAgain(Patient patient) {
        this.patient=patient;
    }

    //Action event for the back buton
    @FXML
    void handleBackButton(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.PATIENT_HISTORY);
        Parent parent = ui.getParent();
        PatientHistoryController controller = (PatientHistoryController) ui.getController();
        //controller.showPatient(patient);
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);

    }

}
