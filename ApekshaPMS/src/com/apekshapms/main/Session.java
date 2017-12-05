package com.apekshapms.main;

import com.apekshapms.database.connector.BoneMarrowConnector;
import com.apekshapms.database.connector.LabReportConnector;
import com.apekshapms.database.connector.PatientConnector;
import com.apekshapms.database.connector.WardConnector;

public class Session {
    public static PatientConnector patientConnector;
    public static LabReportConnector labReportConnector;
    public static WardConnector wardConnector;
    //public static BoneMarrowConnector boneMarrowConnector;
}
