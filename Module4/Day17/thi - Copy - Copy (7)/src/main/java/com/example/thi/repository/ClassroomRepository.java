package com.example.thi.repository;

import com.example.thi.model.Classroom;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends PagingAndSortingRepository<Classroom,Integer> {
}
