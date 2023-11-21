package br.com.nautilus.configuration;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;

@OpenAPIDefinition(info = @Info(
		title = "Customer Service",
		version = "v1",
		description = "Microservice de gestão de clientes"
))
public class OpenAPIConfiguration {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components())
				.info( new io.swagger.v3.oas.models.info.Info().title("Customer Service").version("v1") );
	}
}