package com.example.thi.controller;

import com.example.thi.model.Classroom;
import com.example.thi.model.Student;
import com.example.thi.service.IClassroomService;
import com.example.thi.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<Student> studentList(@PageableDefault(sort = {"studentId"}, size = 3, direction = Sort.Direction.DESC) Pageable pageable,
                                     @RequestParam(defaultValue = "") String search) {

        return iStudentService.findByName(pageable, search);
    }

@ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public ResponseEntity<?> createStudent(@RequestBody Student student, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        iStudentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
