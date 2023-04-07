package com.example.book_borrow.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
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
    private String bookName;
    @Column(name = "amount")
    @NotNull
    @Min(0)
    private Integer amount;

    public Book(int bookID, String bookName, Integer amount) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.amount = amount;
    }

    public Book() {
    }

    public Book(String bookName, Integer amount) {
        this.bookName = bookName;
        this.amount = amount;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
