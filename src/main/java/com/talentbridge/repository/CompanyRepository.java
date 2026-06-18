package com.talentbridge.repository;
import com.talentbridge.model.Company;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository
        extends MongoRepository<Company, String> {
                List<Company> findByCompanyName(String companyName);
}
