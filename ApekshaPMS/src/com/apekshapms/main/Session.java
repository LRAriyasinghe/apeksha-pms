package com.apekshapms.main;

import com.apekshapms.database.connector.BoneMarrowConnector;
import com.apekshapms.database.connector.EmployeeConnector;
import com.apekshapms.database.connector.LabReportConnector;
import com.apekshapms.database.connector.PatientConnector;
import com.apekshapms.database.connector.WardConnector;
import com.apekshapms.model.Employee;
import com.apekshapms.model.Patient;

public class Session {

    public static PatientConnector patientConnector;
    public static LabReportConnector labReportConnector;
    public static EmployeeConnector employeeConnector;
    public static WardConnector wardConnector;
    //public static BoneMarrowConnector boneMarrowConnector;
        public static void addEmployee(Employee employee){
            EmployeeConnector ec = new EmployeeConnector();
                    ec.newEmployee(employee);
        }






}
