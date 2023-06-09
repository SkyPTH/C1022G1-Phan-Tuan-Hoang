package com.example.thi.model;

import javax.persistence.*;

@Entity
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classId;

    private String className;

    public Classroom(Integer classId, String className) {
        this.classId = classId;
        this.className = className;
    }

    public Classroom(String className) {
        this.className = className;
    }

    public Classroom() {
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
