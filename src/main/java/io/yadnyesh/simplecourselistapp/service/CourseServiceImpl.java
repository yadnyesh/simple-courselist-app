package io.yadnyesh.simplecourselistapp.service;

import io.yadnyesh.simplecourselistapp.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

@Service
public class CourseServiceImpl implements CourseService{

    List<Course> courseList = new ArrayList<>();

    CourseServiceImpl() {
        courseList.add(new Course(1L, "Spring Boot REST", "Tutorial for Spring Boot"));
        courseList.add(new Course(2L, "Java for Beginners", "Get started on your Java journey"));
        courseList.add(new Course(3L, "Advanced Java", "Java - Advanced Concepts"));
        courseList.add(new Course(4L, "Angular JS", "Angular for UI"));
    }

    @Override
    public List<Course> getAllCourses() {
        return courseList;
    }

    @Override
    public Course getCourseById(String courseId) {
        //return courseList.get(Integer.parseInt(courseId));
        Course returnCourseById =  courseList.stream()
                                    .filter(course -> course.getCourseId().equals(Long.parseLong(courseId)))
                                    .findAny()
                                    .orElse(null);
        return returnCourseById;
    }

    @Override
    public Course createCourse(Course course) {
        Course newCourse = new Course();
        newCourse.setCourseId(new Random().nextLong());
        newCourse.setTitle(course.getTitle());
        newCourse.setDescription(course.getDescription());
        courseList.add(newCourse);
        return newCourse;
    }

    @Override
    public Course updateCourse(String courseId, Course course) {
        Stream<Course> existingCourse = courseList.stream()
                                        .filter(c -> c.getCourseId().equals(Long.parseLong(courseId)));
        existingCourse = (Stream<Course>) course;
        return (Course) existingCourse;
    }
}
