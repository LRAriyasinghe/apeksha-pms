package com.apekshapms.services;

import com.apekshapms.main.Session;
import com.apekshapms.model.Patient;

public class PatientServices {
    public static void addPatient(Patient patient){
        Session.patientConnector.newPatient(patient);
        System.out.println("NSNSNSN");
    }
    public static void searchPatient(Patient patient) {
        Session.patientConnector.searchPatient(patient);
    }
}
