package com.example.book_borrow.service;

import com.example.book_borrow.model.Borrow;

import java.util.List;

public interface IBorrowService {
     void save(Borrow borrow);
    List<Borrow> list(
    );
    Borrow findBorrow(int studentID, int bookID);
}
