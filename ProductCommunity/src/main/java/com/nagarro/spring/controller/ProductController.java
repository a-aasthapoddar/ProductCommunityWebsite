package com.nagarro.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.spring.model.Product;
import com.nagarro.spring.service.ProductService;

/**
 * Product Controller is responsible for handling all the rest APIs of Product
 *
 */
@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * Rest API for saving Product data into database
	 *
	 */
	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
	}

	/**
	 * Rest API for get all product data from database
	 *
	 */
	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(productService.getAllProducts());
	}

	/**
	 * Rest API for searching the product in database from input search string
	 *
	 */
	@GetMapping("/search")
	public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") String query) {
		return ResponseEntity.ok(productService.searchProducts(query));
	}

	/**
	 * Rest API for retrieving product from Product Id
	 *
	 */
	@GetMapping("{productCode}")
	public ResponseEntity<Product> getProductById(@PathVariable("productCode") String productCode) {
		return new ResponseEntity<Product>(productService.getProductById(productCode), HttpStatus.OK);
	}

	/**
	 * Rest API for getting the list of all unique brands
	 *
	 */
	@GetMapping("/productBrands")
	public List<String> getAllBrands() {
		return productService.getAllBrands();
	}

	/**
	 * Rest API for getting the list of all product codes
	 *
	 */
	@GetMapping("/productCodes")
	public List<String> getAllProductCodes() {
		return productService.getAllProductCodes();
	}
}
