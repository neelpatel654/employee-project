package com.example.emp_project.service;

import com.example.emp_project.repository.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    List<EmployeeEntity> readEmployees();
    String createEmployee(EmployeeEntity employeeEntity);
    boolean deleteEmployee(int id);
    String updateEmployee(int id, EmployeeEntity employee);
}
