package com.khan.code.Employee.Directory.REST.API.dao;

import com.khan.code.Employee.Directory.REST.API.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    /*
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int empId) {
        Employee theEmployee = entityManager.find(Employee.class, empId);
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee theEmployee = entityManager.merge(employee);
        return theEmployee;
    }

    @Override
    public void deleteById(int empId) {
        Employee theEmployee = entityManager.find(Employee.class, empId);
        entityManager.remove(theEmployee);

    }

     */
}
