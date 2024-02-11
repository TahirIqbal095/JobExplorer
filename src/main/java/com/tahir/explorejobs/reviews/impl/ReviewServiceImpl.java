package com.tahir.explorejobs.reviews.impl;

import com.tahir.explorejobs.company.Company;
import com.tahir.explorejobs.company.CompanyService;
import com.tahir.explorejobs.reviews.Review;
import com.tahir.explorejobs.reviews.ReviewRepository;
import com.tahir.explorejobs.reviews.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository repository;
    private final CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository repository, CompanyService companyService) {
        this.repository = repository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(int companyId) {
        return repository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReviews(Review review, int companyId) {
        Company company = companyService.getById(companyId);
        if(company != null) {
            review.setCompany(company);
            return true;
        } else
            return false;
    }
}
