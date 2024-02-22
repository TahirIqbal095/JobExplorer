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
            repository.save(review);
            return true;
        } else
            return false;
    }

    @Override
    public Review getReview(int companyId, int reviewId) {
        List<Review> reviews = repository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId() == reviewId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReview(int companyId, int reviewId, Review review) {
        List<Review> reviews = repository.findByCompanyId(companyId);
        Review updatedReview = reviews.stream()
                .filter(rev -> rev.getId() == reviewId)
                .findFirst()
                .orElse(null);

        if(updatedReview != null) {
            updatedReview.setDescription(review.getDescription());
            updatedReview.setRating(review.getRating());
            updatedReview.setTittle(review.getTittle());
            repository.save(updatedReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(int companyId, int reviewId) {
        if(companyService.getById(companyId) != null && repository.existsById(reviewId)) {
            Review review = repository.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            companyService.updateCompany(company, companyId);
            repository.deleteById(reviewId);
            return true;
        }
        return false;
    }
}
