package com.talentbridge.service;
import com.talentbridge.dto.CompanyJobsDTO;
import com.talentbridge.model.Company;
import com.talentbridge.repository.CompanyRepository;
import com.talentbridge.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private JobRepository jobRepository;

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public List<Company> getCompaniesByName(
        String companyName) {
            return companyRepository.findByCompanyName(
                companyName);
}

    public CompanyJobsDTO getCompanyJobs(String companyId) {

        Company company =
            companyRepository.findById(companyId)
                    .orElse(null);

        if (company == null) {
            return null;
        }

        CompanyJobsDTO dto =
            new CompanyJobsDTO();

        dto.setCompanyId(company.getId());
            dto.setCompanyName(company.getCompanyName());
        dto.setJobs(
            jobRepository.findByCompanyId(companyId)
        );
        return dto;
    }

    public Company updateCompany(String id,
                                 Company updatedCompany) {

        Company company =
                companyRepository.findById(id).orElse(null);

        if (company != null) {
            company.setCompanyName(
                    updatedCompany.getCompanyName());
            company.setLocation(
                    updatedCompany.getLocation());
            company.setIndustry(
                    updatedCompany.getIndustry());
            return companyRepository.save(company);
        }
        return null;
    }

    public String deleteCompany(String id) {
        companyRepository.deleteById(id);
            return "Company Deleted Successfully";
    }
}