package ru.geraskindenis.model;

import org.springframework.data.annotation.Id;

import ru.geraskindenis.web.dto.CustomerDto;

public class Customer {
	@Id
	private Long id;
	private String name;

	public static Builder builder() {
		return new Builder();
	}

	public Customer createCustomer(CustomerDto dto) {
		return new Customer(dto);

	}
	
	public Customer() {
	}
	
	private Customer(CustomerDto dto) {
		this.id = dto.getId();
		this.name = dto.getName();
	}

	private Customer(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "{" + "name='" + name + '\'' + '}';
	}

	public static class Builder {
		private Long id;
		private String name;

		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Customer build() {
			return new Customer(this);
		}
	}

}
