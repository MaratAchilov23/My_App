package com.rost.my_app.controllers;

import com.rost.my_app.models.Employee;
import com.rost.my_app.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("new")
    public String index(){
        List<Employee> employeeList= employeeService.findAll();
        for (Employee e:employeeList)
            System.out.println("Работник :"+e.getName()+" "+e.getSurname()+" "+e.getDepartment());
            return "index";
        }
    }

