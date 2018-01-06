package com.apekshapms.model;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class DiagnosisCard {

    private Patient patient;
    private PatientHistory patientHistory;
    private ObservableList<Treatment> treatments;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public PatientHistory getPatientHistory() {
        return patientHistory;
    }

    public void setPatientHistory(PatientHistory patientHistory) {
        this.patientHistory = patientHistory;
    }


    public ObservableList<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(ObservableList<Treatment> treatments) {
        this.treatments = treatments;
    }
}
