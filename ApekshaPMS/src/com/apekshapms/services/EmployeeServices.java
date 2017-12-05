package com.apekshapms.services;

import com.apekshapms.main.Session;
import com.apekshapms.model.Employee;
import com.apekshapms.model.Patient;

public class EmployeeServices {
    public static void addEmployee(Employee employee){
        Session.employeeConnector.newEmployee(employee);
    }
}
