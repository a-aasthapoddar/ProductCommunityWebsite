package com.nagarro.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.spring.model.User;

/**
 * User Service Interface
 *
 */
@Service
public interface UserService {

	/**
	 * Saving user data
	 *
	 */
	User saveUser(User user);

	/**
	 * fetch all users data
	 *
	 */
	List<User> getAllUsers();

	/**
	 * Get total number of registered users
	 *
	 */
	int getNoOfUsers();

	/**
	 * fetch user by its user name
	 *
	 */
	User findByUsername(String username);
}
