package com.example.riotshop_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;
    @Column(name = "name_product")
    private String nameProduct;
    @Column(name = "price")
    private Long price;
    @Column(name = "number_champ")
    private int numberChamp;
    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private Set<Skin> skin;
    @ManyToOne
    @JoinColumn(name = "id_rank")
    private Ranking ranking;

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

    public Set<Skin> getSkin() {
        return skin;
    }

    public void setSkin(Set<Skin> skin) {
        this.skin = skin;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }
}
