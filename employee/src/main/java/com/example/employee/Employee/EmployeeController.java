package com.example.employee.Employee;

import com.example.employee.Exceptions.DuplicateUserException;
import com.example.employee.Exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRespository employeeRespository;
    private EmployeeEntity employeeEntity;

    @PostMapping("/create-employee")
    public String createEmployee(
            @RequestBody EmployeeEntity employeeEntity
    ){
        try {
            employeeRespository.save(employeeEntity);
            return "User created";
        }
        catch (Exception e){
            throw new DuplicateUserException("Duplicate record found for "+employeeEntity.getName());
        }
    }

    @GetMapping("employee/{name}")
    public EmployeeEntity employeeId(
           @PathVariable String name
    ){
        employeeEntity = employeeRespository.findByName(name);
        try{
            employeeEntity.getName();
            return employeeEntity;
        }
        catch (Exception e){
            throw new EmployeeNotFoundException(name+" not found");
        }
    }
}
