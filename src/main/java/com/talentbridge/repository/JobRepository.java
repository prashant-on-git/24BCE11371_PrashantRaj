package com.talentbridge.repository;
import com.talentbridge.model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface JobRepository
        extends MongoRepository<Job, String> {
            List<Job> findByCompanyId(String companyId);
            List<Job> findByJobTitleContainingIgnoreCase(String jobTitle);
}
