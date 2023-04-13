package com.example.thi.service.impl;

import com.example.thi.model.BookType;
import com.example.thi.repository.ITypeBookRepository;
import com.example.thi.service.ITypeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeBookService implements ITypeBookService {
    @Autowired
    private ITypeBookRepository iTypeBookRepository;
    @Override
    public List<BookType> list() {
        return (List<BookType>) iTypeBookRepository.findAll();
    }
}
