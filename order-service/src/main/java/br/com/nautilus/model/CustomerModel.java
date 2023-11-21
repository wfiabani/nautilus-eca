package br.com.nautilus.model;

import java.io.Serializable;
import java.util.Objects;

public class CustomerModel implements Serializable{
	
	private static final long serialVersionUID = 2076838433725220531L;
	private String id;
	private String name;
	private String document;
	private String email;
	
	public CustomerModel(String id, String name, String document, String email) {
		super();
		this.id = id;
		this.name = name;
		this.document = document;
		this.email = email;
	}
	@Override
	public int hashCode() {
		return Objects.hash(document, email, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerModel other = (CustomerModel) obj;
		return Objects.equals(document, other.document) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
