package com.nagarro.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nagarro.spring.model.User;

/**
 * User Repository performs the data handling and manipulation operations in
 * User table
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Query to select the total number of users registered
	 *
	 */
	@Query("select count(id) from User")
	int findNoOfUser();

	/**
	 * Query to find the user by user name
	 *
	 */
	public User findByUsername(String username);
}
