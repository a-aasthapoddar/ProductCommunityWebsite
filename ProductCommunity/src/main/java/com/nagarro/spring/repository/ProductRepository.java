package com.nagarro.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.nagarro.spring.model.Product;

/**
 * Product Repository performs the data handling and manipulation operations in Product table
 *
 */
public interface ProductRepository extends JpaRepository<Product, String>{

	/**
	 * Query for searching product list by giving a search string parameter as input
	 *
	 */
	@Query("from Product where productName like concat ('%',:query,'%') OR brand like concat ('%', :query, '%') OR productCode like concat ('%', :query, '%')")
	List<Product> searchProducts(String query);
	
	/**
	 * Query to get the total number of products  
	 *
	 */
	@Query("select count(id) from Product")
	int findNoOfProducts();
	
	/**
	 * Query to fetch the list of all unique brands
	 *
	 */
	@Query("Select distinct brand from Product")
	List<String> getAllBrands();
	
	/**
	 * Query to fetch the list of all product codes
	 *
	 */
	@Query("Select distinct productCode from Product")
	List<String> getAllProductCodes();
}
