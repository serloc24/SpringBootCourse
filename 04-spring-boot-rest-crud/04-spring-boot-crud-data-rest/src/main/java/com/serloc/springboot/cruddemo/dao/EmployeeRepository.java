package com.serloc.springboot.cruddemo.dao;

import com.serloc.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//Exposes the /members not the plural of the Entity
//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //We don't need to add code here, we can use CRUD methods anyways
}
