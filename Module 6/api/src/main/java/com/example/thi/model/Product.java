package com.example.thi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "code")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "name")
    private String name;
    @Column(name = "quantity")
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "id_shop")
    @JsonBackReference
    private Shop shop;
    @ManyToOne
    @JoinColumn(name ="id_employee" )
    @JsonBackReference
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "id_customer")
    @JsonBackReference
    private Customer customer;

    public Product(Integer id, String name, Integer quantity, Shop shop, Employee employee, Customer customer) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.shop = shop;
        this.employee = employee;
        this.customer = customer;
    }

    public Product() {
    }

    public Product(String name, Integer quantity, Shop shop, Employee employee, Customer customer) {
        this.name = name;
        this.quantity = quantity;
        this.shop = shop;
        this.employee = employee;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
