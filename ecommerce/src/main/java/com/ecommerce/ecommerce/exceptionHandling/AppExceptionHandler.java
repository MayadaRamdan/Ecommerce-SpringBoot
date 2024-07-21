package com.ecommerce.ecommerce.exceptionHandling;


import com.ecommerce.ecommerce.exceptions.CategoryNotFoundException;
import com.ecommerce.ecommerce.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler({CategoryNotFoundException.class , ProductNotFoundException.class})
    public ResponseEntity<ErrorResponse> handelRunTimeException( CategoryNotFoundException ex){

        ErrorResponse  er=new ErrorResponse(ex.getMsg());
        return new ResponseEntity<>(er , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handelNPException( NullPointerException ex){

        ErrorResponse  er=new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(er , HttpStatus.NOT_FOUND);
    }



}
