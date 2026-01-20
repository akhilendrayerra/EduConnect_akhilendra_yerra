package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Student;
import com.edutech.progressive.service.impl.StudentServiceImplArraylist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImplArraylist studentServiceImplArraylist;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return null;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(int studentId) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Integer> addStudent(Student student) {
        return null;
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Void> updateStudent(int studentId, Student student) {
        return null;
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(int studentId) {
        return null;
    }

    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Student>> getAllStudentFromArrayList() {
        return new ResponseEntity<>(studentServiceImplArraylist.getAllStudents(),HttpStatus.OK); 
    }

    @PostMapping("/toArrayList")
    public ResponseEntity<Integer> addStudentToArrayList(Student student) {
        return new ResponseEntity<>(studentServiceImplArraylist.addStudent(student),HttpStatus.CREATED); 
    }

    @GetMapping("/fromArrayList/sorted")
    public ResponseEntity<List<Student>> getAllStudentSortedByNameFromArrayList() {
        return new ResponseEntity<>(studentServiceImplArraylist.getAllStudentSortedByName(),HttpStatus.OK);
    }
}