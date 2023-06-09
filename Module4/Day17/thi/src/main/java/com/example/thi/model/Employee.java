package com.example.thi.model;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmployee;
    @Column(name = "name_employee")
    private String nameEmployee;
    @Column(name = "gender")
    private String gender;

    public Employee(Integer idEmployee, String nameEmployee, String gender) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.gender = gender;
    }

    public Employee() {
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
