package com.example.employeeapp.repository;

import com.example.employeeapp.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    public Employee findByIdAndIsActive(String id, Boolean isActive);
    public List<Employee> findByIsActive(Boolean isActive);
}
