package ru.geraskindenis.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import ru.geraskindenis.dao.CustomerDao;
import ru.geraskindenis.model.Customer;

@Service
public class CustomerService {
	private static final Logger LOGGER = Logger.getLogger(CustomerService.class.getName());
	private final CustomerDao customerDao;

	private CustomerService(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public Customer createCustomer(Customer customer) {
		List<Customer> customers = customerDao.findCustomerByName(customer.getName());
		if (customers.isEmpty()) {
			customer = customerDao.save(customer);
			LOGGER.info("Create customer:" + customer);
		} else {
			customer = customers.get(0);
		}
		return customer;
	}

	public List<Customer> findByName(String name) {
		return customerDao.findCustomerByName(name);
	}

	public List<Customer> findAll() {
		return (List<Customer>) customerDao.findAll();
	}

	public Customer findById(long id) {
		return customerDao.findById(id).orElseThrow(() -> {
			String message = "Search error by id: Customer id = '" + id + "' not found.";
			LOGGER.log(Level.WARNING, message);
			return new RuntimeException(message);
		});
	}

	public void deleteById(Long id) {
		if (!customerDao.existsById(id)) {
			throw new RuntimeException("Error deletion by id: Customer id = '" + id + "' not found.");
		}
		customerDao.deleteById(id);
		LOGGER.log(Level.INFO, "The customer id = '" + id + "' deleted.");
	}
}
