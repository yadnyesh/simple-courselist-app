package io.yadnyesh.simplecourselistapp.controller;

import io.yadnyesh.simplecourselistapp.model.Course;
import io.yadnyesh.simplecourselistapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;


    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/courses/{courseId}")
    public ResponseEntity<Course> getAllCourses(@PathVariable String courseId) {
        return new ResponseEntity<>(courseService.getCourseById(courseId), HttpStatus.OK);
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> createNewCourses(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.createCourse(course), HttpStatus.CREATED);
    }

    @PutMapping("/courses/{courseId}")
    public ResponseEntity<Course> createNewCourses(@PathVariable String courseId, @RequestBody Course course) {
        return new ResponseEntity<>(courseService.updateCourse(courseId, course), HttpStatus.ACCEPTED);
    }


}
