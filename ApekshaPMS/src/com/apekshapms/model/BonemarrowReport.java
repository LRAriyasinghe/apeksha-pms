package com.apekshapms.model;

import java.time.LocalDate;

public class BonemarrowReport {

    //General reports declaration
    private String TestType;
    private  String TestID ;
    private  String PatientName ;
    private String PatientID;
    private LocalDate Date ;
    private  String Reference;
    private String Remarks;

    //Bonemarrow Test Variables
    private String BMBx;
    private String TrephineBMBx;

    public BonemarrowReport(String 	type,String test_Id,String patient_Id,String patient_name,LocalDate date, String labAssistaant_emp_Id, String remarks
    ,String BMBx,String TrephineBMBx){
        super();
        this.TestType=type;
        this.TestID=test_Id;
        this.PatientID=patient_Id;
        this.PatientName=patient_name;
        this.Date=date;
        this.Reference=labAssistaant_emp_Id;
        this.Remarks=remarks;
        this.BMBx=BMBx;
        this.TrephineBMBx=TrephineBMBx;
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

    public String getBMBx() {
        return BMBx;
    }

    public void setBMBx(String BMBx) {
        this.BMBx = BMBx;
    }

    public String getTrephineBMBx() {
        return TrephineBMBx;
    }

    public void setTrephineBMBx(String trephineBMBx) {
        TrephineBMBx = trephineBMBx;
    }

    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String patientName) {
        PatientName = patientName;
    }
}
