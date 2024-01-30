package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CustomerDTO;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class RestCustomer {
	
	@Autowired
	@Qualifier("customerServiceImpl")
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<CustomerDTO> getCustomers(){
		return customerService.listAllCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public CustomerDTO getCustomer(@PathVariable int customerId){
		return customerService.findCustomerByIdModel(customerId);
	}
	
	@PostMapping("/customers")
	public CustomerDTO updateCustomer(@RequestBody CustomerDTO customer) {
		customerService.addCustomer(customer);
		return customer;
	}
	
}
