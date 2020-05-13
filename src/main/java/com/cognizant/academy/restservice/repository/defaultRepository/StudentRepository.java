package com.cognizant.academy.restservice.repository.defaultRepository;

import com.cognizant.academy.restservice.model.defaultModel.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
