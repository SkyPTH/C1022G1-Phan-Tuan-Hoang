package com.example.riotshop_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class SkinDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(columnDefinition = "id_skin")
    private Skin skin;
    @ManyToOne
    @JoinColumn(columnDefinition = "id_product")
    @JsonBackReference
    private Product product;

    public SkinDetail() {
    }

    public SkinDetail(Integer id, Skin skin, Product product) {
        this.id = id;
        this.skin = skin;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Skin getSkin() {
        return skin;
    }

    public void setSkin(Skin skin) {
        this.skin = skin;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
