package com.example.book_borrow.service;

import com.example.book_borrow.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> list(Pageable pageable,String search);
    Book findByID(int id);
}
