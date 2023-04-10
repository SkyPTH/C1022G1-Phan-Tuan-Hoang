package com.example.thi.model;

import javax.persistence.*;

@Entity
@Table(name = "book_type")
public class BookType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeID;
    @Column(name = "type_name")
    private String typeName;

    public BookType(int typeID, String typeName) {
        this.typeID = typeID;
        this.typeName = typeName;
    }

    public BookType() {

    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
