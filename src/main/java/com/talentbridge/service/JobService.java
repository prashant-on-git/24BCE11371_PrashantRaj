package com.talentbridge.service;
import com.talentbridge.model.Job;
import com.talentbridge.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.talentbridge.dto.JobApplicationsDTO;
import com.talentbridge.repository.ApplicationRepository;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;
    @Autowired  
    private ApplicationRepository applicationRepository;

    public List<Job> searchJobsByTitle(String title) {
    return jobRepository.findByJobTitleContainingIgnoreCase(title);
    }

    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public JobApplicationsDTO getJobApplications(
        String jobId) {

    Job job =
            jobRepository.findById(jobId)
                    .orElse(null);

    if (job == null) {
        return null;
    }

    JobApplicationsDTO dto =
            new JobApplicationsDTO();

    dto.setJobId(job.getId());
    dto.setJobTitle(job.getJobTitle());
    dto.setApplications(applicationRepository.findByJobId(jobId)
    );
    return dto;
}

    public Job updateJob(String id,
                         Job updatedJob) {
        Job job =
                jobRepository.findById(id).orElse(null);

        if (job != null) {

            job.setJobTitle(
                    updatedJob.getJobTitle());
            job.setJobDescription(
                    updatedJob.getJobDescription());
            job.setSalary(
                    updatedJob.getSalary());
            job.setCompanyId(
                    updatedJob.getCompanyId());
            return jobRepository.save(job);
        }
        return null;
    }

    public String deleteJob(String id) {
        jobRepository.deleteById(id);
            return "Job Deleted Successfully";
    }
}