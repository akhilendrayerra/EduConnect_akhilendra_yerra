package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Student;
import com.edutech.progressive.service.impl.StudentServiceImplArraylist;
import com.edutech.progressive.service.impl.StudentServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImplArraylist studentServiceImplArraylist;

    @Autowired
    private StudentServiceImplJpa studentServiceImplJpa;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        try {
            return new ResponseEntity<>(studentServiceImplJpa.getAllStudents(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable int studentId) {
        try {
            return new ResponseEntity<>(studentServiceImplJpa.getStudentById(studentId),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @PostMapping
    public ResponseEntity<Integer> addStudent(@RequestBody Student student) {
        try {
            return new ResponseEntity<>(studentServiceImplJpa.addStudent(student),HttpStatus.CREATED);
        // } catch (RuntimeException e) {
        
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Void> updateStudent(@PathVariable int studentId,@RequestBody Student student) {
        try {
            student.setStudentId(studentId);
            studentServiceImplJpa.updateStudent(student);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException("");
        }
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int studentId) {
        try {
            studentServiceImplJpa.deleteStudent(studentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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