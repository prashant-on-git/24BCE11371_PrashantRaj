package com.talentbridge.controller;
import com.talentbridge.dto.CompanyJobsDTO;
import com.talentbridge.model.Company;
import com.talentbridge.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(
    name = "Company APIs",
    description = "Operations related to Companies"
)
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Operation(summary = "Create a new company")
    @PostMapping("/companies")
    public Company createCompany(
    @RequestBody Company company) {
        return companyService.saveCompany(company);
    }

    @Operation(summary = "Get all companies")
    @GetMapping("/companies")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @Operation(summary = "Search company by name")
    @GetMapping("/companies/name/{name}")
    public List<Company> getCompaniesByName(
    @PathVariable String name) {
        return companyService.getCompaniesByName(name);
    }

    @Operation(summary = "Update company details")
    @PutMapping("/companies/{id}")
    public Company updateCompany(
    @PathVariable String id,
    @RequestBody Company company) {
        return companyService.updateCompany(id, company);
    }

    @Operation(summary = "Get company with all jobs")
    @GetMapping("/companies/{companyId}/jobs")
    public CompanyJobsDTO getCompanyJobs(
    @PathVariable String companyId) {
        return companyService.getCompanyJobs(
            companyId);
    }

    @Operation(summary = "Delete company")
    @DeleteMapping("/companies/{id}")
    public String deleteCompany(
    @PathVariable String id) {
        return companyService.deleteCompany(id);
    }
}
