package me.spring.keycloak.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import me.spring.keycloak.model.Customer;
import me.spring.keycloak.repository.CustomerRepository;

@Controller
public class WebController {

	private final CustomerRepository customerRepository;

	public WebController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@GetMapping(path = "/")
	public String index() {
		return "external";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) throws Exception {
		request.logout();
		return "redirect:/";
	}

	@GetMapping(path = "/customers")
	public String customers(Principal principal, Model model) {
		addCustomers();
		Iterable<Customer> customers = customerRepository.findAll();
		model.addAttribute("customers", customers);
		model.addAttribute("username", principal.getName());
		return "customers";
	}

	// add customers for demonstration
	public void addCustomers() {

		Customer customer1 = new Customer();
		customer1.setAddress("1111 foo blvd");
		customer1.setName("Foo Industries");
		customer1.setServiceRendered("Important services");
		customerRepository.save(customer1);

		Customer customer2 = new Customer();
		customer2.setAddress("2222 bar street");
		customer2.setName("Bar LLP");
		customer2.setServiceRendered("Important services");
		customerRepository.save(customer2);

		Customer customer3 = new Customer();
		customer3.setAddress("33 main street");
		customer3.setName("Big LLC");
		customer3.setServiceRendered("Important services");
		customerRepository.save(customer3);
	}
}
