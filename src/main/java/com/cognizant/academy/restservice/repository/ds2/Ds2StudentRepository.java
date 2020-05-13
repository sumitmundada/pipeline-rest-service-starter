package com.cognizant.academy.restservice.repository.ds2;

import com.cognizant.academy.restservice.model.ds2.Student;
import org.springframework.data.repository.CrudRepository;

public interface Ds2StudentRepository extends CrudRepository<Student, Integer> {
}
