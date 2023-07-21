package com.bridgelabz.SpringEmployeePayrollApp.model;

import com.bridgelabz.SpringEmployeePayrollApp.dto.EmployeeDTO;
import com.bridgelabz.SpringEmployeePayrollApp.model.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@Entity
@Table(name = "Employee_Table")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fName;
    private String lName;
    private String email;
    private int phone;
    private String address;
    private double salary;
    private String gender;
    private String profilePic;
    private LocalDate startDate;
    private List<String> department;
    private String note;

    public Employee(int id , EmployeeDTO employeeDTO) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.salary = salary;
        this.gender = gender;
        this.profilePic = profilePic;
        this.startDate = startDate;
        this.department = department;
        this.note = note;
    }
}
