package com.example.thi.controller;

import com.example.thi.model.Classroom;
import com.example.thi.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/classroom")
public class ClassroomController {
    @Autowired private IClassroomService iClassroomService;
    @GetMapping("")
    List<Classroom> classroomList(){
        return iClassroomService.findAll();
    }
}
