package com.khan.code.Employee.Directory.REST.API.dao;

import com.khan.code.Employee.Directory.REST.API.entity.Employee;

import java.util.List;

public interface EmployeeDAO {


    List<Employee> findAll();
}
