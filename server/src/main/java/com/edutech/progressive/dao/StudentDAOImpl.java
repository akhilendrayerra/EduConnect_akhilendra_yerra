package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Student;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public int addStudent(Student student) throws SQLException{
        Connection connection = DatabaseConnectionManager.getConnection();
        String query = "INSERT INTO student (full_name,date_of_birth,contact_number,email,address) VALUES (?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, student.getFullName());
        ps.setDate(2, new java.sql.Date(student.getDateOfBirth().getTime()));
        ps.setString(3,student.getContactNumber());
        ps.setString(4,student.getEmail());
        ps.setString(5,student.getAddress());
        ps.executeUpdate();
        ResultSet gk = ps.getGeneratedKeys();
        if(gk.next()){
            student.setStudentId(gk.getInt(1));
            return student.getStudentId();
        }
        return -1;
    }

    @Override
    public Student getStudentById(int studentId) throws SQLException{
        Connection connection = DatabaseConnectionManager.getConnection();
        String query = "SELECT * FROM student WHERE student_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, studentId);
        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            return new Student(rs.getInt("student_id"), rs.getString("full_name"), rs.getDate("date_of_birth"), rs.getString("contact_number"),rs.getString("email"),rs.getString("address"));
        }
        return null;
    }

    @Override
    public void updateStudent(Student student) throws SQLException{
        Connection connection = DatabaseConnectionManager.getConnection();
        String query = "UPDATE student SET full_name = ?,date_of_birth = ?,contact_number = ?,email = ?,address = ? WHERE student_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, student.getFullName());
        ps.setDate(2, new java.sql.Date(student.getDateOfBirth().getTime()));
        ps.setString(3,student.getContactNumber());
        ps.setString(4,student.getEmail());
        ps.setString(5,student.getAddress());
        ps.setInt(6,student.getStudentId());
        ps.executeUpdate();
    }

    @Override
    public void deleteStudent(int studentId) throws SQLException{
        Connection connection = DatabaseConnectionManager.getConnection();
        String query = "DELETE FROM student WHERE student_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1,studentId);
        ps.executeUpdate();
    }

    @Override
    public List<Student> getAllStudents() throws SQLException{
        Connection connection = DatabaseConnectionManager.getConnection();
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM student";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            students.add(new Student(rs.getInt("student_id"), rs.getString("full_name"), rs.getDate("date_of_birth"), rs.getString("contact_number"),rs.getString("email"),rs.getString("address")));
        }
        return students;
    }

}