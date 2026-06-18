package com.talentbridge.service;
import com.talentbridge.model.Student;
import com.talentbridge.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.talentbridge.dto.StudentApplicationsDTO;
import com.talentbridge.repository.ApplicationRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired  
    private ApplicationRepository applicationRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String id) {
    return studentRepository.findById(id).orElse(null);
}

    public List<Student> getStudentsByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> getStudentsByCgpa(Double cgpa) {
        return studentRepository.findByCgpaGreaterThan(cgpa);
    }

    public List<Student> getStudentsBySkill(String skill) {
        return studentRepository.findBySkillsContaining(skill);
    }

    public Student updateStudent(String id, Student updatedStudent) {

        Student student =
                studentRepository.findById(id).orElse(null);

        if (student != null) {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setCgpa(updatedStudent.getCgpa());
            student.setSkills(updatedStudent.getSkills());
            return studentRepository.save(student);
        }
        return null;
    }

    public StudentApplicationsDTO getStudentApplications(
        String studentId) {

    Student student =
            studentRepository.findById(studentId)
                    .orElse(null);

    if (student == null) {
        return null;
    }

    StudentApplicationsDTO dto = new StudentApplicationsDTO();
            

    dto.setStudentId(student.getId());
    dto.setStudentName(student.getName());
    dto.setApplications(applicationRepository.findByStudentId(studentId));
    return dto;
}

    public String deleteStudent(String id) {
        studentRepository.deleteById(id);
            return "Student Deleted Successfully";
    }
}