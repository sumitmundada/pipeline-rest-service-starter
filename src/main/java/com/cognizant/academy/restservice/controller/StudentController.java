package com.cognizant.academy.restservice.controller;

import com.cognizant.academy.restservice.model.AbstractStudent;
import com.cognizant.academy.restservice.service.defaultService.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String helloWorld() {

        logger.info("Received request for Hello World message.");
        return "Cognizant Academy REST Service Online!";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/{db}/students")
    public List<AbstractStudent> getStudents(@PathVariable String db) {

        logger.info("Received request for all Students from database [" + db + "].");
        List<AbstractStudent> students = studentService.findAll(db);

        return students;

    }




}
