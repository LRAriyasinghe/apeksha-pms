package com.apekshapms.services;

import com.apekshapms.main.Session;
import com.apekshapms.model.LabReport;
import com.apekshapms.model.LabReport2;

/**
 * Created by Thilina on 10/13/2017.
 * Univercity of Colombo School of Computing
 */
public class LabReportServices {
    public static void addLabReport(LabReport labReport){
        Session.labReportConnector.newLabReport(labReport);
    }
    public static void addLabReportUrine(LabReport labReport){Session.labReportConnector.newLabReportUrine(labReport);}
}
