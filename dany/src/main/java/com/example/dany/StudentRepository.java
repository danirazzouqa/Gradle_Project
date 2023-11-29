package com.example.dany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT new com.example.dany.StudentCourseDTO(s.name, c.title) FROM Student s JOIN s.courses c")
    List<StudentCourseDTO> findStudentCourseDetails();
}
