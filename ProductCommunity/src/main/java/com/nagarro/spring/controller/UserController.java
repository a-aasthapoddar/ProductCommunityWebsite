package com.nagarro.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nagarro.spring.model.User;
import com.nagarro.spring.service.UserService;

/**
 * User Controller is responsible for handling all the rest APIs of User
 *
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Rest API for saving User data
	 *
	 */
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user) throws Exception {
		User userObj = userService.findByUsername(user.getUsername());
		if (userObj != null) {
			throw new Exception("User already exists");
		} else {
			return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
		}
	}

	/**
	 * Rest API to fetch all User details
	 *
	 */
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
}
