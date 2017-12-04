package com.apekshapms.controller.reportAnalysis;

import com.apekshapms.controller.Controller;
import com.apekshapms.database.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StatisticalMaleFemaleDistrictController implements Controller {


    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private Button loadBarChart;

    @FXML
    private PieChart pieChart;

    @FXML
    private ChoiceBox<String> genderChoiceBox;

    //private ObservableList district = FXCollections.observableArrayList();

    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genderChoiceBox.getItems().addAll("Male","Female");
        genderChoiceBox.setValue("Male");

        loadBarChart.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                XYChart.Series<String,Integer> series = new XYChart.Series<>();
                try {
                    Connection connection = new Connector().getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement("select district,count(district) from patient WHERE gender='male' GROUP BY district");
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
