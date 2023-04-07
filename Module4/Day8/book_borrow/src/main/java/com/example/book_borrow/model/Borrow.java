package com.example.book_borrow.model;

import javax.persistence.*;

@Entity
@Table(name = "borrow")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @Column(name = "borrow_day")
    private String borrowDay;
    @Column(name = "return_day")
    private String returnDay;

    public Borrow(int id, Book book, Student student, String borrowDay, String returnDay) {
        this.id = id;
        this.book = book;
        this.student = student;
        this.borrowDay = borrowDay;
        this.returnDay = returnDay;
    }

    public Borrow() {
    }

    public Borrow(Book book, Student student, String borrowDay) {
        this.book = book;
        this.student = student;
        this.borrowDay = borrowDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getBorrowDay() {
        return borrowDay;
    }

    public void setBorrowDay(String borrowDay) {
        this.borrowDay = borrowDay;
    }

    public String getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(String returnDay) {
        this.returnDay = returnDay;
    }
}
