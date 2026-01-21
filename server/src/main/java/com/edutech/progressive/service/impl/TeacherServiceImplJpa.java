package com.edutech.progressive.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Teacher;
import com.edutech.progressive.repository.TeacherRepository;
import com.edutech.progressive.service.TeacherService;

@Service
public class TeacherServiceImplJpa implements TeacherService {

    private TeacherRepository teacherRepository;
    
    @Autowired
    public TeacherServiceImplJpa(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> getAllTeachers() throws Exception {
        return teacherRepository.findAll();
    }

    public TeacherServiceImplJpa() {
    }

    @Override
    public Integer addTeacher(Teacher teacher) throws Exception {
        return teacherRepository.save(teacher).getTeacherId();
    }

    @Override
    public List<Teacher> getTeacherSortedByExperience() throws Exception {
        List<Teacher> teachers = teacherRepository.findAll();
        Collections.sort(teachers);
        return teachers;
    }

    public void updateTeacher(Teacher teacher) throws Exception{
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(int teacherId) throws Exception{
        teacherRepository.deleteById(teacherId);
    }

    public Teacher getTeacherById(int teacherId) throws Exception{
        return teacherRepository.findByTeacherId(teacherId);
    }

}