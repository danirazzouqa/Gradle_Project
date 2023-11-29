package com.example.dany;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public DataSeeder(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) {
        // Create and save students without courses
        Student student1 = new Student();
        student1.setName("Dany");
        studentRepository.save(student1); // Save immediately

        Student student2 = new Student();
        student2.setName("Ahmed");
        studentRepository.save(student2); // Save immediately

        // Create and save courses
        Course course1 = new Course();
        course1.setTitle("Math");
        courseRepository.save(course1); // Save immediately

        Course course2 = new Course();
        course2.setTitle("Logic");
        courseRepository.save(course2); // Save immediately

        // Add courses to students and merge
        student1.getCourses().add(course1);
        studentRepository.save(student1); // Merge student

        student2.getCourses().add(course2);
        studentRepository.save(student2); // Merge student
    }

}
