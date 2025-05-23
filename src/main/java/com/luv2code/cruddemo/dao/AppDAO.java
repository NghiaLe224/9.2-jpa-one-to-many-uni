package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.Entity.Course;
import com.luv2code.cruddemo.Entity.Instructor;
import com.luv2code.cruddemo.Entity.InstructorDetail;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findById(int id);
    void deleteById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
    List<Course> findCoursesByInstructorId(int id);
    Instructor findInstructorByIdJoinFetch(int id);
    void update(Instructor tempInstructor);
    Course findCourseById(int id);
    void update(Course course);
    void deleteInstructorById(int id);
    void deleteCourseById(int id);
    void save(Course course);
    Course findCourseAndReviewsByCourseId(int id);
    void deleteCourseAndReviewsByCourseId(int id);
}

