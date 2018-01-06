package com.apekshapms.database.connector;

import com.apekshapms.controller.DashboardController;
import com.apekshapms.database.Connector;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.main.Main;
import com.apekshapms.model.Ward;
import com.apekshapms.ui.UI;
import com.apekshapms.ui.UIName;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class WardConnector extends Connector {
    private Main mainApp;
    String notification = "";
    public void newWard(Ward ward){
        try{
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("INSERT INTO " +
                    "Ward(Ward_id,Ward_name, Description, Max_patients,Gender_acceptence,Supervisor) " +
                    "VALUES(?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, ward.getWardID());
            preparedStatement.setString(2, ward.getWardName());
            preparedStatement.setString(3, ward.getDescription());
            preparedStatement.setString(4, ward.getMaxPatient_Count());
            preparedStatement.setString(5, ward.getGender_acceptence());
            preparedStatement.setString(6, ward.getSupervisor());

            //Final get the all Result in the MessageBox
            notification += "Ward ID : "+ward.getWardID();
            notification += "\nWard Title : "+ward.getWardName();
            notification += "\nWard Description : "+ward.getDescription();
            notification += "\nWard Max Patients : "+ward.getMaxPatient_Count();


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Look, a Confirmation Dialog");
            alert.setContentText("Are you ok with New Ward Add in to the System ?\n"+notification);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                // ... user chose OK
                preparedStatement.execute();
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Message");
                alert1.setHeaderText("");
                alert1.setContentText("Succussfully Added WARD.!");
                alert1.showAndWait();
                alert1.setOnCloseRequest(e -> alert.close());
            } else {
                // ... user chose CANCEL or closed the dialog then go to the Back
                UI ui = UIFactory.getUI(UIName.NEW_PATIENT);
                Parent parent = ui.getParent();
                DashboardController dashboardController = ((DashboardController) (UIFactory.getUI(UIName.DASHBOARD).getController()));
                dashboardController.setWorkspace(parent);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }


        }

    }

