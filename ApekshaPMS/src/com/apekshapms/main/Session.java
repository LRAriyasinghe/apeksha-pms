package com.apekshapms.main;

import com.apekshapms.database.connector.*;
import com.apekshapms.model.SystemMessage;

public class Session {
    public static PatientConnector patientConnector = new PatientConnector();
    public static LabReportConnector labReportConnector = new LabReportConnector();
    public static WardConnector wardConnector = new WardConnector();
    public static EmployeeConnector employeeConnector = new EmployeeConnector();
    public static MessageConnector messageConnector;
}
