package com.example.riotshop_api.dto;

import com.example.riotshop_api.model.Ranking;

import javax.persistence.Column;

public class ProductDTO {
    private Integer idProduct;

    private String nameProduct;

    private String passwordProduct;

    private Long price;

    private String imageProduct;

    private int numberChamp;

    private Ranking ranking;

    public ProductDTO() {
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getPasswordProduct() {
        return passwordProduct;
    }

    public void setPasswordProduct(String passwordProduct) {
        this.passwordProduct = passwordProduct;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }

    public int getNumberChamp() {
        return numberChamp;
    }

    public void setNumberChamp(int numberChamp) {
        this.numberChamp = numberChamp;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }
}
