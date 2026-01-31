package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Course;
import com.edutech.progressive.exception.CourseAlreadyExistsException;
import com.edutech.progressive.exception.CourseNotFoundException;
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
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Course with ID " + courseId + " not found for deletion"));
    }

    @Override
    public Integer addCourse(Course course) throws Exception {
        Optional<Course> existingCourse = courseRepository.findById(course.getCourseId());
        if (existingCourse.isPresent()) {
            throw new CourseAlreadyExistsException("Course with this name already exists, Course Name: " + course.getCourseName());
        }
        return courseRepository.save(course).getCourseId();
    }

    @Override
    public void updateCourse(Course course) throws Exception {
        Course existingCourse = courseRepository.findByCourseName(course.getCourseName());
        if (existingCourse != null && existingCourse.getCourseId() != course.getCourseId()) {
            throw new CourseAlreadyExistsException("Course with this name already exists, Course Name: " + course.getCourseName());
        }
        courseRepository.save(course);
    }

    @Override
    public void deleteCourse(int courseId) throws Exception {
        if (!courseRepository.existsById(courseId)) {
            throw new CourseNotFoundException("Course with ID " + courseId + " not found for deletion");
        }
        courseRepository.deleteById(courseId);
    }

    public List<Course> getAllCourseByTeacherId(int teacherId) {
        return courseRepository.findAllByTeacherId(teacherId);
    }
}