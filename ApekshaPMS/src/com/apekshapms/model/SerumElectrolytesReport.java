package com.apekshapms.model;

import java.time.LocalDate;

public class SerumElectrolytesReport {

    //General reports declaration
    private String TestType;
    private  String TestID ;
    private  String PatientName ;
    private String PatientID;
    private LocalDate Date ;
    private  String Reference;
    private String Remarks;

    //FullBlood Count Test Variables
    private String Sodium;
    private String Potassium;



    public SerumElectrolytesReport(String test_Id, String patient_Id, String patient_name, LocalDate date, String type, String labAssistaant_emp_Id, String remarks
    , String Sodium, String Potassium){
        super();
        this.TestID=test_Id;
        this.PatientID=patient_Id;
        this.PatientName=patient_name;
        this.Date=date;
        this.TestType=type;
        this.Reference=labAssistaant_emp_Id;
        this.Remarks=remarks;
        this.Sodium=Sodium;
        this.Potassium=Potassium;
    }

    public SerumElectrolytesReport(){}

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


    public String getSodium() {
        return Sodium;
    }

    public void setSodium(String sodium) {
        Sodium = sodium;
    }

    public String getPotassium() {
        return Potassium;
    }

    public void setPotassium(String potassium) {
        Potassium = potassium;
    }
}
