package edu.comp4382.inventorymanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class InvalidArgumentException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> getErrors(MethodArgumentNotValidException ex) {

        Map<String,String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });

        return errorMap;

    }
}
