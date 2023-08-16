package com.example.employeeapp.exception;

public class EmployeeException extends Exception {

    String code;
    String message;

    public EmployeeException(String message){
          System.out.println(message+"Error");
    }



}
