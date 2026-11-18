package com.alekhya.employeeservice.controller;

import com.alekhya.employeeservice.entity.Employee;
import com.alekhya.employeeservice.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public Employee createEmployee(
            @Valid @RequestBody Employee employee) {

        return employeeService.createEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {

        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(
            @PathVariable Long id) {

        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable Long id,
            @Valid  @RequestBody Employee employee) {

        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(
            @PathVariable Long id) {

        employeeService.deleteEmployee(id);
    }
}