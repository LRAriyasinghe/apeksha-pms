package com.apekshapms.controller.ward;

import com.apekshapms.controller.Controller;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.Ward;
import com.apekshapms.services.WardServices;
import com.apekshapms.ui.UIName;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by Thilina on 10/15/2017.
 * Univercity of Colombo School of Computing
 */
public class NewWardController implements Controller {
    @FXML
    private TextField wardIdTextField;
    @FXML
    private TextField wardNameTextField;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private TextField maxPatientCountTextField;
    @FXML
    private RadioButton radiobtnMale;
    @FXML
    private RadioButton radiobtnFemale;
    @FXML
    private TextField headID;
    @FXML
    private Button SubmitButton;

    private Ward ward = new Ward();

    public void initialize(URL location, ResourceBundle resources) {
        SubmitButton.setOnAction(new EventHandler<ActionEvent>()  {
            @Override
            public void handle(ActionEvent event) {
                if (isInputValid()) {
                    try {
                        ward.setWardID((wardIdTextField.getText()));
                        ward.setWardName(wardNameTextField.getText());
                        ward.setDescription(descriptionTextArea.getText());
                        ward.setMaxPatient_Count(maxPatientCountTextField.getText());
                        ward.setGenderaccept(radiobtnMale.isSelected());
                        ward.setSupervisor(headID.getText());

                    }catch (Exception e){
                        System.err.println(e);
                    }
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);//Patient Register Confirmation Dialog box
                    alert.setTitle("Confirmation Dialog");
                    alert.setHeaderText("Look, a Confirmation Dialog");
                    alert.setContentText("Do yu want to add a new Ward??");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {

                        System.out.println("Yes");
                        WardServices.addNewWord(ward);
                    }else {
                        UIFactory.launchUI(UIName.NEW_WARD, true);
                        // ... user chose CANCEL or closed the dialog
                    }

                }

            }
        });
    }

    @Override
    public void refreshView() {

    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (wardIdTextField.getText() == null || wardIdTextField.getText().length() == 0) {
            errorMessage += "Ward ID field is Empty!\n";
        }
        if (wardNameTextField.getText() == null || wardNameTextField.getText().length() == 0) {
            errorMessage += "Ward Name Field is Empty!\n";
        }
        if (headID.getText() == null || headID.getText().length() == 0) {
            errorMessage += "Ward Head is Empty!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Look, a Warning Dialog");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            System.out.println("Successfully Fail");

            return false;
        }
    }

}//Class Finish