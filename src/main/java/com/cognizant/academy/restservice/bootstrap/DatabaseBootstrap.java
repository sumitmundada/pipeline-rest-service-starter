package com.cognizant.academy.restservice.bootstrap;

import com.cognizant.academy.restservice.model.AbstractStudent;
import com.cognizant.academy.restservice.model.defaultModel.Student;
import com.cognizant.academy.restservice.model.defaultModel.enumeration.DatabaseName;
import com.cognizant.academy.restservice.model.defaultModel.lookup.FirstName;
import com.cognizant.academy.restservice.model.defaultModel.lookup.LastName;
import com.cognizant.academy.restservice.model.defaultModel.lookup.Occupation;
import com.cognizant.academy.restservice.service.defaultService.StudentService;
import org.apache.commons.text.WordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Random;

@Configuration
public class DatabaseBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private static Logger logger = LoggerFactory.getLogger(DatabaseBootstrap.class.getName());

    //private CourseService courseService;
    //private InstructorService instructorService;
    //private LocationService locationService;
    //private SectionService sectionService;
    @Autowired
    private StudentService studentService;


    private Integer studentCount;

    public DatabaseBootstrap() {
        this.studentCount = 100;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {


        bootstrapStudents();
        //bootstrapInstructors();

    }

    private void bootstrapStudents() {

        for (DatabaseName dbName : DatabaseName.values()) {

            String databaseName = dbName.name().toLowerCase();

            for (int x = 0; x < studentCount; x++) {

                AbstractStudent student = null;
                switch (databaseName) {
                    case "ds1":
                        student = new com.cognizant.academy.restservice.model.ds1.Student();
                        break;
                    case "ds2":
                        student = new com.cognizant.academy.restservice.model.ds2.Student();
                        break;
                    default:
                        student = new com.cognizant.academy.restservice.model.defaultModel.Student();
                }

                Random random = new Random();

                int index = random.nextInt(FirstName.names.size());
                student.setFirstName(WordUtils.capitalizeFully(FirstName.names.get(index)));

                index = random.nextInt(LastName.names.size());
                student.setLastName(WordUtils.capitalizeFully(LastName.names.get(index)));

                index = random.nextInt(Occupation.occupations.size());
                student.setOccupation(WordUtils.capitalizeFully(Occupation.occupations.get(index)));

                studentService.save(student, databaseName);

            }

            logger.info(studentCount + " Students initialized for [" + databaseName + "].");
        }
    }

    private void bootstrapInstructors() {


    }

}
