package br.com.nautilus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.nautilus.client.CustomerProxy;
import br.com.nautilus.model.CustomerModel;
import br.com.nautilus.model.OrderModel;

@RestController
@RequestMapping("/order-service")
public class OrderController {
	
	@Autowired CustomerProxy customerProxy;
	
	@GetMapping(value = "/order/{id}")
	public String findOrderById(
		@PathVariable("id") String id) {
		CustomerModel customer = customerProxy.getCustomer("123456");
		OrderModel order = new OrderModel(
				id,
				"commerce",
				customer.getId(),
				customer.getName(),
				customer.getDocument(),
				customer.getEmail()
		);
		ObjectMapper mapper = new ObjectMapper();
		try {			
			return mapper.writeValueAsString( order );
		}catch(Exception e) {
			System.out.println(e);
			return "";
		}
		
	}

}
