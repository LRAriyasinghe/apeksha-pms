package com.apekshapms.services;

import com.apekshapms.main.Session;

import java.util.ArrayList;
import java.util.HashMap;

public class StatisticalServices {
    public static ArrayList<Integer> getYears(){
        return Session.statisticalConnector.getYears();
    }

    public static ArrayList<String> getTypes(){
        return Session.statisticalConnector.getTypes();
    }

    public static ArrayList<String> getDistricts(){
        return Session.statisticalConnector.getDistricts();
    }

    public static HashMap<String, Integer> getTextualData(Integer year, String type, String district){
        return Session.statisticalConnector.getTextualData(year, type, district);
    }
}
