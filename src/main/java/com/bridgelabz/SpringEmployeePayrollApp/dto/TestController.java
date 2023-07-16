package com.bridgelabz.SpringEmployeePayrollApp.dto;

import com.bridgelabz.SpringEmployeePayrollApp.model.Employee;
import com.bridgelabz.SpringEmployeePayrollApp.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    EmployeeRepo employeeRepo;

    @PostMapping("/save")
    public String addEmployee(Employee employee){
    employeeRepo.save(employee);
        return "data is saved ";
    }

}
