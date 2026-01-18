package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Teacher;

public class TeacherDAOImpl implements TeacherDAO {


    @Override
    public int addTeacher(Teacher teacher) throws SQLException{
        Connection connection = DatabaseConnectionManager.getConnection();
        String query = "INSERT INTO teacher (full_name,subject,contact_number,email,years_of_experience) VALUES (?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, teacher.getFullName());
        ps.setString(2, teacher.getSubject());
        ps.setString(3,teacher.getContactNumber());
        ps.setString(4,teacher.getEmail());
        ps.setInt(5,teacher.getYearsOfExperience());
        ps.executeUpdate();
        ResultSet gk = ps.getGeneratedKeys();
        if(gk.next()){
            teacher.setTeacherId(gk.getInt(1));
            return teacher.getTeacherId();
        }
        return -1;    }

    @Override
    public Teacher getTeacherById(int teacherId) throws SQLException{
        Connection connection = DatabaseConnectionManager.getConnection();
        String query = "SELECT * FROM teacher WHERE teacher_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, teacherId);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            return new Teacher(rs.getInt("teacher_id"), rs.getString("full_name"), rs.getString("subject"), rs.getString("contact_number"),rs.getString("email"),rs.getInt("years_of_experience"));
        }
        return null;
    }

    @Override
    public void updateTeacher(Teacher teacher) throws SQLException{
        Connection connection = DatabaseConnectionManager.getConnection();
        String query = "UPDATE teacher SET full_name = ?,subject = ?,contact_number = ?,email = ?,years_of_experience = ? WHERE teacher_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, teacher.getFullName());
        ps.setString(2, teacher.getSubject());
        ps.setString(3,teacher.getContactNumber());
        ps.setString(4,teacher.getEmail());
        ps.setInt(5,teacher.getYearsOfExperience());
        ps.setInt(6,teacher.getTeacherId());
        ps.executeUpdate();
    }

    @Override
    public void deleteTeacher(int teacherId) throws SQLException{
        Connection connection = DatabaseConnectionManager.getConnection();
        String query = "DELETE FROM teacher WHERE teacher_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1,teacherId);
        ps.executeUpdate();
    }

    @Override
    public List<Teacher> getAllTeachers() throws SQLException{
        Connection connection = DatabaseConnectionManager.getConnection();
        List<Teacher> teachers = new ArrayList<>();
        String query = "SELECT * FROM teacher";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            teachers.add(new Teacher(rs.getInt("teacher_id"), rs.getString("full_name"), rs.getString("subject"), rs.getString("contact_number"),rs.getString("email"),rs.getInt("years_of_experience")));
        }
        return teachers;
    }
}