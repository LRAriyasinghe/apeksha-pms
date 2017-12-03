package com.apekshapms.model;

import java.time.LocalDate;

public class LipidProfileReport {

    //General reports declaration
    private String TestType;
    private  String TestID ;
    private  String PatientName ;
    private String PatientID;
    private LocalDate Date ;
    private  String Reference;
    private String Remarks;

    //FullBlood Count Test Variables
    private String Serium_Colostrol;
    private String Serium_Triglycerides;
    private String HDL;
    private String LDL;
    private String VLDL;
    private String CHOL;
    private String LDLHDL;


    public LipidProfileReport(String test_Id, String patient_Id, String patient_name, LocalDate date, String type, String labAssistaant_emp_Id, String remarks
    , String Serum_Cholostrol, String Serum_Triglycer, String HDL, String LDL, String VLDL, String CHOL,String 	LDLHDL){
        super();
        this.TestID=test_Id;
        this.PatientID=patient_Id;
        this.PatientName=patient_name;
        this.Date=date;
        this.TestType=type;
        this.Reference=labAssistaant_emp_Id;
        this.Remarks=remarks;
        this.Serium_Colostrol=Serum_Cholostrol;
        this.Serium_Triglycerides=Serum_Triglycer;
        this.HDL=HDL;
        this.LDL=LDL;
        this.VLDL=VLDL;
        this.CHOL=CHOL;
        this.LDLHDL=LDLHDL;

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


    public String getSerium_Colostrol() {
        return Serium_Colostrol;
    }

    public void setSerium_Colostrol(String serium_Colostrol) {
        Serium_Colostrol = serium_Colostrol;
    }

    public String getSerium_Triglycerides() {
        return Serium_Triglycerides;
    }

    public void setSerium_Triglycerides(String serium_Triglycerides) {
        Serium_Triglycerides = serium_Triglycerides;
    }

    public String getHDL() {
        return HDL;
    }

    public void setHDL(String HDL) {
        this.HDL = HDL;
    }

    public String getLDL() {
        return LDL;
    }

    public void setLDL(String LDL) {
        this.LDL = LDL;
    }

    public String getVLDL() {
        return VLDL;
    }

    public void setVLDL(String VLDL) {
        this.VLDL = VLDL;
    }

    public String getCHOL() {
        return CHOL;
    }

    public void setCHOL(String CHOL) {
        this.CHOL = CHOL;
    }

    public String getLDLHDL() {
        return LDLHDL;
    }

    public void setLDLHDL(String LDLHDL) {
        this.LDLHDL = LDLHDL;
    }
}
