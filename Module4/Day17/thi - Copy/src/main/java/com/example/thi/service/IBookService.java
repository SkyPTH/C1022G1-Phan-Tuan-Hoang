package com.example.thi.service;

import com.example.thi.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> list(Pageable pageable, String search);
    void save(Book book);
    void detete(int id);
    Book findByID(int id);
}
