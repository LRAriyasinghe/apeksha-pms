package com.apekshapms.model;

import javafx.scene.control.DatePicker;

import java.time.LocalDate;

public class AdminMessage {
    private Integer adminmessageid;
    private String adminmessage;
    private String emp_Id;
    private String adminstatus;
    private LocalDate admindate;


    public AdminMessage(int id, String employee_emp_id, String message, String status, LocalDate sendDate) {
        this.adminmessageid=id;
        this.emp_Id=employee_emp_id;
        this.adminmessage=message;
        this.adminstatus=status;
        this.admindate=sendDate;
    }


    public Integer getAdminmessageid() {
        return adminmessageid;
    }

    public void setAdminmessageid(Integer adminmessageid) {
        this.adminmessageid = adminmessageid;
    }

    public String getAdminmessage() {
        return adminmessage;
    }

    public void setAdminmessage(String adminmessage) {
        this.adminmessage = adminmessage;
    }

    public String getEmp_Id() {
        return emp_Id;
    }

    public void setEmp_Id(String emp_Id) {
        this.emp_Id = emp_Id;
    }

    public String getAdminstatus() {
        return adminstatus;
    }

    public void setAdminstatus(String adminstatus) {
        this.adminstatus = adminstatus;
    }

    public LocalDate getAdmindate() {
        return admindate;
    }

    public void setAdmindate(LocalDate admindate) {
        this.admindate = admindate;
    }
}
