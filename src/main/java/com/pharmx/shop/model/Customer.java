package com.pharmx.shop.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pharmx.shop.dto.CustomerDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	@JsonIgnore
	private String password;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(id, other.id);
	}
	
	public Customer(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public Customer(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
	public Customer() {

	}

	public CustomerDTO toDTO() {
	    CustomerDTO dto = new CustomerDTO();
	    dto.setId(this.id);
	    dto.setName(this.name);
	    dto.setEmail(this.email);
	    return dto;
	}
	
	public Customer toObject() {
		return new Customer(name, email, password);
	}
	
	
	
}

