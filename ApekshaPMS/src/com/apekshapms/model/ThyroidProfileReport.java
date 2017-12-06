package com.apekshapms.model;

import java.time.LocalDate;

public class ThyroidProfileReport {

    //General reports declaration
    private String TestType;
    private  String TestID ;
    private  String PatientName ;
    private String PatientID;
    private LocalDate Date ;
    private  String Reference;
    private String Remarks;

    //FullBlood Count Test Variables
    private String 	TSH;
    private String 	FreeT4;
    private String FreeT3;



    public ThyroidProfileReport(String test_Id, String patient_Id, String patient_name, LocalDate date, String type, String labAssistaant_emp_Id, String remarks
    , String TSH, String FreeT4, String FreeT3){
        super();
        this.TestID=test_Id;
        this.PatientID=patient_Id;
        this.PatientName=patient_name;
        this.Date=date;
        this.TestType=type;
        this.Reference=labAssistaant_emp_Id;
        this.Remarks=remarks;
        this.TSH=TSH;
        this.FreeT4=FreeT4;
        this.FreeT3=FreeT3;


    }
    public ThyroidProfileReport(){}


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


    public String getTSH() {
        return TSH;
    }

    public void setTSH(String TSH) {
        this.TSH = TSH;
    }

    public String getFreeT4() {
        return FreeT4;
    }

    public void setFreeT4(String freeT4) {
        FreeT4 = freeT4;
    }

    public String getFreeT3() {
        return FreeT3;
    }

    public void setFreeT3(String freeT3) {
        FreeT3 = freeT3;
    }
}
