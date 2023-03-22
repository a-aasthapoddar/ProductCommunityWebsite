package com.nagarro.spring.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.spring.model.User;
import com.nagarro.spring.repository.UserRepository;
import com.nagarro.spring.service.UserService;

/**
 * User Service Implementation
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Save user details
	 *
	 */
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	/**
	 * get all user details
	 *
	 */
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	/**
	 * get total number of users
	 *
	 */
	@Override
	public int getNoOfUsers() {
		return userRepository.findNoOfUser();
	}

	/**
	 * get user by username
	 *
	 */
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
