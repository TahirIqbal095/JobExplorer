package com.tahir.explorejobs.reviews;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tittle;
    private String description;
    private double rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}

/**
 *
 * GET /company/{companyId}/reviews
 * POST /company/{companyId}/reviews
 *
 * PUT /company/{companyId}/reviews/{reviewId}
 * GET /company/{companyId}/reviews/{reviewId}
 * DELETE /company/{companyId}/reviews/{reviewId}
 *
 */