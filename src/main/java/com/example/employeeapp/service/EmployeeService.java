package com.example.employeeapp.service;

import com.example.employeeapp.exception.EmployeeException;
import com.example.employeeapp.model.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee addEmployee(Employee employee);

    public List<Employee> addAllEmployee(List<Employee> employees);

    public Employee updateEmployee(Employee employee);

    public Employee getEmployee(String id);

    public List<Employee> getAllEmployee();

    public String softDeleteEmployee(String id);

    public String hardDeleteEmpoyee(String id);

    public String deleteAll() throws EmployeeException;

    public List<Employee> getAllEmployeeFilteredByAge();
}
