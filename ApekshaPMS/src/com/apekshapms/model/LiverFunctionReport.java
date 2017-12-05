package com.apekshapms.model;

import java.time.LocalDate;

public class LiverFunctionReport {

    //General reports declaration
    private String TestType;
    private  String TestID ;
    private  String PatientName ;
    private String PatientID;
    private LocalDate Date ;
    private  String Reference;
    private String Remarks;

    //FullBlood Count Test Variables
    private String Serum_Bilrubin;
    private String SGPT;
    private String SGOT;
    private String Serum_Alkaline;
    private String Serum_Creatinine;
    private String Serum_Calcium;


    public LiverFunctionReport(String test_Id, String patient_Id, String patient_name, LocalDate date, String type, String labAssistaant_emp_Id, String remarks
    , String Serum_Bilrubin, String SGPT, String SGOT, String Serum_Alkaline,String Serum_Creatinine,String Serum_Calcium){
        super();
        this.TestID=test_Id;
        this.PatientID=patient_Id;
        this.PatientName=patient_name;
        this.Date=date;
        this.TestType=type;
        this.Reference=labAssistaant_emp_Id;
        this.Remarks=remarks;
        this.Serum_Bilrubin=Serum_Bilrubin;
        this.SGPT=SGPT;
        this.SGOT=SGOT;
        this.Serum_Alkaline=Serum_Alkaline;
        this.Serum_Creatinine=Serum_Creatinine;
        this.Serum_Calcium=Serum_Calcium;

    }
    public LiverFunctionReport(){}

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


    public String getSerum_Bilrubin() {
        return Serum_Bilrubin;
    }

    public void setSerum_Bilrubin(String serum_Bilrubin) {
        Serum_Bilrubin = serum_Bilrubin;
    }

    public String getSGPT() {
        return SGPT;
    }

    public void setSGPT(String SGPT) {
        this.SGPT = SGPT;
    }

    public String getSGOT() {
        return SGOT;
    }

    public void setSGOT(String SGOT) {
        this.SGOT = SGOT;
    }

    public String getSerum_Alkaline() {
        return Serum_Alkaline;
    }

    public void setSerum_Alkaline(String serum_Alkaline) {
        Serum_Alkaline = serum_Alkaline;
    }

    public String getSerum_Creatinine() {
        return Serum_Creatinine;
    }

    public void setSerum_Creatinine(String serum_Creatinine) {
        Serum_Creatinine = serum_Creatinine;
    }

    public String getSerum_Calcium() {
        return Serum_Calcium;
    }

    public void setSerum_Calcium(String serum_Calcium) {
        Serum_Calcium = serum_Calcium;
    }
}
