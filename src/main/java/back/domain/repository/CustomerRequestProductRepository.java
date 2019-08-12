package back.domain.repository;

import org.springframework.data.repository.Repository;

import back.domain.entity.CustomerRequestProduct;

public interface CustomerRequestProductRepository extends Repository<CustomerRequestProduct, Integer> {

	void save(CustomerRequestProduct customerRequestProduct);

	void delete(CustomerRequestProduct customerRequestProduct);

	CustomerRequestProduct findById(Integer id);
}
