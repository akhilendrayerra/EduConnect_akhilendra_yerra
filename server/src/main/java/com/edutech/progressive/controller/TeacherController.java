package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Teacher;
import com.edutech.progressive.service.impl.TeacherServiceImplJpa;

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

import java.util.Collections;
import java.util.List;
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherServiceImplJpa teacherServiceImplJpa;

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        try {
            return new ResponseEntity<>(teacherServiceImplJpa.getAllTeachers(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable int teacherId) {
        try {
            return new ResponseEntity<>(teacherServiceImplJpa.getTeacherById(teacherId),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Integer> addTeacher(@RequestBody Teacher teacher) {
        try {
            return new ResponseEntity<>(teacherServiceImplJpa.addTeacher(teacher),HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{teacherId}")
    public ResponseEntity<Void> updateTeacher(@PathVariable int teacherId,@RequestBody Teacher teacher) {
        try {
            teacherServiceImplJpa.updateTeacher(teacher);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable int teacherId) {
        try {
            teacherServiceImplJpa.deleteTeacher(teacherId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/yearsofexperience")
    public ResponseEntity<List<Teacher>> getTeacherSortedByYearsOfExperience() {
        try {
            List<Teacher> teachers = teacherServiceImplJpa.getAllTeachers();
            Collections.sort(teachers);
            return new ResponseEntity<>(teachers,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
}