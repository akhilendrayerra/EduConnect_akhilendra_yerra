package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.dao.TeacherDAO;
import com.edutech.progressive.entity.Teacher;
import com.edutech.progressive.service.TeacherService;

public class TeacherServiceImplJdbc implements TeacherService {

    private TeacherDAO teacherDAO;

    public TeacherServiceImplJdbc(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    public List<Teacher> getAllTeachers() throws Exception {
        try {
            return teacherDAO.getAllTeachers();
        } catch (SQLException e) {
            throw new Exception("",e);
        }
    }

    @Override
    public Integer addTeacher(Teacher teacher) throws Exception {
        try {
            return teacherDAO.addTeacher(teacher);
        } catch (SQLException e) {
            throw new Exception("",e);
        }
    }

    @Override
    public List<Teacher> getTeacherSortedByExperience() throws Exception {
        try {
            List<Teacher> teachers = teacherDAO.getAllTeachers();
            Collections.sort(teachers);
            return teachers;
        } catch (SQLException e) {
            throw new Exception("",e);
        }
    }

    public void updateTeacher(Teacher teacher) throws Exception {
        try {
            teacherDAO.updateTeacher(teacher);
        } catch (SQLException e) {
            throw new Exception("",e);
        }

    }

    public void deleteTeacher(int teacherId) throws Exception {
        try {
            teacherDAO.deleteTeacher(teacherId);
        } catch (SQLException e) {
            throw new Exception("",e);
        }
    }

    public Teacher getTeacherById(int teacherId) throws Exception {
        try {
            return teacherDAO.getTeacherById(teacherId);
        } catch (SQLException e) {
            throw new Exception("",e);
        }
    }
}