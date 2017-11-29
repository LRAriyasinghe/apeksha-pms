package com.apekshapms.controller.admin;

/**
 * Created by Thilina on 10/21/2017.
 * Univercity of Colombo School of Computing
 */
import com.apekshapms.controller.Controller;
import com.apekshapms.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ExampleController implements Controller{
    private Connection connection;
    private String url;
    private String userName;
    private String password;
    private String dbName;

    ObservableList<User> data = FXCollections.observableArrayList();
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;

    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> usernameColumn;

    @FXML
    private TableColumn<?, ?> passwordColumn;

    @Override
    public void refreshView() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        try {
            loadDatabaseUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void loadDatabaseUser() throws SQLException {
        try {
            url = "jdbc:mysql://" + "localhost" + ":3306/";
            userName = "root";
            password = "";
            dbName = "apekshahospitalmaharagama";

            try {
                connection  =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/apekshahospitalmaharagama", "root", "");
                //connection = (Connection) DriverManager.getConnection(url + dbName, userName, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }


            preparedStatement = connection.prepareStatement("select * from usernamepassword");
            //preparedStatement = preparedStatement.getConnection().prepareStatement("select * from usernamepassword");
            rs=preparedStatement.executeQuery();

            while (rs.next()){
                data.add(new User(
                        rs.getString("username"),
                        rs.getString("emp_Id"),
                        rs.getString("password")
                ));
                userTable.setItems(data);
            }
            preparedStatement.close();
            rs.close();
        }catch (Exception e){
            System.err.println(e);
        }



    }
}
