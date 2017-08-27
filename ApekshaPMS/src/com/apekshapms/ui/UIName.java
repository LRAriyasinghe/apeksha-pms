package com.apekshapms.ui;

public enum UIName {
    DASHBOARD("/com/apekshapms/ui/view/Dashboard.fxml"),

    NEW_PATIENT("/com/apekshapms/ui/view/NewPatient.fxml"),
    PATIENT_HISTORY("/com/apekshapms/ui/view/PatientHistory.fxml"),
    ASSIGNING("/com/apekshapms/ui/view/Assigning.fxml"),
    SOME_LOGIN("/com/apekshapms/ui/view/SomeLogin.fxml"),

    SEARCH_PATIENT("/com/apekshapms/ui/view/SearchPatient.fxml");

    private final String location;

    UIName(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
