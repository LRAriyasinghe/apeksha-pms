package com.apekshapms.model;

import java.time.LocalDate;

public class Ward {

    //Ward declaration
    private String WardID;
    private  String WardName ;
    private  String Description ;
    private String MaxPatient_Count;
    private boolean isGenderaccept ;
    private  String Supervisor;

    public Ward(String 	Ward_id, String Ward_name, String Description,String Max_patients,boolean Gender_acceptence,String Supervisor){
        super();
        this.WardID=Ward_id;
        this.WardName=Ward_name;
        this.Description=Description;
        this.MaxPatient_Count=Max_patients;
        this.isGenderaccept=Gender_acceptence;
        this.Supervisor=Supervisor;
    }
    public Ward(){}

    //Declaration of getters and setters


    public String getWardID() {
        return WardID;
    }

    public void setWardID(String wardID) {
        WardID = wardID;
    }

    public String getWardName() {
        return WardName;
    }

    public void setWardName(String wardName) {
        WardName = wardName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getMaxPatient_Count() {
        return MaxPatient_Count;
    }

    public void setMaxPatient_Count(String maxPatient_Count) {
        MaxPatient_Count = maxPatient_Count;
    }

    public boolean isGenderaccept() {
        return isGenderaccept;
    }

    public void setGenderaccept(boolean genderaccept) {
        isGenderaccept = genderaccept;
    }

    public String getSupervisor() {
        return Supervisor;
    }

    public void setSupervisor(String supervisor) {
        Supervisor = supervisor;
    }
}
