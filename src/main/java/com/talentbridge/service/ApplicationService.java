package com.talentbridge.service;
import com.talentbridge.model.Application;
import com.talentbridge.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public Application saveApplication(
         Application application) {
            return applicationRepository.save(application);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public List<Application> getApplicationsByStudent(
        String studentId) {
            return applicationRepository
                .findByStudentId(studentId);
    }

    public List<Application> getApplicationsByJob(
        String jobId) {
            return applicationRepository
                .findByJobId(jobId);
    }

    public Application updateStatus(
        String id,
        String status) {
        Application application =
                applicationRepository.findById(id)
                        .orElse(null);

        if (application != null) {
            application.setStatus(status);
                return applicationRepository
                    .save(application);
        }
        return null;
    }

    public String deleteApplication(String id) {
        applicationRepository.deleteById(id);
            return "Application Deleted Successfully";
    }

    public List<Application> getApplicationsByStatus(String status) {
        return applicationRepository.findByStatus(status);
    }
}