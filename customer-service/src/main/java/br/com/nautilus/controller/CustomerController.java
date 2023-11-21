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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Customers Endpoint")
@RestController
@RequestMapping("/customer-service")
public class CustomerController {
	
	@Autowired
	private CustomerServiceConfiguration config;
	
	private final String template = "The customer id is: %s <br />Customer Service Version: %s";
	
	@Operation(summary = "Retorna dados básicos de um cliente")
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
	
	@Operation(summary = "Retorna um valor parametrizado do server-config, apenas para fins de teste da funcionalidade")
	@GetMapping("/customer-service-version")
	public String getCustomerServiceVersion(){
		return String.format(template, config.getCustomerServiceVersion());
	}

}
