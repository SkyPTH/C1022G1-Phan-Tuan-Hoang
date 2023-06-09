package com.example.thi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCustomer;
    @Column(name = "name_customer")
    private String nameCustomer;
    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private Set<Product> productSet;

    public Customer(Integer idCustomer, String nameCustomer, Set<Product> productSet) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.productSet = productSet;
    }

    public Customer() {
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }
}
