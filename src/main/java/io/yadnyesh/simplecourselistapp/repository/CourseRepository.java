package io.yadnyesh.simplecourselistapp.repository;

import io.yadnyesh.simplecourselistapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
