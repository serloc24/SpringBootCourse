package com.serloc.springboot.cruddemo.service;

import com.serloc.springboot.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int thId);
    Employee save(Employee theEmployee);
    void deleteByID(int theId);
}
