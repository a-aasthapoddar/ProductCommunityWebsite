package com.nagarro.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Model class of Product to store product details in database
 *
 */
@Entity
public class Product {

	@Id
	private String productCode;
	private String brand;
	private String productName;
	private double price;
	private float avgRating;

	public Product() {
	}

	public Product(String productCode, String brand, String productName, double price) {
		super();
		this.productCode = productCode;
		this.brand = brand;
		this.productName = productName;
		this.price = price;
	}

	public float getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(float avgRating) {
		this.avgRating = avgRating;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", Brand=" + brand + ", productName=" + productName + ", price="
				+ price + "]";
	}
}
