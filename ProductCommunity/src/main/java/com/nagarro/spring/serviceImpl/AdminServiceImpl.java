package com.nagarro.spring.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.spring.model.Admin;
import com.nagarro.spring.repository.AdminRepository;
import com.nagarro.spring.service.AdminService;

/**
 * Admin Service Implementation
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	/**
	 * Save admin details 
	 *
	 */
	@Override
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	/**
	 * Get all admin details
	 *
	 */
	@Override
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

}
