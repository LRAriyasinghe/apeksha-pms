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

    private ObservableList cancerType = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fillListView1();
        fillListView12();
        //registerDocListView.getItems().addAll("a","b","c");
        //consultantDocListView.getItems().addAll("a","b","c");
        //registerDocListView.getItems().add(String.valueOf(registerDoc));
        //consultantDocListView.getItems().add(String.valueOf(consultant));
        addedDocterTable();

        cancerType.addAll("A","B","C");
        cancerTypeChoiceBox.setItems(cancerType);

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (isInputValid()){
                    String emp_idReg = txtRegisterDocId.getText();
                    String emp_idCons = txtConsultantId.getText();
                    if (ValidateSearchRegisterDoctor.validate_registerDoc(emp_idReg)){ //Check Registor Doctor ID
                        if (ValidateSearchConsultant.validate_consultant(emp_idCons)){ //Check Consultant Doctor ID
                                patient.setRegisterDocId(txtRegisterDocId.getText());
                                patient.setConsultantId(txtConsultantId.getText());
                                patient.setDetails(EEE.getText());
                                patient.setCancerType(cancerTypeChoiceBox.getValue());
                                patient.setJoinedDate(joinedDatePicker.getValue());

                            PatientServices.addPatient(patient);

//                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);//Patient Register Confirmation Dialog box
//                            alert.setTitle("Confirmation Dialog");
//                            alert.setHeaderText("Look, a Confirmation Dialog");
//                            alert.setContentText("Are you ok with this?");
//
//                            Optional<ButtonType> result = alert.showAndWait();
//                            if (result.get() == ButtonType.OK){
//
//                                System.out.println("Yes");
//                                PatientServices.addPatient(patient);
//
//                            } else {
//                                UIFactory.launchUI(UIName.NEW_PATIENT, true);
//                                // ... user chose CANCEL or closed the dialog
//                            }

                        }else{
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Warning Dialog");
                            alert.setHeaderText("Look, a Warning Dialog");
                            alert.setContentText("Invalid Consultant ID.!");

                            alert.showAndWait();
                        }
                    }else{
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning Dialog");
                        alert.setHeaderText("Look, a Warning Dialog");
                        alert.setContentText("Invalid Regostor Doctor ID.!");

                        alert.showAndWait();
                    }
                }



            }
        });

        registerDocListView.setOnMouseClicked((MouseEvent mouseEvent) ->{

            try {
                Connection connection = new Connector().getConnection();
                preparedStatement = connection.prepareStatement("select emp_Id from registerdoctor");
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

        consultantDocListView.setOnMouseClicked((MouseEvent mouseEvent) ->{
            try {
                Connection connection = new Connector().getConnection();
                preparedStatement = connection.prepareStatement("select emp_Id from consultant");
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
    }

    private void loadDocterDetails() {
        try {
            Connection connection = new Connector().getConnection();
            preparedStatement = connection.prepareStatement("select emp_Id,firstName,lastName,type from employee");
            rs=preparedStatement.executeQuery();
            while (rs.next()){
                empdata.add(new Employee(
                        rs.getString("emp_Id"),
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

    private void fillListView1(){
        try {
            Connection connection = new Connector().getConnection();
            preparedStatement = connection.prepareStatement("select emp_Id from registerdoctor");
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

    private void fillListView12(){
        try {
            Connection connection = new Connector().getConnection();
            preparedStatement = connection.prepareStatement("select emp_Id from consultant");
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

    private  void addedDocterTable(){
        docterTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        idColumn.setCellValueFactory(new PropertyValueFactory<Employee,String>("emp_Id"));
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

    public void showPatient(Parent parent) {
    }

    @FXML
    void handleBackButton(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.PATIENT_HISTORY);
        Parent parent = ui.getParent();
        PatientHistoryController controller = (PatientHistoryController) ui.getController();
        //controller.showPatient(patient);
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);

    }
    @FXML
    void handleBackOnAction(javafx.event.ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.EMTY);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);

    }
}
