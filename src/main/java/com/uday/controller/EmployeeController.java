package com.uday.controller;

import com.uday.model.Employee;
import com.uday.service.EmployeeService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/post")
    public String post(@RequestBody final Employee emp) {

        employeeService.persist(emp);

        return "employee data saved..!";
    }
    @GetMapping("/getAll")
    public List<Employee> getEmployees() {

        return employeeService.getEmployees();
    }
}
