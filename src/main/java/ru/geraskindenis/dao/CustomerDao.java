package ru.geraskindenis.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ru.geraskindenis.model.Customer;

public interface CustomerDao extends CrudRepository<Customer, Long> {
	List<Customer> findCustomerByName(String name);
}
