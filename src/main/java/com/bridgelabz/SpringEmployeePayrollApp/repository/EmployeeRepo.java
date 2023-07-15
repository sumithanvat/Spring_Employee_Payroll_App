package com.bridgelabz.SpringEmployeePayrollApp.repository;

import com.bridgelabz.SpringEmployeePayrollApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
