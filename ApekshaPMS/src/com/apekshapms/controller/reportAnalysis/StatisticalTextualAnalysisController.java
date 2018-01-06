package com.apekshapms.controller.reportAnalysis;

import com.apekshapms.controller.Controller;
import com.apekshapms.database.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StatisticalTextualAnalysisController implements Controller {
    @FXML
    private Button clearButton;

    @FXML
    private Button getButton;

    @FXML
    private ComboBox YearComboBox;

    @FXML
    private ComboBox TypeComboBox;

    @FXML
    private ComboBox DistrictComboBox;

    @FXML
    private TextField totalTextField;

    @FXML
    private TextField maleTextField;

    @FXML
    private TextField femaleTextField;

    private ObservableList cancerType = FXCollections.observableArrayList();
    private ObservableList district = FXCollections.observableArrayList();
    private ObservableList year = FXCollections.observableArrayList();

    @Override
    public void refreshView() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cancerType.addAll("ALL", "Lung", "Brain", "Bladder", "Leukemia", "Breast", "Oral", "Oesophagus", "Colon", "Ovary");
        TypeComboBox.setItems(cancerType);

        district.addAll("Jaffna", "Kilinochchi", "Mannar", "Mullaitivu", "Vavuniya", "Puttalam", "Kurunegala", "Gampaha", "Colombo", "Kalutara", "Anuradhapura", "Polonnaruwa", "Matale", "Kandy", "Nuwara Eliya", "Kegalle", "Ratnapura", "Trincomalee", "Batticaloa", "Ampara", "Badulla", "Monaragala", "Hambantota", "Matara", "Galle");
        DistrictComboBox.setItems(district);

        year.addAll("2015", "2016", "2017");
        YearComboBox.setItems(year);

        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                YearComboBox.getSelectionModel().clearSelection();
                DistrictComboBox.getSelectionModel().clearSelection();
                TypeComboBox.getSelectionModel().clearSelection();
                totalTextField.clear();
                maleTextField.clear();
                femaleTextField.clear();
            }
        });

        getButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (YearComboBox.getSelectionModel().isEmpty() && TypeComboBox.getSelectionModel().isEmpty() && DistrictComboBox.getSelectionModel().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("No Search Criteria");
                    alert.setHeaderText("Empty Search Criteria");
                    alert.setContentText("Please Select Your Desired Search Criteria and Try Again");
                    alert.showAndWait();
                    alert.setOnCloseRequest(e -> alert.close());
                }

                //# 1 Only Year
                else if (!YearComboBox.getSelectionModel().isEmpty() && TypeComboBox.getSelectionModel().isEmpty() && DistrictComboBox.getSelectionModel().isEmpty()) {

                    try {
                        Connection connection = new Connector().getConnection();
                        String s ="select  EXTRACT(YEAR FROM Date_Joined),count(Date_Joined) from patient WHERE EXTRACT(YEAR FROM Date_Joined)='" + YearComboBox.getValue() + "'";
                        System.out.println(s);
                        PreparedStatement preparedStatement1 = connection.prepareStatement(s);
                        ResultSet rs1 = preparedStatement1.executeQuery();

                        PreparedStatement preparedStatement2 = connection.prepareStatement("select  EXTRACT(YEAR FROM Date_Joined),count(Date_Joined),gender from patient WHERE EXTRACT(YEAR FROM Date_Joined)='" + YearComboBox.getValue() + "'&& gender='Male'");
                        ResultSet rs2 = preparedStatement2.executeQuery();

                        PreparedStatement preparedStatement3 = connection.prepareStatement("select  EXTRACT(YEAR FROM Date_Joined),count(Date_Joined),gender from patient WHERE EXTRACT(YEAR FROM Date_Joined)='" + YearComboBox.getValue() + "'&& gender='Female'");
                        ResultSet rs3 = preparedStatement3.executeQuery();

                        while (rs1.next()) {
                            totalTextField.setText(rs1.getString(2));
                        }

                        while (rs2.next()) {
                            maleTextField.setText(rs2.getString(2));
                        }

                        while (rs3.next()) {
                            femaleTextField.setText(rs3.getString(2));
                        }

                         } catch (SQLException e) {
                        e.printStackTrace();
                            }
                        }

                //# 2 Only Cancer Type
                else if (YearComboBox.getSelectionModel().isEmpty() && !TypeComboBox.getSelectionModel().isEmpty() && DistrictComboBox.getSelectionModel().isEmpty()) {

                    if (TypeComboBox.getValue() == "ALL") {
                        try {
                            Connection connection = new Connector().getConnection();
                            PreparedStatement preparedStatement = connection.prepareStatement("select cancer_type,count(cancer_type) from patient ");
                            ResultSet rs = preparedStatement.executeQuery();

                            PreparedStatement preparedStatement2 = connection.prepareStatement("select cancer_type,count(cancer_type),gender from patient WHERE gender='Male'");
                            ResultSet rs2 = preparedStatement2.executeQuery();

                            PreparedStatement preparedStatement3 = connection.prepareStatement("select cancer_type,count(cancer_type),gender from patient WHERE  gender='Female'");
                            ResultSet rs3 = preparedStatement3.executeQuery();


                            while (rs.next()) {
                                totalTextField.setText(rs.getString(2));
                            }

                            while (rs2.next()) {
                                maleTextField.setText(rs2.getString(2));
                            }

                            while (rs3.next()) {
                                femaleTextField.setText(rs3.getString(2));
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            Connection connection = new Connector().getConnection();
                            PreparedStatement preparedStatement = connection.prepareStatement("select cancer_type,count(cancer_type) from patient WHERE cancer_type='" + TypeComboBox.getValue() + "'");
                            ResultSet rs = preparedStatement.executeQuery();

                            PreparedStatement preparedStatement2 = connection.prepareStatement("select cancer_type,count(cancer_type),gender from patient WHERE cancer_type='" + TypeComboBox.getValue() + "'&& gender='Male'");
                            ResultSet rs2 = preparedStatement2.executeQuery();

                            PreparedStatement preparedStatement3 = connection.prepareStatement("select cancer_type,count(cancer_type),gender from patient WHERE cancer_type='" + TypeComboBox.getValue() + "'&& gender='Female'");
                            ResultSet rs3 = preparedStatement3.executeQuery();


                            while (rs.next()) {
                                totalTextField.setText(rs.getString(2));
                            }

                            while (rs2.next()) {
                                maleTextField.setText(rs2.getString(2));
                            }

                            while (rs3.next()) {
                                femaleTextField.setText(rs3.getString(2));

                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }

                }

                //# 3 Only District
                if (YearComboBox.getSelectionModel().isEmpty() && TypeComboBox.getSelectionModel().isEmpty() && !DistrictComboBox.getSelectionModel().isEmpty()) {

                    try {
                        Connection connection = new Connector().getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement("select district,count(district) from patient WHERE district='" + DistrictComboBox.getValue() + "'");
                        ResultSet rs = preparedStatement.executeQuery();

                        PreparedStatement preparedStatement2 = connection.prepareStatement("select district,count(district),gender from patient WHERE district='" + DistrictComboBox.getValue() + "'&&gender='Male'");
                        ResultSet rs2 = preparedStatement2.executeQuery();

                        PreparedStatement preparedStatement3 = connection.prepareStatement("select district,count(district),gender from patient WHERE district='" + DistrictComboBox.getValue() + "'&&gender='Female'");
                        ResultSet rs3 = preparedStatement3.executeQuery();

                        while (rs.next()) {
                            totalTextField.setText(rs.getString(2));
                        }
                        while (rs2.next()) {
                            maleTextField.setText(rs2.getString(2));
                        }
                        while (rs3.next()) {
                            femaleTextField.setText(rs3.getString(2));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }


                //# 4 Year and Cancer Type
                if (!YearComboBox.getSelectionModel().isEmpty() && !TypeComboBox.getSelectionModel().isEmpty() && DistrictComboBox.getSelectionModel().isEmpty()) {

                    try {

                        Connection connection = new Connector().getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),cancer_type,count(cancer_type) from patient WHERE cancer_type='" + TypeComboBox.getValue() + "'&& EXTRACT(YEAR FROM Date_Joined)='" + YearComboBox.getValue() + "'");
                        ResultSet rs = preparedStatement.executeQuery();

                        PreparedStatement preparedStatement2 = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),cancer_type,count(cancer_type),gender from patient WHERE cancer_type='" + TypeComboBox.getValue() + "'&& EXTRACT(YEAR FROM Date_Joined)='" + YearComboBox.getValue() + "'&&gender='Male'");
                        ResultSet rs2 = preparedStatement2.executeQuery();

                        PreparedStatement preparedStatement3 = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),cancer_type,count(cancer_type),gender from patient WHERE cancer_type='" + TypeComboBox.getValue() + "'&& EXTRACT(YEAR FROM Date_Joined)='" + YearComboBox.getValue() + "'&&gender='Female'");
                        ResultSet rs3 = preparedStatement3.executeQuery();


                        while (rs.next()) {

                            totalTextField.setText(rs.getString(3));

                        }
                        while (rs2.next()) {

                            maleTextField.setText(rs2.getString(3));

                        }

                        while (rs3.next()) {

                            femaleTextField.setText(rs3.getString(3));

                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                //# 5 Year and District
                if (!YearComboBox.getSelectionModel().isEmpty() && TypeComboBox.getSelectionModel().isEmpty() && !DistrictComboBox.getSelectionModel().isEmpty()) {

                    try {

                        Connection connection = new Connector().getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),district,count(district) from patient WHERE district='" + DistrictComboBox.getValue() + "'&& EXTRACT(YEAR FROM Date_Joined)='" + YearComboBox.getValue() + "'");
                        ResultSet rs = preparedStatement.executeQuery();

                        PreparedStatement preparedStatement2 = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),district,count(district),gender from patient WHERE district='" + DistrictComboBox.getValue() + "'&& EXTRACT(YEAR FROM Date_Joined)='" + YearComboBox.getValue() + "'&&gender='Male'");
                        ResultSet rs2 = preparedStatement2.executeQuery();

                        PreparedStatement preparedStatement3 = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),district,count(district),gender from patient WHERE district='" + DistrictComboBox.getValue() + "'&& EXTRACT(YEAR FROM Date_Joined)='" + YearComboBox.getValue() + "'&&gender='Female'");
                        ResultSet rs3 = preparedStatement3.executeQuery();


                        while (rs.next()) {

                            totalTextField.setText(rs.getString(3));

                        }

                        while (rs2.next()) {

                            maleTextField.setText(rs2.getString(3));

                        }

                        while (rs3.next()) {

                            femaleTextField.setText(rs3.getString(3));

                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }


                //# 6 Cancer Type and District

                if (YearComboBox.getSelectionModel().isEmpty() && !TypeComboBox.getSelectionModel().isEmpty() && !DistrictComboBox.getSelectionModel().isEmpty()) {

                    try {

                        Connection connection = new Connector().getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement("select cancer_type,district,count(district) from patient WHERE district='" + DistrictComboBox.getValue() + "'&& cancer_type='" + TypeComboBox.getValue() + "'");
                        ResultSet rs = preparedStatement.executeQuery();
                        PreparedStatement preparedStatement2 = connection.prepareStatement("select cancer_type,district,count(district),gender from patient WHERE district='" + DistrictComboBox.getValue() + "'&& cancer_type='" + TypeComboBox.getValue() + "'&&gender='Male'");
                        ResultSet rs2 = preparedStatement2.executeQuery();
                        PreparedStatement preparedStatement3 = connection.prepareStatement("select cancer_type,district,count(district),gender from patient WHERE district='" + DistrictComboBox.getValue() + "'&& cancer_type='" + TypeComboBox.getValue() + "'&&gender='Female'");
                        ResultSet rs3 = preparedStatement3.executeQuery();


                        while (rs.next()) {

                            totalTextField.setText(rs.getString(3));

                        }
                        while (rs2.next()) {

                            maleTextField.setText(rs2.getString(3));

                        }

                        while (rs3.next()) {

                            femaleTextField.setText(rs3.getString(3));

                        }


                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                //All 3 variables

                if(!YearComboBox.getSelectionModel().isEmpty() && !TypeComboBox.getSelectionModel().isEmpty() && !DistrictComboBox.getSelectionModel().isEmpty()){

                    try {

                        Connection connection = new Connector().getConnection ();
                        PreparedStatement preparedStatement = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined, district, cancer_type, count(cancer_type) FROM patient WHERE EXTRACT (YEAR FROM Date_Joined)='" + YearComboBox.getValue() + "'&& cancer_type='" + TypeComboBox.getValue() + "'&& district='" + DistrictComboBox.getValue() + "'");
                        ResultSet rs = preparedStatement.executeQuery();
                        PreparedStatement preparedStatement2 = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined, district, cancer_type, count(cancer_type), gender FROM patient WHERE EXTRACT (YEAR FROM Date_Joined)='" + YearComboBox.getValue() + "'&& cancer_type='" + TypeComboBox.getValue() + "'&& district='" + DistrictComboBox.getValue() + "'&&gender='Male'");
                        ResultSet rs2 = preparedStatement2.executeQuery();
                        PreparedStatement preparedStatement3 = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined, district, cancer_type, count(cancer_type), gender FROM patient WHERE EXTRACT (YEAR FROM Date_Joined)='" + YearComboBox.getValue() + "'&& cancer_type='" + TypeComboBox.getValue() + "'&& district='" + DistrictComboBox.getValue()  + "'&&gender='Female'");
                        ResultSet rs3 = preparedStatement3.executeQuery();


                        while (rs.next()) {

                            totalTextField.setText(rs.getString(4));

                        }
                        while (rs2.next()) {

                            maleTextField.setText(rs2.getString(4));

                        }

                        while (rs3.next()) {

                            femaleTextField.setText(rs3.getString(4));

                        }


                    }catch (Exception e){
                        e.printStackTrace();
                   }
               }



            }
        });


    }
}





