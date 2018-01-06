package com.apekshapms.main;

import com.apekshapms.database.connector.*;
import com.apekshapms.model.Employee;
import com.apekshapms.model.SystemMessage;

public class Session {
    public static PatientConnector patientConnector = new PatientConnector();
    public static LabReportConnector labReportConnector = new LabReportConnector();
    public static WardConnector wardConnector = new WardConnector();
    //public static EmployeeConnector employeeConnector = new EmployeeConnector();
     public static EmployeeConnector employeeConnector;
    public static MessageConnector messageConnector;

    public static StatisticalConnector statisticalConnector = new StatisticalConnector();


      public static void addEmployee(Employee employee){
            EmployeeConnector ec = new EmployeeConnector();
                    ec.newEmployee(employee);
        }

    public static void addAdmin(Employee employee){
        EmployeeConnector ec = new EmployeeConnector();
        ec.newAdmin(employee);
    }
    public static void addSystem(Employee employee){
        EmployeeConnector ec = new EmployeeConnector();
        ec.newSystemEmployee(employee);
    }

    public static void addConsultant(Employee employee){
        EmployeeConnector ec = new EmployeeConnector();
        ec.newConsultant(employee);
    }
    public static void addLabAssistant(Employee employee){
        EmployeeConnector ec = new EmployeeConnector();
        ec.newLabAssistant(employee);
    }

    public static void addRegisterDoctor(Employee employee){
        EmployeeConnector ec = new EmployeeConnector();
        ec.newRegisterDoctor(employee);
    }

    public static void addNonSystemEmployee(Employee employee){
        EmployeeConnector ec = new EmployeeConnector();
        ec.newNonSystemEmployee(employee);
    }

}
