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

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StatisticalAnalysisCancerTypePieChartController implements Controller {
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
    private Button loadPieChart;

    private ObservableList cancerTypeDate = FXCollections.observableArrayList();


    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadBarChart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                XYChart.Series<String,Integer> series = new XYChart.Series<>();
                try {
                    Connection connection = new Connector().getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement("select cancer_type,count(cancer_type) from patient GROUP BY cancer_type ");
                    ResultSet rs = preparedStatement.executeQuery();

                    while (rs.next()){


                        series.getData().add(new XYChart.Data<>(rs.getString(1),rs.getInt(2)));
                    }

                    barChart.getData().add(series);

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
