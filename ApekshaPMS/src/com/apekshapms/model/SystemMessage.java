package com.apekshapms.model;

import java.time.LocalDate;

public class SystemMessage {
    public SystemMessage(){

    }

    private Integer messageid;
    private String patientId;
    private String counsultantId;
    private String labAssistantId;
    private String message;
    private String statusMessage;
    private String workedStatus;
    private LocalDate sendDate;
    private LocalDate receivedDate;

    public SystemMessage(Integer id, String patient_id, String consultant_id, String message, String status, LocalDate receivedDate){
        super();
        this.messageid = id;
        this.patientId = patient_id;
        this.counsultantId = consultant_id;
        this.message = message;
        this.statusMessage = status;
        this.receivedDate = receivedDate;


    }



    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getCounsultantId() {
        return counsultantId;
    }

    public void setCounsultantId(String counsultantId) {
        this.counsultantId = counsultantId;
    }

    public String getLabAssistantId() {
        return labAssistantId;
    }

    public void setLabAssistantId(String labAssistantId) {
        this.labAssistantId = labAssistantId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getWorkedStatus() {
        return workedStatus;
    }

    public void setWorkedStatus(String workedStatus) {
        this.workedStatus = workedStatus;
    }

    public LocalDate getSendDate() {
        return sendDate;
    }

    public void setSendDate(LocalDate sendDate) {
        this.sendDate = sendDate;
    }

    public LocalDate getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(LocalDate receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
