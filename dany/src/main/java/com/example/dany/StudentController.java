package com.example.dany;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "Test endpoint is working";
    }

    @GetMapping("/students")
    public String listStudents(Model model,
                               @RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "5") int size) {
        Page<Student> studentPage = studentService.findPaginated(page, size);
        model.addAttribute("students", studentPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", studentPage.getTotalPages());
        return "students";
    }
    @PostMapping("/students/update/{id}")
    public String updateStudent(@PathVariable Long id, Student student, RedirectAttributes redirectAttributes) {
        // Service method to update student
        studentService.updateStudent(id, student);

        redirectAttributes.addFlashAttribute("successMessage", "Student updated successfully!");

        return "redirect:/students";
    }
}

