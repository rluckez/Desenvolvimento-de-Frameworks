package org.cbsoft.framework;

import org.exercicio.application.Uppercase;

public class Product{
	
	private String name;
	private String brand;
	private double price;
	private String code;
	private String secretCode;
	
	public Product(String name, String brand, double price, String code) {
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.code = code;
	}
	@Uppercase
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Prefix("R$")
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Prefix("NR#")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@DontIncludeOnFile
	public String getSecretCode() {
		return secretCode;
	}
	public void setSecretCode(String secretCode) {
		this.secretCode = secretCode;
	}

}
