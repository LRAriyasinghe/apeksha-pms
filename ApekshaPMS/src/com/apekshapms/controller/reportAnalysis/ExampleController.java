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

public class ExampleController implements Controller {
    @FXML
    private CheckBox genderCheckBox;
    @FXML
    private TextField fromYearTextField;
    @FXML
    private TextField toYearTextField;
    @FXML
    private ChoiceBox cancerTypeChoiceBox;
    @FXML
    private  TextField fromAgeTextField;
    @FXML
    private TextField toAgeTextField;
    @FXML
    private ChoiceBox districtChoiceBox;

    @FXML
    private PieChart pieChart;

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private Button loadBarChart;

    @FXML
    private Button loadBarChartage;

    @FXML
    private Button loadPieChart;

    private ObservableList cancerTypeDate = FXCollections.observableArrayList();


    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Gender and cancer Type (3)
        loadBarChart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

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
        });

        loadBarChartage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

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
        });




























        loadPieChart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Connection connection = new Connector().getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement("select cancer_type,count(cancer_type) from patient GROUP BY cancer_type ");
                    ResultSet rs = preparedStatement.executeQuery();

                    while (rs.next()) {

                        //cancerTypeDate.addAll(rs.getString(1), rs.getInt(2));
                        cancerTypeDate.add(new PieChart.Data(rs.getString(1),rs.getInt(2)));

                    }
                    pieChart.setData(cancerTypeDate);
                } catch (SQLException e) {
                    e.printStackTrace();
                    return;
                }

            }

            /*@Override
            public void start(Stage stage) throws Exception {
                //PIE CHART
                PieChart pieChart = new PieChart();
                buildData();
                pieChart.getData().addAll(data);

                //Main Scene
                Scene scene = new Scene(pieChart);

                stage.setScene(scene);
                stage.setVisible(true);
            }
            */





              /*  ObservableList<PieChart.Data> pieChartData =
                        FXCollections.observableArrayList(

                                new PieChart.Data("Bladder", 20),
                                new PieChart.Data("Brain", 30),
                                new PieChart.Data("Brest", 20),
                                new PieChart.Data("Lung", 30));
                pieChart.setData(pieChartData);*/



        });



    }


}
