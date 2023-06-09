package com.example.thi.service;

import com.example.thi.model.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStudentService {
    List<Student> findByName(Pageable pageable,String search);
    Student findById(int id);
    void save(Student student);
    void delete(int id);
}
