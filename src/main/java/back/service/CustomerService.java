package back.service;

import java.util.List;

import back.domain.entity.Customer;

public interface CustomerService {

	Customer save(Customer customer) throws IllegalAccessException;

	List<Customer> findByNameContaining(String name);
}