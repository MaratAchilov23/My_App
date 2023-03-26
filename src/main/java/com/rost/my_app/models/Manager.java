package com.rost.my_app.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @NotEmpty(message = "Имя не может быть пустым")
    @Size(min = 2, max = 23, message = "Имя должно быть от 2х до 23х символов")
    private String name;

    @Column(name = "surname")
    @NotEmpty(message = "Фамилия не может быть пустой")
    @Size(min = 2, max = 23, message = "Фамилия  должна быть от 2х до 23х символов")
    private String surname;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id")
    private Department department;

    public Manager() {
    }

    public Manager(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
