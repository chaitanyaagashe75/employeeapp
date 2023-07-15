package com.example.employeeapp.exception;

public class EmployeeException extends Exception {

    String code;
    String message;

    public EmployeeException(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
