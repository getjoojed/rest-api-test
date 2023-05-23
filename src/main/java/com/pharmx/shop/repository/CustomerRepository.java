package com.pharmx.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharmx.shop.model.Customer;

	public interface CustomerRepository extends JpaRepository<Customer, Long>{
		
	
}
