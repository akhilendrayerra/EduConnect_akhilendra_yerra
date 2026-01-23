package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Course;
import com.edutech.progressive.repository.CourseRepository;
import com.edutech.progressive.service.CourseService;

@Service
public class CourseServiceImplJpa implements CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImplJpa(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() throws Exception {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(int courseId) throws Exception {
        return courseRepository.findByCourseId(courseId);
    }

    @Override
    public Integer addCourse(Course course) throws Exception {
        courseRepository.save(course);
        return course.getCourseId();
    }

    @Override
    public void updateCourse(Course course) throws Exception {
        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(int courseId) throws Exception {
        courseRepository.deleteById(courseId);
    }

    public List<Course> getAllCourseByTeacherId(int teacherId) {
        return courseRepository.findAllByTeacherId(teacherId);
    }
}