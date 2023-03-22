package com.nagarro.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.spring.model.Product;

/**
 * Product Service Interface
 *
 */
@Service
public interface ProductService {

	/**
	 * Save Product
	 *
	 */
	Product saveProduct(Product product);

	/**
	 * Search Products
	 *
	 */
	List<Product> searchProducts(String query);

	/**
	 * Get List of all products
	 *
	 */
	List<Product> getAllProducts();

	/**
	 * Get total number of products
	 *
	 */
	int findTotalProducts();

	/**
	 * Get product by its Id
	 *
	 */
	public Product getProductById(String productCode);

	/**
	 * Get List of all brands
	 *
	 */
	List<String> getAllBrands();
	
	/**
	 * Get List of all product Codes
	 *
	 */
	List<String> getAllProductCodes();
}
