package com.talentbridge.controller;
import com.talentbridge.model.Application;
import com.talentbridge.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(
    name = "Application APIs",
    description = "Operations related to Applications"
)
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @Operation(summary = "Create application")
    @PostMapping("/applications")
    public Application createApplication(
    @RequestBody Application application) {
        return applicationService
            .saveApplication(application);
    }

    @Operation(summary = "Get all applications")
    @GetMapping("/applications")
    public List<Application> getAllApplications() {
        return applicationService
            .getAllApplications();
    }

    @Operation(summary = "Get applications by student")
    @GetMapping("/applications/student/{studentId}")
    public List<Application> getApplicationsByStudent(
    @PathVariable String studentId) {
        return applicationService
            .getApplicationsByStudent(studentId);
    }

    @Operation(summary = "Get applications by status")
    @GetMapping("/applications/status/{status}")
    public List<Application> getApplicationsByStatus(
    @PathVariable String status) {
        return applicationService.getApplicationsByStatus(status);
    }

    @Operation(summary = "Get applications by job")
    @GetMapping("/applications/job/{jobId}")
    public List<Application> getApplicationsByJob(
    @PathVariable String jobId) {
        return applicationService
            .getApplicationsByJob(jobId);
    }

    @Operation(summary = "Update application status")
    @PutMapping("/applications/{id}/{status}")
    public Application updateStatus(
    @PathVariable String id,
    @PathVariable String status) {
         return applicationService
            .updateStatus(id, status);
    }

    @Operation(summary = "Delete application")
    @DeleteMapping("/applications/{id}")
    public String deleteApplication(
    @PathVariable String id) {
        return applicationService
            .deleteApplication(id);
    }
}