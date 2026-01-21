package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.dto.StudentDTO;
import com.edutech.progressive.entity.Student;
import com.edutech.progressive.repository.StudentRepository;
import com.edutech.progressive.service.StudentService;

@Service
public class StudentServiceImplJpa implements StudentService {

    private StudentRepository studentRepository;
    
    @Autowired
    public StudentServiceImplJpa(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() throws Exception {
        return studentRepository.findAll();
    }

    @Override
    public Integer addStudent(Student student) throws Exception {
        return studentRepository.save(student).getStudentId();
    }

    @Override
    public List<Student> getAllStudentSortedByName() throws Exception {
        List<Student> students = studentRepository.findAll();
        Collections.sort(students);
        return students;
    }

    public void updateStudent(Student student) throws Exception {
        studentRepository.save(student);
    }

    public void deleteStudent(int studentId) throws Exception {
        studentRepository.deleteById(studentId);
    }

    public Student getStudentById(int studentId) throws Exception {
        return studentRepository.findByStudentId(studentId);
    }

    public void modifyStudentDetails(StudentDTO studentDTO) throws Exception{
    }
}