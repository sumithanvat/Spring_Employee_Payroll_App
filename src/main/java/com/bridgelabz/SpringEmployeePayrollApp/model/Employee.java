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
@NoArgsConstructor
@Entity
@Table(name = "Employee_Table")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fName;
    private String lName;
    private String email;
    private String phone;
    private String address;
    private double salary;
    private String gender;
    private String profilePic;
    private LocalDate startDate;
    @ElementCollection
    @CollectionTable(name = "Department_Table",joinColumns = @JoinColumn (name = "employee_id"))
    @Column(name = "Department")
    private List<String> department;
    private String note;
    public Employee (EmployeeDTO employeeDTO){
        this.updateEmployee(employeeDTO);
    }

    public void updateEmployee(EmployeeDTO employeeDTO) {
        this.fName = employeeDTO.getFName();
        this.lName = employeeDTO.getLName();
        this.email = employeeDTO.getEmail();
        this.phone = employeeDTO.getPhone();
        this.address = employeeDTO.getAddress();
        this.salary = employeeDTO.getSalary();
        this.gender = employeeDTO.getGender();
        this.profilePic = employeeDTO.getProfilePic();
        this.startDate = employeeDTO.getStartDate();
        this.department = employeeDTO.getDepartment();
        this.note = employeeDTO.getNote();
    }
}