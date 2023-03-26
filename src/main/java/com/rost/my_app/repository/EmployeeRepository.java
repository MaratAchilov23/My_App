package com.rost.my_app.repository;

import com.rost.my_app.models.Department;
import com.rost.my_app.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
    List<Employee> getAll();

    List<Employee>findEmployeeByDepartment(Department department);

    List<Employee>findEmployeeBySalary();

    List<Employee>findEmployeeByUsername();

    List<Employee>findByEmail();

    List<Employee>findByNameOrderById();

    List<Employee>findBySurname();

    List<Employee>findBySalaryBetween();


}
