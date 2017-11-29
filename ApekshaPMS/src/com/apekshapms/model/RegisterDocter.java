package com.apekshapms.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Thilina on 10/22/2017.
 * Univercity of Colombo School of Computing
 */
public class RegisterDocter {
    private SimpleStringProperty regDocId;

    public RegisterDocter(String emp_id) {
        this.regDocId = new SimpleStringProperty(emp_id);
    }

    public String getRegDocId() {
        return regDocId.get();
    }

    public void setRegDocId(SimpleStringProperty regDocId) {
        this.regDocId = regDocId;
    }
}
