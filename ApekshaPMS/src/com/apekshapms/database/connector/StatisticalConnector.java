package com.apekshapms.database.connector;

import com.apekshapms.database.Connector;
import com.apekshapms.main.Session;
import com.mysql.jdbc.PreparedStatement;
//import com.mysql.cj.jdbc.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class StatisticalConnector extends Connector {
    public ArrayList<Integer> getYears() {
        ArrayList<Integer> resultArrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("SELECT DISTINCT YEAR(date) AS cyear FROM treatment ORDER BY cyear");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                resultArrayList.add(resultSet.getInt("cyear"));
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

        //>> Check the SQL for errors
        //>> Adding dummy data
        resultArrayList.add(2000);
        resultArrayList.add(2001);
        resultArrayList.add(2002);
        resultArrayList.add(2004);

        return resultArrayList;
    }

    public ArrayList<String> getTypes(){
        ArrayList<String> resultArrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("SELECT DISTINCT type AS ctype FROM treatment");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                resultArrayList.add(resultSet.getString("ctype"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //>> Check the SQL for errors
        //>> Adding dummy data
        resultArrayList.add("Lung");
        resultArrayList.add("Brain");
        resultArrayList.add("Pancrease");
        resultArrayList.add("Skin");

        return resultArrayList;
    }

    public ArrayList<String> getDistricts(){
        ArrayList<String> resultArrayList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement("SELECT DISTINCT district FROM patient");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                resultArrayList.add(resultSet.getString("district"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //>> Check the SQL for errors
        //>> Adding dummy data
        resultArrayList.add("Kurunegala");
        resultArrayList.add("Colombo");
        resultArrayList.add("Galle");
        resultArrayList.add("Matara");

        return resultArrayList;
    }

    public HashMap<String, Integer> getTextualData(Integer year, String type, String district){
        HashMap<String, Integer> resultHashMap = new HashMap<>();

        try {
            String sql1 = "SELECT COUNT(*) FROM patient " +
                    "INNER JOIN treatment ON patient.patient_Id = treatment.patient_Id " +
                    "WHERE TRUE";
            if(year != null){
                sql1 = sql1 + " AND YEAR(treatment.date) = " + year;
            }
            PreparedStatement preparedStatement1 = (PreparedStatement) getConnection().prepareStatement(sql1);
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while(resultSet1.next()){
                resultHashMap.put("male", resultSet1.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //>> Check the SQL for errors
        //>> Adding dummy data

        return resultHashMap;
    }
}
