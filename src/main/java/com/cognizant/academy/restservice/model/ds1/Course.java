package com.cognizant.academy.restservice.model.ds1;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String courseId;
    private String name;
    private String description;
    private Double credits;

    @OneToMany(mappedBy = "course")
    private Set<Section> sections = new HashSet<>();

}
