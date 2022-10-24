package me.spring.keycloak.model;

public class Customer {
	private Long id;
	private String name;
	private String serviceRendered;
	private String address;

	public Customer() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServiceRendered() {
		return serviceRendered;
	}

	public void setServiceRendered(String serviceRendered) {
		this.serviceRendered = serviceRendered;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
