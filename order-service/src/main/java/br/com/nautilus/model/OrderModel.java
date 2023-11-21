package br.com.nautilus.model;

import java.io.Serializable;
import java.util.Objects;

public class OrderModel implements Serializable{

	private String id;
	private String origin;
	private String customerId;
	private String customerName;
	private String customerDocument;
	private String customerEmail;
	public OrderModel(String id, String origin, String customerId, String customerName, String customerDocument,
			String customerEmail) {
		super();
		this.id = id;
		this.origin = origin;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerDocument = customerDocument;
		this.customerEmail = customerEmail;
	}
	@Override
	public int hashCode() {
		return Objects.hash(customerDocument, customerEmail, customerId, customerName, id, origin);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderModel other = (OrderModel) obj;
		return Objects.equals(customerDocument, other.customerDocument)
				&& Objects.equals(customerEmail, other.customerEmail) && Objects.equals(customerId, other.customerId)
				&& Objects.equals(customerName, other.customerName) && Objects.equals(id, other.id)
				&& Objects.equals(origin, other.origin);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerDocument() {
		return customerDocument;
	}
	public void setCustomerDocument(String customerDocument) {
		this.customerDocument = customerDocument;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
	
}
