package com.example.emp_project.controller;

import com.example.emp_project.repository.EmployeeEntity;
import com.example.emp_project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping("employees")
    public List<EmployeeEntity> getAllEmployees(){

        return employeeService.readEmployees();
    }

    @PostMapping("employees")
    public String createEmployee(@RequestBody EmployeeEntity employee){
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        if(employeeService.deleteEmployee(id)){
            return "employee deleted";
        }
        return "employee not found";
    }

    @PutMapping("employees/{id}")
    public String updateEmployee(@PathVariable int id,@RequestBody EmployeeEntity employee){
        return employeeService.updateEmployee(id,employee);
    }

}
