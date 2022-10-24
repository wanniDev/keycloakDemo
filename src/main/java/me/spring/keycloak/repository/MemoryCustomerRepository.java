package me.spring.keycloak.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import me.spring.keycloak.model.Customer;

@Repository
public class MemoryCustomerRepository implements CustomerRepository {
	private final AtomicLong id = new AtomicLong();
	private final Map<Long, Customer> map = new ConcurrentHashMap<>();

	@Override
	public Iterable<Customer> findAll() {
		return map.values();
	}

	@Override
	public Customer save(Customer customer) {
		customer.setId(id.getAndIncrement());
		return map.put(customer.getId(), customer);
	}
}
