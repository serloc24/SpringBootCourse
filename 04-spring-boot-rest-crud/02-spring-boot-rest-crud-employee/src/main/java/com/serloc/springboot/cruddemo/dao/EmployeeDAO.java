package com.serloc.springboot.cruddemo.dao;

import com.serloc.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
    Employee findById(int employeeId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
