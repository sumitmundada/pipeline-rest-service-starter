package com.cognizant.academy.restservice.service.defaultService;

import com.cognizant.academy.restservice.model.defaultModel.Instructor;
import com.cognizant.academy.restservice.repository.defaultRepository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    private InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public List<Instructor> findAll() {
        return (List<Instructor>) instructorRepository.findAll();
    }
}
