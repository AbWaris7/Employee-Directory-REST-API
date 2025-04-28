package com.khan.code.Employee.Directory.REST.API.service;

import com.khan.code.Employee.Directory.REST.API.entity.Employee;
import com.khan.code.Employee.Directory.REST.API.request.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int empId);
    Employee save(EmployeeRequest employee);
    Employee update(long id, EmployeeRequest employeeRequest);
    Employee convertToEmployee (long id, EmployeeRequest employeeRequest);
    void deleteById(int empId);
}
