package com.cognizant.academy.restservice.service.defaultService;

import com.cognizant.academy.restservice.model.AbstractStudent;
import com.cognizant.academy.restservice.repository.defaultRepository.StudentRepository;
import com.cognizant.academy.restservice.repository.ds1.Ds1StudentRepository;
import com.cognizant.academy.restservice.repository.ds2.Ds2StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private Ds1StudentRepository ds1StudentRepository;

    @Autowired
    private Ds2StudentRepository ds2StudentRepository;


    public List<AbstractStudent> findAll(String databaseName) {

        List<AbstractStudent> students = new ArrayList<>();
        databaseName = databaseName.toLowerCase();

        switch (databaseName) {

            case "ds1":
                Iterable<com.cognizant.academy.restservice.model.ds1.Student> ds1Students = ds1StudentRepository.findAll();
                ds1Students.forEach(students::add);
                break;
            case "ds2":
                Iterable<com.cognizant.academy.restservice.model.ds2.Student> ds2Students = ds2StudentRepository.findAll();
                ds2Students.forEach(students::add);
                break;
            default:
                Iterable<com.cognizant.academy.restservice.model.defaultModel.Student> defaultStudents = studentRepository.findAll();
                defaultStudents.forEach(students::add);

        }
        return students;
    }

    public AbstractStudent save(AbstractStudent student, String databaseName) {

        databaseName = databaseName.toLowerCase();
        AbstractStudent abstractStudent = null;

        switch (databaseName) {

            case "ds1":
                abstractStudent = ds1StudentRepository.save((com.cognizant.academy.restservice.model.ds1.Student) student);
                break;
            case "ds2":
                abstractStudent = ds2StudentRepository.save((com.cognizant.academy.restservice.model.ds2.Student) student);
                break;
            default:
                abstractStudent = studentRepository.save((com.cognizant.academy.restservice.model.defaultModel.Student) student);

        }

        return abstractStudent;
    }
}
