package com.cognizant.academy.restservice.service.defaultService;

import com.cognizant.academy.restservice.model.defaultModel.Course;
import com.cognizant.academy.restservice.repository.defaultRepository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }
}
