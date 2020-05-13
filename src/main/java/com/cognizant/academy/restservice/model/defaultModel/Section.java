package com.cognizant.academy.restservice.model.defaultModel;

import com.cognizant.academy.restservice.configuration.converter.LocalDateConverter;
import com.cognizant.academy.restservice.configuration.converter.LocalTimeConverter;
import com.cognizant.academy.restservice.model.defaultModel.enumeration.Availability;
import com.cognizant.academy.restservice.model.defaultModel.enumeration.DeliveryMethod;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@SequenceGenerator(name = "sectionNumbers", initialValue = 12000, allocationSize = 100)
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sectionNumbers")
    private Integer sectionId;
    private String semester;
    private DeliveryMethod deliveryMethod;
    private Availability availability;
    private String bookInformation;
    private String notes;

    @OneToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToMany(mappedBy = "sections")
    private Set<Student> students = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Convert(converter = LocalDateConverter.class)
    private LocalDate startingDate;
    @Convert(converter = LocalDateConverter.class)
    private LocalDate endingDate;
    @Convert(converter = LocalTimeConverter.class)
    private LocalTime startTime;
    @Convert(converter = LocalTimeConverter.class)
    private LocalTime stopTime;


}
