package back.service;

import back.domain.entity.CustomerRequestProduct;

public interface CustomerRequestProductService {

	void save(CustomerRequestProduct customerRequestProduct) throws IllegalAccessException;

	void delete(Integer id) throws IllegalAccessException;
}