package com.edutech.progressive.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edutech.progressive.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer>{

    @Query("SELECT c FROM Course c WHERE courseId = :courseId")
    public Course findByCourseId(@Param("courseId") int courseId);

    @Query("SELECT c FROM Course c WHERE courseId = :courseName")
    public Course findByCourseName(@Param("courseName") String cousrseName);

    @Query("Select c FROM Course c WHERE c.teacher.teacherId = :teacherId")
    public List<Course> findAllByTeacherId(@Param("teacherId") int teacherId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Course c WHERE c.teacher.teacherId = :teacherId")
    public void deleteByTeacherId(int teacherId);
}