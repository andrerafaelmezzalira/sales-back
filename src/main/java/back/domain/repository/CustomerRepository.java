package back.domain.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import back.domain.entity.Customer;

public interface CustomerRepository extends Repository<Customer, Integer> {

	void save(Customer customer);

	List<Customer> findByNameContaining(String name);

	Customer findByCpfCnpj(String cpfCnpj);
}
