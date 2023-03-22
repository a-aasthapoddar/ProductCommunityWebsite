package com.nagarro.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.spring.model.Admin;

/**
 * Admin Service Interface
 *
 */
@Service
public interface AdminService {

	/**
	 * Save Admin
	 *
	 */
	Admin saveAdmin(Admin admin);

	/**
	 * Get List of Admins
	 *
	 */
	List<Admin> getAllAdmins();
}
