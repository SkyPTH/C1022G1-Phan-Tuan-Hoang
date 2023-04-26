package com.example.thi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "book_name")
    @NotBlank
    private String bookName;
    @Column(name = "page_size")
    @NotNull
    private int pageSize;
    @NotBlank
    @Column(name = "book_description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private BookType bookType;

    public Book(int id, String bookName, int pageSize, String description, BookType bookType) {
        this.id = id;
        this.bookName = bookName;
        this.pageSize = pageSize;
        this.description = description;
        this.bookType = bookType;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }
}
