package back.domain.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import back.domain.entity.CustomerRequest;
import back.domain.entity.CustomerRequestProduct;
import back.domain.entity.CustomerRequestProductId;

public interface CustomerRequestProductRepository extends Repository<CustomerRequestProduct, CustomerRequestProductId> {

	void save(CustomerRequestProduct customerRequestProduct);

	void delete(CustomerRequestProduct customerRequestProduct);

	CustomerRequestProduct findById(CustomerRequestProductId customerRequestProductId);

	List<CustomerRequestProduct> findByCustomerRequest(CustomerRequest customerRequest);
}
