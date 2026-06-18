package com.talentbridge.repository;
import com.talentbridge.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface StudentRepository
        extends MongoRepository<Student, String> {
            List<Student> findByName(String name);
            List<Student> findByCgpaGreaterThan(Double cgpa);
            List<Student> findBySkillsContaining(String skill);
}
