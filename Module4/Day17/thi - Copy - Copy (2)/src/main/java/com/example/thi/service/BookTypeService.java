package com.example.thi.service;

import com.example.thi.model.BookType;
import com.example.thi.repository.IBookTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTypeService implements IBookTypeService {
    @Autowired
    IBookTypeRepository iBookTypeRepository;
    @Override
    public List<BookType> list() {
        return (List<BookType>) iBookTypeRepository.findAll();
    }
}
