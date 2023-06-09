package com.example.thi.model;

import javax.persistence.*;

@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idShop;
    @Column(name = "name_shop")
    private String nameShop;
    @Column(name = "address")
    private String address;

    public Shop(Integer idShop, String nameShop, String address) {
        this.idShop = idShop;
        this.nameShop = nameShop;
        this.address = address;
    }

    public Shop() {
    }

    public Integer getIdShop() {
        return idShop;
    }

    public void setIdShop(Integer idShop) {
        this.idShop = idShop;
    }

    public String getNameShop() {
        return nameShop;
    }

    public void setNameShop(String nameShop) {
        this.nameShop = nameShop;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
