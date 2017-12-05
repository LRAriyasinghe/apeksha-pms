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
    EXAMPLE("/com/apekshapms/ui/view/admin/Example.fxml"),
    ADD_NEW_EMPLOYEE("/com/apekshapms/ui/view/admin/AddNewEmployee.fxml"),

    ADMIN_SEARCH_EMPLOYEE("/com/apekshapms/ui/view/admin/AdminSearchEmployee.fxml"),


    //Report
    LAB_OVERVIEW("/com/apekshapms/ui/view/LabOverview.fxml"),
    BONEMARROW_REPORT("/com/apekshapms/ui/view/labReport/BoneMarrowReport.fxml"),
    CREACTIVEPROTEIN_REPORT("/com/apekshapms/ui/view/labReport/CreactiveProtein.fxml"),
    FULLBLOODCOUNT_REPORT("/com/apekshapms/ui/view/labReport/FullBloodCount.fxml"),
    LIPIDPROFILE_REPORT("/com/apekshapms/ui/view/labReport/LipidProfile.fxml"),
    LIVERFUNCTION_REPORT("/com/apekshapms/ui/view/labReport/LiverFunction.fxml"),
    SERUMCALCIUM_REPORT("/com/apekshapms/ui/view/labReport/SerumCalcium.fxml"),
    SERUM_ELECTROLYTES_REPORT("/com/apekshapms/ui/view/labReport/SerumElectrolytes.fxml"),
    SERUM_PROTEIN_REPORT("/com/apekshapms/ui/view/labReport/SerumProteinElectrophoresis.fxml"),
    THYROID_REPORT("/com/apekshapms/ui/view/labReport/ThyroidProfile.fxml"),



    //Analysis Reports
    STATISTICAL_ANALYSIS_GRAPHICAL("/com/apekshapms/ui/view/reportAnalysis/StatisticalAnalysisGraphical.fxml"),
    STATISTICAL_ANALYSIS_GRAPHICAL_MALE_FEMALE_DISTRICT("/com/apekshapms/ui/view/reportAnalysis/StatisticalMaleFemaleDistrict.fxml"),
    STATISTICAL_ANALYSIS_GRAPHICAL_CANCERTYPE_COUNT("/com/apekshapms/ui/view/reportAnalysis/StatisticalAnalysisCancerTypeCount.fxml"),
    STATISTICAL_ANALYSIS_GRAPHICAL_PIE_CHART("/com/apekshapms/ui/view/reportAnalysis/PieChartExample.fxml"),

    //Lab Assistant
    ADD_REPORT("/com/apekshapms/ui/view/labAssistant/AddReport.fxml"),
    ADD_DETAILS("/com/apekshapms/ui/view/labAssistant/AddDetails.fxml"),
    CHECK_REPORT("/com/apekshapms/ui/view/labAssistant/CheckReport.fxml"),

    //Ward
    NEW_WARD("/com/apekshapms/ui/view/ward/NewWard.fxml"),
    WARD_MANAGEMENT("/com/apekshapms/ui/view/ward/WardManagement.fxml"),

    NEW_PATIENT("/com/apekshapms/ui/view/NewPatient.fxml"),
    PATIENT_HISTORY("/com/apekshapms/ui/view/PatientHistory.fxml"),
    ASSIGNING("/com/apekshapms/ui/view/Assigning.fxml"),
    SOME_LOGIN("/com/apekshapms/ui/view/SomeLogin.fxml"),
    LOGIN("/com/apekshapms/ui/view/login.fxml"),

    SEARCH_PATIENT("/com/apekshapms/ui/view/SearchPatient.fxml"),

    //Side Bar
    REGISTOR_DOCTOR_SIDEBAR("/com/apekshapms/ui/view/sidebar/RegisterDoctorSideBar.fxml"),
    LAB_ASSISTANT_SIDEBAR("/com/apekshapms/ui/view/sidebar/LabAssistantSideBar.fxml"),
    CONSULTANT_DOCTOR_SIDEBAR("/com/apekshapms/ui/view/sidebar/ConsultantDoctorSideBar.fxml"),
    ADMIN_SIDEBAR("/com/apekshapms/ui/view/sidebar/AdminSideBar.fxml");



    private final String location;

    UIName(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
