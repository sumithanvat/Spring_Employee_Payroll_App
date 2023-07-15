package com.bridgelabz.SpringEmployeePayrollApp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Employee_Data")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fName;
    private String lName;
    private int salary;

    public Employee(String fName, String lName, int salary) {
        this.fName = fName;
        this.lName = lName;
        this.salary = salary;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
