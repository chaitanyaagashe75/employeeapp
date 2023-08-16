package com.example.employeeapp.comparator;

import com.example.employeeapp.model.Employee;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee employee1, Employee employee2) {
        return Integer.compare(employee1.getAge(), employee2.getAge());
    }
}
