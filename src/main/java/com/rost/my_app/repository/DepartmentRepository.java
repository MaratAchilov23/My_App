package com.rost.my_app.repository;

import com.rost.my_app.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    List<Department>findById();
    List<Department>findByTitle();
    List<Department>findByManager();

    List<Department>findByEmployeeList();

    List<Department>findByLocation();


}
