package com.cg.service;

import java.util.List;

import com.cg.dto.CustomerDto;



public interface ICustomerService {
	List<CustomerDto> getAllCustomers();
	CustomerDto getCustomer(long customerId);
	CustomerDto saveCustomer(CustomerDto customer);
	CustomerDto updateCustomer(Long customerId,CustomerDto customer);
	void deleteCustomer(Long customerId);

}
