package com.nagarro.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.spring.model.Review;

/**
 * Review Service Interface
 *
 */
@Service
public interface ReviewService {
	
	/**
	 * Save Review
	 *
	 */
	public Review addReview(Review review);
	
	/**
	 * Get List of reviews of a single product
	 *
	 */
	public List<Review> getAllReviewOfProduct(String code);
	
	/**
	 * Get total number of reviews
	 *
	 */
	public int noOfReview();

	/**
	 * Get average rating of reviews of a single product
	 *
	 */
	public float getAverageRating(String code);
	
	/**
	 * Get the total number of reviews in a single product
	 *
	 */
	public int totalReviewInSingleProduct(String code);
	
	/**
	 * Update the status of review
	 *
	 */
	public int updateReviewStatus(long id, String status);
}
