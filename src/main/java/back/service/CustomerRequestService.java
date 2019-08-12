package back.service;

import java.util.List;

import back.domain.entity.CustomerRequest;

public interface CustomerRequestService {

	CustomerRequest save(CustomerRequest customerRequest) throws IllegalAccessException;

	List<CustomerRequest> findAll();

	CustomerRequest findById(Integer id);

	CustomerRequest finalizeCustomerRequest(Integer id) throws IllegalAccessException;
}