package com.vz.bimpass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vz.bimpass.dto.CustomerRegistrationDTO;
import com.vz.bimpass.service.CustomerService;
import com.vz.bimpass.response.RESTServiceResponse;

/**
 * @author SN00341498
 *
 */
@RestController
@RequestMapping(value = "/customerRegistration")
public class CustomerController {

	@Autowired
	private CustomerService service;

	/**
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public RESTServiceResponse<CustomerRegistrationDTO> getCustomerDetails(@PathVariable String id) {
		RESTServiceResponse<CustomerRegistrationDTO> serviceResponse = new RESTServiceResponse<CustomerRegistrationDTO>();
		serviceResponse.setResponse(service.getCustomerById(id));
		return serviceResponse;
	}

	@PostMapping
	public RESTServiceResponse<String> registerCustomer(@RequestBody final CustomerRegistrationDTO customer) {

		String id = service.saveCustomerRegistrationDTO(customer);

		RESTServiceResponse<String> serviceResponse = new RESTServiceResponse<String>();
		serviceResponse.setResponse("Customer registration Done : " + id);
		return serviceResponse;
	}

}
