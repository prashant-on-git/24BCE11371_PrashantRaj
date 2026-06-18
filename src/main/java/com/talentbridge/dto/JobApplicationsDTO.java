package com.talentbridge.dto;
import com.talentbridge.model.Application;
import java.util.List;

public class JobApplicationsDTO {

    private String jobId;
    private String jobTitle;
    private List<Application> applications;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }
}
