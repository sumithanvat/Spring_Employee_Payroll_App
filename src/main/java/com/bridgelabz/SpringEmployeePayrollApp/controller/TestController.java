package com.bridgelabz.SpringEmployeePayrollApp.controller;

import com.bridgelabz.SpringEmployeePayrollApp.model.Employee;
import com.bridgelabz.SpringEmployeePayrollApp.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    EmployeeRepo employeeRepo;

    @RequestMapping("/employee")
    @PostMapping("/save")
    public String addEmployee(Employee employee){
        employeeRepo.save(employee);
        return "data is saved ";
    }

}
