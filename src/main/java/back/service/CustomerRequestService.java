package back.service;

import java.util.List;

import back.domain.entity.CustomerRequest;

public interface CustomerRequestService {

	void save(CustomerRequest customerRequest) throws IllegalAccessException;

	List<CustomerRequest> findAll();

	CustomerRequest findById(Integer id);

	void finalizeCustomerRequest(Integer id) throws IllegalAccessException;
}