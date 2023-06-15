package com.example.thi.dto;

import com.example.thi.model.Employee;
import com.example.thi.model.Shop;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductDTO implements Validator {
    private Integer id;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String name;
    private Integer quantity;
    private ShopDTO shopDTO;
    private CustomerDTO customerDTO;
    private EmployeeDTO employeeDTO;

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public ProductDTO() {
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

    public ShopDTO getShopDTO() {
        return shopDTO;
    }

    public void setShopDTO(ShopDTO shopDTO) {
        this.shopDTO = shopDTO;
    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
