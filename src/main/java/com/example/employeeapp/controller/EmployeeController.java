package com.example.employeeapp.controller;

import com.example.employeeapp.exception.EmployeeException;
import com.example.employeeapp.model.Employee;
import com.example.employeeapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PostMapping("/addAll")
    public List<Employee> addEmployee(@RequestBody List<Employee> employees) {
        return employeeService.addAllEmployee(employees);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @GetMapping("/get/{id}")
    public Employee getEmployee(@PathVariable String id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/getAll")
    public List<Employee> getAllEmployee(   ) {

        return employeeService.getAllEmployee();
    }

    @DeleteMapping("/softDelete/{id}")
    public String softDeleteEmployee(@PathVariable String id) {
        return employeeService.softDeleteEmployee(id);
    }

    @DeleteMapping("/hardDelete/{id}")
    public String hardDeleteEmployee(@PathVariable String id) {
        return employeeService.hardDeleteEmpoyee(id);
    }

    @GetMapping("/getAll/ageFilter")
    public List<Employee> getAllEmployeeFilteredByAge() {
        return employeeService.getAllEmployeeFilteredByAge();
    }


}
