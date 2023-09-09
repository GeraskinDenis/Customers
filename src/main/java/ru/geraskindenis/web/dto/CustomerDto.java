package ru.geraskindenis.web.dto;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import jakarta.validation.constraints.NotNull;
import ru.geraskindenis.model.Customer;

@JsonDeserialize(builder = CustomerDto.Builder.class)
public class CustomerDto {

	private Long id;
	@NotNull(message = "Key 'name' is mandatory.")
	@Length(min = 3, max = 100, message = "Name length must be from 3 to 100")
	private final String name;

	public static Builder builder() {
		return new Builder();
	}

	public static CustomerDto createCustomerDto(Customer customer) {
		return new CustomerDto(customer);
	}

	private CustomerDto(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
	}

	public CustomerDto(Customer customer) {
		this.id = customer.getId();
		this.name = customer.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "{" + "id='" + id + "' name='" + name + '\'' + '}';
	}

	@JsonPOJOBuilder(withPrefix = "set")
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

		public CustomerDto build() {
			return new CustomerDto(this);
		}
	}
}
