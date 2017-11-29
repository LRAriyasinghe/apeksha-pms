package com.apekshapms.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Thilina on 10/22/2017.
 * Univercity of Colombo School of Computing
 */
public class Consultant {
    private SimpleStringProperty consultantDocId;

    public Consultant(String emp_id) {
        this.setConsultantDocId(new SimpleStringProperty(emp_id));
    }


    public SimpleStringProperty getConsultantDocId() {
        return consultantDocId;
    }

    public void setConsultantDocId(SimpleStringProperty consultantDocId) {
        this.consultantDocId = consultantDocId;
    }
}
