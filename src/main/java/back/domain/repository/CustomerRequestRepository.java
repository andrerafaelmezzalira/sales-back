package back.domain.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import back.domain.entity.CustomerRequest;

public interface CustomerRequestRepository extends Repository<CustomerRequest, Integer> {

	void save(CustomerRequest customerRequest);

	List<CustomerRequest> findAll();

	CustomerRequest findById(Integer id);
}
