package com.example.dany;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentCourseDTO> getStudentCourseDetails() {
        return studentRepository.findStudentCourseDetails();
    }
    public Page<Student> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return studentRepository.findAll(pageable);
    }
    public void updateStudent(Long id, Student updatedStudent) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setName(updatedStudent.getName());
            // Update other fields as necessary
            studentRepository.save(student);
        }
    }
}
