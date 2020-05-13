package com.cognizant.academy.restservice.repository.defaultRepository;

import com.cognizant.academy.restservice.model.defaultModel.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
}
