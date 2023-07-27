package com.bridgelabz.SpringEmployeePayrollApp.exception;

import com.bridgelabz.SpringEmployeePayrollApp.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;
@ControllerAdvice
public class ExceptionHandelerEX {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream().map(objError -> objError.getDefaultMessage()).collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO("Exception while performing REST API", errMsg.toString());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CostomException.class)
    public ResponseEntity<ResponseDTO> handleCustomException(CostomException exception){
        ResponseDTO responseDTO = new ResponseDTO("Exception while performing api ",exception.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}

