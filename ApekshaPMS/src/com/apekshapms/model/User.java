package com.apekshapms.model;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

/**
 * Created by Thilina on 10/21/2017.
 * Univercity of Colombo School of Computing
 */
public class User {
    private SimpleStringProperty id;
    private SimpleStringProperty username;
    private SimpleStringProperty password;

    public User(String id, String username, String password) {
        this.id = new SimpleStringProperty(id);
        this.username= new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);

    }


    public String getId() {
        return id.get();
    }

    public void setId(SimpleStringProperty id) {
        this.id = id;
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(SimpleStringProperty username) {
        this.username = username;
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(SimpleStringProperty password) {
        this.password = password;
    }
}
