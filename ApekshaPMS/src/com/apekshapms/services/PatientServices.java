package com.apekshapms.services;

import com.apekshapms.database.connector.PatientConnector;
import com.apekshapms.main.Session;
import com.apekshapms.model.Patient;

public class PatientServices {
    public static void addPatient(Patient patient){
        PatientConnector patientConnector = new PatientConnector();
        patientConnector.newPatient(patient);
        //Session.patientConnector.newPatient(patient);
    }

    public static void addHistory(Patient patient){
        PatientConnector patientConnector = new PatientConnector();
        patientConnector.newHistory(patient);
    }

    public static void searchPatient(Patient patient){
        Session.patientConnector.searchPatient(patient);}
}
