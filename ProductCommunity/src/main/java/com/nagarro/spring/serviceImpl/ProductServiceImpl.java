package com.nagarro.spring.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.spring.model.Product;
import com.nagarro.spring.repository.ProductRepository;
import com.nagarro.spring.service.ProductService;

/**
 * Product Service Implementation
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	/**
	 * save product into database
	 *
	 */
	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	/**
	 * Search Products from the input search string
	 *
	 */
	@Override
	public List<Product> searchProducts(String query) {
		List<Product> products = productRepository.searchProducts(query);
		return products;
	}

	/**
	 * get total number of products
	 *
	 */
	@Override
	public int findTotalProducts() {
		return productRepository.findNoOfProducts();
	}

	/**
	 * get product by its id
	 *
	 */
	@Override
	public Product getProductById(String productCode) {
		Optional<Product> product = productRepository.findById(productCode);
		return product.get();
	}

	/**
	 * get the list of all products
	 *
	 */
	@Override
	public List<Product> getAllProducts() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	/**
	 * Get the list of all product brands
	 *
	 */
	@Override
	public List<String> getAllBrands() {
		return productRepository.getAllBrands();
	}

	/**
	 * get the list of all product codes
	 *
	 */
	@Override
	public List<String> getAllProductCodes() {
		return productRepository.getAllProductCodes();
	}
}
