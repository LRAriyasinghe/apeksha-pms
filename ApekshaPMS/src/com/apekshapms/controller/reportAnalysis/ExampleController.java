package com.apekshapms.controller.reportAnalysis;

import com.apekshapms.controller.Controller;
import com.apekshapms.database.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.control.Button;

public class ExampleController implements Controller {

    //Declaration Of FXML Elements
    @FXML
    private Button loadBarChart;

    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

    @FXML
    private ComboBox<String> districtCombo;

    @FXML
    private ComboBox<String> cancerTypeCombo;

    @FXML
    private PieChart pieChart;

    @FXML
    private Button loadPieChart;

    @FXML
    private CheckBox genderCheckBox;

    @FXML
    private TextField fromYearTextField;

    @FXML
    private TextField toYearTextField;

    @FXML
    private TextField onlyYearTextField;

    @FXML
    private Button clearUI;

    @FXML
    private AnchorPane backgroundAnchorPane;

    @FXML
    private Button backButton;

    @FXML
    private Button loadLineChart;

    @FXML
    private LineChart<String, Integer> LineChart;

    //Declaration Of Observable Lists
    private ObservableList cancerType = FXCollections.observableArrayList();
    private ObservableList district = FXCollections.observableArrayList();

    private ObservableList barChartObservable = FXCollections.observableArrayList();
    private ObservableList pieChartObservable = FXCollections.observableArrayList();
    private ObservableList lineChartObservable = FXCollections.observableArrayList();


    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            cancerType.addAll("ALL","Lung","Brain","Bladder","Leukemia","Breast","Oral");
            cancerTypeCombo.setItems(cancerType);

            district.addAll("ALL Districts","Jaffna","Kilinochchi","Mannar","Mullaitivu","Vavuniya","Puttalam","Kurunegala","Gampaha","Colombo","Kalutara","Anuradhapura","Polonnaruwa","Matale","Kandy","Nuwara Eliya","Kegalle","Ratnapura","Trincomalee","Batticaloa","Ampara","Badulla","Monaragala","Hambantota","Matara","Galle");
            districtCombo.setItems(district);

            //Clear Charts and Text Fields upon clicking of Clear Button

            clearUI.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                // #1 CLEAR accumulated data of Text Fields and Combo boxes

                    fromYearTextField.clear();
                    toYearTextField.clear();
                    districtCombo.getSelectionModel().clearSelection();
                    cancerTypeCombo.getSelectionModel().clearSelection();
                    onlyYearTextField.clear();
                    genderCheckBox.setSelected(false);

                    // #2 Clear Chart accumulated data

                    barChart.getData().clear();
                    pieChart.getData().clear();
                    LineChart.getData().clear();

                    // #3 Clear Observable List data

                    barChartObservable.clear();
                    pieChartObservable.clear();
                    lineChartObservable.clear();


                }
            });

            loadBarChart.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    // Error Message Pop up for Empty Search Criteria
                    if (!genderCheckBox.isSelected()&&fromYearTextField.getText().isEmpty()&&toYearTextField.getText().isEmpty()&&districtCombo.getSelectionModel().isEmpty()&&cancerTypeCombo.getSelectionModel().isEmpty()){

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("No Search Criteria");
                        alert.setHeaderText("Empty Search Criteria");
                        alert.setContentText("Please Select Your Desired Search Criteria and Try Again");
                        alert.showAndWait();
                        alert.setOnCloseRequest(e -> alert.close());
                    }
                    ///01 Bar Chart for the selection of  Only Gender

                    else if(genderCheckBox.isSelected()&&fromYearTextField.getText().isEmpty()&&fromYearTextField.getText().isEmpty()&&districtCombo.getSelectionModel().isEmpty()&&cancerTypeCombo.getSelectionModel().isEmpty()){
                        XYChart.Series series=new XYChart.Series();
                        try{
                            Connection connection = new Connector().getConnection();
                            PreparedStatement preparedStatement = connection.prepareStatement("SELECT gender,count(gender) from patient GROUP BY gender");
                            ResultSet rs = preparedStatement.executeQuery();

                            while (rs.next()){
                                barChartObservable.addAll(rs.getString(1));
                                xAxis.setCategories(barChartObservable);
                                series.getData().add(new XYChart.Data<>(rs.getString(1),rs.getInt(2)));

                            }
                            barChart.getData().addAll(series);

                        }

                        catch (SQLException e){
                            e.printStackTrace();
                        }
                    }

                    //02 Bar Chart for the selection of Gender and District


                    else if (genderCheckBox.isSelected() && !districtCombo.getSelectionModel().isEmpty() && fromYearTextField.getText().isEmpty() && toYearTextField.getText().isEmpty() && cancerTypeCombo.getSelectionModel().isEmpty()) {
                        XYChart.Series series = new XYChart.Series();
                        try {
                            Connection connection = new Connector().getConnection();
                            PreparedStatement preparedStatement1 = connection.prepareStatement("select gender,district,count(gender) from patient WHERE  district='" + districtCombo.getValue() + "' GROUP BY gender");
                            ResultSet rs = preparedStatement1.executeQuery();


                            while (rs.next()) {
                                barChartObservable.addAll(rs.getString(1));
                                xAxis.setCategories(barChartObservable);
                                series.getData().add(new XYChart.Data(rs.getString(1), rs.getInt(3)));
                            }


                            barChart.getData().addAll(series);

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    // 03 Bar Chart for the selection of Gender and Cancer Type
                    else if (genderCheckBox.isSelected() && !cancerTypeCombo.getSelectionModel().isEmpty() && districtCombo.getSelectionModel().isEmpty() && fromYearTextField.getText().isEmpty() && toYearTextField.getText().isEmpty()) {

                        XYChart.Series series = new XYChart.Series();
                        try {
                            Connection connection = new Connector().getConnection();
                            PreparedStatement preparedStatement1 = connection.prepareStatement("select gender,cancer_type,count(gender) from patient WHERE  cancer_type='" + cancerTypeCombo.getValue() + "' GROUP BY gender");
                            ResultSet rs = preparedStatement1.executeQuery();


                            while (rs.next()) {
                                barChartObservable.addAll(rs.getString(1));
                                xAxis.setCategories(barChartObservable);
                                series.getData().add(new XYChart.Data(rs.getString(1), rs.getInt(3)));
                            }

                            barChart.getData().addAll(series);

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }


                    // 04 Bar Chart for the selection of Gender and YEAR RANGE

                    else if (cancerTypeCombo.getSelectionModel().isEmpty() && districtCombo.getSelectionModel().isEmpty() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && genderCheckBox.isSelected()) {
                        XYChart.Series series1 = new XYChart.Series();
                        series1.setName("Male");
                        XYChart.Series series2 = new XYChart.Series();
                        series2.setName("Female");
                             try {
                            Connection connection = new Connector().getConnection();
                            PreparedStatement preparedStatement1 = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),gender,count(Date_Joined) from patient WHERE gender='Male' && EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' GROUP BY EXTRACT(YEAR FROM Date_Joined)");
                            ResultSet rs1 = preparedStatement1.executeQuery();

                            PreparedStatement preparedStatement2 = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),gender,count(Date_Joined) from patient WHERE gender='Female' && EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' GROUP BY EXTRACT(YEAR FROM Date_Joined)");

                            ResultSet rs2 = preparedStatement2.executeQuery();

                            while (rs1.next()) {
                                barChartObservable.addAll(rs1.getString(1));
                                xAxis.setCategories(barChartObservable);
                                series1.getData().add(new XYChart.Data(rs1.getString(1), rs1.getInt(3)));
                                          }

                            while (rs2.next()) {
                                barChartObservable.addAll(rs2.getString(1));
                                xAxis.setCategories(barChartObservable);
                                series2.getData().add(new XYChart.Data(rs2.getString(1), rs2.getInt(3)));
                            }

                            barChart.getData().addAll(series1, series2);

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    // 05 Bar Chart for the selection of GENDER, YEAR RANGE AND CANCER TYPE

                    else if (!cancerTypeCombo.getSelectionModel().isEmpty() && districtCombo.getSelectionModel().isEmpty() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && genderCheckBox.isSelected()) {
                        XYChart.Series series1 = new XYChart.Series();
                        series1.setName("Male");
                        XYChart.Series series2 = new XYChart.Series();
                        series2.setName("Female");
                          try {
                            Connection connection = new Connector().getConnection();
                            PreparedStatement preparedStatement1 = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),gender,count(Date_Joined),cancer_type from patient WHERE gender='Male' && EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' && cancer_type='"+cancerTypeCombo.getValue()+"' GROUP BY EXTRACT(YEAR FROM Date_Joined)");
                            ResultSet rs1 = preparedStatement1.executeQuery();

                            PreparedStatement preparedStatement2 = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),gender,count(Date_Joined),cancer_type from patient WHERE gender='Female' && EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' && cancer_type='"+cancerTypeCombo.getValue()+"' GROUP BY EXTRACT(YEAR FROM Date_Joined)");

                            ResultSet rs2 = preparedStatement2.executeQuery();
                            while (rs1.next()) {
                                barChartObservable.addAll(rs1.getString(1));
                                xAxis.setCategories(barChartObservable);
                                series1.getData().add(new XYChart.Data(rs1.getString(1), rs1.getInt(3)));
                            }
                            while (rs2.next()) {
                                barChartObservable.addAll(rs2.getString(1));
                                xAxis.setCategories(barChartObservable);
                                series2.getData().add(new XYChart.Data(rs2.getString(1), rs2.getInt(3)));
                            }

                            barChart.getData().addAll(series1, series2);

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }}

                    // 06 Bar Chart for the selection of GENDER, YEAR RANGE AND DISTRICT

                    else if (cancerTypeCombo.getSelectionModel().isEmpty() && !districtCombo.getSelectionModel().isEmpty() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && genderCheckBox.isSelected()) {
                        XYChart.Series series1 = new XYChart.Series();
                        series1.setName("Male");
                        XYChart.Series series2 = new XYChart.Series();
                        series2.setName("Female");
                          try {
                            Connection connection = new Connector().getConnection();
                            PreparedStatement preparedStatement1 = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),gender,count(Date_Joined),district from patient WHERE gender='Male' && EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' && district='"+districtCombo.getValue()+"' GROUP BY EXTRACT(YEAR FROM Date_Joined)");
                            ResultSet rs1 = preparedStatement1.executeQuery();

                            PreparedStatement preparedStatement2 = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),gender,count(Date_Joined),district from patient WHERE gender='Female' && EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' && district='"+districtCombo.getValue()+"' GROUP BY EXTRACT(YEAR FROM Date_Joined)");

                            ResultSet rs2 = preparedStatement2.executeQuery();
                            while (rs1.next()) {
                                barChartObservable.addAll(rs1.getString(1));
                                xAxis.setCategories(barChartObservable);
                                series1.getData().add(new XYChart.Data(rs1.getString(1), rs1.getInt(3)));
                            }
                            while (rs2.next()) {
                                barChartObservable.addAll(rs2.getString(1));
                                xAxis.setCategories(barChartObservable);
                                series2.getData().add(new XYChart.Data(rs2.getString(1), rs2.getInt(3)));
                            }
                            barChart.getData().addAll(series1, series2);

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    // 07 Bar Chart for the selection of GENDER,DISTRICT and CANCER TYPE

                    else if (!cancerTypeCombo.getSelectionModel().isEmpty() && !districtCombo.getSelectionModel().isEmpty() && fromYearTextField.getText().isEmpty() && toYearTextField.getText().isEmpty() && genderCheckBox.isSelected()) {
                        XYChart.Series series = new XYChart.Series();
                        try {
                            Connection connection = new Connector().getConnection();
                            PreparedStatement preparedStatement1 = connection.prepareStatement("select gender,cancer_type,district,count(gender) from patient WHERE  cancer_type ='" + cancerTypeCombo.getValue() + "' && district='" + districtCombo.getValue() + "' GROUP BY gender");
                            ResultSet rs = preparedStatement1.executeQuery();
                            while (rs.next()) {
                                barChartObservable.addAll(rs.getString(1));
                                xAxis.setCategories(barChartObservable);
                                series.getData().add(new XYChart.Data(rs.getString(1), rs.getInt(4)));
                            }
                            barChart.getData().addAll(series);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    //08 Bar Chart for the selection of Only One Cancer type and Select All Cancer Types
                    else if (!cancerTypeCombo.getSelectionModel().isEmpty() && districtCombo.getSelectionModel().isEmpty() && fromYearTextField.getText().isEmpty() && toYearTextField.getText().isEmpty() && !genderCheckBox.isSelected()) {
                                if (cancerTypeCombo.getValue() == "ALL") {
                                    XYChart.Series<String, Integer> series = new XYChart.Series<>();
                                    try {
                                Connection connection = new Connector().getConnection();
                                PreparedStatement preparedStatement = connection.prepareStatement("select cancer_type,count(cancer_type) from patient GROUP BY cancer_type");
                                ResultSet rs = preparedStatement.executeQuery();

                                while (rs.next()) {
                                    barChartObservable.addAll(rs.getString(1));
                                    xAxis.setCategories(barChartObservable);
                                    series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(2)));
                                }
                                barChart.getData().add(series);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        } else {
                            XYChart.Series<String, Integer> series = new XYChart.Series<>();
                            try {
                                Connection connection = new Connector().getConnection();
                                PreparedStatement preparedStatement = connection.prepareStatement("select cancer_type,count(cancer_type) from patient WHERE cancer_type = '" + cancerTypeCombo.getValue() + "' GROUP BY cancer_type");
                                ResultSet rs = preparedStatement.executeQuery();

                                while (rs.next()) {
                                    barChartObservable.addAll(rs.getString(1));
                                    xAxis.setCategories(barChartObservable);
                                    series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(2)));
                                }
                                barChart.getData().add(series);

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }}}

                    //09 Bar Chart for the selection of ONE District And ALL Districts
                    else if (!districtCombo.getSelectionModel().isEmpty() && !genderCheckBox.isSelected() && cancerTypeCombo.getSelectionModel().isEmpty() && fromYearTextField.getText().isEmpty() && toYearTextField.getText().isEmpty()) {
                        if (districtCombo.getValue() == "ALL Districts") {

                            XYChart.Series<String, Integer> series = new XYChart.Series<>();
                            try {
                                Connection connection = new Connector().getConnection();
                                PreparedStatement preparedStatement = connection.prepareStatement("select district,count(district) from patient GROUP BY district");
                                ResultSet rs = preparedStatement.executeQuery();

                                while (rs.next()) {
                                    barChartObservable.addAll(rs.getString(1));
                                    xAxis.setCategories(barChartObservable);
                                    series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(2)));
                                }
                                barChart.getData().add(series);

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                        } else {

                            XYChart.Series<String, Integer> series = new XYChart.Series<>();
                            try {
                                Connection connection = new Connector().getConnection();
                                PreparedStatement preparedStatement = connection.prepareStatement("select district,count(district) from patient WHERE district = '" + districtCombo.getValue() + "' GROUP BY district");
                                ResultSet rs = preparedStatement.executeQuery();

                                while (rs.next()) {
                                    barChartObservable.addAll(rs.getString(1));
                                    xAxis.setCategories(barChartObservable);
                                    series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(2)));
                                }
                                barChart.getData().add(series);

                            } catch (SQLException e) {
                                e.printStackTrace();

                            }
                        }
                    }
                    //10 Bar Chart for the selection of District and Cancer Type

                    else if (!cancerTypeCombo.getSelectionModel().isEmpty() && !districtCombo.getSelectionModel().isEmpty() && fromYearTextField.getText().isEmpty() && toYearTextField.getText().isEmpty() && !genderCheckBox.isSelected()) {
                        if (districtCombo.getValue() == "ALL Districts") {

                            XYChart.Series<String, Integer> series = new XYChart.Series<>();
                            try {
                                Connection connection = new Connector().getConnection(); //("select district,count(district) from patient WHERE district = '" + districtCombo.getValue() + "' GROUP BY district");

                                PreparedStatement preparedStatement = connection.prepareStatement("select district,cancer_type,count(cancer_type) from patient WHERE cancer_type='" + cancerTypeCombo.getValue() + "' GROUP BY district");

                                ResultSet rs = preparedStatement.executeQuery();

                                while (rs.next()) {
                                    barChartObservable.addAll(rs.getString(1));
                                    xAxis.setCategories(barChartObservable);
                                    series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(3)));
                                }
                                barChart.getData().add(series);

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                        } else if (cancerTypeCombo.getValue() == "ALL") {
                            XYChart.Series<String, Integer> series = new XYChart.Series<>();
                            try {
                                Connection connection = new Connector().getConnection();
                                PreparedStatement preparedStatement = connection.prepareStatement("select cancer_type,district,count(district) from patient WHERE district= '" + districtCombo.getValue() + "'GROUP BY cancer_type");

                                ResultSet rs = preparedStatement.executeQuery();

                                while (rs.next()) {
                                    barChartObservable.addAll(rs.getString(1));
                                    xAxis.setCategories(barChartObservable);
                                    series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(3)));
                                }
                                barChart.getData().add(series);

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        } else {

                            XYChart.Series<String, Integer> series = new XYChart.Series<>();
                            try {
                                Connection connection = new Connector().getConnection();
                                PreparedStatement preparedStatement = connection.prepareStatement("select cancer_type,district,count(district) from patient WHERE district= '" + districtCombo.getValue() + "' && cancer_type='" + cancerTypeCombo.getValue() + "' GROUP BY cancer_type");

                                ResultSet rs = preparedStatement.executeQuery();

                                while (rs.next()) {
                                    barChartObservable.addAll(rs.getString(1));
                                    xAxis.setCategories(barChartObservable);
                                    series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(3)));
                                }
                                barChart.getData().add(series);

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    //11 Bar Chart for the selection of Only YEAR RANGE

                    else if (cancerTypeCombo.getSelectionModel().isEmpty() && districtCombo.getSelectionModel().isEmpty() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && !genderCheckBox.isSelected()) {
                        XYChart.Series<String, Integer> series = new XYChart.Series<>();

                        try {
                            Connection connection = new Connector().getConnection();
                            PreparedStatement preparedStatement = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),count(Date_Joined) from patient WHERE EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' GROUP BY EXTRACT(YEAR FROM Date_Joined)");

                            ResultSet rs = preparedStatement.executeQuery();

                            while (rs.next()) {
                                barChartObservable.addAll(rs.getString(1));
                                xAxis.setCategories(barChartObservable);
                                series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(2)));
                            }
                            barChart.getData().add(series);

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    //12 Bar Chart for the selection of YEAR RANGE AND District
                    else if (cancerTypeCombo.getSelectionModel().isEmpty() && !districtCombo.getSelectionModel().isEmpty() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && !genderCheckBox.isSelected()) {
                        XYChart.Series<String, Integer> series = new XYChart.Series<>();
                        try {
                            Connection connection = new Connector().getConnection();
                            PreparedStatement preparedStatement = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),count(Date_Joined),district from patient WHERE district='" + districtCombo.getValue() + "'&& EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' GROUP BY EXTRACT(YEAR FROM Date_Joined)");
                            ResultSet rs = preparedStatement.executeQuery();

                            while (rs.next()) {
                                barChartObservable.addAll(rs.getString(1));
                                xAxis.setCategories(barChartObservable);
                                series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(2)));
                            }
                            barChart.getData().add(series);

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    ////13 Bar Chart for the selection of YEAR RANGE AND CANCER TYPE

                    else if (!cancerTypeCombo.getSelectionModel().isEmpty() && districtCombo.getSelectionModel().isEmpty() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && !genderCheckBox.isSelected()) {
                        XYChart.Series<String, Integer> series = new XYChart.Series<>();

                        try {
                            Connection connection = new Connector().getConnection();
                            PreparedStatement preparedStatement = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),count(Date_Joined),cancer_type from patient WHERE cancer_type='" + cancerTypeCombo.getValue() + "'&& EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' GROUP BY EXTRACT(YEAR FROM Date_Joined)");
                            ResultSet rs = preparedStatement.executeQuery();

                            while (rs.next()) {
                                barChartObservable.addAll(rs.getString(1));
                                xAxis.setCategories(barChartObservable);
                                series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(2)));
                            }
                            barChart.getData().add(series);

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    //14 Bar Chart for the selection of YEAR RANGE, CANCER TYPE and LOCATION

                    else if (!cancerTypeCombo.getSelectionModel().isEmpty() && !districtCombo.getSelectionModel().isEmpty() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && !genderCheckBox.isSelected()) {
                        XYChart.Series<String, Integer> series = new XYChart.Series<>();

                        try {
                            Connection connection = new Connector().getConnection();
                            PreparedStatement preparedStatement = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),count(Date_Joined),cancer_type,district from patient WHERE cancer_type='" + cancerTypeCombo.getValue() + "'&& district='"+districtCombo.getValue()+"' &&  EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' GROUP BY EXTRACT(YEAR FROM Date_Joined)");
                            ResultSet rs = preparedStatement.executeQuery();

                            while (rs.next()) {
                                barChartObservable.addAll(rs.getString(1));
                                xAxis.setCategories(barChartObservable);
                                series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(2)));
                            }
                            barChart.getData().add(series);

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    //  15Bar Chart for the selection of ALL VARIABLES

                    else if (!cancerTypeCombo.getSelectionModel().isEmpty() && !districtCombo.getSelectionModel().isEmpty() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && genderCheckBox.isSelected()) {
                        XYChart.Series series1 = new XYChart.Series();
                        series1.setName("Male");
                        XYChart.Series series2 = new XYChart.Series();
                        series2.setName("Female");
                        try {
                            Connection connection = new Connector().getConnection();
                            PreparedStatement preparedStatement1 = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),count(Date_Joined),cancer_type,district,gender from patient WHERE cancer_type='" + cancerTypeCombo.getValue() + "'&& district='"+districtCombo.getValue()+"' &&  EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' && gender='Male' GROUP BY EXTRACT(YEAR FROM Date_Joined)");
                            ResultSet rs1 = preparedStatement1.executeQuery();

                            PreparedStatement preparedStatement2 = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),count(Date_Joined),cancer_type,district,gender from patient WHERE cancer_type='" + cancerTypeCombo.getValue() + "'&& district='"+districtCombo.getValue()+"' &&  EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "'&& gender='Female' GROUP BY EXTRACT(YEAR FROM Date_Joined)");

                            ResultSet rs2 = preparedStatement2.executeQuery();


                            while (rs1.next()) {
                                barChartObservable.addAll(rs1.getString(1));
                                xAxis.setCategories(barChartObservable);
                                series1.getData().add(new XYChart.Data(rs1.getString(1), rs1.getInt(2)));
                            }

                            while (rs2.next()) {
                                barChartObservable.addAll(rs2.getString(1));
                                xAxis.setCategories(barChartObservable);


                                series2.getData().add(new XYChart.Data(rs2.getString(1), rs2.getInt(2)));
                            }

                            barChart.getData().addAll(series1, series2);

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }

            });

// ################# PIE CHARTS

            loadPieChart.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    ///01 Error Message for Selection of Only Gender
                    if (!genderCheckBox.isSelected()&&fromYearTextField.getText().isEmpty()&&toYearTextField.getText().isEmpty()&&districtCombo.getSelectionModel().isEmpty()&&cancerTypeCombo.getSelectionModel().isEmpty()){

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("No Search Criteria");
                        alert.setHeaderText("Empty Search Criteria");
                        alert.setContentText("Please Select Your Desired Search Criteria and Try Again");
                        alert.showAndWait();
                        alert.setOnCloseRequest(e -> alert.close());
                    }
                    // 02 Pie Chart for Selection of Only Gender
                    else if (genderCheckBox.isSelected() && cancerTypeCombo.getSelectionModel().isEmpty() && fromYearTextField.getText().isEmpty() && toYearTextField.getText().isEmpty() && districtCombo.getSelectionModel().isEmpty()) {

                        try {
                            Connection connection = new Connector().getConnection();
                            PreparedStatement preparedStatement = connection.prepareStatement("select gender,count(gender) from patient GROUP BY gender");
                            ResultSet rs = preparedStatement.executeQuery();

                            while (rs.next()) {
                                pieChartObservable.add(new PieChart.Data(rs.getString(1), rs.getInt(2)));
                            }
                            pieChart.setData(pieChartObservable);

                        } catch (SQLException e) {
                            e.printStackTrace();
                            return;
                        }
                    }

                    //03 Pie Chart for Selection of Gender and Location

                    else if (genderCheckBox.isSelected() && !districtCombo.getSelectionModel().isEmpty() && fromYearTextField.getText().isEmpty() && toYearTextField.getText().isEmpty() && cancerTypeCombo.getSelectionModel().isEmpty()) {
                    try {
                        Connection connection = new Connector().getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement("select district,gender,count(gender) from patient WHERE district='" + districtCombo.getValue() + "'GROUP BY gender");
                        ResultSet rs = preparedStatement.executeQuery();
                        while (rs.next()) {

                            //cancerTypeDate.addAll(rs.getString(1), rs.getInt(2));
                            pieChartObservable.add(new PieChart.Data(rs.getString(2), rs.getInt(3)));
                        }
                        pieChart.setData(pieChartObservable);
                        // pieChart.setData(cancerTypeDate2);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        return;

                }}

                    // 04 Pie Chart for Selection of Gender and Cancer Type

                    else if (genderCheckBox.isSelected() && !cancerTypeCombo.getSelectionModel().isEmpty() && districtCombo.getSelectionModel().isEmpty() && fromYearTextField.getText().isEmpty() && toYearTextField.getText().isEmpty()) {

                        try {
                            Connection connection = new Connector().getConnection();
                            PreparedStatement preparedStatement = connection.prepareStatement("select cancer_type,gender,count(gender) from patient WHERE cancer_type='" + cancerTypeCombo.getValue() + "'GROUP BY gender");
                            ResultSet rs = preparedStatement.executeQuery();

                            while (rs.next()) {

                                pieChartObservable.add(new PieChart.Data(rs.getString(2), rs.getInt(3)));
                            }

                            pieChart.setData(pieChartObservable);

                        } catch (SQLException e) {
                            e.printStackTrace();
                            return;
                        }
                    }


                    // 05 Error Message for Selection of Gender and YEAR RANGE

                    else if (cancerTypeCombo.getSelectionModel().isEmpty() && districtCombo.getSelectionModel().isEmpty() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && genderCheckBox.isSelected()) {

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Pie Chart Error");
                        alert.setHeaderText("Logic Error");
                        alert.setContentText("Unable to generate Pie chart due to error in Logic.Please Try this analysis using Bar Charts or Line Charts");
                        alert.showAndWait();
                        alert.setOnCloseRequest(e -> alert.close());

                    }

                    // 06 Error Message for Selection of  GENDER (YEAR RANGE, CANCER TYPE)

                    else if (!cancerTypeCombo.getSelectionModel().isEmpty() && districtCombo.getSelectionModel().isEmpty() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && genderCheckBox.isSelected()) {

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Pie Chart Error");
                        alert.setHeaderText("Logic Error");
                        alert.setContentText("Unable to generate Pie chart due to error in Logic.Please Try this analysis using Bar Charts or Line Charts");
                        alert.showAndWait();
                        alert.setOnCloseRequest(e -> alert.close());
                    }
                    // 07 Error Message for Selection of GENDER, YEAR RANGE AND DISTRICT

                    else if (cancerTypeCombo.getSelectionModel().isEmpty() && !districtCombo.getSelectionModel().isEmpty() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && genderCheckBox.isSelected()) {

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Pie Chart Error");
                        alert.setHeaderText("Logic Error");
                        alert.setContentText("Unable to generate Pie chart due to error in Logic.Please Try this analysis using Bar Charts or Line Charts");
                        alert.showAndWait();
                        alert.setOnCloseRequest(e -> alert.close());
                    }

                    // 08 Pie Chart for Selection of  GENDER,DISTRICT and CANCER TYPE

                    else if (!cancerTypeCombo.getSelectionModel().isEmpty() && !districtCombo.getSelectionModel().isEmpty() && fromYearTextField.getText().isEmpty() && toYearTextField.getText().isEmpty() && genderCheckBox.isSelected()) {
                        try {
                            Connection connection = new Connector().getConnection();
                            PreparedStatement preparedStatement1 = connection.prepareStatement("select gender,cancer_type,district,count(gender) from patient WHERE  cancer_type ='" + cancerTypeCombo.getValue() + "' && district='" + districtCombo.getValue() + "' GROUP BY gender");
                            ResultSet rs = preparedStatement1.executeQuery();
                            while (rs.next()) {
                                pieChartObservable.add(new PieChart.Data(rs.getString(1), rs.getInt(4)));
                            }

                            pieChart.setData(pieChartObservable);

                        } catch (SQLException e) {
                            e.printStackTrace();
                            return;
                        }
                    }

                    // 09  Pie Chart for Selection of Only  Cancer type

                    else if (!cancerTypeCombo.getSelectionModel().isEmpty() && districtCombo.getSelectionModel().isEmpty() && fromYearTextField.getText().isEmpty() && toYearTextField.getText().isEmpty() && !genderCheckBox.isSelected()) {
                        if (cancerTypeCombo.getValue() == "ALL") {
                            try {
                                Connection connection = new Connector().getConnection();
                                PreparedStatement preparedStatement = connection.prepareStatement("select cancer_type,count(cancer_type) from patient GROUP BY cancer_type");
                                ResultSet rs = preparedStatement.executeQuery();

                                while (rs.next()) {
                                    pieChartObservable.add(new PieChart.Data(rs.getString(1), rs.getInt(2)));
                                }
                                pieChart.setData(pieChartObservable);

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                        } else {
                            try {
                                Connection connection = new Connector().getConnection();
                                PreparedStatement preparedStatement = connection.prepareStatement("select cancer_type,count(cancer_type) from patient WHERE cancer_type = '" + cancerTypeCombo.getValue() + "' GROUP BY cancer_type");

                                ResultSet rs = preparedStatement.executeQuery();

                                while (rs.next()) {
                                    pieChartObservable.add(new PieChart.Data(rs.getString(1), rs.getInt(2)));
                                }
                                pieChart.setData(pieChartObservable);

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    //10 Pie Chart for Selection of ONE District And ALL Districts

                    else if (!districtCombo.getSelectionModel().isEmpty() && !genderCheckBox.isSelected() && cancerTypeCombo.getSelectionModel().isEmpty() && fromYearTextField.getText().isEmpty() && toYearTextField.getText().isEmpty()) {

                        if (districtCombo.getValue() == "ALL Districts") {
                            try {
                                Connection connection = new Connector().getConnection();
                                PreparedStatement preparedStatement = connection.prepareStatement("select district,count(district) from patient GROUP BY district");

                                ResultSet rs = preparedStatement.executeQuery();

                                while (rs.next()) {
                                    pieChartObservable.add(new PieChart.Data(rs.getString(1), rs.getInt(2)));
                                }
                                pieChart.setData(pieChartObservable);

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        } else {


                            try {
                                Connection connection = new Connector().getConnection();
                                PreparedStatement preparedStatement = connection.prepareStatement("select district,count(district) from patient WHERE district = '" + districtCombo.getValue() + "' GROUP BY district");

                                ResultSet rs = preparedStatement.executeQuery();

                                while (rs.next()) {
                                    pieChartObservable.add(new PieChart.Data(rs.getString(1), rs.getInt(2)));
                                }
                                pieChart.setData(pieChartObservable);

                            } catch (SQLException e) {
                                e.printStackTrace();

                            }
                        }}

                     //11 Pie Chart for Selection of District and Cancer Type

                    else if (!cancerTypeCombo.getSelectionModel().isEmpty() && !districtCombo.getSelectionModel().isEmpty() && fromYearTextField.getText().isEmpty() && toYearTextField.getText().isEmpty() && !genderCheckBox.isSelected()) {
                        if (districtCombo.getValue() == "ALL Districts") {



                            try {
                                Connection connection = new Connector().getConnection(); //("select district,count(district) from patient WHERE district = '" + districtCombo.getValue() + "' GROUP BY district");

                                PreparedStatement preparedStatement = connection.prepareStatement("select district,cancer_type,count(cancer_type) from patient WHERE cancer_type='" + cancerTypeCombo.getValue() + "' GROUP BY district");

                                ResultSet rs = preparedStatement.executeQuery();

                                while (rs.next()) {
                                    pieChartObservable.add(new PieChart.Data(rs.getString(1), rs.getInt(3)));
                                }
                                pieChart.setData(pieChartObservable);

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                        } else if (cancerTypeCombo.getValue() == "ALL") {

                            try {
                                Connection connection = new Connector().getConnection();
                                PreparedStatement preparedStatement = connection.prepareStatement("select cancer_type,district,count(district) from patient WHERE district= '" + districtCombo.getValue() + "'GROUP BY cancer_type");

                                ResultSet rs = preparedStatement.executeQuery();

                                while (rs.next()) {
                                    pieChartObservable.add(new PieChart.Data(rs.getString(1), rs.getInt(3)));
                                }
                                pieChart.setData(pieChartObservable);

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }}

                        else{


                            try {
                                Connection connection = new Connector().getConnection();
                                PreparedStatement preparedStatement = connection.prepareStatement("select cancer_type,district,count(district) from patient WHERE district= '" + districtCombo.getValue() + "' && cancer_type='" + cancerTypeCombo.getValue() + "' GROUP BY cancer_type");

                                ResultSet rs = preparedStatement.executeQuery();

                                while (rs.next()) {
                                    pieChartObservable.add(new PieChart.Data(rs.getString(1), rs.getInt(3)));
                                }
                                pieChart.setData(pieChartObservable);

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    //12 Pie Chart for Selection of Only YEAR RANGE

                    else if (cancerTypeCombo.getSelectionModel().isEmpty() && districtCombo.getSelectionModel().isEmpty() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && !genderCheckBox.isSelected()) {
                        XYChart.Series<String, Integer> series = new XYChart.Series<>();

                        try {
                            Connection connection = new Connector().getConnection();
                            PreparedStatement preparedStatement = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),count(Date_Joined) from patient WHERE EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' GROUP BY EXTRACT(YEAR FROM Date_Joined)");

                            ResultSet rs = preparedStatement.executeQuery();

                            while (rs.next()) {
                                pieChartObservable.add(new PieChart.Data(rs.getString(1), rs.getInt(2)));
                            }
                            pieChart.setData(pieChartObservable);

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }


                    //13 Pie Chart for Selection of YEAR RANGE AND District


                    else if (cancerTypeCombo.getSelectionModel().isEmpty() && !districtCombo.getSelectionModel().isEmpty() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && !genderCheckBox.isSelected()) {

                        try {
                            Connection connection = new Connector().getConnection();
                            PreparedStatement preparedStatement = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),count(Date_Joined),district from patient WHERE district='" + districtCombo.getValue() + "'&& EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' GROUP BY EXTRACT(YEAR FROM Date_Joined)");

                            ResultSet rs = preparedStatement.executeQuery();

                            while (rs.next()) {

                                pieChartObservable.add(new PieChart.Data(rs.getString(1), rs.getInt(2)));
                            }
                            pieChart.setData(pieChartObservable);

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    //14 Pie Chart for Selection of  YEAR RANGE AND CANCER TYPE


                    else if (!cancerTypeCombo.getSelectionModel().isEmpty() && districtCombo.getSelectionModel().isEmpty() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && !genderCheckBox.isSelected()) {


                        try {
                            Connection connection = new Connector().getConnection();
                            PreparedStatement preparedStatement = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),count(Date_Joined),cancer_type from patient WHERE cancer_type='" + cancerTypeCombo.getValue() + "'&& EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' GROUP BY EXTRACT(YEAR FROM Date_Joined)");

                            ResultSet rs = preparedStatement.executeQuery();

                            while (rs.next()) {

                                pieChartObservable.add(new PieChart.Data(rs.getString(1), rs.getInt(2)));
                            }
                            pieChart.setData(pieChartObservable);

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    //15 Pie Chart for Selection of  YEAR RANGE, CANCER TYPE and LOCATION
                     else if (!cancerTypeCombo.getSelectionModel().isEmpty() && !districtCombo.getSelectionModel().isEmpty() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && !genderCheckBox.isSelected()) {

                        try {
                            Connection connection = new Connector().getConnection();
                            PreparedStatement preparedStatement = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),count(Date_Joined),cancer_type,district from patient WHERE cancer_type='" + cancerTypeCombo.getValue() + "'&& district='"+districtCombo.getValue()+"' && EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' GROUP BY EXTRACT(YEAR FROM Date_Joined)");

                            ResultSet rs = preparedStatement.executeQuery();

                            while (rs.next()) {

                                pieChartObservable.add(new PieChart.Data(rs.getString(1), rs.getInt(2)));
                            }
                            pieChart.setData(pieChartObservable);

                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    ////  16 Error for  ALL VARIABLES SELECTED

                    else if (!cancerTypeCombo.getSelectionModel().isEmpty() && !districtCombo.getSelectionModel().isEmpty() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && genderCheckBox.isSelected()){

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Pie Chart Error");
                        alert.setHeaderText("Logic Error");
                        alert.setContentText("Unable to generate Pie chart due to error in Logic.Please Try this analysis using Bar Charts or Line Charts");
                        alert.showAndWait();
                        alert.setOnCloseRequest(e -> alert.close());
                    }} });


                // Line Chart Generation

            loadLineChart.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {


                            ///01 Generation Error box for Empty Search Criteria

                            if (!genderCheckBox.isSelected()&&fromYearTextField.getText().isEmpty()&&toYearTextField.getText().isEmpty()&&districtCombo.getSelectionModel().isEmpty()&&cancerTypeCombo.getSelectionModel().isEmpty()){

                                Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("No Search Criteria");
                                alert.setHeaderText("Empty Search Criteria");
                                alert.setContentText("Please Select Your Desired Search Criteria and Try Again");
                                alert.showAndWait();
                                alert.setOnCloseRequest(e -> alert.close());

                            }

                            // 02 Generation Error box when only GENDER checkbox is selected

                            else if (genderCheckBox.isSelected() && cancerTypeCombo.getSelectionModel().isEmpty() && fromYearTextField.getText().isEmpty() && toYearTextField.getText().isEmpty() && districtCombo.getSelectionModel().isEmpty()) {


                                Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("Line Chart Error");
                                alert.setHeaderText("Logic is Not Rational");
                                alert.setContentText("Line Charts are only defined for variables changing with Year Range. Please Use Pie charts and Bar Graphs to obtain Graphical Analysis of Non-Year Range Variables");
                                alert.showAndWait();
                                alert.setOnCloseRequest(e -> alert.close());

                            }

                            //03 Generation Error box when only GENDER checkbox and District Combobox  are selected

                            else if (genderCheckBox.isSelected() && !districtCombo.getSelectionModel().isEmpty() && fromYearTextField.getText().isEmpty() && toYearTextField.getText().isEmpty() && cancerTypeCombo.getSelectionModel().isEmpty()) {


                                Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("Line Chart Error");
                                alert.setHeaderText("Logic is Not Rational");
                                alert.setContentText("Line Charts are only defined for variables changing with Year Range. Please Use Pie charts and Bar Graphs to obtain Graphical Analysis of Non-Year Range Variables");
                                alert.showAndWait();
                                alert.setOnCloseRequest(e -> alert.close());

                            }

                            // 04 Generation of Error box when  GENDER checkbox and Cancer Combobox  are selected
                            else if (genderCheckBox.isSelected() && !cancerTypeCombo.getSelectionModel().isEmpty() && districtCombo.getSelectionModel().isEmpty() && fromYearTextField.getText().isEmpty() && toYearTextField.getText().isEmpty()) {


                                Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("Line Chart Error");
                                alert.setHeaderText("Logic is Not Rational");
                                alert.setContentText("Line Charts are only defined for variables changing with Year Range. Please Use Pie charts and Bar Graphs to obtain Graphical Analysis of Non-Year Range Variables");
                                alert.showAndWait();
                                alert.setOnCloseRequest(e -> alert.close());

                            }
                            // 05 GENDER,DISTRICT and CANCER TYPE - Line Chart Error

                            else if (!cancerTypeCombo.getSelectionModel().isEmpty() && !districtCombo.getSelectionModel().isEmpty() && fromYearTextField.getText().isEmpty() && toYearTextField.getText().isEmpty() && genderCheckBox.isSelected()) {
                                Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("Line Chart Error");
                                alert.setHeaderText("Logic is Not Rational");
                                alert.setContentText("Line Charts are only defined for variables changing with Year Range. Please Use Pie charts and Bar Graphs to obtain Graphical Analysis of Non-Year Range Variables");
                                alert.showAndWait();
                                alert.setOnCloseRequest(e -> alert.close());
                            }
                            //   06 Only One Cancer type and Select All Cancer Types  Error

                            else if (!cancerTypeCombo.getSelectionModel().isEmpty() && districtCombo.getSelectionModel().isEmpty() && fromYearTextField.getText().isEmpty() && toYearTextField.getText().isEmpty() && !genderCheckBox.isSelected()) {
                                Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("Line Chart Error");
                                alert.setHeaderText("Logic is Not Rational");
                                alert.setContentText("Line Charts are only defined for variables changing with Year Range. Please Use Pie charts and Bar Graphs to obtain Graphical Analysis of Non-Year Range Variables");
                                alert.showAndWait();
                                alert.setOnCloseRequest(e -> alert.close());

                            }

                            //07 Error for District only Line Chart Error

                            else if (!districtCombo.getSelectionModel().isEmpty() && !genderCheckBox.isSelected() && cancerTypeCombo.getSelectionModel().isEmpty() && fromYearTextField.getText().isEmpty() && toYearTextField.getText().isEmpty()) {


                                Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("Line Chart Error");
                                alert.setHeaderText("Logic is Not Rational");
                                alert.setContentText("Line Charts are only defined for variables changing with Year Range. Please Use Pie charts and Bar Graphs to obtain Graphical Analysis of Non-Year Range Variables");
                                alert.showAndWait();
                                alert.setOnCloseRequest(e -> alert.close());

                            }

                            //08 Error for Cancer Type only Line Chart Error

                            else if (!cancerTypeCombo.getSelectionModel().isEmpty() && districtCombo.getSelectionModel().isEmpty() && fromYearTextField.getText().isEmpty() && toYearTextField.getText().isEmpty() && !genderCheckBox.isSelected()) {


                                Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("Line Chart Error");
                                alert.setHeaderText("Logic is Not Rational");
                                alert.setContentText("Line Charts are only defined for variables changing with Year Range. Please Use Pie charts and Bar Graphs to obtain Graphical Analysis of Non-Year Range Variables");
                                alert.showAndWait();
                                alert.setOnCloseRequest(e -> alert.close());

                            }
                            //09 Error Message when  District and Cancer Type are selected to generate line chart

                            else if (!cancerTypeCombo.getSelectionModel().isEmpty() && !districtCombo.getSelectionModel().isEmpty() && fromYearTextField.getText().isEmpty() && toYearTextField.getText().isEmpty() && !genderCheckBox.isSelected()) {


                                Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("Line Chart Error");
                                alert.setHeaderText("Logic is Not Rational");
                                alert.setContentText("Line Charts are only defined for variables changing with Year Range. Please Use Pie charts and Bar Graphs to obtain Graphical Analysis of Non-Year Range Variables");
                                alert.showAndWait();
                                alert.setOnCloseRequest(e -> alert.close());

                            }
                            // Line Chart Generation for variables involving year range
                            // 01 Line Chart for the Selection Gender and YEAR RANGE

                             if (cancerTypeCombo.getSelectionModel().isEmpty() && districtCombo.getSelectionModel().isEmpty() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && genderCheckBox.isSelected()) {

                                 XYChart.Series series1 = new XYChart.Series();
                                 series1.setName("Male");
                                 XYChart.Series series2 = new XYChart.Series();
                                 series2.setName("Female");
                                        try {
                                     Connection connection = new Connector().getConnection();
                                     PreparedStatement preparedStatement1 = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),gender,count(Date_Joined) from patient WHERE gender='Male' && EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' GROUP BY EXTRACT(YEAR FROM Date_Joined)");
                                     ResultSet rs1 = preparedStatement1.executeQuery();

                                     PreparedStatement preparedStatement2 = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),gender,count(Date_Joined) from patient WHERE gender='Female' && EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' GROUP BY EXTRACT(YEAR FROM Date_Joined)");

                                     ResultSet rs2 = preparedStatement2.executeQuery();


                                     while (rs1.next()) {
                                         lineChartObservable.addAll(rs1.getString(1));
                                         xAxis.setCategories(lineChartObservable);
                                         series1.getData().add(new XYChart.Data(rs1.getString(1), rs1.getInt(3)));


                                     }

                                     while (rs2.next()) {
                                         lineChartObservable.addAll(rs2.getString(1));
                                         xAxis.setCategories(lineChartObservable);
                                         series2.getData().add(new XYChart.Data(rs2.getString(1), rs2.getInt(3)));
                                     }

                                     LineChart.getData().addAll(series1, series2);

                                 } catch (SQLException e) {
                                     e.printStackTrace();
                                 }
                             }

                             // 02 Line Chart for the Selection of Gender and YEAR RANGE -AND CANCER TYPE

                             else if (!cancerTypeCombo.getSelectionModel().isEmpty() && districtCombo.getSelectionModel().isEmpty() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && genderCheckBox.isSelected()) {
//
                                 XYChart.Series series1 = new XYChart.Series();
                                 series1.setName("Male");
                                 XYChart.Series series2 = new XYChart.Series();
                                 series2.setName("Female");
                                     try {
                                     Connection connection = new Connector().getConnection();
                                     PreparedStatement preparedStatement1 = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),gender,count(Date_Joined),cancer_type from patient WHERE gender='Male' && EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' && cancer_type='"+cancerTypeCombo.getValue()+"' GROUP BY EXTRACT(YEAR FROM Date_Joined)");
                                     ResultSet rs1 = preparedStatement1.executeQuery();
                                     PreparedStatement preparedStatement2 = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),gender,count(Date_Joined),cancer_type from patient WHERE gender='Female' && EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' && cancer_type='"+cancerTypeCombo.getValue()+"' GROUP BY EXTRACT(YEAR FROM Date_Joined)");
                                     ResultSet rs2 = preparedStatement2.executeQuery();
                                     while (rs1.next()) {
                                         lineChartObservable.addAll(rs1.getString(1));
                                         xAxis.setCategories(lineChartObservable);
                                         series1.getData().add(new XYChart.Data(rs1.getString(1), rs1.getInt(3)));
                                     }
                                     while (rs2.next()) {
                                         lineChartObservable.addAll(rs2.getString(1));
                                         xAxis.setCategories(lineChartObservable);
                                         series2.getData().add(new XYChart.Data(rs2.getString(1), rs2.getInt(3)));
                                     }

                                     LineChart.getData().addAll(series1, series2);

                                 } catch (SQLException e) {
                                     e.printStackTrace();
                                 }
                             }
                             // 03 Line Chart for the Selection of Gender and YEAR RANGE -AND DISTRICT

                             else if (cancerTypeCombo.getSelectionModel().isEmpty() && !districtCombo.getSelectionModel().isEmpty() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && genderCheckBox.isSelected()) {

                                 XYChart.Series series1 = new XYChart.Series();
                                 series1.setName("Male");
                                 XYChart.Series series2 = new XYChart.Series();
                                 series2.setName("Female");

                                 try {
                                     Connection connection = new Connector().getConnection();
                                     PreparedStatement preparedStatement1 = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),gender,count(Date_Joined),district from patient WHERE gender='Male' && EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' && district='"+districtCombo.getValue()+"' GROUP BY EXTRACT(YEAR FROM Date_Joined)");
                                     ResultSet rs1 = preparedStatement1.executeQuery();

                                     PreparedStatement preparedStatement2 = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),gender,count(Date_Joined),district from patient WHERE gender='Female' && EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' && district='"+districtCombo.getValue()+"' GROUP BY EXTRACT(YEAR FROM Date_Joined)");
                                     ResultSet rs2 = preparedStatement2.executeQuery();

                                     while (rs1.next()) {
                                         lineChartObservable.addAll(rs1.getString(1));
                                         xAxis.setCategories(lineChartObservable);
                                         series1.getData().add(new XYChart.Data(rs1.getString(1), rs1.getInt(3)));
                                     }

                                     while (rs2.next()) {
                                         lineChartObservable.addAll(rs2.getString(1));
                                         xAxis.setCategories(lineChartObservable);
                                         series2.getData().add(new XYChart.Data(rs2.getString(1), rs2.getInt(3)));
                                     }

                                     LineChart.getData().addAll(series1, series2);

                                 } catch (SQLException e) {
                                     e.printStackTrace();
                                 }
                             }

                            // 04 Line Chart for the Selection of Year Range

                            if (cancerTypeCombo.getSelectionModel().isEmpty() && districtCombo.getSelectionModel().isEmpty() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && !genderCheckBox.isSelected()) {
                                XYChart.Series<String, Integer> series = new XYChart.Series<>();

                                try {
                                    Connection connection = new Connector().getConnection();
                                    PreparedStatement preparedStatement = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),count(Date_Joined) from patient WHERE EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' GROUP BY EXTRACT(YEAR FROM Date_Joined)");

                                    ResultSet rs = preparedStatement.executeQuery();

                                    while (rs.next()) {
                                        lineChartObservable.addAll(rs.getString(1));
                                        xAxis.setCategories(lineChartObservable);
                                        series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(2)));
                                    }
                                    LineChart.getData().add(series);

                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                            // 05 Line Chart for the Selection of Year Range YEAR RANGE AND District

                            else if (cancerTypeCombo.getSelectionModel().isEmpty() && !districtCombo.getSelectionModel().isEmpty() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && !genderCheckBox.isSelected()) {
                                XYChart.Series<String, Integer> series = new XYChart.Series<>();

                                try {
                                    Connection connection = new Connector().getConnection();
                                    PreparedStatement preparedStatement = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),count(Date_Joined),district from patient WHERE district='" + districtCombo.getValue() + "'&& EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' GROUP BY EXTRACT(YEAR FROM Date_Joined)");

                                    ResultSet rs = preparedStatement.executeQuery();

                                    while (rs.next()) {
                                        lineChartObservable.addAll(rs.getString(1));
                                        xAxis.setCategories(lineChartObservable);
                                        series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(2)));
                                    }
                                    LineChart.getData().add(series);

                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }

                            // 06 Line Chart for the Selection of YEAR RANGE AND Cancer Type

                            else if (!cancerTypeCombo.getSelectionModel().isEmpty() && districtCombo.getSelectionModel().isEmpty() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && !genderCheckBox.isSelected()) {
                                XYChart.Series<String, Integer> series = new XYChart.Series<>();

                                try {
                                    Connection connection = new Connector().getConnection();
                                    PreparedStatement preparedStatement = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),count(Date_Joined),cancer_type from patient WHERE cancer_type='" + cancerTypeCombo.getValue() + "'&& EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' GROUP BY EXTRACT(YEAR FROM Date_Joined)");

                                    ResultSet rs = preparedStatement.executeQuery();

                                    while (rs.next()) {
                                        lineChartObservable.addAll(rs.getString(1));
                                        xAxis.setCategories(lineChartObservable);
                                        series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(2)));
                                    }
                                    LineChart.getData().add(series);

                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }

                            // 07 Line Chart for the Selection of YEAR RANGE AND Cancer Type and LOCATION

                            else if (!cancerTypeCombo.getSelectionModel().isEmpty() && !districtCombo.getSelectionModel().isEmpty() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && !genderCheckBox.isSelected()) {
                                XYChart.Series<String, Integer> series = new XYChart.Series<>();

                                try {
                                    Connection connection = new Connector().getConnection();
                                    PreparedStatement preparedStatement = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),count(Date_Joined),cancer_type,district from patient WHERE cancer_type='" + cancerTypeCombo.getValue() + "'&& district='"+districtCombo.getValue()+"' &&  EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' GROUP BY EXTRACT(YEAR FROM Date_Joined)");

                                    ResultSet rs = preparedStatement.executeQuery();

                                    while (rs.next()) {
                                        lineChartObservable.addAll(rs.getString(1));
                                        xAxis.setCategories(lineChartObservable);
                                        series.getData().add(new XYChart.Data<>(rs.getString(1), rs.getInt(2)));
                                    }
                                    LineChart.getData().add(series);

                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }

                            // 08 Line Chart for the Selection of ALL VARIABLES

                          else if (!cancerTypeCombo.getSelectionModel().isEmpty() && !districtCombo.getSelectionModel().isEmpty() && !fromYearTextField.getText().isEmpty() && !toYearTextField.getText().isEmpty() && genderCheckBox.isSelected()) {
                                XYChart.Series series1 = new XYChart.Series();
                                series1.setName("Male");
                                XYChart.Series series2 = new XYChart.Series();
                                series2.setName("Female");
                                try {
                                    Connection connection = new Connector().getConnection();
                                    PreparedStatement preparedStatement1 = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),count(Date_Joined),cancer_type,district,gender from patient WHERE cancer_type='" + cancerTypeCombo.getValue() + "'&& district='"+districtCombo.getValue()+"' &&  EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "' && gender='Male' GROUP BY EXTRACT(YEAR FROM Date_Joined)");
                                    ResultSet rs1 = preparedStatement1.executeQuery();

                                    PreparedStatement preparedStatement2 = connection.prepareStatement("select EXTRACT(YEAR FROM Date_Joined),count(Date_Joined),cancer_type,district,gender from patient WHERE cancer_type='" + cancerTypeCombo.getValue() + "'&& district='"+districtCombo.getValue()+"' &&  EXTRACT(YEAR FROM Date_Joined)<='" + toYearTextField.getText() + "' && EXTRACT(YEAR FROM Date_Joined) >='" + fromYearTextField.getText() + "'&& gender='Female' GROUP BY EXTRACT(YEAR FROM Date_Joined)");

                                    ResultSet rs2 = preparedStatement2.executeQuery();


                                    while (rs1.next()) {
                                        lineChartObservable.addAll(rs1.getString(1));
                                        xAxis.setCategories(lineChartObservable);
                                        series1.getData().add(new XYChart.Data(rs1.getString(1), rs1.getInt(2)));
                                    }

                                    while (rs2.next()) {
                                        lineChartObservable.addAll(rs2.getString(1));
                                        xAxis.setCategories(lineChartObservable);

                                        series2.getData().add(new XYChart.Data(rs2.getString(1), rs2.getInt(2)));
                                    }

                                    LineChart.getData().addAll(series1, series2);

                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }

                        }});

   }}