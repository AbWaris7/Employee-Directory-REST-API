package com.khan.code.Employee.Directory.REST.API.controller;

import com.khan.code.Employee.Directory.REST.API.entity.Employee;
import com.khan.code.Employee.Directory.REST.API.request.EmployeeRequest;
import com.khan.code.Employee.Directory.REST.API.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee Rest API Endpoints", description = "Operations related to employee. ")
public class EmployeeRestController {

    EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary = "Get All employee", description = "Retrieve a list of all employee")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    List<Employee> getEmployees() {

        return employeeService.findAll();
    }


    @Operation(summary = "Get Single Employee By Id", description = "Retrieve employee by Id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{empId}")
    public Employee getEmployee(@PathVariable @Min(value = 1) int empId) {

        Employee employee = employeeService.findById(empId);

        return employee;

    }

    @Operation(summary = "create a new employee", description = "Add a new employee")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Employee addEmployee(@Valid @RequestBody EmployeeRequest theEmployee) {
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @Operation(summary = "update an Employee", description = "update the current employee")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable @Min(value = 1) int employeeId, @Valid @RequestBody EmployeeRequest employeeRequest) {
        Employee dbEmployee = employeeService.update(employeeId, employeeRequest);


        return dbEmployee;
    }


    @Operation(summary = "Delete an Employee", description = "Delete the current employee")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable @Min(value = 1) int employeeId) {
        employeeService.deleteById(employeeId);
    }

}
