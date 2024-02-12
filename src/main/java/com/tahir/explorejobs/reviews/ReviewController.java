package com.tahir.explorejobs.reviews;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/{companyId}")
public class ReviewController {

    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAll(@PathVariable int companyId) {
        return new ResponseEntity<>(service.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<HttpStatus> addReview(@RequestBody Review review, @PathVariable int companyId) {
        boolean isAdded = service.addReviews(review, companyId);
        if(isAdded) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable int companyId,@PathVariable int reviewId) {
        if(service.getReview(companyId, reviewId) != null) {
            return new ResponseEntity<>(service.getReview(companyId, reviewId), HttpStatus.OK);
        } else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<HttpStatus> updateReview(@PathVariable int companyId,@PathVariable int reviewId,
                                                   @RequestBody Review review) {
        boolean isUpdated = service.updateReview(companyId, reviewId, review);
        if(isUpdated) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<HttpStatus> deleteReview(@PathVariable int companyId,@PathVariable int reviewId) {
        boolean isDeleted = service.deleteReview(companyId, reviewId);
        if(isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
