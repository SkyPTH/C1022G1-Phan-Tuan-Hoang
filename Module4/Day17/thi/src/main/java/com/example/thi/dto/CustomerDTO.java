package com.example.thi.dto;

import com.example.thi.model.Product;

import java.util.Set;

public class CustomerDTO {
    private Integer idCustomer;
    private String nameCustomer;
    private Set<ProductDTO> productSet;

    public CustomerDTO() {
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

    public Set<ProductDTO> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<ProductDTO> productSet) {
        this.productSet = productSet;
    }
}
