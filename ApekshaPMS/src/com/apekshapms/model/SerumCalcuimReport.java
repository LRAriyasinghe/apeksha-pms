package com.apekshapms.model;

import java.time.LocalDate;

public class SerumCalcuimReport {

    //General reports declaration
    private String TestType;
    private  String TestID ;
    private  String PatientName ;
    private String PatientID;
    private LocalDate Date ;
    private  String Reference;
    private String Remarks;

    //FullBlood Count Test Variables
    private String FreeCalcium;
    private String TotalCalcium;



    public SerumCalcuimReport(String test_Id, String patient_Id, String patient_name, LocalDate date, String type, String labAssistaant_emp_Id, String remarks
    , String Free_calcium, String Total_calcium){
        super();
        this.TestID=test_Id;
        this.PatientID=patient_Id;
        this.PatientName=patient_name;
        this.Date=date;
        this.TestType=type;
        this.Reference=labAssistaant_emp_Id;
        this.Remarks=remarks;
        this.FreeCalcium=Free_calcium;
        this.TotalCalcium=Total_calcium;


    }
    public SerumCalcuimReport(){}

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



    public String getFreeCalcium() {
        return FreeCalcium;
    }

    public void setFreeCalcium(String freeCalcium) {
        FreeCalcium = freeCalcium;
    }

    public String getTotalCalcium() {
        return TotalCalcium;
    }

    public void setTotalCalcium(String totalCalcium) {
        TotalCalcium = totalCalcium;
    }
}
