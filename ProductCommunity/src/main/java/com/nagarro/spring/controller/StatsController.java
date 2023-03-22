package com.nagarro.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.spring.service.ProductService;
import com.nagarro.spring.service.ReviewService;
import com.nagarro.spring.service.UserService;

/**
 * Stats Controller is responsible for handling all the rest APIs of Statistics
 *
 */
@RestController
@RequestMapping("/stats")
@CrossOrigin(origins = "http://localhost:4200")
public class StatsController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@Autowired
	private ReviewService reviewService;

	/**
	 * Total number of registered users Rest API
	 *
	 */
	@GetMapping("/totalUsers")
	public int getNoOfUsers() {
		return userService.getNoOfUsers();
	}

	/**
	 * Total number of products Rest API
	 *
	 */
	@GetMapping("/totalProducts")
	public int getTotalNoOfProducts() {
		return productService.findTotalProducts();
	}

	/**
	 * Total number of Reviews Rest API
	 *
	 */
	@GetMapping("/totalReviews")
	public int getTotalNoOfReviews() {
		return reviewService.noOfReview();
	}
}
