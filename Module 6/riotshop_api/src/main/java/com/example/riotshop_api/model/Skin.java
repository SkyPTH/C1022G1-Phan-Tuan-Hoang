package com.example.riotshop_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Skin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSkin;
    @Column(name = "name_skin")
    private String nameSkin;
    @Column(name = "image_skin")
    private String imageSkin;
    @ManyToOne
    @JoinColumn(name = "id_product")
    @JsonBackReference
    private Product product;

    public Skin() {
    }
}
