package com.alekhya.employeeservice.service;

import com.alekhya.employeeservice.entity.Employee;
import com.alekhya.employeeservice.exception.DuplicateEmailException;
import com.alekhya.employeeservice.exception.EmployeeNotFoundException;
import com.alekhya.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        if (employeeRepository.existsByEmail(employee.getEmail())) {

            throw new DuplicateEmailException(
                    "Email already exists : " + employee.getEmail());
        }

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee not found with id " + id));
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {

        Employee existingEmployee = getEmployeeById(id);

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());

        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {

        Employee employee = getEmployeeById(id);

        employeeRepository.delete(employee);
    }
}