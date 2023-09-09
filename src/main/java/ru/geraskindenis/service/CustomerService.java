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

	public void createCustomer(Customer customer) {
		customerDao.save(customer);
	}

	public List<Customer> findAll() {
		return (List<Customer>) customerDao.findAll();
	}

	public Customer findById(long id) {
		return customerDao.findById(id).orElseThrow(() -> {
			String message = "The customer id = '" + id + "' not found.";
			LOGGER.log(Level.WARNING, message);
			return new RuntimeException(message);
		});
	}

	public void deleteById(Long id) {
		Customer c = findById(id);
		customerDao.deleteById(c.getId());
	}
}
