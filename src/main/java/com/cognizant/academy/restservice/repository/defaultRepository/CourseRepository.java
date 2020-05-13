package com.cognizant.academy.restservice.repository.defaultRepository;

import com.cognizant.academy.restservice.model.defaultModel.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
