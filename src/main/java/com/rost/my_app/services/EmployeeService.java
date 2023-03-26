package com.rost.my_app.services;

import com.rost.my_app.models.Department;
import com.rost.my_app.models.Employee;
import com.rost.my_app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll(){
        List<Employee>employees =employeeRepository.findAll();
        return employees;
    }

    public List<Employee>findEmployeeByDepartment(Department department){
        List<Employee>employees= employeeRepository.findEmployeeByDepartment(department);
        return employees;
    }

    public List<Employee>findByDepartment(Department department){
        List<Employee>employees=employeeRepository.findEmployeeByDepartment(department);
        return employees;
    }

    public Optional<Employee> showEmpById(int id){
       Optional<Employee>emp = employeeRepository.findById(id);
       if(emp.isEmpty())
           throw new UsernameNotFoundException("Такого работника нет");
       return emp;
    }
    @Transactional
    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }


    }

