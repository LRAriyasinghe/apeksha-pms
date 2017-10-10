package com.apekshapms.ui;

public enum UIName {
    DASHBOARD("/com/apekshapms/ui/view/Dashboard.fxml"),
    REGISTER_DOCTOR_DASHBOARD("/com/apekshapms/ui/view/main/RegisterDoctorDashboard.fxml"),
    CONSULTANT_DASHBOARD("/com/apekshapms/ui/view/main/ConsultantDashboard.fxml"),
    LAB_ASSISTANT_DASHBOARD("/com/apekshapms/ui/view/main/LabAssistantDashboard.fxml"),
    ADMIN_DASHBOARD("/com/apekshapms/ui/view/main/AdminDashboard.fxml"),


    //Admin Dashborad
    PATIENT_DASHBOARD("/com/apekshapms/ui/view/admin/PatientDashboard.fxml"),
    EMPLOYEE_DASHBOARD("/com/apekshapms/ui/view/admin/EmployeeDashboard.fxml"),
    REPORT_DASHBOARD("/com/apekshapms/ui/view/admin/ReportDashboard.fxml"),
    WARD_DASHBOARD("/com/apekshapms/ui/view/admin/WardDashboard.fxml"),
    TREATMENT_DASHBOARD("/com/apekshapms/ui/view/admin/TreatmentDashboard.fxml"),

    NEW_PATIENT("/com/apekshapms/ui/view/NewPatient.fxml"),
    PATIENT_HISTORY("/com/apekshapms/ui/view/PatientHistory.fxml"),
    ASSIGNING("/com/apekshapms/ui/view/Assigning.fxml"),
    SOME_LOGIN("/com/apekshapms/ui/view/SomeLogin.fxml"),
    LOGIN("/com/apekshapms/ui/view/login.fxml"),

    SEARCH_PATIENT("/com/apekshapms/ui/view/SearchPatient.fxml");

    private final String location;

    UIName(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
