package com.tahir.explorejobs.reviews;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(int companyId);
    boolean addReviews(Review review, int companyId);
}
