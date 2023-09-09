package ru.geraskindenis.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ru.geraskindenis.model.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		return Customer.builder()
				.setId(rs.getLong("id"))
				.setName(rs.getString("name"))
				.build();
	}
}
