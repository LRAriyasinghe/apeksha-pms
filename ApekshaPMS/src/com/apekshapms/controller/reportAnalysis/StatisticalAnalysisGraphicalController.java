package com.apekshapms.controller.reportAnalysis;

import com.apekshapms.controller.Controller;
import com.apekshapms.controller.DashboardController;
import com.apekshapms.database.Connector;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.Patient;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class StatisticalAnalysisGraphicalController implements Controller {

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    private ObservableList districtData = FXCollections.observableArrayList();

    //private ObservableList countDistrict = FXCollections.observableArrayList();
    //int[] countDistrict = new int[12];

    @FXML
    void handleBackOnAction(ActionEvent event) {
        UI ui = UIFactory.getUI(UIName.REPORT_DASHBOARD);
        Parent parent = ui.getParent();
        DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
        dashboardController.setWorkspace(parent);

    }

    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        try {
//            Connection connection = new Connector().getConnection();
//            PreparedStatement pra = connection.prepareStatement("select district,type from patient");
//            ResultSet rs1 = pra.executeQuery();
//            while (rs1.next()){
//                districtData.addAll(rs1.getString(1));
//            }
//            xAxis.setCategories(districtData);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println(e);
//        }


        XYChart.Series<String,Integer> series = new XYChart.Series<>();
        try {
            Connection connection = new Connector().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select district,count(district) from patient GROUP BY district ");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                series.getData().add(new XYChart.Data<>(rs.getString(1),rs.getInt(2)));
            }
            barChart.getData().add(series);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
