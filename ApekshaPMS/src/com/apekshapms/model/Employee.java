package com.apekshapms.model;

import java.time.LocalDate;

/**
 * Created by Thilina on 10/21/2017.
 * Univercity of Colombo School of Computing
 */
public class Employee {
    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private String doorNu;
    private String city;
    private String distric;
    private String street;
    private String nic;
    private String contactNu;
    private String bank;
    private String branch;
    private String department;
    private String type;
    private LocalDate dob;
    private String grade;
    private String bank_acc_nu;
    private String address;
    private String gender;


    public Employee() {

    }

    public Employee(String emp_id, String firstName, String lastName, String type) {
        this.id = emp_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
    }

    public Employee(String emp_id, String firstName, String lastName, String nic_no, String type, String city, String district, String contact_no, String department) {
        this.id = emp_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nic = nic_no;
        this.type = type;
        this.city = city;
        this.distric = district;
        this.contactNu = contact_no;
        this.department = department;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDoorNu() {
        return doorNu;
    }

    public void setDoorNu(String doorNu) {
        this.doorNu = doorNu;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistric() {
        return distric;
    }

    public void setDistric(String distric) {
        this.distric = distric;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getContactNu() {
        return contactNu;
    }

    public void setContactNu(String contactNu) {
        this.contactNu = contactNu;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getBank_acc_nu() {
        return bank_acc_nu;
    }

    public void setBank_acc_nu(String bank_acc_nu) {
        this.bank_acc_nu = bank_acc_nu;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}


