package com.nagarro.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nagarro.spring.model.Review;

/**
 * Review Repository performs the data handling and manipulation operations in
 * Review table
 *
 */
public interface ReviewRepository extends JpaRepository<Review, Long> {

	/**
	 * Query to Fetch all reviews of a product with a given product code
	 *
	 */
	@Query("from Review where code =:code")
	List<Review> getAllProductReviewById(String code);

	/**
	 * Query to select the total number of reviews
	 *
	 */
	@Query("select count(id) from Review")
	int findNoOfReview();

	/**
	 * Query to select the average rating of a give product
	 *
	 */
	@Query("select avg(rating) from Review where code =:code")
	Float getAverageRating(String code);

	/**
	 * Query to get the total number of reviews of a single product
	 *
	 */
	@Query("select count(title) from Review where code =:code")
	int noOfReviewInSingleProduct(String code);

	/**
	 * Query to update the status of the review
	 *
	 */
	@Transactional
	@Modifying
	@Query("update Review set status =:status where id =:id")
	int updateReviewStatus(long id, String status);
}
