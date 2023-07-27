package com.bridgelabz.SpringEmployeePayrollApp.controller;

import com.bridgelabz.SpringEmployeePayrollApp.dto.EmployeeDTO;
import com.bridgelabz.SpringEmployeePayrollApp.dto.ResponseDTO;
import com.bridgelabz.SpringEmployeePayrollApp.model.Employee;
import com.bridgelabz.SpringEmployeePayrollApp.repository.EmployeeRepo;
import com.bridgelabz.SpringEmployeePayrollApp.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        try {
            Employee addedEmployee = employeeService.addEmployee(employeeDTO);
            log.info("Data added Successfully");
            ResponseDTO responseDTO = new ResponseDTO("Data Added Successfully", addedEmployee);
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            log.error("Email is already present. Please use a different email address.");
            ResponseDTO responseDTO = new ResponseDTO("Email is already present. Please use a different email address.", null);
            return new ResponseEntity<>(responseDTO, HttpStatus.CONFLICT);
        } catch (Exception e) {
            log.error("An error occurred while processing the request.");
            ResponseDTO responseDTO = new ResponseDTO("An error occurred while processing the request.", null);
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/Getallemployee")
    public ResponseEntity<ResponseDTO> getAllEmployee() {
        log.warn("Retrieving all data");
        ResponseDTO responseDTO = new ResponseDTO(" All Data Retrieve Successfully", employeeService.findAll());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getemployeebyid/{id}")
    public ResponseEntity<ResponseDTO> getEmployeeById(@PathVariable long id) {
        log.warn("Data if retrieveing from id");
        ResponseDTO responseDTO = new ResponseDTO("Data Fetched Successfully", employeeService.getEmployeeById(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @PutMapping("/updateemployee/{id}")
    public ResponseEntity updateEmployee(@PathVariable long id, @RequestBody EmployeeDTO employeeDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Employee Updated ", employeeService.updateEmployee(id, employeeDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    @DeleteMapping("/DeleteById/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable long id) {
        boolean deleted = employeeService.deleteEmployee(id);
        if (deleted) {
            ResponseDTO responseDTO = new ResponseDTO("Data Deleted Successfully", id);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            ResponseDTO responseDTO = new ResponseDTO("Data Not Found", id);
            return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/department/{department}")
            public ResponseEntity<ResponseDTO>getEmployeeByDepartment(@PathVariable String department){
        List<Employee> employeeList = employeeService.getEmployeeByDepartment(department);
        ResponseDTO responseDTO =new ResponseDTO("getting data by department ",employeeList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
}