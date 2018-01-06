package com.apekshapms.model;

public class PatientHistory {
    private int id;
    private String patientid;
    private String pastMedicalHistory;
    private String presentComplaint;
    private String surgicalHistory;
    private String allegiHistory;
    private String socialHistory;
    private String familyHistory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public String getPastMedicalHistory() {
        return pastMedicalHistory;
    }

    public void setPastMedicalHistory(String pastMedicalHistory) {
        this.pastMedicalHistory = pastMedicalHistory;
    }

    public String getPresentComplaint() {
        return presentComplaint;
    }

    public void setPresentComplaint(String presentComplaint) {
        this.presentComplaint = presentComplaint;
    }

    public String getSurgicalHistory() {
        return surgicalHistory;
    }

    public void setSurgicalHistory(String surgicalHistory) {
        this.surgicalHistory = surgicalHistory;
    }

    public String getAllegiHistory() {
        return allegiHistory;
    }

    public void setAllegiHistory(String allegiHistory) {
        this.allegiHistory = allegiHistory;
    }

    public String getSocialHistory() {
        return socialHistory;
    }

    public void setSocialHistory(String socialHistory) {
        this.socialHistory = socialHistory;
    }

    public String getFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(String familyHistory) {
        this.familyHistory = familyHistory;
    }
}

