package com.khan.code.Employee.Directory.REST.API.service;


import com.khan.code.Employee.Directory.REST.API.dao.EmployeeDAO;
import com.khan.code.Employee.Directory.REST.API.dao.EmployeeRepository;
import com.khan.code.Employee.Directory.REST.API.entity.Employee;
import com.khan.code.Employee.Directory.REST.API.request.EmployeeRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(long empId) {

        Optional<Employee> result = employeeRepository.findById(empId);
        Employee employee = null;

        if(result.isPresent()) {
            employee = result.get();
        } else {
            throw new RuntimeException("Did not find employee with id: " + empId);
        }
        return employee;
    }

    @Transactional
    @Override
    public Employee save(EmployeeRequest employeeRequest) {

        Employee theEmployee = convertToEmployee(0,employeeRequest);
        return employeeRepository.save(theEmployee);
    }

    @Transactional
    @Override
    public Employee update(long id, EmployeeRequest employeeRequest) {
        Employee theEmployee = convertToEmployee(id,employeeRequest);
        return employeeRepository.save(theEmployee);
    }

    @Override
    public Employee convertToEmployee(long id, EmployeeRequest employeeRequest) {
        return new Employee(id,employeeRequest.getFirstName(), employeeRequest.getLastName(), employeeRequest.getEmail());
    }

    @Transactional
    @Override
    public void deleteById(long empId) {

        employeeRepository.deleteById(empId);
    }


}
