package com.example.validateuser.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    @NotBlank(message = "Tên không được để trống")
    private String firstName;
    @Column(name = "last_name")
    @NotBlank(message = "Tên không được để trống")
    private String lastName;
    @Column(name = "email")
    @Pattern(message = "Cú pháp không hợp lệ,",regexp = ("^[a-zA-Z0-9]{3,50}@[a-zA-Z.]{3,50}$"))
    private String eMail;
    @Column(name = "age")
    @Min(value = 18,message = "Tuổi phải trên 18")
    @Max(value = 100,message = "Tuổi phải dưới 100")
    private Integer age;

    public User(int id, String firstName, String lastName, String eMail, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.age = age;
    }

    public User(String firstName, String lastName, String eMail, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.age = age;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
