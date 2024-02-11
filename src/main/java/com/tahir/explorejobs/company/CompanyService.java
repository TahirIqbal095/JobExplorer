package com.tahir.explorejobs.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAll();

    Company getById(int id);

    boolean updateCompany(Company company, int id);

    void addCompany(Company company);

    boolean deleteCompany(int id);
}
