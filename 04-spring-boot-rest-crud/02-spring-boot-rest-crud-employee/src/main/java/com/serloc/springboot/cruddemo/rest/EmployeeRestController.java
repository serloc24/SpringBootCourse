package com.serloc.springboot.cruddemo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.serloc.springboot.cruddemo.dao.EmployeeDAO;
import com.serloc.springboot.cruddemo.entity.Employee;
import com.serloc.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    private ObjectMapper objectMapper;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService, ObjectMapper theObjectMapper){
        objectMapper = theObjectMapper;
        employeeService = theEmployeeService;

    }
    //expose /employees and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeID}")
    public Employee findById(@PathVariable int employeeID){
        Employee theEmployee = employeeService.findById(employeeID);
        if(theEmployee == null){
            throw new RuntimeException("Employee id not found: " + employeeID);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee theEmployee){
        //Set ID to 0 due to force new item
        theEmployee.setId(0);
        return employeeService.save(theEmployee);
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee theEmployee){
        return employeeService.save(theEmployee);
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayload){
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null) throw new RuntimeException("Employee id Not Found " + employeeId);
        if(patchPayload.containsKey("id")) throw new RuntimeException("Id not allowed on Request Body");
        Employee patchedEmployee = apply(patchPayload, theEmployee);
        return employeeService.save(patchedEmployee);
    }

    private Employee apply(Map<String, Object> patchPayload, Employee theEmployee) {
        ObjectNode employeeNode = objectMapper.convertValue(theEmployee, ObjectNode.class);
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        //Merge the patch update
        employeeNode.setAll(patchNode);
        return objectMapper.convertValue(employeeNode, Employee.class);
    }

    @DeleteMapping("/employees/{employeeID}")
    public String deleteById(@PathVariable int employeeID){
        Employee theEmployee = employeeService.findById(employeeID);
        if(theEmployee == null) throw new RuntimeException("Employee id Not Found " + employeeID);
        employeeService.deleteByID(employeeID);
        return "Deleted employee with ID: " + employeeID;
    }

}
