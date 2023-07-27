package com.bridgelabz.SpringEmployeePayrollApp.exception;

public class CostomException extends RuntimeException {
    public CostomException(String employee){
        super(employee);
    }
}
