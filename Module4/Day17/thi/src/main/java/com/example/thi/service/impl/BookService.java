package com.example.thi.service.impl;

import com.example.thi.model.Book;
import com.example.thi.repository.IBookRepository;
import com.example.thi.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository iBookRepository;

    @Override
    public Page<Book> list(String search, Pageable pageable) {
        return iBookRepository.findBookByBookNameContaining(pageable, search);
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public Book findByID(int id) {
        return iBookRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        iBookRepository.deleteById(id);
    }
}
