package com.rost.my_app.repository;

import com.rost.my_app.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Integer> {
    List<Manager>findById();
    List<Manager>findByName();
    List<Manager>findBySurname();
    List<Manager> findByDepartment();
}
