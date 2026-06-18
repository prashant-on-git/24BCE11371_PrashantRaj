package com.talentbridge.dto;
import com.talentbridge.model.Application;
import java.util.List;

public class StudentApplicationsDTO {

    private String studentId;
    private String studentName;
    private List<Application> applications;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(
            List<Application> applications) {

        this.applications = applications;
    }
}
