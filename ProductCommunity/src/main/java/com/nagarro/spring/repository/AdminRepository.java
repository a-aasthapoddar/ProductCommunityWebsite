package com.nagarro.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.spring.model.Admin;

/**
 * Admin Repository performs the data handling and manipulation operations in Admin table
 *
 */
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
