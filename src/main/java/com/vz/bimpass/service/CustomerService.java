/**
 * 
 */
package com.vz.bimpass.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vz.bimpass.dto.CustomerRegistrationDTO;
import com.vz.bimpass.repository.CustomerRepository;

/**
 * @author AR00539983
 *
 */
@Service
public class CustomerService {
	
	private static final Logger logger = LogManager.getLogger(CustomerService.class);

	@Autowired
	private CustomerRepository repository;
	
	public CustomerRegistrationDTO getCustomerById(String id) {
		return repository.findOne(id);
	}

	public String saveCustomerRegistrationDTO(CustomerRegistrationDTO registrationDTO) {
		String id  = repository.save(registrationDTO).customerId;
		logger.info("Customer saved withy ID : " + id);
		return id;
	}
	
}
