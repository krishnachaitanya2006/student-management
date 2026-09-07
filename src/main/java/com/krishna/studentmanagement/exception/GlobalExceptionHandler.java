package com.krishna.studentmanagement.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//for validation error handling
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.validation.FieldError;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//for full json error message
import com.krishna.studentmanagement.dto.ErrorResponse;

//validation error handling
import com.krishna.studentmanagement.dto.ValidationError;


import jakarta.servlet.http.HttpServletRequest;



@ControllerAdvice
public class GlobalExceptionHandler 
{
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStudentNotFound(StudentNotFoundException ex,  HttpServletRequest request)
    {

        ErrorResponse error = new ErrorResponse(
            404,
            ex.getMessage(),
            request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> handleValidationException(MethodArgumentNotValidException ex, HttpServletRequest request)
    {
        System.out.println("Validation handler called");
    
        Map<String,String> errors = new HashMap<>();

        for(FieldError error : ex.getBindingResult().getFieldErrors())
        {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        ValidationError error = new ValidationError(400,errors,request.getRequestURI());

        return ResponseEntity.badRequest().body(error);
    }



    
}
