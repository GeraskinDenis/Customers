package ru.geraskindenis.web;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ru.geraskindenis.model.Customer;
import ru.geraskindenis.service.CustomerService;
import ru.geraskindenis.web.dto.CustomerDto;

@RestController
public class CustomerWebController {
	private static final Logger LOGGER = Logger.getLogger(CustomerWebController.class.getName());
	private CustomerService customerService;

	private CustomerWebController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping("/customers")
	public void createCustomer(@Valid @RequestBody CustomerDto customerDto) {
		LOGGER.info("Create customer request received: " + customerDto);
		customerService.createCustomer(Customer.builder().setName(customerDto.getName()).build());
	}

	@GetMapping("/customers")
	public ResponseEntity<List<CustomerDto>> getAll() {
		List<Customer> customers = customerService.findAll();
		List<CustomerDto> customersDto = customers.stream().map(CustomerDto::createCustomerDto).toList();
		return ResponseEntity.accepted().body(customersDto);
	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<CustomerDto> getById(@PathVariable Long id) {
		Customer customer = customerService.findById(id);
		return ResponseEntity.accepted().body(CustomerDto.createCustomerDto(customer));
	}
}
