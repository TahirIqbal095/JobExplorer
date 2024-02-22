package com.tahir.explorejobs.company.implementation;

import com.tahir.explorejobs.company.Company;
import com.tahir.explorejobs.company.CompanyRepository;
import com.tahir.explorejobs.company.CompanyService;
import com.tahir.explorejobs.job.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repository;

    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Company> getAll() {
        return repository.findAll();
    }

    @Override
    public Company getById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public boolean updateCompany(Company company, int id) {
        Optional<Company> optionalCompany = repository.findById(id);
        if(optionalCompany.isPresent()) {
            Company exCompany = optionalCompany.get();
            exCompany.setDescription(company.getDescription());
            exCompany.setName(company.getName());
            repository.save(exCompany);
            return true;
        }
        return false;
    }

    @Override
    public void addCompany(Company company) {
        repository.save(company);
    }

    @Override
    public boolean deleteCompany(int id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
