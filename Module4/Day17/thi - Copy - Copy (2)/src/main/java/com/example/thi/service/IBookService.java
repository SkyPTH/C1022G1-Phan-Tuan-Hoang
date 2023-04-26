package com.example.thi.service;

import com.example.thi.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> list (Pageable pageable,String search);
    Book findById(int id);
    void save(Book book);
    void delete(int id);
}
