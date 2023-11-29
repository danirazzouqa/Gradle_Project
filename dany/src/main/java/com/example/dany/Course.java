package com.example.dany;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Set<Student> getStudents() {
        return students;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
