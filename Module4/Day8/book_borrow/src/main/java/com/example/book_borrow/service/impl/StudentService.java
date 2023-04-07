package com.example.book_borrow.service.impl;

import com.example.book_borrow.model.Student;
import com.example.book_borrow.repository.IStudentRepository;
import com.example.book_borrow.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {
    @Autowired
    IStudentRepository iStudentRepository;
    @Override
    public Student findByID(int id) {
        return iStudentRepository.findById(id).get();
    }
}
