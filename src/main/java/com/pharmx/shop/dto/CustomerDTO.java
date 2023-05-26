package com.pharmx.shop.dto;


import com.pharmx.shop.model.Customer;


public class CustomerDTO {
	private Long id;
	private String name;
	private String email;
	private String password;

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

	
	public Customer toObject() {
		return new Customer(name, email, password);
	}
	
	public CustomerDTO(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerDTO() {
	}

	public CustomerDTO toDTO() {
	    return new CustomerDTO(this.getName(), this.getEmail());
	}

}

