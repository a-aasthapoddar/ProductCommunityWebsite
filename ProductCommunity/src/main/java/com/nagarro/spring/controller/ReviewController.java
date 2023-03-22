package com.nagarro.spring.controller;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.spring.model.Review;
import com.nagarro.spring.service.ReviewService;

/**
 * Review Controller is responsible for handling all the rest APIs of Reviews
 *
 */
@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	DecimalFormat df = new DecimalFormat("#.#");

	/**
	 * Rest API for adding the review in database
	 *
	 */
	@PostMapping
	public Review addReview(@RequestBody Review review) {
		return reviewService.addReview(review);
	}

	/**
	 * Rest API for fetching all the reviews associated with a single product
	 *
	 */
	@GetMapping("/code")
	public List<Review> productReview(@RequestParam("productCode") String code) {
		return reviewService.getAllReviewOfProduct(code);
	}

	/**
	 * Rest API for getting the average rating of reviews of a single product
	 *
	 */
	@GetMapping("/avgRating")
	public float averageRating(@RequestParam("productCode") String code) {
		String avgRating = df.format(reviewService.getAverageRating(code));
		float averageRating = Float.parseFloat(avgRating);
		System.out.print(averageRating);
		return averageRating;
	}

	/**
	 * Rest API of getting the count of the reviews associated with a single product
	 *
	 */
	@GetMapping("/totalReviews")
	public int getTotalReviewsOfSingleProduct(@RequestParam("productCode") String code) {
		return reviewService.totalReviewInSingleProduct(code);
	}
}
