package com.nagarro.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.spring.model.Admin;
import com.nagarro.spring.service.AdminService;
import com.nagarro.spring.service.ReviewService;

/**
 * Admin Controller is responsible for handling all the rest APIs of Admin
 *
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private ReviewService reviewService;

	/**
	 * Save admin data to the Admin Table in database Rest API
	 *
	 */
	@PostMapping
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminService.saveAdmin(admin), HttpStatus.CREATED);
	}

	/**
	 * Get all admin data from the database Rest API
	 *
	 */
	@GetMapping
	public List<Admin> getAllAdmins() {
		return adminService.getAllAdmins();
	}

	/**
	 * Update Request for updating the review status in the database Rest API
	 *
	 */
	@PutMapping("/status/{status}/{id}")
	public int updateReviewStatus(@PathVariable("status") String status, @PathVariable("id") long id) {
		return reviewService.updateReviewStatus(id, status);
	}
}
