package com.apekshapms.main;

import com.apekshapms.controller.DashboardController;
import com.apekshapms.controller.EditPatientController;

public class Global {

    static DashboardController dashboardController;

    static EditPatientController editPatientController;

    public static DashboardController getdashboardController(){

        return dashboardController;
    }
    public static void setdashboardController(DashboardController dashboardController ){

        Global.dashboardController=dashboardController;
    }

}
