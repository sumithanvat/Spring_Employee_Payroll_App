package com.bridgelabz.SpringEmployeePayrollApp.service;

import com.bridgelabz.SpringEmployeePayrollApp.dto.EmployeeDTO;
import com.bridgelabz.SpringEmployeePayrollApp.dto.ResponseDTO;
import com.bridgelabz.SpringEmployeePayrollApp.exception.CostomException;
import com.bridgelabz.SpringEmployeePayrollApp.model.Employee;
import com.bridgelabz.SpringEmployeePayrollApp.repository.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee addEmployee(EmployeeDTO employeeDTO) {
        // Check if the email already exists in the database
        String email = employeeDTO.getEmail();
        if (isEmailAlreadyExists(email)) {
            throw new IllegalArgumentException("Email is already present. Please use a different email address.");
        }

        // If the email is not present, create a new Employee object and save it in the database
        Employee employeeData = new Employee(employeeDTO);
        return employeeRepo.save(employeeData);
    }

    // Function to check if the email already exists in the database
    private boolean isEmailAlreadyExists(String email) {
        // Implement your database query here to check if the email exists
        // You can use employeeRepo.findByEmail(email) or any appropriate method based on your database setup
        // Return true if the email exists, false otherwise
        return employeeRepo.existsByEmail(email);
    }


    public Employee getEmployeeById(long id) {
        return employeeRepo.findById(id).orElseThrow(() -> new CostomException("Message With Id:" + id + " Not Present"));
    }

    public Employee updateEmployee(long id, EmployeeDTO employeeDTO) {
        Employee employeeData = getEmployeeById(id);
        if (employeeData != null) {
            employeeData.updateEmployee(employeeDTO);
            return employeeRepo.save(employeeData);
        }
        return null;
    }

    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    public boolean deleteEmployee(long id) {
        // Check if Employee iss present
        if (employeeRepo.existsById(id)) {
            employeeRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Employee> getEmployeeByDepartment(String department){
        return employeeRepo.findEmployeeByDepartment(department);
    }
}