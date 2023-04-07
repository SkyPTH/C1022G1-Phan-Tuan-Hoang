package com.example.book_borrow.service;

import com.example.book_borrow.model.Student;

public interface IStudentService {
    Student findByID(int id);
}
