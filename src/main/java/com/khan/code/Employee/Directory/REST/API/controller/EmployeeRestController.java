package com.khan.code.Employee.Directory.REST.API.controller;

import com.khan.code.Employee.Directory.REST.API.dao.EmployeeDAO;
import com.khan.code.Employee.Directory.REST.API.entity.Employee;
import com.khan.code.Employee.Directory.REST.API.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    List<Employee> getEmployees() {

        return employeeService.findAll();
    }
}
