package com.bridgelabz.SpringEmployeePayrollApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@ToString
public class EmployeeDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$",message ="Employee not valid")
    public String fName;
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$",message ="Employee not valid")
    public String lName;
    public String email;
    @Pattern(regexp ="^[+]{1}[0-9]{2}[6-9]{1}[0-9]{9}$",message = "invalid mobile number")
    public String phone;
    public String address;
    @Min(value = 500,message = "minimum value is 500")
    public double salary;
    @Pattern(regexp ="male|female",message = "Not Valid")
    public String gender;
    @NotBlank
    public String profilePic;
    @JsonFormat(pattern = "dd MMM yyyy")
    public LocalDate startDate;

    public List<String> department;
    @NotBlank
    public String note;

}
