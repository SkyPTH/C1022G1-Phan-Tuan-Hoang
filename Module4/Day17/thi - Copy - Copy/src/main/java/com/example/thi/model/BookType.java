package com.example.thi.model;

import javax.persistence.*;

@Entity
public class BookType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idType;
    @Column(name = "type_name")
    private String typeName;

    public BookType(Integer idType, String typeName) {
        this.idType = idType;
        this.typeName = typeName;
    }

    public BookType() {
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
