package br.com.nautilus.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("customer-service")
public class CustomerServiceConfiguration {
	
	private String customerServiceVersion;

	public String getCustomerServiceVersion() {
		return customerServiceVersion;
	}

	public void setCustomerServiceVersion(String customerServiceVersion) {
		this.customerServiceVersion = customerServiceVersion;
	}

	public CustomerServiceConfiguration() {}
	
}
