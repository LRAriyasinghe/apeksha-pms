package com.apekshapms.services;

import com.apekshapms.main.Session;
import com.apekshapms.model.*;

/**
 * Created by Thilina on 10/13/2017.
 * Univercity of Colombo School of Computing
 */
public class LabReportServices {
    public static void addBoneMarrowReport(BonemarrowReport bonemarrowreport) {
        System.out.println("Correct 1");
        Session.labReportConnector.newBoneMarrowReport(bonemarrowreport);
        System.out.println("Correct 3");
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
    public static void addLiverFunctionReport(LiverFunctionReport liverFunctionReport) {

        Session.labReportConnector.newLiverFunctionReport(liverFunctionReport);
    }
    public static void addSerumCalciumReport(SerumCalcuimReport serumCalcuimReport) {

        Session.labReportConnector.newSerumCalciumReport(serumCalcuimReport);
    }
    public static void addSerumElectrolytesReport(SerumElectrolytesReport serumElectrolytesReport) {

        Session.labReportConnector.newSerumElectrolytesReport(serumElectrolytesReport);
    }
    public static void addSerumProteinReport(SerumProteinReport serumProteinReport) {

        Session.labReportConnector.newSerumProteinReport(serumProteinReport);
    }
}

