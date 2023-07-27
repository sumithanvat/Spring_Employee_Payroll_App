package com.bridgelabz.SpringEmployeePayrollApp.repository;

import com.bridgelabz.SpringEmployeePayrollApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    @Query(value = "select * from Employee_Table,Department_Table where employee_id=id and department=department",nativeQuery = true)
       List<Employee> findEmployeeByDepartment(String department);

    boolean existsByEmail(String email);
}
