package com.apekshapms.controller.reportAnalysis;

import com.apekshapms.controller.Controller;
import com.apekshapms.database.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private ChoiceBox<String> onlyYearTextField;

    @FXML
    private ChoiceBox<String> districtChoice;

    private ObservableList cancerType = FXCollections.observableArrayList();
    private ObservableList distrct = FXCollections.observableArrayList();
    private ObservableList dateList = FXCollections.observableArrayList();


    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cancerType.addAll("Brain", "Lung", "Brest", "Bladder", "Other");
        cancerTypeChoiceBox.setItems(cancerType);

        distrct.addAll("Jaffna", "Kilinochchi", "Mannar", "Mullaitivu", "Vavuniya", "Puttalam", "Kurunegala", "Gampaha", "Colombo", "Kalutara", "Anuradhapura", "Polonnaruwa", "Matale", "Kandy", "Nuwara Eliya", "Kegalle", "Ratnapura", "Trincomalee", "Batticaloa", "Ampara", "Badulla", "Monaragala", "Hambantota", "Matara", "Galle");
        districtChoice.setItems(distrct);
        districtChoice.setValue("Colombo");

        dateList.addAll("2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022");
        onlyYearTextField.setItems(dateList);

        loadBarChart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //02 Gender and Location



            /* if (genderCheckBox.isSelected() && !districtChoice.getValue().isEmpty()) {
                    XYChart.Series series1 = new XYChart.Series();
                    series1.setName("Male");
                    XYChart.Series series2 = new XYChart.Series();
                    series2.setName("Female");


                    //XYChart.Series<String,Integer> series = new XYChart.Series<>();
                    try {
                        Connection connection = new Connector().getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement("select district,gender,count(district) from patient WHERE gender='Male'" +
                                "&& district='" + districtChoice.getValue() + "'GROUP BY district");
                        ResultSet rs = preparedStatement.executeQuery();

                        PreparedStatement preparedStatement2 = connection.prepareStatement("select district,gender,count(district) from patient WHERE gender='Female'" +
                                "&& district='" + districtChoice.getValue() + "' GROUP BY district");
                        ResultSet rs2 = preparedStatement2.executeQuery();


                        while (rs.next()) {

                            series1.getData().add(new XYChart.Data(rs.getString(1), rs.getInt(3)));
                        }

                        while (rs2.next()) {

                            series2.getData().add(new XYChart.Data(rs2.getString(1), rs2.getInt(3)));
                        }

                        barChart.getData().addAll(series1, series2);

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                // 03 Gender and Cancer Type
                else if (genderCheckBox.isSelected() && !cancerTypeChoiceBox.getValue().isEmpty()) {
                    XYChart.Series series1 = new XYChart.Series();
                    series1.setName("Male");
                    XYChart.Series series2 = new XYChart.Series();
                    series2.setName("Female");


                    //XYChart.Series<String,Integer> series = new XYChart.Series<>();
                    try {
                        Connection connection = new Connector().getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement("select cancer_type,gender,count(cancer_type) from patient WHERE gender='Male'" +
                                "&& cancer_type='" + cancerTypeChoiceBox.getValue() + "'GROUP BY cancer_type");
                        ResultSet rs = preparedStatement.executeQuery();

                        PreparedStatement preparedStatement2 = connection.prepareStatement("select cancer_type,gender,count(cancer_type) from patient WHERE gender='Female'" +
                                "&& cancer_type='" + cancerTypeChoiceBox.getValue() + "' GROUP BY cancer_type");
                        ResultSet rs2 = preparedStatement2.executeQuery();


                        while (rs.next()) {

                            series1.getData().add(new XYChart.Data(rs.getString(1), rs.getInt(3)));
                        }

                        while (rs2.next()) {

                            series2.getData().add(new XYChart.Data(rs2.getString(1), rs2.getInt(3)));
                        }

                        barChart.getData().addAll(series1, series2);

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                ///01 Only Gender | Male vs Female | All Patient
                else if (genderCheckBox.isSelected() && cancerTypeChoiceBox.getValue().isEmpty() && districtChoice.getValue().isEmpty()) {


                    XYChart.Series<String, Integer> series = new XYChart.Series<>();
                    try {
                        Connection connection = new Connector().getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement("select district,count(district) from patient WHERE gender='male' GROUP BY district");

                        //PreparedStatement preparedStatement = connection.prepareStatement("select gender,count(gender) from patient  GROUP BY gender");

                        ResultSet rs = preparedStatement.executeQuery();


                        while (rs.next()) {
                            series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(2)));
                        }
                        barChart.getData().add(series);

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }*/


                //04 Gender and Year(Only One Year)
                                        /* if (genderCheckBox.isSelected() && !onlyYearTextField.getValue().isEmpty()) {

                                             XYChart.Series series1 = new XYChart.Series();
                                             series1.setName("Male");
                                             XYChart.Series series2 = new XYChart.Series();
                                             series2.setName("Female");


                                             XYChart.Series<String, Integer> series = new XYChart.Series<>();
                                             try {
                                                 Connection connection = new Connector().getConnection();
                                                 PreparedStatement preparedStatement = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),gender,count(gender) from patient WHERE gender='Male'" +
                                                         "&& EXTRACT(YEAR FROM Date_Joined)= '" + onlyYearTextField.getValue() +"' GROUP BY Date_Joined");
                                                 ResultSet rs = preparedStatement.executeQuery();

                                                 PreparedStatement preparedStatement2 = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),gender,count(gender) from patient WHERE gender='Female'" +
                                                         "&& EXTRACT(YEAR FROM Date_Joined)= '" + onlyYearTextField.getValue() +"' GROUP BY Date_Joined");
                                                 ResultSet rs2 = preparedStatement2.executeQuery();


                                                 while (rs.next()) {

                                                     series1.getData().add(new XYChart.Data(rs.getString(1), rs.getInt(3)));
                                                 }

                                                 while (rs2.next()) {

                                                     series2.getData().add(new XYChart.Data(rs2.getString(1), rs2.getInt(3)));
                                                 }

                                                 barChart.getData().addAll(series1, series2);

                                             } catch (SQLException e) {
                                                 e.printStackTrace();
                                             }
                                         }*/


                //05 Gender and Cancer Type and also Year Range Year
                /*if (genderCheckBox.isSelected() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty()) {

                    XYChart.Series series1 = new XYChart.Series();
                    series1.setName("Male");
                    XYChart.Series series2 = new XYChart.Series();
                    series2.setName("Female");


                    //XYChart.Series<String,Integer> series = new XYChart.Series<>();
                    try {
                        int fromyear = Integer.parseInt(fromYearTextField.getText());
                        int toyear = Integer.parseInt(toYearTextField.getText());


                        Connection connection = new Connector().getConnection();

                        PreparedStatement preparedStatement = connection.prepareStatement("select cancer_type,EXTRACT(YEAR FROM Date_Joined),gender,count(cancer_type) from patient WHERE gender='Male'" +
                                "&& EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined)>='" + fromYearTextField.getText() + "' && cancer_type='" + cancerTypeChoiceBox.getValue() + "'GROUP BY cancer_type");
                        ResultSet rs = preparedStatement.executeQuery();

                        PreparedStatement preparedStatement2 = connection.prepareStatement("select cancer_type,EXTRACT(YEAR FROM Date_Joined),gender,count(cancer_type) from patient WHERE gender='Female'" +
                                "&& EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined)>='" + fromYearTextField.getText() + "' && cancer_type='" + cancerTypeChoiceBox.getValue() + "' GROUP BY cancer_type");
                        ResultSet rs2 = preparedStatement2.executeQuery();


                        while (rs.next()) {

                            series1.getData().add(new XYChart.Data(rs.getString(1), rs.getInt(4)));
                        }

                        while (rs2.next()) {

                            series2.getData().add(new XYChart.Data(rs2.getString(1), rs2.getInt(4)));
                        }

                        barChart.getData().addAll(series1, series2);

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }*/


                //06 Gender | Year Range | Location
                if (genderCheckBox.isSelected() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && !districtChoice.getValue().isEmpty()) {


                    XYChart.Series series1 = new XYChart.Series();
                    series1.setName("Male");
                    XYChart.Series series2 = new XYChart.Series();
                    series2.setName("Female");


                    //XYChart.Series<String,Integer> series = new XYChart.Series<>();
                    try {
                        int fromyear = Integer.parseInt(fromYearTextField.getText());
                        int toyear = Integer.parseInt(toYearTextField.getText());


                        Connection connection = new Connector().getConnection();

                        PreparedStatement preparedStatement = connection.prepareStatement("select district,EXTRACT(YEAR FROM Date_Joined),gender,count(district) from patient WHERE gender='Male'" +
                                "&& EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined)>='" + fromYearTextField.getText() + "' && district='" + districtChoice.getValue() + "'GROUP BY district");
                        ResultSet rs = preparedStatement.executeQuery();

                        PreparedStatement preparedStatement2 = connection.prepareStatement("select district,EXTRACT(YEAR FROM Date_Joined),gender,count(district) from patient WHERE gender='Female'" +
                                "&& EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined)>='" + fromYearTextField.getText() + "' && district='" + districtChoice.getValue() + "' GROUP BY district");
                        ResultSet rs2 = preparedStatement2.executeQuery();


                        while (rs.next()) {

                            series1.getData().add(new XYChart.Data(rs.getString(1), rs.getInt(4)));
                        }

                        while (rs2.next()) {

                            series2.getData().add(new XYChart.Data(rs2.getString(1), rs2.getInt(4)));
                        }

                        barChart.getData().addAll(series1, series2);

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}

//
//                //07 Gender and Only one Year | Cancer Type
//                else if(genderCheckBox.isSelected() && !onlyYearTextField.getText().isEmpty() && !cancerTypeChoiceBox.getValue().isEmpty()){
//
//                }
//
//                //08 Only Age Range in all Patient,Not separate Male and Female
//                else if(!fromAgeTextField.getText().isEmpty() && !toAgeTextField.getText().isEmpty()){
//
//                }
//
//                //09 Only Cancer Type in all patient, Not Separate Male and Fmale
//                else if (!cancerTypeChoiceBox.getValue().isEmpty()){
//
//                }
//
//                // 10 Cancer Type and Age Range
//                else if(!cancerTypeChoiceBox.getValue().isEmpty() && !toAgeTextField.getText().isEmpty() && !fromAgeTextField.getText().isEmpty()){
//
//                }
//
//                // 11 Only Year Range, Not Separate Male and Female
//                else if (!fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty()){
//
//                }
//
//                // 12 Only Year range and Age Range
//                else if(!fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && !fromAgeTextField.getText().isEmpty() && !toAgeTextField.getText().isEmpty()){
//
//                }
//
//                // 13 Only One Year and Cancer Type
//                else if(!onlyYearTextField.getText().isEmpty() &&  !cancerTypeChoiceBox.getValue().isEmpty()){
//
//                }
//
//                // 14  Year range | Cancer Type | Age Range
//                else if(!fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && !cancerTypeChoiceBox.getValue().isEmpty() && !fromAgeTextField.getText().isEmpty() && !toAgeTextField.getText().isEmpty()){
//
//                }
//
//                // 15 Gender | Year Range | Cancer Type | Age Range
//                else if(genderCheckBox.isSelected() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && !cancerTypeChoiceBox.getValue().isEmpty() && !fromAgeTextField.getText().isEmpty() && !toAgeTextField.getText().isEmpty()){
//
//                }


