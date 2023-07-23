package com.bridgelabz.SpringEmployeePayrollApp.dto;

import com.bridgelabz.SpringEmployeePayrollApp.model.Employee;

public class ResponseDTO {
    public String message;
    public Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }

}

