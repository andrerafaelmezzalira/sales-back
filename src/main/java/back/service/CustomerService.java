package back.service;

import java.util.List;

import back.domain.entity.Customer;

public interface CustomerService {

	void save(Customer customer) throws IllegalAccessException;

	List<Customer> findByNameContaining(String name);
}