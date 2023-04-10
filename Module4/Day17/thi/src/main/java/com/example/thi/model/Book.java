package com.example.thi.model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookID;
    @Column(name = "book_name")
    private String bookName;
    @ManyToOne
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
