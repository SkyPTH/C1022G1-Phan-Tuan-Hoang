package com.example.thi.service;

import com.example.thi.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> list (String search, Pageable pageable);
    void save(Book book);
    Book findByID(int id);
    void delete(int id);
}
