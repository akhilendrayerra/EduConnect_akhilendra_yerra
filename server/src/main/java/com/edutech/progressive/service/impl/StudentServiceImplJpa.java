package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.dto.StudentDTO;
import com.edutech.progressive.entity.Student;
import com.edutech.progressive.service.StudentService;

public class StudentServiceImplJpa implements StudentService {

    @Override
    public List<Student> getAllStudents() throws Exception {
        return new ArrayList<>();
    }

    @Override
    public Integer addStudent(Student student) throws Exception {
        return -1;
    }

    @Override
    public List<Student> getAllStudentSortedByName() throws Exception {
        return new ArrayList<>();
    }

    public void updateStudent(Student student) throws Exception {

    }

    public void deleteStudent(int studentId) throws Exception {
    }

    public Student getStudentById(int studentId) throws Exception {
        return null;
    }

    public void modifyStudentDetails(StudentDTO studentDTO) {
    }
}