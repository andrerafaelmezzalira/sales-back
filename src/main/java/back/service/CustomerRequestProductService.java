package back.service;

import java.util.List;

import back.domain.entity.CustomerRequest;
import back.domain.entity.CustomerRequestProduct;

public interface CustomerRequestProductService {

	CustomerRequestProduct save(CustomerRequestProduct customerRequestProduct) throws IllegalAccessException;

	List<CustomerRequestProduct> findByCustomerRequest(CustomerRequest customerRequest);

	void delete(Integer idCustomerRequest, Integer idProduct) throws IllegalAccessException;
}