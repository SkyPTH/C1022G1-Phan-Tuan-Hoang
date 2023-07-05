package com.example.riotshop_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class Skin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSkin;
    @Column(name = "name_skin")
    private String nameSkin;
    @Column(name = "image_skin")
    private String imageSkin;
   @OneToMany(mappedBy = "skin")
   @JsonBackReference
   private Set<SkinDetail> skinDetailSet=new TreeSet<>();

    public Skin() {
    }

    public Integer getIdSkin() {
        return idSkin;
    }

    public void setIdSkin(Integer idSkin) {
        this.idSkin = idSkin;
    }

    public String getNameSkin() {
        return nameSkin;
    }

    public void setNameSkin(String nameSkin) {
        this.nameSkin = nameSkin;
    }

    public String getImageSkin() {
        return imageSkin;
    }

    public void setImageSkin(String imageSkin) {
        this.imageSkin = imageSkin;
    }

    public Set<SkinDetail> getSkinDetailSet() {
        return skinDetailSet;
    }

    public void setSkinDetailSet(Set<SkinDetail> skinDetailSet) {
        this.skinDetailSet = skinDetailSet;
    }
}
