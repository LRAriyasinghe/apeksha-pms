package com.apekshapms.controller.labAssistant;

import com.apekshapms.controller.Controller;
import com.apekshapms.database.Connector;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.LabReport;
import com.apekshapms.model.Patient;
import com.apekshapms.ui.UIName;
import com.sun.org.apache.xpath.internal.operations.String;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class SearchLabReportController implements Controller{
    //ObservableList<Patient> data = FXCollections.observableArrayList(); //Create Array for store patient data
    PreparedStatement preparedStatement = null;
    ResultSet rs= null;
    //FilteredList<Patient> filteredList = new FilteredList<>(data,e->true); //Create list for the Patient store while searching Patient

    private ObservableList CancerType = FXCollections.observableArrayList();
    java.lang.String Labreport = "";



    @FXML
    private TextField PatientIDTextField;

    @FXML
    private TextField TestIDTextField;
    @FXML
    private ComboBox<java.lang.String> TypeComoBox;
    @FXML
    private Button getreportButton;






    @Override
    public void refreshView() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CancerType.addAll("BoneMarrow","Creactive","FullBlood","LipidProfile","LiverFunction","SerumCalcium","SerumElectrolytes","serumProtein","Thyroid","UFRC","UrineForBence");
        TypeComoBox.setItems(CancerType);


        getreportButton.setOnAction(new EventHandler<ActionEvent>(){ //Search the Lab reports with Patient ID,Test ID and Type
            @Override
            public void handle(ActionEvent event) {
                if(TypeComoBox.getValue()=="BoneMarrow"){
                try{
                    Connection connection = new Connector().getConnection();
                    PreparedStatement preparedStatement1 = connection.prepareStatement("select test_Id,patient_Id,patient_name,date,type,emp_Id,remarks from testreport WHERE test_Id='" + TestIDTextField.getText() + "' && patient_Id='" + PatientIDTextField.getText() + "'");
                    ResultSet rs1 = preparedStatement1.executeQuery();
                    PreparedStatement preparedStatement2 = connection.prepareStatement("select BMBx,TrepchineBMBx from bonemarrow_report WHERE TestID='" + TestIDTextField.getText() + "' && Patient_Id='" + PatientIDTextField.getText() + "'");

                    ResultSet rs2 = preparedStatement2.executeQuery();


                    //View Lab report Details
                    System.out.println("Yes");
                    while(rs1.next()) {
                        Labreport += "Test Report ID : " + rs1.getString(1);
                        Labreport += "\nPatient ID  : " + rs1.getString(2);
                        Labreport += "\nPatient Name : " + rs1.getString(3);
                        Labreport += "\nDate  : " + rs1.getString(4);
                        Labreport += "\nType : " + rs1.getString(5);
                        Labreport += "\nEmployee ID  : " + rs1.getString(6);
                        Labreport += "\nRemarks : " + rs1.getString(7);
                        System.out.println("First");
                    }
                    while (rs2.next()) {
                        Labreport += "\nBMBx  : " + rs2.getString(1);
                        Labreport += "\nTrepchineBMBx  : " + rs2.getString(2);
                        System.out.println("Second");
                    }

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Lab Report");
                    alert.setHeaderText("Bonemarrow Report");
                    alert.setContentText("Full Details Report \n"+Labreport);
                    alert.show();
                    Labreport="";

                }catch (SQLException e) {
                    e.printStackTrace();
                }

                }

                else if(TypeComoBox.getValue()=="Creactive"){
                    try{
                        Connection connection = new Connector().getConnection();
                        PreparedStatement preparedStatement1 = connection.prepareStatement("select test_Id,patient_Id,patient_name,date,type,emp_Id,remarks from testreport WHERE  test_Id='" + TestIDTextField.getText() + "' && patient_Id='" + PatientIDTextField.getText() + "'");
                        ResultSet rs1 = preparedStatement1.executeQuery();
                        PreparedStatement preparedStatement2 = connection.prepareStatement("select c_reactive WHERE Testid='" + TestIDTextField.getText() + "' && Patient_Id='" + PatientIDTextField.getText() + "'");

                        ResultSet rs2 = preparedStatement2.executeQuery();

                        while (rs1.next()) {
                            //View Lab report Details
                            Labreport += "Test Report ID : " + rs1.getString(1);
                            Labreport += "\nPatient ID  : " + rs1.getString(2);
                            Labreport += "\nPatient Name : " + rs1.getString(3);
                            Labreport += "\nDate  : " + rs1.getString(4);
                            Labreport += "\nType : " + rs1.getString(5);
                            Labreport += "\nEmployee ID  : " + rs1.getString(6);
                            Labreport += "\nRemarks : " + rs1.getString(7);
                        }
                        while (rs2.next()) {
                            Labreport += "\nc_reactive  : " + rs2.getString(1);
                        }


                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Lab Report");
                        alert.setHeaderText("Creactive Report");
                        alert.setContentText("Full Report \n"+Labreport);

                    }catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
                else if(TypeComoBox.getValue()=="FullBlood"){
                    try{
                        Connection connection = new Connector().getConnection();
                        PreparedStatement preparedStatement1 = connection.prepareStatement("select test_Id,patient_Id,patient_name,date,type,emp_Id,remarks from testreport WHERE  test_Id='" + TestIDTextField.getText() + "' && patient_Id='" + PatientIDTextField.getText() + "'");
                        ResultSet rs1 = preparedStatement1.executeQuery();
                        PreparedStatement preparedStatement2 = connection.prepareStatement("select WBC,NE,Himoglobin,Platlets from fullblood_report WHERE Testid='" + TestIDTextField.getText() + "' && Patient_Id='" + PatientIDTextField.getText() + "'");

                        ResultSet rs2 = preparedStatement2.executeQuery();


                        //View Lab report Details
                        while (rs1.next()) {
                            Labreport += "Test Report ID : " + rs1.getString(1);
                            Labreport += "\nPatient ID  : " + rs1.getString(2);
                            Labreport += "\nPatient Name : " + rs1.getString(3);
                            Labreport += "\nDate  : " + rs1.getString(4);
                            Labreport += "\nType : " + rs1.getString(5);
                            Labreport += "\nEmployee ID  : " + rs1.getString(6);
                            Labreport += "\nRemarks : " + rs1.getString(7);
                        }
                        while (rs2.next()) {
                            Labreport += "\nWBC  : " + rs2.getString(1);
                            Labreport += "\nNE  : " + rs2.getString(2);
                            Labreport += "\nHimoglobin  : " + rs2.getString(3);
                            Labreport += "\nPlatlets  : " + rs2.getString(4);
                        }



                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Lab Report");
                        alert.setHeaderText("Full Blood Report");
                        alert.setContentText("Hi ?\n"+Labreport);

                    }catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
                if(TypeComoBox.getValue()=="LipidProfile"){
                    try{
                        Connection connection = new Connector().getConnection();
                        PreparedStatement preparedStatement1 = connection.prepareStatement("select test_Id,patient_Id,patient_name,date,type,emp_Id,remarks from testreport WHERE test_Id='" + TestIDTextField.getText() + "' && patient_Id='" + PatientIDTextField.getText() + "'");
                        ResultSet rs1 = preparedStatement1.executeQuery();
                        PreparedStatement preparedStatement2 = connection.prepareStatement("select Serum_Cholostrol,Serum_Triglycer,HDL,LDL,VLDL,CHOL,LDLHDL from lipidprofile_report WHERE TestID='" + TestIDTextField.getText() + "' && Patient_Id='" + PatientIDTextField.getText() + "'");

                        ResultSet rs2 = preparedStatement2.executeQuery();


                        //View Lab report Details
                        System.out.println("Yes");
                        while(rs1.next()) {
                            Labreport += "Test Report ID : " + rs1.getString(1);
                            Labreport += "\nPatient ID  : " + rs1.getString(2);
                            Labreport += "\nPatient Name : " + rs1.getString(3);
                            Labreport += "\nDate  : " + rs1.getString(4);
                            Labreport += "\nType : " + rs1.getString(5);
                            Labreport += "\nEmployee ID  : " + rs1.getString(6);
                            Labreport += "\nRemarks : " + rs1.getString(7);
                            System.out.println("First");
                        }
                        while (rs2.next()) {
                            Labreport += "\nSerum Cholostrol  : " + rs2.getString(1);
                            Labreport += "\nSerum_Triglycer  : " + rs2.getString(2);
                            Labreport += "\nHDL  : " + rs2.getString(3);
                            Labreport += "\nLDL  : " + rs2.getString(4);
                            Labreport += "\nVLDL  : " + rs2.getString(5);
                            Labreport += "\nCHOL  : " + rs2.getString(6);
                            Labreport += "\nLDLHDL  : " + rs2.getString(7);

                            System.out.println("Second");
                        }

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Lab Report");
                        alert.setHeaderText("Liver Profile Report");
                        alert.setContentText("Full Details Report \n"+Labreport);
                        alert.show();
                        Labreport="";

                    }catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
                if(TypeComoBox.getValue()=="LiverFunction"){
                    try{
                        Connection connection = new Connector().getConnection();
                        PreparedStatement preparedStatement1 = connection.prepareStatement("select test_Id,patient_Id,patient_name,date,type,emp_Id,remarks from testreport WHERE test_Id='" + TestIDTextField.getText() + "' && patient_Id='" + PatientIDTextField.getText() + "'");
                        ResultSet rs1 = preparedStatement1.executeQuery();
                        PreparedStatement preparedStatement2 = connection.prepareStatement("select Serum_Bilrubin,SGPT,SGOT,Serum_Alkaline,Serum_Creatinine,Serum_Calcium from liverfunction_report WHERE TestID='" + TestIDTextField.getText() + "' && Patient_Id='" + PatientIDTextField.getText() + "'");

                        ResultSet rs2 = preparedStatement2.executeQuery();


                        //View Lab report Details
                        System.out.println("Yes");
                        while(rs1.next()) {
                            Labreport += "Test Report ID : " + rs1.getString(1);
                            Labreport += "\nPatient ID  : " + rs1.getString(2);
                            Labreport += "\nPatient Name : " + rs1.getString(3);
                            Labreport += "\nDate  : " + rs1.getString(4);
                            Labreport += "\nType : " + rs1.getString(5);
                            Labreport += "\nEmployee ID  : " + rs1.getString(6);
                            Labreport += "\nRemarks : " + rs1.getString(7);
                            System.out.println("First");
                        }
                        while (rs2.next()) {
                            Labreport += "\nBMBx  : " + rs2.getString(1);
                            Labreport += "\nSerum Bilrubin  : " + rs2.getString(2);
                            Labreport += "\nSGPT  : " + rs2.getString(3);
                            Labreport += "\nSGOT  : " + rs2.getString(4);
                            Labreport += "\nSerum Alkaline  : " + rs2.getString(5);
                            Labreport += "\nSerum Creatinine  : " + rs2.getString(6);
                            Labreport += "\nSerum Calcium  : " + rs2.getString(7);



                            System.out.println("Second");
                        }

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Lab Report");
                        alert.setHeaderText("Bonemarrow Report");
                        alert.setContentText("Full Details Report \n"+Labreport);
                        alert.show();
                        Labreport="";

                    }catch (SQLException e) {
                        e.printStackTrace();
                    }

                }




            }
            });




        }
    }

