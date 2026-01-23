package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Course;
import com.edutech.progressive.service.impl.CourseServiceImplJpa;

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
@RequestMapping("/course")
public class CourseController {

    private CourseServiceImplJpa courseServiceImplJpa;

    @Autowired
    public CourseController(CourseServiceImplJpa courseServiceImplJpa) {
        this.courseServiceImplJpa = courseServiceImplJpa;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        try {
            return new ResponseEntity<List<Course>>(courseServiceImplJpa.getAllCourses(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable int courseId) {
        try {
            return new ResponseEntity<Course>(courseServiceImplJpa.getCourseById(courseId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Integer> addCourse(@RequestBody Course course) {
        try {
            return new ResponseEntity<Integer>(courseServiceImplJpa.addCourse(course), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Void> updateCourse(@PathVariable int courseId, @RequestBody Course course) {
        try {
            courseServiceImplJpa.updateCourse(course);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable int courseId) {
        try {
            courseServiceImplJpa.deleteCourse(courseId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<Course>> getAllCourseByTeacherId(@PathVariable int teacherId) {
        try {
            List<Course> courses = courseServiceImplJpa.getAllCourseByTeacherId(teacherId);
            return new ResponseEntity<>(courses,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
