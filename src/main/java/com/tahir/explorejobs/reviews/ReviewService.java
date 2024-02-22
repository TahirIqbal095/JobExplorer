package com.tahir.explorejobs.reviews;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(int companyId);

    boolean addReviews(Review review, int companyId);

    Review getReview(int companyId, int reviewId);

    boolean updateReview(int companyId, int reviewId, Review review);

    boolean deleteReview(int companyId, int reviewId);
}
