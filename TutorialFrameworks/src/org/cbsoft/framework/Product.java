package org.cbsoft.framework;

import java.util.HashMap;
import java.util.Map;

public class Product implements PropertiesGetter{
	
	private String name;
	private String brand;
	private double price;
	private String code;
	
	public Product(String name, String brand, double price, String code) {
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.code = code;
	}
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public Map<String, Object> getPropertiesList() {
		Map<String,Object> props = new HashMap<String, Object>();
		props.put("name", name);
		props.put("brand", brand);
		props.put("price", price);
		props.put("code", code);
		return props;
	}
	
	

}
