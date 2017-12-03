package com.apekshapms.services;

import com.apekshapms.main.Session;
import com.apekshapms.model.*;

/**
 * Created by Thilina on 10/13/2017.
 * Univercity of Colombo School of Computing
 */
public class LabReportServices {
    public static void addBoneMarrowReport(BonemarrowReport bonemarrowreport) {

        Session.labReportConnector.newBoneMarrowReport(bonemarrowreport);
    }
    public static void addCreactiveProteinReport(CreactiveproteinReport creactiveproteinReport) {

        Session.labReportConnector.newCreactiveProteinReport(creactiveproteinReport);
    }
    public static void addFullBloodReport(FullBloodReport fullBloodReport) {

        Session.labReportConnector.newFullBloodReport(fullBloodReport);
    }
    public static void addLipidProfileReport(LipidProfileReport lipidProfileReport) {

        Session.labReportConnector.newLipidProfileReport(lipidProfileReport);
    }
}

