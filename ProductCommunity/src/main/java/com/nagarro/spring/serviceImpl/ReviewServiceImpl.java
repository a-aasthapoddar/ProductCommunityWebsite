package com.nagarro.spring.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.spring.model.Review;
import com.nagarro.spring.repository.ReviewRepository;
import com.nagarro.spring.service.ReviewService;

/**
 * Review Service Implementation
 *
 */
@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	/**
	 * Save review to database
	 *
	 */
	@Override
	public Review addReview(Review review) {
		return reviewRepository.save(review);
	}

	/**
	 * Get all reviews of a single product with given product code
	 *
	 */
	@Override
	public List<Review> getAllReviewOfProduct(String code) {
		return reviewRepository.getAllProductReviewById(code);
	}

	/**
	 * get total number of reviews
	 *
	 */
	@Override
	public int noOfReview() {
		return reviewRepository.findNoOfReview();
	}

	/**
	 * get average rating of reviews of a single product
	 *
	 */
	@Override
	public float getAverageRating(String code) {
		return reviewRepository.getAverageRating(code);
	}

	/**
	 * get total number of reviews of a single product
	 *
	 */
	@Override
	public int totalReviewInSingleProduct(String code) {
		return reviewRepository.noOfReviewInSingleProduct(code);
	}

	/**
	 * update review status
	 *
	 */
	@Override
	public int updateReviewStatus(long id, String status) {
		return reviewRepository.updateReviewStatus(id, status);
	}
}
