package com.khan.code.Employee.Directory.REST.API.dao;

import com.khan.code.Employee.Directory.REST.API.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
