package ru.geraskindenis.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import ru.geraskindenis.model.Customer;

public interface CustomerDao extends CrudRepository<Customer, Long> {

//	@Query("SELECT * FROM customer")
//	List<Customer> findAll();

}
