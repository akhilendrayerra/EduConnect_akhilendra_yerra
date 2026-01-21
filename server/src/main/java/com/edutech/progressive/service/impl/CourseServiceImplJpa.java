package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.entity.Course;
import com.edutech.progressive.service.CourseService;

public class CourseServiceImplJpa implements CourseService {

    @Override
    public List<Course> getAllCourses() throws Exception {
        return new ArrayList<>();
    }

    @Override
    public Course getCourseById(int courseId) throws Exception {
        return null;
    }

    @Override
    public Integer addCourse(Course course) throws Exception {
        return -1;
    }

    @Override
    public void updateCourse(Course course) throws Exception {
        
    }

    @Override
    public void deleteCourse(int courseId) throws Exception {

    }

    public List<Course> getAllCourseByTeacherId(int teacherId){
        return null;
    }
}