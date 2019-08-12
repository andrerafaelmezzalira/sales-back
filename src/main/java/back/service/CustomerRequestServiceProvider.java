package back.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import back.domain.entity.CustomerRequest;
import back.domain.repository.CustomerRequestRepository;

@Service
public class CustomerRequestServiceProvider implements CustomerRequestService {

	@Autowired
	private UserService userService;

	@Autowired
	private CustomerRequestRepository repository;

	@Override
	public void save(CustomerRequest customerRequest) throws IllegalAccessException {

		validations(customerRequest);
		repository.save(customerRequest);
	}

	private void validations(CustomerRequest customerRequest) throws IllegalAccessException {

		if (customerRequest.getCustomer() == null) {
			throw new IllegalAccessException("Campos obrigatórios não preenchidos");
		}

		if (customerRequest.getId() == null) {
			customerRequest.setRegisterDate(LocalDate.now());
			customerRequest.setAmount(BigDecimal.ZERO);
		} else {
			CustomerRequest customerRequestBd = findById(customerRequest.getId());
			if (customerRequestBd != null && customerRequestBd.getEmissionDate() != null) {
				throw new IllegalAccessException("Pedido já finalizado");
			}
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		customerRequest.setSalesMan(userService.findByEmail(email));
	}

	@Override
	public List<CustomerRequest> findAll() {
		return repository.findAll();
	}

	@Override
	public CustomerRequest findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public void finalizeCustomerRequest(Integer id) throws IllegalAccessException {
		CustomerRequest customerRequest = findById(id);
		if (customerRequest == null) {
			throw new IllegalAccessException("Pedido não encontrado");
		}
		customerRequest.setEmissionDate(LocalDate.now());
		save(customerRequest);
	}
}