package com.example.emp_project.service;

import com.example.emp_project.repository.EmployeeEntity;
import com.example.emp_project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeEntity> readEmployees() {
        List<EmployeeEntity> employeeList =  employeeRepository.findAll();
        return  employeeList;
    }

    @Override
    public String createEmployee(EmployeeEntity employeeEntity) {
        employeeRepository.save(employeeEntity);
        return "saved successfully";

    }
    @Override
    public boolean deleteEmployee(int id) {
      EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
      employeeRepository.delete(employeeEntity);
      return true;
    }

    @Override
    public String updateEmployee(int id, EmployeeEntity employee) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeEntity.setId(employee.getId());
        employeeEntity.setName(employee.getName());
        employeeEntity.setPhone(employee.getPhone());
        employeeEntity.setEmail(employee.getEmail());

        employeeRepository.save(employeeEntity);
        return "employee data updated successfully";
    }
}
