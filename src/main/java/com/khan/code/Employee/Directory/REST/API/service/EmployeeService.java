package com.khan.code.Employee.Directory.REST.API.service;

import com.khan.code.Employee.Directory.REST.API.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
