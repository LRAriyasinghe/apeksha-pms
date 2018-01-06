package com.apekshapms.controller.ward;

import com.apekshapms.controller.Controller;
import com.apekshapms.database.Connector;
import com.apekshapms.factory.UIFactory;
import com.apekshapms.model.Ward;
import com.apekshapms.services.WardServices;
import com.apekshapms.ui.UIName;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Thilina on 10/15/2017.
 * Univercity of Colombo School of Computing
 */
public class NewWardController implements Controller {
    PreparedStatement preparedStatement = null;
    ResultSet rs= null;


    @FXML
    private TextField wardIdTextField;
    @FXML
    private TextField wardNameTextField;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private TextField maxPatientCountTextField;
    @FXML
    private ComboBox<String> genderComboBox;
    @FXML
    private ComboBox<String> headID;
    @FXML
    private Button SubmitButton;


    //Make a observable list called 'gendertypes' to store gender
    private ObservableList gendertypes = FXCollections.observableArrayList();
    //Make a observale list called 'SupervisorList' to store Consultant names
    private ObservableList SupervisorList = FXCollections.observableArrayList();

    private Ward ward = new Ward();



    public void initialize(URL location, ResourceBundle resources) {

        try {
            Connection connection = new Connector().getConnection();
            String query = "select * from employee WHERE type LIKE 'Consultant Doctor' ";
            preparedStatement=connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                SupervisorList.setAll(rs.getString(3));
            }

            headID.setItems(SupervisorList);

        }

        catch (Exception e){
            System.err.println(e);
        }


        gendertypes.addAll("Male","Female");
        genderComboBox.setItems(gendertypes);

        //Add a ward to the system
        SubmitButton.setOnAction(new EventHandler<ActionEvent>()  {
            @Override
            public void handle(ActionEvent event) {
                if (isInputValid()) {
                    try {
                        ward.setWardID((wardIdTextField.getText()));
                        ward.setWardName(wardNameTextField.getText());
                        ward.setDescription(descriptionTextArea.getText());
                        ward.setMaxPatient_Count(maxPatientCountTextField.getText());
                        ward.setGender_acceptence(genderComboBox.getValue());
                        ward.setSupervisor(headID.getValue());

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

                        wardIdTextField.setText("");
                        wardNameTextField.setText("");
                        descriptionTextArea.setText("");
                        maxPatientCountTextField.setText("");
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
        String expression = "^[a-zA-Z]*$";

        //java.lang.String expression2 = "[0-9]";

        CharSequence inputStr1 = wardNameTextField.getText();
        Pattern pattern1 = Pattern.compile(expression);
        Matcher matcher1 = pattern1.matcher(inputStr1);

        if (wardIdTextField.getText() == null || wardNameTextField.getText().length() == 0||!matcher1.matches()) {
            errorMessage += "Not a Valid Ward Name!\n";
        }


        if(maxPatientCountTextField.getText() == null ||maxPatientCountTextField.getText().length() == 0 ){
            errorMessage += "Max Patient field is Empty!\n";
        }
        /*if (headID.getValue() == null || headID.getValue().length() == 0) {
            errorMessage += "Ward Head is Empty!\n";
        }*/
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