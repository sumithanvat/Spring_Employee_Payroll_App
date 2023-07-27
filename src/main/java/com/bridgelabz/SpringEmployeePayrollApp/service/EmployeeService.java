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
        Employee employeeData = new Employee(employeeDTO);
        return employeeRepo.save(employeeData);
    }

    public Employee getEmployeeById(long id) {
        return employeeRepo.findById(id).orElseThrow(() -> new CostomException("Message With Id:" + id + " Not Present"));
    }

    public Employee updateEmployee(long id, EmployeeDTO employeeDTO) {
        Employee employeeData = getEmployeeById(id);
        if (employeeData != null) {
            Employee saveEmployee =new Employee(employeeDTO);
            saveEmployee.setId(id);
            //employeeData.updateEmployee(employeeDTO);
            return employeeRepo.save(saveEmployee);
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