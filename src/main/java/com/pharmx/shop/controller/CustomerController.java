package com.pharmx.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmx.shop.dto.CustomerDTO;
import com.pharmx.shop.model.Customer;
import com.pharmx.shop.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public List<Customer> list() {
		return customerService.getAllCustomers();
	}
	
	@PostMapping
	public ResponseEntity<Customer> save(@RequestBody CustomerDTO dto) {
	    Customer customer = customerService.createCustomer(dto.toObject());
	    return new ResponseEntity<>(customer, HttpStatus.CREATED);
	}
	
	
	@PostMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO dto) {
	    Customer customer = customerService.editCustomer(id, dto.toObject());
	    return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
	    Customer customer = customerService.getCustomerById(id);
	    if (customer != null) {
	        CustomerDTO customerDTO = customer.toDTO();
	        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
	    } else {
	        throw new ResourceNotFoundException("Customer with ID " + id + " not found.");
	    }
	}
	
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
	}
	
}