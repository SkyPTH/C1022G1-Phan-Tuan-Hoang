package com.example.thi.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "book_name")
    @NotBlank(message = "Không để trống")
    private String bookName;
    @NotBlank(message = "Không để trống")
    @Column(name = "book_description")
    private String description;
    @NotNull(message = "Không để trống")
    @Column(name = "page_size")
    private Integer pageSize;
    @ManyToOne
    @JoinColumn(name = "id_type")
    private BookType bookType;

    public Book(Integer id, String bookName, String description, Integer pageSize, BookType bookType) {
        this.id = id;
        this.bookName = bookName;
        this.description = description;
        this.pageSize = pageSize;
        this.bookType = bookType;
    }

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }
}
