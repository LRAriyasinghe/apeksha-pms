package com.apekshapms.controller.reportAnalysis;

import com.apekshapms.controller.Controller;
import com.apekshapms.database.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StatisticalAnalysisController implements Controller{


    //@FXML
    //private ChoiceBox districtChoiceBox;
    @FXML
    private Button backButton;
    @FXML
    private BarChart<String, Integer> barChart;
    @FXML
    private ChoiceBox<String> cancerTypeChoiceBox;


    @FXML
    private PieChart pieChart;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;

    @FXML
    private Button loadBarCharttype;

    //private Button loadPieChart;

    @FXML
    private CheckBox genderCheckBox;

    @FXML
    private TextField fromYearTextField;

    @FXML
    private TextField toYearTextField;

    @FXML
    private TextField fromAgeTextField;

    @FXML
    private TextField toAgeTextField;

    @FXML
    private TextField onlyYearTextField;
    @FXML
    private ChoiceBox<String> districtChoice;

    private ObservableList cancerTypeDate = FXCollections.observableArrayList();
    private ObservableList districtData = FXCollections.observableArrayList();



    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        districtData.addAll("Jaffna","Kilinochchi","Mannar","Mullaitivu","Vavuniya","Puttalam","Kurunegala","Gampaha","Colombo","Kalutara","Anuradhapura","Polonnaruwa","Matale","Kandy","Nuwara Eliya","Kegalle","Ratnapura","Trincomalee","Batticaloa","Ampara","Badulla","Monaragala","Hambantota","Matara","Galle");
        districtChoice.setItems(districtData);
        districtChoice.setValue("Colombo");

        cancerTypeDate.addAll("Brain","Lung","Brest","Bladder","Other");
        cancerTypeChoiceBox.setItems(cancerTypeDate);
        cancerTypeChoiceBox.setValue("Other");


        loadBarCharttype.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //01 Only Gender | Male vs Female | All Patient
                if(genderCheckBox.isSelected()){

                }

                //02 Gender and Age Range
                else if (genderCheckBox.isSelected() && !fromAgeTextField.getText().isEmpty() && !toAgeTextField.getText().isEmpty()){

                }

                //03 Gender and Cancer Type
                else if (genderCheckBox.isSelected()){

                    XYChart.Series series1 = new XYChart.Series();
                    series1.setName("Male");
                    XYChart.Series series2 = new XYChart.Series();
                    series2.setName("Female");


                    //XYChart.Series<String,Integer> series = new XYChart.Series<>();
                    try {
                        Connection connection = new Connector().getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement("select cancer_type,gender,count(cancer_type) from patient WHERE gender='Male' GROUP BY cancer_type");
                        ResultSet rs = preparedStatement.executeQuery();

                        PreparedStatement preparedStatement2 = connection.prepareStatement("select cancer_type,gender,count(cancer_type) from patient WHERE gender='Female' GROUP BY cancer_type");
                        ResultSet rs2 = preparedStatement2.executeQuery();


                        while (rs.next()){
                            //series.getData().add(new XYChart.Data<>(rs.getString(1),rs.getInt(2)));


                            series1.getData().add(new XYChart.Data(rs.getString(1),rs.getInt(3)));
                        }

                        while (rs2.next()){
                            //series.getData().add(new XYChart.Data<>(rs.getString(1),rs.getInt(2)));


                            series2.getData().add(new XYChart.Data(rs2.getString(1),rs2.getInt(3)));
                        }

                        //barChart.getData().add(series);
                        barChart.getData().addAll(series1, series2);

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }





                }

                //04 Gender and Year
                else if (genderCheckBox.isSelected() && !onlyYearTextField.getText().isEmpty()){

                }

                //05 Gender and Cancer Type and also Year Range Year
                else if(genderCheckBox.isSelected() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty()){

                }

                //06 Gender | Year Range | Age
                else if(genderCheckBox.isSelected() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && !fromAgeTextField.getText().isEmpty() && !toAgeTextField.getText().isEmpty()){

                }

                //07 Gender and Only one Year | Cancer Type
                else if(genderCheckBox.isSelected() && !onlyYearTextField.getText().isEmpty() && !cancerTypeChoiceBox.getValue().isEmpty()){

                }

                //08 Only Age Range in all Patient,Not separate Male and Female
                else if(!fromAgeTextField.getText().isEmpty() && !toAgeTextField.getText().isEmpty()){

                }

                //09 Only Cancer Type in all patient, Not Separate Male and Fmale
                else if (!cancerTypeChoiceBox.getValue().isEmpty()){

                }

                // 10 Cancer Type and Age Range
                else if(!cancerTypeChoiceBox.getValue().isEmpty() && !toAgeTextField.getText().isEmpty() && !fromAgeTextField.getText().isEmpty()){

                }

                // 11 Only Year Range, Not Separate Male and Female
                else if (!fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty()){

                }

                // 12 Only Year range and Age Range
                else if(!fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && !fromAgeTextField.getText().isEmpty() && !toAgeTextField.getText().isEmpty()){

                }

                // 13 Only One Year and Cancer Type
                else if(!onlyYearTextField.getText().isEmpty() &&  !cancerTypeChoiceBox.getValue().isEmpty()){

                }

                // 14  Year range | Cancer Type | Age Range
                else if(!fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && !cancerTypeChoiceBox.getValue().isEmpty() && !fromAgeTextField.getText().isEmpty() && !toAgeTextField.getText().isEmpty()){

                }

                // 15 Gender | Year Range | Cancer Type | Age Range
                else if(genderCheckBox.isSelected() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && !cancerTypeChoiceBox.getValue().isEmpty() && !fromAgeTextField.getText().isEmpty() && !toAgeTextField.getText().isEmpty()){

                }

            }
        });


    }
}
