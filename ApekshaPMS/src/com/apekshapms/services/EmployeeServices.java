package com.apekshapms.services;

import com.apekshapms.main.Session;
import com.apekshapms.model.Employee;

public class EmployeeServices {
    public static void addEmployee(Employee employee){
        //System.out.println("Ok");
        Session.addEmployee(employee);
        System.out.println("Ok");
    }
}
