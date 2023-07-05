package com.example.riotshop_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;
    @Column(name = "name_product")
    private String nameProduct;
    @Column(name = "password_product")
    private String passwordProduct;
    @Column(name = "price")
    private Long price;
    @Column(name = "image_product")
    private String imageProduct;
    @Column(name = "number_champ")
    private int numberChamp;
    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @ManyToOne
    @JoinColumn(name = "id_rank")
    private Ranking ranking;
    @JsonBackReference
    @OneToMany(mappedBy = "product")
    @OrderBy("idOrderDetail ASC")
    private Set<OrderDetail> oderDetails = new TreeSet<>();
    @OneToMany(mappedBy = "product")
    @OrderBy("id ASC")
    private Set<SkinDetail> skinDetailSet = new TreeSet<>();
    public Product(Integer productId) {
    this.idProduct = productId;
    }

    public Product() {
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
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

    public Set<OrderDetail> getOderDetails() {
        return oderDetails;
    }

    public Set<SkinDetail> getSkinDetailSet() {
        return skinDetailSet;
    }

    public void setSkinDetailSet(Set<SkinDetail> skinDetailSet) {
        this.skinDetailSet = skinDetailSet;
    }

    public void setOderDetails(Set<OrderDetail> oderDetails) {
        this.oderDetails = oderDetails;
    }

    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }

    public String getPasswordProduct() {
        return passwordProduct;
    }

    public void setPasswordProduct(String passwordProduct) {
        this.passwordProduct = passwordProduct;
    }
}
