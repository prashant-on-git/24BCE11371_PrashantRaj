package com.talentbridge.controller;
import com.talentbridge.model.Student;
import com.talentbridge.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.talentbridge.dto.StudentApplicationsDTO;

@RestController
@Tag(
    name = "Student APIs",
    description = "Operations related to Students"
)
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Operation(summary = "Create a new student")
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @Operation(summary = "Get all students")
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Operation(summary = "Get student by ID")
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    @Operation(summary = "Get student with all applications")
    @GetMapping("/students/{studentId}/applications")
    public StudentApplicationsDTO
    getStudentApplications(
    @PathVariable String studentId) {
        return studentService
            .getStudentApplications(
                    studentId);
    }

    @Operation(summary = "Search students by name")
    @GetMapping("/students/name/{name}")
    public List<Student> getStudentsByName(
    @PathVariable String name) {
        return studentService.getStudentsByName(name);
    }

    @Operation(summary = "Search students by cgpa")
    @GetMapping("/students/cgpa/{cgpa}")
    public List<Student> getStudentsByCgpa(
    @PathVariable Double cgpa) {
        return studentService.getStudentsByCgpa(cgpa);
    }

    @Operation(summary = "Search students by skill")
    @GetMapping("/students/skill/{skill}")
    public List<Student> getStudentsBySkill(
    @PathVariable String skill) {
        return studentService.getStudentsBySkill(skill);
    }

    @Operation(summary = "Update student details")
    @PutMapping("/students/{id}")
    public Student updateStudent(
    @PathVariable String id,
    @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @Operation(summary = "Delete student")
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable String id) {
        return studentService.deleteStudent(id);
    }
}