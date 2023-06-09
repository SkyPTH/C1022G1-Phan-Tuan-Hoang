package com.example.thi.service;

import com.example.thi.model.Classroom;

import java.util.List;

public interface IClassroomService {
    List<Classroom> findAll();
    Classroom findById(int id);
}
