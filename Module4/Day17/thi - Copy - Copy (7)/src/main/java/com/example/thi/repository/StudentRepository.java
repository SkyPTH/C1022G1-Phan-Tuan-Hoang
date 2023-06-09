package com.example.thi.repository;

import com.example.thi.model.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student,Integer> {
    List<Student> findAllByStudentNameContaining(Pageable pageable,String search);
}
