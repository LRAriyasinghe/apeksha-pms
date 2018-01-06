package com.apekshapms.services;

import com.apekshapms.main.Session;
import com.apekshapms.model.Employee;

public class EmployeeServices {
    public static void addEmployee(Employee employee){
        //System.out.println("Ok");
        Session.addEmployee(employee);
        System.out.println("Ok");
    }

    public static void addNewAdmin(Employee employee){
        //System.out.println("Ok");
        Session.addAdmin(employee);
        System.out.println("Ok");
    }
    public static void addNewSystemEmployee(Employee employee){
        //System.out.println("Ok");
        Session.addSystem(employee);
        System.out.println("Ok");
    }
    public static void addNewConsultant(Employee employee){
        //System.out.println("Ok");
        Session.addConsultant(employee);
        System.out.println("Ok");
    }
    public static void addNewLabAssistant(Employee employee){
        //System.out.println("Ok");
        Session.addLabAssistant(employee);
        System.out.println("Ok");
    }

    public static void addNewRegisterDoctor(Employee employee){
        //System.out.println("Ok");
        Session.addRegisterDoctor(employee);
        System.out.println("Ok");
    }
    public static void addNewNonSystemEmployeee(Employee employee){
        //System.out.println("Ok");
        Session.addNonSystemEmployee(employee);
        System.out.println("Ok");
    }
}
