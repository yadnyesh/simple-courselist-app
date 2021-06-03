package io.yadnyesh.simplecourselistapp.service;

import io.yadnyesh.simplecourselistapp.model.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getAllCourses();
    public Course getCourseById(String courseId);
    public Course createCourse(Course course);
    public Course updateCourse(String courseId, Course course);
}
