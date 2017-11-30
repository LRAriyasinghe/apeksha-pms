package com.apekshapms.model;

import java.time.LocalDate;

public class Patient {
    public Patient(){

    }

    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private String nicNo;
    private LocalDate dob;
    private boolean isMale;
    private String occupation;
    private String telephone;
    private String city;
    private String district;
    private String address;
    private boolean isCivil;
    private String history;
    private String surgical;
    private String allergy;
    private String social;
    private String family;
    private String registerDocId;
    private String consultantId;
    private String details;

    public Patient(String patient_id, String title, String first_name, String last_name, String nic_no, LocalDate dob, boolean gender, String occupation, boolean civil_status, String contact_no, String address, String city, String distric, String registerDoctor_emp_id, String consultant_emp_id, String additional_details) {
    super();
    this.id=patient_id;
    this.title=title;
    this.firstName=first_name;
    this.lastName=last_name;
    this.nicNo=nic_no;
    this.dob=dob;
    this.isMale=gender;
    this.occupation=occupation;
    this.isCivil=civil_status;
    this.telephone=contact_no;
    this.address=address;
    this.city=city;
    this.district=distric;
    this.registerDocId=registerDoctor_emp_id;
    this.consultantId=consultant_emp_id;
    this.details=additional_details;


    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getSurgical() {
        return surgical;
    }

    public void setSurgical(String surgical) {
        this.surgical = surgical;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getSocial() {
        return social;
    }

    public void setSocial(String social) {
        this.social = social;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getRegisterDocId() {
        return registerDocId;
    }

    public void setRegisterDocId(String registerDocId) {
        this.registerDocId = registerDocId;
    }

    public String getConsultantId() {
        return consultantId;
    }

    public void setConsultantId(String consultantId) {
        this.consultantId = consultantId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }

    public boolean isCivil() {
        return isCivil;
    }

    public void setCivil(boolean civil) {
        isCivil = civil;
    }
}