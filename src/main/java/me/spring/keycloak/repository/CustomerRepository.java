package me.spring.keycloak.repository;

import me.spring.keycloak.model.Customer;

public interface CustomerRepository {

	Iterable<Customer> findAll();

	Customer save(Customer customer);
}
