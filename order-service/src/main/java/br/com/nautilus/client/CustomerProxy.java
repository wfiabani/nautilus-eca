package br.com.nautilus.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.nautilus.model.CustomerModel;

@FeignClient(name = "customer-service")
public interface CustomerProxy {

	@GetMapping(value = "/customer-service/customer/{id}", consumes = "application/json", produces = "application/json")
	public CustomerModel getCustomer(
			@PathVariable("id") String id
	);
}
