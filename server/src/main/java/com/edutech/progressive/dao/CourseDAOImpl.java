package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Course;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public int addCourse(Course course) throws SQLException {
        Connection connection = DatabaseConnectionManager.getConnection();
        String query = "INSERT INTO course (course_name,description,teacher_id) VALUES (?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, course.getCourseName());
        ps.setString(2, course.getDescription());
        ps.setInt(3,course.getTeacher().getTeacherId());
        ps.executeUpdate();
        ResultSet gk = ps.getGeneratedKeys();
        if(gk.next()){
            course.setCourseId(gk.getInt(1));
            return course.getCourseId();
        }
        return -1;
    }

    @Override
    public Course getCourseById(int courseId) throws SQLException {
        Connection connection = DatabaseConnectionManager.getConnection();
        String query = "SELECT * FROM course WHERE course_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, courseId);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            return new Course(rs.getInt("course_id"), rs.getString("course_name"), rs.getString("description"), rs.getInt("teacher_id"));
        }
        return null;
    }

    @Override
    public void updateCourse(Course course) throws SQLException{
        Connection connection = DatabaseConnectionManager.getConnection();
        String query = "UPDATE course SET course_name = ?,description = ?,teacher_id = ? WHERE course_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, course.getCourseName());
        ps.setString(2, course.getDescription());
        ps.setInt(3,course.getTeacher().getTeacherId());
        ps.setInt(4,course.getCourseId());
        ps.executeUpdate();
    }

    @Override
    public void deleteCourse(int courseId) throws SQLException{
        Connection connection = DatabaseConnectionManager.getConnection();
        String query = "DELETE FROM course WHERE course_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1,courseId);
        ps.executeUpdate();
    }

    @Override
    public List<Course> getAllCourses() throws SQLException{
        Connection connection = DatabaseConnectionManager.getConnection();
        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM course";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            courses.add(new Course(rs.getInt("course_id"), rs.getString("course_name"), rs.getString("description"), rs.getInt("teacher_id")));
        }
        return courses;
    }

}
