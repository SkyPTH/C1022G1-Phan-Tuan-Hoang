package com.example.thi.service;

import com.example.thi.model.Classroom;
import com.example.thi.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService implements IClassroomService{
    @Autowired
    private ClassroomRepository classroomRepository;
    @Override
    public List<Classroom> findAll() {
        return (List<Classroom>) classroomRepository.findAll();
    }
    @Override
    public Classroom findById(int id) {
        return classroomRepository.findById(id).get();
    }
}
