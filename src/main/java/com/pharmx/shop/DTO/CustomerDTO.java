package com.pharmx.shop.DTO;


import com.pharmx.shop.model.Customer;


public class CustomerDTO {

	private String name;
	private String email;
	private String password;

	public Customer toObject() {
		return new Customer(name, email, password);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	

}
