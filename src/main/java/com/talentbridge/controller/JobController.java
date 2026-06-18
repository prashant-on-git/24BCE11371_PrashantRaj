package com.talentbridge.controller;
import com.talentbridge.model.Job;
import com.talentbridge.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.talentbridge.dto.JobApplicationsDTO;

@RestController
@Tag(
    name = "Job APIs",
    description = "Operations related to Jobs"
)
public class JobController {

    @Autowired
    private JobService jobService;

    @Operation(summary = "Create a new job")
    @PostMapping("/jobs")
    public Job createJob(@RequestBody Job job) {
        return jobService.saveJob(job);
    }

    @Operation(summary = "Search jobs by title")
    @GetMapping("/jobs/search/{title}")
    public List<Job> searchJobsByTitle(
    @PathVariable String title) {
        return jobService.searchJobsByTitle(title);
    }

    @Operation(summary = "Get all jobs")
    @GetMapping("/jobs")
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @Operation(summary = "Get job with all applications")
    @GetMapping("/jobs/{jobId}/applications")
    public JobApplicationsDTO getJobApplications(
    @PathVariable String jobId) {
        return jobService
            .getJobApplications(jobId);
    }

    @Operation(summary = "Update job")
    @PutMapping("/jobs/{id}")
    public Job updateJob(
    @PathVariable String id,
    @RequestBody Job job) {
        return jobService.updateJob(id, job);
    }

    @Operation(summary = "Delete job")
    @DeleteMapping("/jobs/{id}")
    public String deleteJob(
    @PathVariable String id) {
        return jobService.deleteJob(id);
    }
}