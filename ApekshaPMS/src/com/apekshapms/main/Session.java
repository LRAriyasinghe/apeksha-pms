package com.apekshapms.main;

import com.apekshapms.database.connector.BoneMarrowConnector;
import com.apekshapms.database.connector.EmployeeConnector;
import com.apekshapms.database.connector.LabReportConnector;
import com.apekshapms.database.connector.PatientConnector;
import com.apekshapms.database.connector.WardConnector;

public class Session {
    public static PatientConnector patientConnector = new PatientConnector();
    public static LabReportConnector labReportConnector = new LabReportConnector();
    public static WardConnector wardConnector = new WardConnector();
    public static EmployeeConnector employeeConnector = new EmployeeConnector();
}
