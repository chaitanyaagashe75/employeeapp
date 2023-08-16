package com.example.employeeapp.service.impl;

import com.example.employeeapp.comparator.EmployeeComparator;
import com.example.employeeapp.exception.EmployeeException;
import com.example.employeeapp.model.Employee;
import com.example.employeeapp.repository.EmployeeRepository;
import com.example.employeeapp.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee addEmployee(Employee employee) {
        employee.setIsActive(true);
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> addAllEmployee(List<Employee> employees) {
        List<Employee> savedEmployees = new ArrayList<>();
        Iterator<Employee> itrEmployees = employees.iterator();
        while (itrEmployees.hasNext()) {
            Employee employee = itrEmployees.next();
            employee.setIsActive(true);
            savedEmployees.add(employeeRepository.save(employee));
        }
        return savedEmployees;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        if(employee.getId() != null) {
            Optional<Employee> optEmployee = employeeRepository.findById(employee.getId());
            if(optEmployee.isPresent()) {
                Employee employee1 = optEmployee.get();
                employee1.setName(employee.getName());
                employee1.setCity(employee.getCity());
                employee1.setSalary(employee.getSalary());
                return employeeRepository.save(employee1);
            }
        } else {
            log.info("employee id not available");
        }
        return null;
    }

    @Override
    public Employee getEmployee(String id) {
        Employee employee = employeeRepository.findByIdAndIsActive(id, true);
        log.info("employee: {}", employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findByIsActive(true);
    }

    @Override
    public String softDeleteEmployee(String id) {
        try {
            Optional<Employee> optEmployee = employeeRepository.findById(id);
            if(optEmployee.isPresent()) {
                Employee employee = optEmployee.get();
                employee.setIsActive(false);
                employeeRepository.save(employee);
                return "Deleted successfully";
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error occured while deleting record");
        }
        return "Error occured while deleting record";
    }

    @Override
    public String hardDeleteEmpoyee(String id) {
        try {
            employeeRepository.deleteById(id);
            return "Deleted successfully";
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error occured while deleting record");
        }
        return "Error occured while deleting record";
    }

    @Override
    public String deleteAll() throws EmployeeException {
        try{
            String s = null;
            s.length();
            employeeRepository.deleteAll();
            return "all record deleted";
        } catch (Exception e) {
            e.printStackTrace();
            throw new EmployeeException("ERROR"+e.getMessage());
        }
    }

    @Override
    public List<Employee> getAllEmployeeFilteredByAge() {
        List<Employee> allEmployees = employeeRepository.findAll();
//        List<Employee> filteredEmployees = allEmployees.stream().filter(e -> e.getAge() > 30).collect(Collectors.toList());
        Collections.sort(allEmployees, new EmployeeComparator());
        return allEmployees;
    }
}
