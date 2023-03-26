package com.rost.my_app.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    @NotNull(message = "Название Департамента не может быть пустым")
    private String title;
    @Column(name = "location")
    @NotNull(message = "Адрес Департаментва не может быть пустым")
    private String location;
    @OneToOne(mappedBy = "department",
             cascade = CascadeType.ALL)
    private Manager manager;
    @OneToMany(mappedBy = "department",
               cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    public Department() {
    }

    public Department(String title, String location) {
        this.title = title;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    public void addEmployee(Employee employee){
        if(this.employeeList==null){
            this.employeeList=new ArrayList<>();
            this.employeeList.add(employee);
            employee.setDepartment(this);
        }
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
