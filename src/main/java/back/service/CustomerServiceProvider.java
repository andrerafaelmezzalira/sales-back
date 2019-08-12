package back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import back.domain.entity.Customer;
import back.domain.repository.CustomerRepository;

@Service
public class CustomerServiceProvider implements CustomerService {

	@Autowired
	private CustomerRepository repository;

	@Override
	public void save(Customer customer) throws IllegalAccessException {

		validations(customer);
		repository.save(customer);
	}

	private void validations(Customer customer) throws IllegalAccessException {

		if (customer.getCpfCnpj() == null || customer.getAddress() == null || customer.getName() == null) {
			throw new IllegalAccessException("Campos obrigatórios não preenchidos");
		}

		Customer customerBd = null;

		if (customer.getId() != null) {
			// se o cliente já existe, então o cpfCnpj não pode ser editado
			customerBd = repository.findByCpfCnpj(customer.getCpfCnpj());
			if (customerBd == null) {
				throw new IllegalAccessException("cliente não encontrado");
			}
			if (!customerBd.getId().equals(customer.getId())) {
				throw new IllegalAccessException("CPF/CNPJ não pode ser editado");
			}
		}

		if (customerBd == null) {

			customerBd = repository.findByCpfCnpj(customer.getCpfCnpj());

			if (customerBd != null) {
				throw new IllegalAccessException("CPF/CNPJ já existe");
			}
		}
	}

	@Override
	public List<Customer> findByNameContaining(String name) {
		return repository.findByNameContaining(name);
	}

}