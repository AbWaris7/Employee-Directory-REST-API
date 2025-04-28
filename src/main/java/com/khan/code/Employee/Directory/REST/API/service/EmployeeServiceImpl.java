package com.khan.code.Employee.Directory.REST.API.service;


import com.khan.code.Employee.Directory.REST.API.dao.EmployeeDAO;
import com.khan.code.Employee.Directory.REST.API.entity.Employee;
import com.khan.code.Employee.Directory.REST.API.request.EmployeeRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int empId) {
        return employeeDAO.findById(empId);
    }

    @Transactional
    @Override
    public Employee save(EmployeeRequest employeeRequest) {

        Employee theEmployee = convertToEmployee(0,employeeRequest);
        return employeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public Employee update(long id, EmployeeRequest employeeRequest) {
        Employee theEmployee = convertToEmployee(id,employeeRequest);
        return employeeDAO.save(theEmployee);
    }

    @Override
    public Employee convertToEmployee(long id, EmployeeRequest employeeRequest) {
        return new Employee(id,employeeRequest.getFirstName(), employeeRequest.getLastName(), employeeRequest.getEmail());
    }

    @Transactional
    @Override
    public void deleteById(int empId) {

        employeeDAO.deleteById(empId);
    }
}
