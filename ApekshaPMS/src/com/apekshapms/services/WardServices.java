package com.apekshapms.services;

import com.apekshapms.main.Session;
import com.apekshapms.model.Ward;


public class WardServices {
    public static void addNewWord(Ward ward) {
        System.out.println("Correct");
        Session.wardConnector.newWard(ward);
    }
}
