package br.com.nautilus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.nautilus.configuration.CustomerServiceConfiguration;
import br.com.nautilus.model.CustomerModel;

@RestController
@RequestMapping("/customer-service")
public class CustomerController {
	
	@GetMapping(value = "/customer/{id}")
	public String findCustomerById(
		@PathVariable("id") String id) {
		CustomerModel customer = new CustomerModel(
				id,
				"Wilian Fiabani",
				"83682112049",
				"fiabani.wilian@gmail.com"
		);
		ObjectMapper mapper = new ObjectMapper();
		try {			
			return mapper.writeValueAsString( customer );
		}catch(Exception e) {
			System.out.println(e);
			return "";
		}
	}
	
	@Autowired
	private CustomerServiceConfiguration config;
	
	private final String template = "The customer id is: %s <br />Customer Service Version: %s";
	
	@GetMapping("/customer2")
	public String getBasicInformation(
			@RequestParam(value="id", defaultValue="") String id
			) {
		return id.isEmpty()? "The customer ID is empty, please insert a valid customer ID" : String.format(template, id, config.getCustomerServiceVersion());
	}

}
