package com.example.thi.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private String studentName;
    @DateTimeFormat(fallbackPatterns = "dd-mm-yyyy")
    private String birthDay;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "class_id")
    private Classroom classroom;

    public Student(Integer studentId, String studentName, String birthDay, Classroom classroom) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.birthDay = birthDay;
        this.classroom = classroom;
    }

    public Student(String studentName, String birthDay, Classroom classroom) {
        this.studentName = studentName;
        this.birthDay = birthDay;
        this.classroom = classroom;
    }

    public Student() {
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
