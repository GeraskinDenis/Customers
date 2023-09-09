package ru.geraskindenis.dao;

import org.springframework.data.repository.CrudRepository;

import ru.geraskindenis.model.Customer;

public interface CustomerDao extends CrudRepository<Customer, Long> {
}
