package com.example.thi.model;

import javax.persistence.*;

@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeId;
    @Column(name = "type_name")
    private String typeName;

    public Type(int typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public Type() {
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
