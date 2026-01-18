package com.edutech.progressive.service.impl;

import java.util.ArrayList;

import java.util.Collections;

import java.util.List;

import com.edutech.progressive.entity.Student;

import com.edutech.progressive.service.StudentService;

public class StudentServiceImplArraylist implements StudentService {

    private static List<Student> studentList = new ArrayList<>();

    @Override

    public List<Student> getAllStudents() {

        return studentList;

    }

    @Override

    public Integer addStudent(Student student) {

        studentList.add(student);

        return studentList.size();

    }

    @Override

    public List<Student> getAllStudentSortedByName() {

        Collections.sort(studentList);

        return studentList;

    }

    public void emptyArrayList() {

        studentList.clear();

    }

}