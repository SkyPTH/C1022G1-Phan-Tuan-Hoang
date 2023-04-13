package com.example.thi.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookID;
    @Column(name = "book_name")
    @NotBlank
    @Range(max = 50)
    private String bookName;
    @ManyToOne
    @NotNull
    @JoinColumn(name = "type_id")
    private BookType bookType;

    public Book(int bookID, String bookName, BookType bookType) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookType = bookType;
    }

    public Book() {
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }
}
