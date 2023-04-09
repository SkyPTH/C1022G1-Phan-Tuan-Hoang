package com.example.book_borrow.service.impl;

import com.example.book_borrow.model.Book;
import com.example.book_borrow.repository.IBookRepository;
import com.example.book_borrow.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository iBookRepository;

    @Override
    public Page<Book> list(Pageable pageable, String search) {
        return iBookRepository.findBookByBookNameContaining(pageable, search);
    }

    @Override
    public Book findByID(int id) {
        return iBookRepository.findById(id).get();
    }

    @Override
    public void borrow(Book book) {
        book.setAmount(book.getAmount() - 1);
        iBookRepository.save(book);
    }

    @Override
    public void returnBook(Book book) {
        book.setAmount(book.getAmount() + 1);
        iBookRepository.save(book);
    }
}
