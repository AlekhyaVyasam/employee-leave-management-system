package com.alekhya.employeeservice.service;

import com.alekhya.employeeservice.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);
}
