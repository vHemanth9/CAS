package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.CustomerDto;

import com.cg.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	Log LOGGER = LogFactory.getFactory().getLog(CustomerController.class);
	 @Autowired
		ICustomerService service;
	 @GetMapping("/getcustomers")
		public List<CustomerDto> getCustomers() {
		 LOGGER.info("customerController::getAllcustomer::Entered");
			List<CustomerDto> customers =	service.getAllCustomers();
			 LOGGER.info("customersController::getAllcustomers::Exits");
			return customers;	
		}
	 @GetMapping("/getcustomersId/{customerId}")
	 public CustomerDto getCustomerById(@PathVariable("customerId") long customerId)
	 {
		 LOGGER.info("customersController::getcustomerById::Entered");
		 CustomerDto customer=service.getCustomer(customerId);
		 LOGGER.info("customerController::getcustomerById::Exits");
		 return  customer;	 
	 }
	 @Validated
	 @PostMapping("/save/customer")
		public CustomerDto saveCustomer(@RequestBody @Valid CustomerDto customer) {
		 LOGGER.info("customerController::savecustomer::Entered");
			
		 CustomerDto dto = service.saveCustomer(customer);
			
			 LOGGER.info("customerController::save::Exit");
			return dto;
		}
	 @PutMapping("/updatecustomer/{id}")
		public CustomerDto updateCustomer(@PathVariable Long id,@RequestBody CustomerDto customer) {
		 LOGGER.info(" customerIdController::UpdateProduct::Entered");
		 CustomerDto customerDto =  service.updateCustomer(id, customer);
		 LOGGER.info("customerController::update::Exits");
			return customerDto;
			
		}
	 @DeleteMapping("/delete/customer/{customerId}")
		public String deleteCustomer(@PathVariable("customerId") long customerId) {
		 LOGGER.info(" customer Controller::delete customer::Entered");
			service.deleteCustomer(customerId);
		 LOGGER.info("customer Controller::deletecustomer::Entered");
			return "Successfully Deleted customer";
			
		}

}
