package io.yadnyesh.simplecourselistapp.service;

import io.yadnyesh.simplecourselistapp.model.Course;
import io.yadnyesh.simplecourselistapp.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CourseServiceDaoImpl implements CourseService{

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(String courseId) {
        return courseRepository.getById(Long.parseLong(courseId));
    }

    @Override
    public Course createCourse(Course course) {
        Course newCourse = courseRepository.save(course);
        return newCourse;
    }

    @Override
    public Course updateCourse(String courseId, Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(String courseId) {
        courseRepository.deleteById(Long.parseLong(courseId));
        log.info("Course with ID: " + courseId + " deleted");
    }
}
