package com.apekshapms.model;

import java.time.LocalDate;

public class FullBloodReport {

    //General reports declaration
    private String TestType;
    private  String TestID ;
    private  String PatientName ;
    private String PatientID;
    private LocalDate Date ;
    private  String Reference;
    private String Remarks;

    //FullBlood Count Test Variables
    private String WBC;
    private String NE;
    private String Himoglobin;
    private String Plateletes;


    public FullBloodReport(String test_Id, String patient_Id, String patient_name, LocalDate date, String type, String labAssistaant_emp_Id, String remarks
    , String WBC,String NE,String Himoglobin,String Platlets){
        super();
        this.TestID=test_Id;
        this.PatientID=patient_Id;
        this.PatientName=patient_name;
        this.Date=date;
        this.TestType=type;
        this.Reference=labAssistaant_emp_Id;
        this.Remarks=remarks;
        this.WBC=WBC;
        this.NE=NE;
        this.Himoglobin=Himoglobin;
        this.Plateletes=Platlets;

    }


    //Declaration of getters and setters
    public String getTestType() {
        return TestType;
    }

    public void setTestType(String testType) {
        TestType = testType;
    }

    public String getTestID() {
        return TestID;
    }

    public void setTestID(String testID) {
        TestID = testID;
    }



    public String getPatientID() {
        return PatientID;
    }

    public void setPatientID(String patientID) {
        PatientID = patientID;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public String getReference() {
        return Reference;
    }

    public void setReference(String reference) {
        Reference = reference;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }



    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String patientName) {
        PatientName = patientName;
    }


    public String getWBC() {
        return WBC;
    }

    public void setWBC(String WBC) {
        this.WBC = WBC;
    }

    public String getNE() {
        return NE;
    }

    public void setNE(String NE) {
        this.NE = NE;
    }

    public String getHimoglobin() {
        return Himoglobin;
    }

    public void setHimoglobin(String himoglobin) {
        Himoglobin = himoglobin;
    }

    public String getPlateletes() {
        return Plateletes;
    }

    public void setPlateletes(String plateletes) {
        Plateletes = plateletes;
    }
}
