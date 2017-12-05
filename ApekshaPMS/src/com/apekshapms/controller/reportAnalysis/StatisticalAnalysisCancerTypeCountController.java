package com.apekshapms.controller.reportAnalysis;

import com.apekshapms.controller.Controller;
import com.apekshapms.database.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StatisticalAnalysisCancerTypeCountController implements Controller {


    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private Button loadBarChart;

    //private ObservableList cancerTypeDate = FXCollections.observableArrayList();


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



    }


}
