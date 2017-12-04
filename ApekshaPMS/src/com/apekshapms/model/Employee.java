package com.apekshapms.model;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Thilina on 10/21/2017.
 * Univercity of Colombo School of Computing
 */
public class Employee {

    private SimpleStringProperty id;
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty doorNu;
    private SimpleStringProperty city;
    private SimpleStringProperty distric;
    private SimpleStringProperty street;
    private SimpleStringProperty nic;
    private SimpleStringProperty contactNu;
    private SimpleStringProperty bank;
    private SimpleStringProperty branch;
    private SimpleStringProperty department;
    private SimpleStringProperty type;
    private LocalDate dob;

    public Employee(String emp_id, String firstName, String lastName, String type) {
        this.id = new SimpleStringProperty(emp_id);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.type = new SimpleStringProperty(type);
    }

    public Employee(String emp_id, String firstName, String lastName, String nic_no, String type, String city, String district, String contact_no, String department) {
    this.id= new SimpleStringProperty(emp_id);
    this.firstName = new SimpleStringProperty(firstName);
    this.lastName = new SimpleStringProperty(lastName);
    this.nic = new SimpleStringProperty(nic_no);
    this.type = new SimpleStringProperty(type);
    this.city = new SimpleStringProperty(city);
    this.distric = new SimpleStringProperty(district);
    this.contactNu = new SimpleStringProperty(contact_no);
    this.department = new SimpleStringProperty(department);
    }


    public String getId() {
        return id.get();
    }

    public void setId(SimpleStringProperty id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(SimpleStringProperty firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(SimpleStringProperty lastName) {
        this.lastName = lastName;
    }

    public String getDoorNu() {
        return doorNu.get();
    }

    public void setDoorNu(SimpleStringProperty doorNu) {
        this.doorNu = doorNu;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(SimpleStringProperty city) {
        this.city = city;
    }

    public String getDistric() {
        return distric.get();
    }

    public void setDistric(SimpleStringProperty distric) {
        this.distric = distric;
    }

    public String getStreet() {
        return street.get();
    }

    public void setStreet(SimpleStringProperty street) {
        this.street = street;
    }

    public String getNic() {
        return nic.get();
    }

    public void setNic(SimpleStringProperty nic) {
        this.nic = nic;
    }

    public String getContactNu() {
        return contactNu.get();
    }

    public void setContactNu(SimpleStringProperty contactNu) {
        this.contactNu = contactNu;
    }

    public String getBank() {
        return bank.get();
    }

    public void setBank(SimpleStringProperty bank) {
        this.bank = bank;
    }

    public String getBranch() {
        return branch.get();
    }

    public void setBranch(SimpleStringProperty branch) {
        this.branch = branch;
    }

    public String getDepartment() {
        return department.get();
    }

    public void setDepartment(SimpleStringProperty department) {
        this.department = department;
    }

    public String getType() {
        return type.get();
    }

    public void setType(SimpleStringProperty type) {
        this.type = type;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
