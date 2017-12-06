package com.apekshapms.controller.reportAnalysis;

import com.apekshapms.controller.Controller;
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
    private ChoiceBox<String> districtChoice;

    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(genderCheckBox.isSelected()){}

    }
}
