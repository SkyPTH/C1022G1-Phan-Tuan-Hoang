package com.example.thi.model;

import javax.persistence.*;

@Entity
public class BookType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeId;
    @Column(name = "type_name")
    private String typeName;

    public BookType(int typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public BookType() {
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
