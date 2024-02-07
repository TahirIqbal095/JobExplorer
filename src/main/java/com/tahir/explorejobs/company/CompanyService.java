package com.tahir.explorejobs.company;

import com.tahir.explorejobs.job.Job;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompanyService {
    List<Company> getAll();

    Company getById(int id);

    boolean updateCompany(Company company, int id);

    void addCompany(Company company);

    boolean deleteCompany(int id);
}
