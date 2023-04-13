package com.example.thi.service;

import com.example.thi.model.Book;
import com.example.thi.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Page<Book> list(Pageable pageable, String search) {
        return iBookRepository.findBookByNameContaining(pageable, search);
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public void detete(int id) {
        iBookRepository.deleteById(id);
    }

    @Override
    public Book findByID(int id) {
        return iBookRepository.findById(id).get();
    }
}
