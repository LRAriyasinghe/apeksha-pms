package com.apekshapms.controller.reportAnalysis;

import com.apekshapms.controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ExampleController implements Controller {

    @FXML
    private AnchorPane backgroundAnchorPane;

    @FXML
    private Button backButton;

    @FXML
    private Button loadBarChart;

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private ChoiceBox<String> cancerTypeChoiceBox;

    @FXML
    private PieChart pieChart;

    @FXML
    private Button loadPieChart;

    @FXML
    private CheckBox genderCheckBox;

    @FXML
    private Label toYear;

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

    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadBarChart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //01 Only Gender | Male vs Female | All Patient
                if(genderCheckBox.isSelected()){

                }

                //02 Gender and Age Range
                else if (genderCheckBox.isSelected() && !fromAgeTextField.getText().isEmpty() && !toAgeTextField.getText().isEmpty()){

                }

                //03 Gender and Cancer Type
                else if (genderCheckBox.isSelected() && !cancerTypeChoiceBox.getValue().isEmpty()){

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
